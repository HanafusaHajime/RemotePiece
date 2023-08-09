package net.mcreator.minedcraft.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.minedcraft.network.MinedcraftModVariables;

public class XPAmountProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("##.##").format((entity.getCapability(MinedcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MinedcraftModVariables.PlayerVariables())).Level))),
					false);
	}
}
