package net.oculate.darkfreeze.listeners;

import net.oculate.darkfreeze.DarkFreeze;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class FrozenListener implements Listener {

    private DarkFreeze plugin;

    public FrozenListener(DarkFreeze plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onItemDropEvent(PlayerDropItemEvent event) {
        if (event.getPlayer() != null) {
            if (plugin.getManagerHandler().getFrozenManager().isFrozen(event.getPlayer().getUniqueId())) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {
        if(event.getEntity() instanceof Player) {
            if(plugin.getManagerHandler().getFrozenManager().isFrozen(event.getEntity().getUniqueId())) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if(event.getDamager() instanceof Player) {
            if(plugin.getManagerHandler().getFrozenManager().isFrozen(event.getEntity().getUniqueId())) {
                event.getDamager().sendMessage("Player is frozen"); //TODO: Config
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        if (event.getPlayer() != null) {
            if (plugin.getManagerHandler().getFrozenManager().isFrozen(event.getPlayer().getUniqueId())) {
                event.getPlayer().sendMessage("Can't do that while frozen!");
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        if (event.getPlayer() != null) {
            if (plugin.getManagerHandler().getFrozenManager().isFrozen(event.getPlayer().getUniqueId())) {
                event.getPlayer().sendMessage("Can't do that while frozen!");
                event.setCancelled(true);
            }
        }
    }
}
