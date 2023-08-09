package net.mcreator.minedcraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.minedcraft.network.MinedcraftModVariables;

public class XPAmountProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(
					Component.literal((new java.text.DecimalFormat("##.##").format((entity.getCapability(MinedcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MinedcraftModVariables.PlayerVariables())).Level))), false);
	}
}
