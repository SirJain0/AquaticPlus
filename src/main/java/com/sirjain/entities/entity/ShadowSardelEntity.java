package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.APSchoolingFishEntity;
import com.sirjain.registries.AquaticPlusEntities;
import com.sirjain.registries.AquaticPlusItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.MoveIntoWaterGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class ShadowSardelEntity extends APSchoolingFishEntity {
	public boolean variantSpawned = false;

	public ShadowSardelEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(0, new MoveIntoWaterGoal(this));
	}

	@Override
	public boolean shouldRenderName() {
		return false;
	}

	@Override
	public ItemStack getBucketItem() {
		return AquaticPlusItems.SHADOW_SARDEL_BUCKET.getDefaultStack();
	}

	@Override
	public void tick() {
		super.tick();

		if (this.hasCustomName()) {
			Text name = this.getCustomName();

			// Check: name is 'Johnson'
			if (Text.literal("Johnson").equals(name) && !variantSpawned) {
				handleVariant(AquaticPlusEntities.JOHNSON_ENTITY);
				variantSpawned = true;
			}

			// Check: name is 'Mindinator'
			else if (Text.literal("Mindinator").equals(name) && !variantSpawned) {
				handleVariant(AquaticPlusEntities.MINDINATOR_ENTITY);
				variantSpawned = true;
			}
		}
	}

	public void handleVariant(EntityType<ShadowSardelEasterEggEntity> entityType) {
		ShadowSardelEasterEggEntity entity = entityType.create(this.getWorld());
		if (entity == null) return;
		entity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), 0.0F);
		this.getWorld().spawnEntity(entity);

		this.discard();
		this.kill(); // To make sure everything of it is removed.
	}

	public static DefaultAttributeContainer.Builder createShadowSardelAttributes() {
		return SchoolingFishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 5)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 3);
	}
}