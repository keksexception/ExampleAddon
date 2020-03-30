package de.raffi.example.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.raffi.example.listener.MyListener;

public class Example extends JavaPlugin{
	
	private static Example plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		Bukkit.getPluginManager().registerEvents(new MyListener(), this);
		
	}
	public static Example getPlugin() {
		return plugin;
	}
	
}
