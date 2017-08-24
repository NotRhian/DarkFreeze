package net.oculate.darkfreeze.manager.managers;

import net.oculate.darkfreeze.DarkFreeze;
import net.oculate.darkfreeze.manager.Manager;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class FrozenManager extends Manager {

    private Set<UUID> frozenPlayers;
    private DarkFreeze plugin;

    public FrozenManager(DarkFreeze plugin) {
        super(plugin);
        this.plugin = plugin; // Clean this up. This is just temp bc im in a rush
        frozenPlayers = new HashSet<>();
    }

    public void freezePlayer(Player player) {
        frozenPlayers.add(player.getUniqueId());
        plugin.getManagerHandler().getPlayerManager().clearPlayerPotionEffects(player);

        player.sendMessage(plugin.getManagerHandler().getLangFile().getString("FROZEN.PLAYER.FROZEN"));
        player.setWalkSpeed(0.0F);

        player.getInventory().clear();
        player.updateInventory();

        //TODO: Make this open an inventory
    }

    public void unfreezePlayer(Player player) {
        frozenPlayers.remove(player.getUniqueId());
        //TODO: Make this restore inventory

        player.sendMessage(plugin.getManagerHandler().getLangFile().getString("FROZEN.PLAYER.UNFROZEN"));
        player.setWalkSpeed(1.0F /* TODO: Make this get stored walk speeds */);

        //TODO: Make this restore inventory's
        player.updateInventory();

        player.closeInventory();
    }

    public boolean isFrozen(UUID uuid) {
        return frozenPlayers.contains(uuid);
    }

    public void unfreezeAll() {
        frozenPlayers.clear();
    }
}