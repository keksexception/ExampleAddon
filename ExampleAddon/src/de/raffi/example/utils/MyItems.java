package de.raffi.example.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import de.raffi.druglabs.main.DrugLabs;
import de.raffi.strawberry.utils.ItemBuilder;

public class MyItems {
	
	public static ItemStack COCAINE = DrugLabs.VERSIONHANDLER.addTag(new ItemBuilder(Material.SUGAR).setName(MyConfig.ITEM_NAME_COCAINE).build(), "cocaine", true);
	public static ItemStack CUSTOM_BLOCK = DrugLabs.VERSIONHANDLER.addTag(new ItemBuilder(Material.CAULDRON_ITEM).setName(MyConfig.BLOCK_NAME_EXAMPLE).build(), "mycustomblock", true);

}
