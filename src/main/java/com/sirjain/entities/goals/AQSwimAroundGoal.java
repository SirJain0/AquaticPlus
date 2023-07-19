package com.sirjain.entities.goals;

import net.minecraft.entity.ai.brain.task.LookTargetUtil;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public class AQSwimAroundGoal extends WanderAroundGoal {
    private final int horziontalRange;
    private final int verticalRange;

    public AQSwimAroundGoal(PathAwareEntity pathAwareEntity, double speed, int chance, int horziontalRange, int verticalRange) {
        super(pathAwareEntity, speed, chance);
        this.horziontalRange = horziontalRange;
        this.verticalRange = verticalRange;
    }

    @Nullable
    protected Vec3d getWanderTarget() {
        return LookTargetUtil.find(this.mob, horziontalRange, verticalRange);
    }
}
