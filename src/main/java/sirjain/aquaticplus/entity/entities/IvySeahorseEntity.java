package sirjain.aquaticplus.entity.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.Shearable;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import sirjain.aquaticplus.entity.entities.template.AbstractEelEntity;
import sirjain.aquaticplus.entity.entities.template.NoBucketSchoolingFishEntity;
import sirjain.aquaticplus.item.AquaticPlusItems;

public class IvySeahorseEntity extends NoBucketSchoolingFishEntity implements Shearable {
	public static final TrackedData<Boolean> IS_SHEARED = DataTracker.registerData(IvySeahorseEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

	public IvySeahorseEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
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
			this.getWorld().spawnEntity(new ItemEntity(this.getWorld(), this.getX(), this.getBodyY(1.0), this.getZ(), new ItemStack(AquaticPlusItems.GHOSTLY_MEMBRANE)));
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
