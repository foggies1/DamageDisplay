package xyz.foggies.damagedisplay.listeners;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import xyz.foggies.damagedisplay.object.DamageHologram;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author foggies on 10/10/2021.
 * @project DamageDisplay
 */
public class AttackListener implements Listener {

	@EventHandler
	public void onEntityHit(EntityDamageByEntityEvent e){
		EntityType entityType = e.getEntityType();
		double damage = e.getDamage();
		int randomLocation = ThreadLocalRandom.current().nextInt(2);
		Location location = e.getEntity().getLocation().add(randomLocation, randomLocation, randomLocation);

		new DamageHologram(damage, entityType, location).spawnHologram();

	}

}
