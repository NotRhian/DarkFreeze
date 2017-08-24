package net.oculate.darkfreeze.player;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.Collection;

@Getter
public class PlayerSnapshot {
    // Made by Ghose edited by Rhian
    private ItemStack[] mainContent;
    private ItemStack[] armorContent;
    private Collection<PotionEffect> potionEffects;
    private float walkSpeed;
    private double health;
    private int foodLevel;

    public PlayerSnapshot(Player player) {
        this.mainContent = player.getInventory().getContents();
        this.armorContent = player.getInventory().getArmorContents();
        this.potionEffects = player.getActivePotionEffects();
        this.walkSpeed = player.getWalkSpeed();
        this.health = player.getHealth();
        this.foodLevel = player.getFoodLevel();
    }
}