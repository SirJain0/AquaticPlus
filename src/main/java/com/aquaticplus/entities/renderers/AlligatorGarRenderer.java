package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.AlligatorGarEntity;
import com.aquaticplus.entities.models.AlligatorGarModel;
import com.aquaticplus.registries.AquaticPlusEntities;
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