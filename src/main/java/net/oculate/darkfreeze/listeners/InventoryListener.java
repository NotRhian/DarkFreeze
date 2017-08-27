package net.oculate.darkfreeze.listeners;

import net.oculate.darkfreeze.DarkFreeze;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class InventoryListener implements Listener {

    private DarkFreeze plugin;

    public InventoryListener(DarkFreeze plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryCloseEvent(InventoryCloseEvent event) {
        if (event.getInventory().equals(plugin.getManagerHandler().getInventoryManager().getFrozenInventory())) {
            if (plugin.getManagerHandler().getFrozenManager().isFrozen(event.getPlayer().getUniqueId())) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        event.getPlayer().openInventory(plugin.getManagerHandler().getInventoryManager().getFrozenInventory());
                    }
                }.runTaskLater(plugin.getManagerHandler().getPlugin(), 1);
            }
        }
    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        if (event.getInventory().equals(plugin.getManagerHandler().getInventoryManager().getFrozenInventory())) {
            if (plugin.getManagerHandler().getFrozenManager().isFrozen(event.getWhoClicked().getUniqueId())) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInventoryDragEvent(InventoryDragEvent event) {
        if (event.getInventory().equals(plugin.getManagerHandler().getInventoryManager().getFrozenInventory())) {
            if (plugin.getManagerHandler().getFrozenManager().isFrozen(event.getWhoClicked().getUniqueId())) {
                event.setCancelled(true);
            }
        }
    }
}