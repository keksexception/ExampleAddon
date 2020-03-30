package de.raffi.example.listener;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import de.raffi.druglabs.economy.Shop;
import de.raffi.druglabs.economy.ShopItem;
import de.raffi.druglabs.event.FunctionblockAddEvent;
import de.raffi.druglabs.event.FunctionblockDestroyEvent;
import de.raffi.druglabs.event.FunctionblockInteractEvent;
import de.raffi.druglabs.event.InventoryCreationEvent;
import de.raffi.druglabs.event.RegisterAddonEvent;
import de.raffi.druglabs.event.InventoryCreationEvent.Type;
import de.raffi.druglabs.main.DrugLabs;
import de.raffi.druglabs.utils.Manager;
import de.raffi.druglabs.utils.SerializableLocation;
import de.raffi.druglabs.utils.Translations;
import de.raffi.example.block.MyCustomBlock;
import de.raffi.example.utils.MyConfig;
import de.raffi.example.utils.MyItems;
import de.raffi.example.utils.TripCocaine;

public class MyListener implements Listener{
	
	@EventHandler
	public void onRegister(RegisterAddonEvent e) {
		//LOAD HERE
		Translations.load(MyConfig.class);
		if(Translations.ECONOMY) { //check if economy is enabled
			if(MyConfig.DO_SELL_COCAINE)
				Shop.registerItem(new ShopItem(MyItems.COCAINE, -1, MyConfig.BUY_COCAINE, Translations.SHOP_CURRENCY)); //register the item
			if(MyConfig.DO_SELL_CUSTOMBLOCK)
				Shop.registerItem(new ShopItem(MyItems.CUSTOM_BLOCK, -1, MyConfig.BUY_CUSTOMBLOCK, Translations.SHOP_CURRENCY));
		}
		
	}
	@EventHandler
	public void onAdd(FunctionblockAddEvent e) {
		if(e.isAddedByPlayer()) {
			//do what ever you want
		}
	}
	@EventHandler
	public void onDestroy(FunctionblockDestroyEvent e) {
		if(e.isDestroyedByPlayer()) {
			//do what ever you want
		}
	}
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		if(DrugLabs.VERSIONHANDLER.hasTag(e.getItemInHand(), "mycustomblock")) {
			Manager.addBlock(e.getPlayer(), new MyCustomBlock(UUID.randomUUID(), SerializableLocation.toSerializable(e.getBlockPlaced().getLocation()), null));
		}
	}
	@EventHandler
	public void onAdd(FunctionblockInteractEvent e) {
		if(e.getBlock() instanceof MyCustomBlock) {
			e.getPlayer().sendMessage("§cYou are not allowed to interact with this block!");
			e.setCancelled(true); //cancels block interaction
		}
		
	}
	@EventHandler
	public void onCreate(InventoryCreationEvent e) {
		if(e.getType()==Type.ADMIN_INVENTORY) {
			e.getInventory().addItem(MyItems.COCAINE);
			e.getInventory().addItem(MyItems.CUSTOM_BLOCK);
		}
	}
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if(e.getAction()==Action.RIGHT_CLICK_AIR||e.getAction()==Action.RIGHT_CLICK_BLOCK) {
			if(DrugLabs.VERSIONHANDLER.hasTag(e.getItem(), "cocaine")) {
				new TripCocaine(e.getPlayer()).startTrip();
				int i = e.getPlayer().getItemInHand().getAmount()-1;
				if(i == 0) e.getPlayer().setItemInHand(new ItemStack(Material.AIR));
				else e.getPlayer().getItemInHand().setAmount(i);
			}
			
		}
	}
	

}
