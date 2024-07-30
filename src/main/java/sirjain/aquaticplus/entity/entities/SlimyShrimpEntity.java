package sirjain.aquaticplus.entity.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.Shearable;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import sirjain.aquaticplus.entity.entities.template.APSchoolingFishEntity;
import sirjain.aquaticplus.item.AquaticPlusItems;

public class SlimyShrimpEntity extends APSchoolingFishEntity implements Shearable {
	public static final TrackedData<Boolean> IS_SHEARED = DataTracker.registerData(SlimyShrimpEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

	public SlimyShrimpEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(2, new TemptGoal(this, 0.8f, Ingredient.ofItems(Items.SUGAR_CANE), false));
	}

	@Override
	public ItemStack getBucketItem() {
		return null;
	}

	@Override
	protected ActionResult interactMob(PlayerEntity player, Hand hand) {
		ItemStack itemStack = player.getStackInHand(hand);
		World world = this.getWorld();

		if (itemStack.isOf(Items.SHEARS) && this.isShearable()) {
			this.sheared(SoundCategory.PLAYERS);
			this.emitGameEvent(GameEvent.SHEAR, player);

			if (!world.isClient) {
				itemStack.damage(1, player, (playerx) -> {
					playerx.sendToolBreakStatus(hand);
				});
			}

			return ActionResult.success(this.getWorld().isClient);
		}

		else if (itemStack.isOf(Items.SUGAR_CANE)) {
			this.heal(1);

			if (this.random.nextInt(3) == 0) {
				player.heal(4);

				if (!world.isClient) {
					((ServerWorld) world).spawnParticles(ParticleTypes.HEART, this.getX(), this.getRandomBodyY(), this.getZ(), 1, 0, 0.2f, 0, 1);
				}
			}

			if (this.random.nextInt(6) == 0) {
				this.setShearedState(false);

				if (!world.isClient) {
					((ServerWorld) world).spawnParticles(ParticleTypes.HEART, this.getX(), this.getRandomBodyY(), this.getZ(), 1, 0, 0.2f, 0, 1);
				}
			}

			return ActionResult.CONSUME;
		}

		return super.interactMob(player, hand);
	}

	// == Shearable ==

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
		int random = this.random.nextInt(2);

		this.getWorld().playSoundFromEntity(null, this, SoundEvents.ENTITY_MOOSHROOM_SHEAR, shearedSoundCategory, 1.0F, 1.0F);
		this.setShearedState(true);

		for(int i = 0; i < random + 1; ++i) {
			this.getWorld().spawnEntity(new ItemEntity(this.getWorld(), this.getX(), this.getBodyY(1.0), this.getZ(), new ItemStack(AquaticPlusItems.GHOSTLY_MEMBRANE)));
		}
	}

	@Override
	public boolean isShearable() {
		return isAlive() && !isSheared();
	}

	// Attributes
	public static DefaultAttributeContainer.Builder createSlimyShrimpAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 6)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 10);
	}
}