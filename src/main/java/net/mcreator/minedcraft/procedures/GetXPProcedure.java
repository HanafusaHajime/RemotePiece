package net.mcreator.minedcraft.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.minedcraft.network.MinedcraftModVariables;
import net.mcreator.minedcraft.entity.MarineEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GetXPProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof MarineEntity) {
			if (sourceentity instanceof Player) {
				{
					double _setval = 1 + (sourceentity.getCapability(MinedcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MinedcraftModVariables.PlayerVariables())).Level;
					sourceentity.getCapability(MinedcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Level = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Message"), false);
			}
		}
	}
}
