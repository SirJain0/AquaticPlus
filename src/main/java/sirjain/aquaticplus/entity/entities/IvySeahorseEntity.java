package sirjain.aquaticplus.entity.entities;

import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import sirjain.aquaticplus.entity.entities.template.AbstractEelEntity;
import sirjain.aquaticplus.entity.entities.template.NoBucketSchoolingFishEntity;
import sirjain.aquaticplus.item.AquaticPlusItems;

import java.util.List;

public class IvySeahorseEntity extends NoBucketSchoolingFishEntity implements Shearable {
	public static final TrackedData<Boolean> IS_SHEARED = DataTracker.registerData(IvySeahorseEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

	public IvySeahorseEntity(EntityType<? extends NoBucketSchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public void tick() {
		super.tick();

		List<Entity> entitiesAround = this.getWorld().getOtherEntities(null, this.getBoundingBox().expand(5), EntityPredicates.VALID_LIVING_ENTITY);

		for (Entity entity : entitiesAround) {
			if (entity instanceof LivingEntity mob && !(mob instanceof FishEntity) && !mob.hasStatusEffect(StatusEffects.POISON) && !mob.hasStatusEffect(StatusEffects.REGENERATION)) {
				mob.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20*5, 0));
			}
		}
	}

	@Override
	public boolean damage(DamageSource source, float amount) {
		Entity attacker = source.getAttacker();

		if (attacker instanceof LivingEntity livingAttacker && this.random.nextInt(3) == 0 && !this.getWorld().isClient) {
			livingAttacker.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*2, 1));
		}

		return super.damage(source, amount);
	}

	@Override
	protected ActionResult interactMob(PlayerEntity player, Hand hand) {
		ItemStack itemStack = player.getStackInHand(hand);
		World world = this.getWorld();

		if (itemStack.isOf(Items.SHEARS) && this.isShearable()) {
			this.sheared(SoundCategory.PLAYERS);
			this.emitGameEvent(GameEvent.SHEAR, player);

			if (!world.isClient) {
				itemStack.damage(1, player, (playerx) -> playerx.sendToolBreakStatus(hand));
			}

			return ActionResult.success(this.getWorld().isClient);
		}

		if (itemStack.isOf(Items.BONE_MEAL) && this.isSheared()) {
			itemStack.decrement(1);

			if (this.random.nextInt(5) == 0) {
				this.setShearedState(false);
				BoneMealItem.createParticles(this.getWorld(), this.getBlockPos(), 15);

				return ActionResult.success(this.getWorld().isClient);
			}

			return ActionResult.CONSUME;
		}

		return super.interactMob(player, hand);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(IS_SHEARED, false);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putBoolean("is_sheared", this.isSheared());
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.dataTracker.set(IS_SHEARED, nbt.getBoolean("is_sheared"));
	}

	public boolean isSheared() {
		return this.dataTracker.get(IS_SHEARED);
	}

	public void setShearedState(boolean value) {
		this.dataTracker.set(IS_SHEARED, value);
	}

	@Override
	public void sheared(SoundCategory shearedSoundCategory) {
		int random = this.random.nextInt(3);

		this.getWorld().playSoundFromEntity(null, this, SoundEvents.ENTITY_MOOSHROOM_SHEAR, shearedSoundCategory, 1.0F, 1.0F);
		this.setShearedState(true);

		for(int i = 0; i < random + 2; ++i) {
			this.getWorld().spawnEntity(new ItemEntity(this.getWorld(), this.getX(), this.getBodyY(1.0), this.getZ(), new ItemStack(AquaticPlusItems.IVY_BERRIES)));
		}
	}

	@Override
	public boolean isShearable() {
		return this.isAlive() && !this.isSheared();
	}

	public static DefaultAttributeContainer.Builder createIvySeahorseAttributes() {
		return AbstractEelEntity
			.createGenericEelAttributes()
			.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 10)
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 12);
	}
}
