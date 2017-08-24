package net.oculate.darkfreeze.manager;

import lombok.Getter;
import lombok.Setter;
import net.oculate.darkfreeze.DarkFreeze;
import net.oculate.darkfreeze.manager.managers.FrozenManager;

@Getter @Setter
public class ManagerHandler {
    private DarkFreeze plugin;

    private FrozenManager frozenManager;

    public ManagerHandler(DarkFreeze plugin) {
        this.plugin = plugin;
        loadManagers();
    }

    private void loadManagers() {
        frozenManager = new FrozenManager(plugin);
    }

    public void disable() {
        frozenManager.unfreezeAll();
    }
}