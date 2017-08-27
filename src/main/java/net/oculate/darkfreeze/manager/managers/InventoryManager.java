package net.oculate.darkfreeze.manager.managers;

import lombok.Getter;
import net.oculate.darkfreeze.DarkFreeze;
import net.oculate.darkfreeze.manager.Manager;
import net.oculate.darkfreeze.utils.ItemBuilder;
import net.oculate.darkfreeze.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

@Getter
public class InventoryManager extends Manager {

    private Inventory frozenInventory;

    public InventoryManager(DarkFreeze plugin) {
        super(plugin);
        setupFrozenInventory();
    }

    private void setupFrozenInventory() {
        List<String> itemInfoLore = new ArrayList<>();
        String separators = StringUtils.repeat(
                plugin.getManagerHandler().getConfigFile().getString("FROZEN_INVENTORY.SEPARATORS.COLOR" + "-"),
                plugin.getManagerHandler().getConfigFile().getInt("FROZEN_INVENTORY.SEPARATORS.SIZE")
        );

        for (String string : plugin.getManagerHandler().getLangFile().getStringList("FROZEN_INVENTORY.LORE")) {
            itemInfoLore.add(string
                    .replace("%separators%", separators)
                    .replace("%ts_ip%", plugin.getManagerHandler().getConfigFile().getString("TEAMSPEAK_IP")));
        }

        frozenInventory = Bukkit.createInventory(null, 9, plugin.getManagerHandler().getConfigFile().getString("FROZEN_INVENTORY.TITLE"));
        ItemStack infoItem = new ItemBuilder(Material.PAPER)
                .name(plugin.getManagerHandler().getConfigFile().getString("FROZEN_INVENTORY.TITLE"))
                .lore(itemInfoLore)
                .build();

        frozenInventory.setItem(4, infoItem);
    }
}