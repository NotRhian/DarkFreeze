package net.oculate.darkfreeze.manager.managers;

import lombok.Getter;
import net.oculate.darkfreeze.DarkFreeze;
import net.oculate.darkfreeze.manager.Manager;
import net.oculate.darkfreeze.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

@Getter
public class InventoryManager extends Manager {

    private Inventory frozenInventory;

    public InventoryManager(DarkFreeze plugin) {
        super(plugin);
        setupFrozenInventory();
    }

    private void setupFrozenInventory() {
        frozenInventory = Bukkit.createInventory(null, 9, plugin.getManagerHandler().getConfigFile().getString("FROZEN_INVENTORY.TITLE"));
        ItemStack infoItem = new ItemBuilder(Material.PAPER)
                .name(plugin.getManagerHandler().getConfigFile().getString("FROZEN_INVENTORY.TITLE"))
                .lore(plugin.getManagerHandler().getConfigFile().getStringList("FROZEN_INVENTORY.LORE")).build();

        frozenInventory.setItem(4, infoItem);
    }
}