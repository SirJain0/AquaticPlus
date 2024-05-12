package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.AlligatorGarEntity;
import com.sirjain.entities.models.AlligatorGarModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class AlligatorGarRenderer extends MobEntityRenderer<AlligatorGarEntity, AlligatorGarModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/alligator_gar.png");

	public AlligatorGarRenderer(EntityRendererFactory.Context context) {
		super(context, new AlligatorGarModel(context.getPart(AquaticPlusEntities.ALLIGATOR_GAR_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(AlligatorGarEntity entity) {
		return TEXTURE;
	}
}