package sirjain.aquaticplus.entity.entities.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class PinkSunfishAnimations {
	public static final Animation PINK_SUNFISH_SWIM = Animation.Builder.create(2.0F).looping()
		.addBoneAnimation("pink_sunfish_swim", new Transformation(Transformation.Targets.TRANSLATE,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.0417F, AnimationHelper.createTranslationalVector(-0.39F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.0833F, AnimationHelper.createTranslationalVector(-0.78F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.125F, AnimationHelper.createTranslationalVector(-1.15F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(-1.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.2083F, AnimationHelper.createTranslationalVector(-1.83F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createTranslationalVector(-2.12F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.2917F, AnimationHelper.createTranslationalVector(-2.38F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(-2.6F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createTranslationalVector(-2.77F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(-2.9F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(-2.97F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(-3.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(-2.97F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(-2.9F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.625F, AnimationHelper.createTranslationalVector(-2.77F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(-2.6F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7083F, AnimationHelper.createTranslationalVector(-2.38F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(-2.12F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7917F, AnimationHelper.createTranslationalVector(-1.83F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(-1.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createTranslationalVector(-1.15F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9167F, AnimationHelper.createTranslationalVector(-0.78F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(-0.39F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(0.39F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0833F, AnimationHelper.createTranslationalVector(0.78F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createTranslationalVector(1.15F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(1.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.2083F, AnimationHelper.createTranslationalVector(1.83F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createTranslationalVector(2.12F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.2917F, AnimationHelper.createTranslationalVector(2.38F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(2.6F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createTranslationalVector(2.77F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(2.9F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(2.97F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(3.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5417F, AnimationHelper.createTranslationalVector(2.97F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5833F, AnimationHelper.createTranslationalVector(2.9F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.625F, AnimationHelper.createTranslationalVector(2.77F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(2.6F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.7083F, AnimationHelper.createTranslationalVector(2.38F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createTranslationalVector(2.12F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.7917F, AnimationHelper.createTranslationalVector(1.83F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.8333F, AnimationHelper.createTranslationalVector(1.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createTranslationalVector(1.15F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.9167F, AnimationHelper.createTranslationalVector(0.78F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.9583F, AnimationHelper.createTranslationalVector(0.39F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("top_fin", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 39.85F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.0417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 39.96F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 39.39F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 38.15F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 36.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 33.74F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 30.64F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 27.02F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 22.94F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 18.47F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.4167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 13.68F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 8.66F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 3.49F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -1.74F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -6.95F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -12.03F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -16.9F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -21.49F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -25.71F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -29.49F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -32.77F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -35.48F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -37.59F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -39.05F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -39.85F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -39.96F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -39.39F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -38.15F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -36.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -33.74F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -30.64F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -27.02F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -22.94F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -18.47F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -13.68F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -8.66F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -3.49F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 1.74F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 6.95F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 12.03F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 16.9F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 21.49F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 25.71F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 29.49F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 32.77F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 35.48F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 37.59F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 39.05F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 39.85F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("bottom_fin", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -34.64F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.0417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -31.73F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -28.28F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -24.35F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -20.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -15.31F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -10.35F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -5.22F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 5.22F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.4167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 10.35F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 15.31F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 20.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 24.35F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 28.28F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 31.73F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 34.64F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 36.96F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 38.64F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 39.66F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 40.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 39.66F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 38.64F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 36.96F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 34.64F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 31.73F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 28.28F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 24.35F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 20.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 15.31F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 10.35F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 5.22F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -5.22F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -10.35F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -15.31F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -20.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -24.35F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -28.28F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -31.73F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -34.64F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -36.96F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -38.64F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -39.66F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -40.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -39.66F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -38.64F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -36.96F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -34.64F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 29.89F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.0417F, AnimationHelper.createRotationalVector(0.0F, 29.97F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.0833F, AnimationHelper.createRotationalVector(0.0F, 29.54F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.125F, AnimationHelper.createRotationalVector(0.0F, 28.61F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(0.0F, 27.19F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.2083F, AnimationHelper.createRotationalVector(0.0F, 25.3F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 22.98F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, 20.27F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 17.21F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 13.85F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.4167F, AnimationHelper.createRotationalVector(0.0F, 10.26F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 6.49F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 2.61F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, -1.31F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, -5.21F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, -9.02F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, -12.68F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7083F, AnimationHelper.createRotationalVector(0.0F, -16.12F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -19.28F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7917F, AnimationHelper.createRotationalVector(0.0F, -22.12F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, -24.57F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, -26.61F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9167F, AnimationHelper.createRotationalVector(0.0F, -28.19F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9583F, AnimationHelper.createRotationalVector(0.0F, -29.29F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -29.89F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0417F, AnimationHelper.createRotationalVector(0.0F, -29.97F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, -29.54F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, -28.61F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.1667F, AnimationHelper.createRotationalVector(0.0F, -27.19F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.2083F, AnimationHelper.createRotationalVector(0.0F, -25.3F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -22.98F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.2917F, AnimationHelper.createRotationalVector(0.0F, -20.27F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, -17.21F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createRotationalVector(0.0F, -13.85F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, -10.26F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, -6.49F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, -2.61F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5417F, AnimationHelper.createRotationalVector(0.0F, 1.31F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, 5.21F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.625F, AnimationHelper.createRotationalVector(0.0F, 9.02F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.6667F, AnimationHelper.createRotationalVector(0.0F, 12.68F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 16.12F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 19.28F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.7917F, AnimationHelper.createRotationalVector(0.0F, 22.12F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, 24.57F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 26.61F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.9167F, AnimationHelper.createRotationalVector(0.0F, 28.19F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.9583F, AnimationHelper.createRotationalVector(0.0F, 29.29F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 29.89F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.build();
}