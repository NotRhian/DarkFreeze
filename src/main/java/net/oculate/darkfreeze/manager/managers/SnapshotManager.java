package net.oculate.darkfreeze.manager.managers;

import net.oculate.darkfreeze.DarkFreeze;
import net.oculate.darkfreeze.manager.Manager;
import net.oculate.darkfreeze.player.PlayerSnapshot;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SnapshotManager extends Manager {
    // Made by Ghose. Edited by Rhian
    private Map<UUID, PlayerSnapshot> playerSnapshotMap = new HashMap<>();

    public SnapshotManager(DarkFreeze plugin) {
        super(plugin);
    }

    public void takeSnapshot(Player player) {
        playerSnapshotMap.put(player.getUniqueId(), new PlayerSnapshot(player));
    }

    public void restorePlayer(Player player) {
        PlayerSnapshot playerSnapshot = getSnapshot(player);
        if(playerSnapshot != null) {
            player.getInventory().clear();
            player.getInventory().setContents(playerSnapshot.getMainContent());
            player.getInventory().setArmorContents(playerSnapshot.getArmorContent());
            player.setHealth(playerSnapshot.getHealth());
            player.setSaturation(playerSnapshot.getFoodLevel());
            player.setWalkSpeed(playerSnapshot.getWalkSpeed());
            player.addPotionEffects(playerSnapshot.getPotionEffects());
            player.updateInventory();
            removeSnapshot(player);
        }
    }

    private void removeSnapshot(Player player) {
        playerSnapshotMap.remove(player.getUniqueId());
    }

    private PlayerSnapshot getSnapshot(Player player) {
        return playerSnapshotMap.get(player.getUniqueId());
    }

    public void clearSnapshots() {
        playerSnapshotMap.clear();
    }
}