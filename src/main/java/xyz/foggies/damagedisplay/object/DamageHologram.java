package xyz.foggies.damagedisplay.object;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import xyz.foggies.damagedisplay.utils.Colorize;
import xyz.foggies.damagedisplay.DamageDisplay;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author foggies on 10/10/2021.
 * @project DamageDisplay
 */
public class DamageHologram {

	private double damageAmount;
	private EntityType entityType;
	private Location location;

	public DamageHologram(double damageAmount, EntityType entityType, Location location) {
		this.damageAmount = damageAmount;
		this.entityType = entityType;
		this.location = location;
	}

	public void spawnHologram(){
		ArmorStand armorStand = (ArmorStand) this.location.getWorld().spawnEntity(this.location, EntityType.ARMOR_STAND);

		armorStand.setCustomName(Colorize.text(randomColor() + Math.floor(getDamageAmount())));
		armorStand.setCustomNameVisible(true);
		armorStand.setVisible(false);

		Bukkit.getScheduler().runTaskLaterAsynchronously(DamageDisplay.getPlugin(), armorStand::remove, 40);
	}

	private String randomColor(){
		int randomNumber = ThreadLocalRandom.current().nextInt(3);
		switch (randomNumber){
			case 0:
				return "&c";
			case 1:
				return "&e";
			case 2:
				return "&4";
			case 3:
				return "&f";
		}
		return "&f";
	}

	public double getDamageAmount() {
		return damageAmount;
	}

	public void setDamageAmount(double damageAmount) {
		this.damageAmount = damageAmount;
	}

	public EntityType getEntityType() {
		return entityType;
	}

	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
