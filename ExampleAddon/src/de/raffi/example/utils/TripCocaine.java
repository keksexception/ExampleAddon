package de.raffi.example.utils;

import org.bukkit.entity.Player;

import de.raffi.druglabs.drug.Trip;

public class TripCocaine extends Trip{

	public TripCocaine(Player player) {
		super(player, MyConfig.TRIP_COCAINE_UPDATETICKS, MyConfig.TRIP_COCAINE_DURARATION_SECONDS);
	}

	@Override
	public void onStart() {
			//add potion effects here
	}

	@Override
	public void onStop() {
		getPlayer().getActivePotionEffects().forEach(p->getPlayer().removePotionEffect(p.getType()));	 //clear all effects	
	}
	@Override
	public void runTrip() {
		//do things here
		getPlayer().setVelocity(getPlayer().getLocation().getDirection().multiply(0.4f).normalize());
		super.runTrip();
		//do not things here
	}

}
