package com.sirjain.entities.entity.projectile;

import com.sirjain.entities.entity.template.SelfKillingProjectileEntity;
import com.sirjain.registries.AquaticPlusEntities;
import com.sirjain.registries.AquaticPlusItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class FrostedSnowballProjectileEntity extends SelfKillingProjectileEntity {
        public FrostedSnowballProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
                super(entityType, world);
        }

        public FrostedSnowballProjectileEntity(World world, LivingEntity owner) {
                super(AquaticPlusEntities.FROSTED_SNOWBALL_PROJECTILE_ENTITY, world, owner);
        }

        @Override
        protected Item getDefaultItem() {
                return AquaticPlusItems.FROSTED_BALL;
        }

        @Override
        protected void onEntityHit(EntityHitResult entityHitResult) {
                super.onEntityHit(entityHitResult);

                Entity entity = entityHitResult.getEntity();
                LivingEntity target = ((LivingEntity) entity);
                if (target == null) return;

                boolean canDamage = !this.getWorld().isClient && !target.isDead();
                if (canDamage) {
                        if (target.canFreeze()) {
                                target.setFrozenTicks(target.getMinFreezeDamageTicks());
                                target.damage(target.getDamageSources().freeze(), 2);
                        }

                        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 6, 3, false, false, false));
                }

                summonParticle(ParticleTypes.SNOWFLAKE, entity.getWorld(), 8, target);
        }

        @Override
        protected void onCollision(HitResult hitResult) {
                super.onCollision(hitResult);
                this.kill();
        }

        @Override
        protected float getGravity() {
                return 0;
        }

        public static void summonParticle(ParticleEffect particle, World world, int numParticles, LivingEntity target) {
                if (world.isClient) {
                        for (int x = 0; x < numParticles; x++) {
                                int xRand = world.random.nextInt(2);
                                int yRand = world.random.nextInt(4);
                                int zRand = world.random.nextInt(2);
                                int negativeDecider = world.random.nextInt(1);

                                world.addParticle(
                                        particle,
                                        target.getX(),
                                        target.getRandomBodyY(),
                                        target.getZ(),
                                        negativeDecider == 0 ? xRand / 10f : -(xRand / 10f),
                                        yRand / 10f,
                                        negativeDecider == 0 ? zRand / 10f : -(zRand / 10f)
                                );
                        }
                }
        }
}
