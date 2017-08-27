package net.oculate.darkfreeze.manager.managers;

import net.oculate.darkfreeze.DarkFreeze;
import net.oculate.darkfreeze.manager.Manager;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class FrozenManager extends Manager {

    private Set<UUID> frozenPlayers;

    public FrozenManager(DarkFreeze plugin) {
        super(plugin);
        frozenPlayers = new HashSet<>();
    }

    public void freezePlayer(Player player) {
        frozenPlayers.add(player.getUniqueId());
        plugin.getManagerHandler().getSnapshotManager().takeSnapshot(player);
        plugin.getManagerHandler().getPlayerManager().clearPlayerPotionEffects(player);

        player.sendMessage(plugin.getManagerHandler().getLangFile().getString("FROZEN.PLAYER.FROZEN"));
        player.getInventory().clear();
        player.updateInventory();
        if (!plugin.getManagerHandler().getConfigFile().getBoolean("DISABLE_FROZEN_INVENTORY")) {
            player.openInventory(plugin.getManagerHandler().getInventoryManager().getFrozenInventory());
        }
    }

    public void unfreezePlayer(Player player) {
        frozenPlayers.remove(player.getUniqueId());
        plugin.getManagerHandler().getSnapshotManager().restorePlayer(player);

        player.sendMessage(plugin.getManagerHandler().getLangFile().getString("FROZEN.PLAYER.UNFROZEN"));

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