package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.DumboBlobEntity;
import com.aquaticplus.entities.entity.SpiritedFishEntity;
import com.aquaticplus.entities.entity.boss.PhantomJellyfishEntity;
import com.aquaticplus.entities.features.APEmissiveTextureFeature;
import com.aquaticplus.entities.features.DumboBlobEmissiveTextureFeature;
import com.aquaticplus.entities.models.DumboBlobModel;
import com.aquaticplus.entities.models.PhantomJellyfishModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class PhantomJellyfishRenderer extends MobEntityRenderer<PhantomJellyfishEntity, PhantomJellyfishModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/phantom_jellyfish/phantom_jellyfish.png");
	public static final Identifier EMISSIVE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/phantom_jellyfish/phantom_jellyfish_e.png");

	public PhantomJellyfishRenderer(EntityRendererFactory.Context context) {
		super(context, new PhantomJellyfishModel(context.getPart(AquaticPlusEntities.PHANTOM_JELLYFISH_LAYER)), 0.75f);
		this.addFeature(new APEmissiveTextureFeature<>(this, TEXTURE));
	}

	@Override
	public Identifier getTexture(PhantomJellyfishEntity entity) {
		return TEXTURE;
	}

	@Nullable
	@Override
	protected RenderLayer getRenderLayer(PhantomJellyfishEntity entity, boolean showBody, boolean translucent, boolean showOutline) {
		return super.getRenderLayer(entity, showBody, true, showOutline);
	}
}