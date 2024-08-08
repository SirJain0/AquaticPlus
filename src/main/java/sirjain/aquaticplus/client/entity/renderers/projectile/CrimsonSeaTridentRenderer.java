package sirjain.aquaticplus.client.entity.renderers.projectile;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.renderers.projectile.template.SeaTridentRenderer;
import sirjain.aquaticplus.entity.entities.template.SeaTridentEntity;

public class CrimsonSeaTridentRenderer extends SeaTridentRenderer {
	public CrimsonSeaTridentRenderer(EntityRendererFactory.Context ctx) {
		super(ctx);
	}

	@Override
	public Identifier getTexture(SeaTridentEntity entity) {
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/sea_trident/crimson_sea_trident.png");
	}
}
