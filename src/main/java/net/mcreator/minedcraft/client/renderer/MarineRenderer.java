
package net.mcreator.minedcraft.client.renderer;

public class MarineRenderer extends HumanoidMobRenderer<MarineEntity, HumanoidModel<MarineEntity>> {

	public MarineRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));

	}

	@Override
	public ResourceLocation getTextureLocation(MarineEntity entity) {
		return new ResourceLocation("minedcraft:textures/entities/marine.png");
	}

}
