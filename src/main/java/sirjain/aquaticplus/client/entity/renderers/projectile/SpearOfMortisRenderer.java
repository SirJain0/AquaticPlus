package sirjain.aquaticplus.client.entity.renderers.projectile;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.renderers.projectile.template.SeaTridentRenderer;
import sirjain.aquaticplus.entity.entities.projectile.SpearOfMortisEntity;
import sirjain.aquaticplus.entity.entities.template.SeaTridentEntity;

public class SpearOfMortisRenderer extends EntityRenderer<SpearOfMortisEntity> {
	public SpearOfMortisRenderer(EntityRendererFactory.Context ctx) {
		super(ctx);
	}

	@Override
	public Identifier getTexture(SpearOfMortisEntity entity) {
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/spear_of_mortis.png");
	}
}