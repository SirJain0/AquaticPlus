package com.sirjain.entities.entity.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class PinkSunfishAnimations {
	public static final Animation PINK_SUNFISH_SWIM = Animation.Builder.create(2.0417F).looping()
		.addBoneAnimation("sunfish", new Transformation(Transformation.Targets.TRANSLATE,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("top_fin", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 30.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -30.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 30.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("bottom_fin", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -30.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 30.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -30.0F), Transformation.Interpolations.CUBIC)
		))
		.build();
}
