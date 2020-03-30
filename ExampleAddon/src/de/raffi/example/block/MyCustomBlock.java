package de.raffi.example.block;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import de.raffi.druglabs.blocks.FunctionBlock;
import de.raffi.druglabs.blocks.Interactable;
import de.raffi.druglabs.utils.SerializableLocation;
import de.raffi.druglabs.utils.Translations;
import de.raffi.example.utils.MyConfig;

public class MyCustomBlock extends FunctionBlock implements Interactable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7732592821497673002L;

	public MyCustomBlock(UUID id, SerializableLocation loc, Inventory blockInventory) {
		super(id, loc, blockInventory);
	}

	@Override
	public void spawn(Player p) {
		p.sendMessage(Translations.MESSAGE_BLOCK_PLACED.replace("%", MyConfig.BLOCK_NAME_EXAMPLE));
		
	}

	@Override
	public void destroy(Player p) {
		p.sendMessage(Translations.MESSAGE_BLOCK_REMOVED.replace("%", MyConfig.BLOCK_NAME_EXAMPLE));
		
	}

	@Override
	public void onInteract(Player p) {
		//only called if you implement interactable, don't open blockinventory here
	}

}
