package com.aquaticplus.entities.ai;

import net.minecraft.entity.mob.PathAwareEntity;
import net.tslat.smartbrainlib.api.core.behaviour.custom.misc.Idle;

public class IdleIfNoTarget<E extends PathAwareEntity> extends Idle<E> {
	@Override
	protected boolean shouldKeepRunning(E entity) {
		return entity.getTarget() == null;
	}
}