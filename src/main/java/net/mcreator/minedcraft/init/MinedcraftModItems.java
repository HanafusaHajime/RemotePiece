
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minedcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.minedcraft.MinedcraftMod;

public class MinedcraftModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MinedcraftMod.MODID);
	public static final RegistryObject<Item> MARINE_SPAWN_EGG = REGISTRY.register("marine_spawn_egg", () -> new ForgeSpawnEggItem(MinedcraftModEntities.MARINE, -1, -13408513, new Item.Properties()));
}
