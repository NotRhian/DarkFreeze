package net.oculate.darkfreeze.manager.managers;

import net.oculate.darkfreeze.DarkFreeze;
import net.oculate.darkfreeze.manager.Manager;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class PlayerManager extends Manager {

    public PlayerManager(DarkFreeze plugin) {
        super(plugin);
    }

    public void clearPlayerPotionEffects(Player player) {
        for(PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }
    }

}
