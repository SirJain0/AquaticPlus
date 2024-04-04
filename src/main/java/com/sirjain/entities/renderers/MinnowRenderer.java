package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.MinnowEntity;
import com.sirjain.entities.entity.SardineEntity;
import com.sirjain.entities.models.MinnowModel;
import com.sirjain.entities.models.SardineModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class MinnowRenderer extends MobEntityRenderer<MinnowEntity, MinnowModel> {
	public MinnowRenderer(EntityRendererFactory.Context context) {
		super(context, new MinnowModel(context.getPart(AquaticPlusEntities.MINNOW_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(MinnowEntity entity) {
		return switch(entity.getVariant()) {
			case ONE -> buildTextureID("");
			case TWO -> buildTextureID("");
			case THREE -> buildTextureID("");
			case FOUR -> buildTextureID("");
		};
	}

	public static Identifier buildTextureID(String id) {
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/minnow/minnow_" + id + ".png");
	}
}