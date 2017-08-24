package net.oculate.darkfreeze.manager;

import lombok.Getter;
import lombok.Setter;
import net.oculate.darkfreeze.DarkFreeze;
import net.oculate.darkfreeze.manager.managers.FrozenManager;
import net.oculate.darkfreeze.manager.managers.PlayerManager;
import net.oculate.darkfreeze.manager.managers.SnapshotManager;
import net.oculate.darkfreeze.utils.ConfigBuilder;

@Getter @Setter
public class ManagerHandler {

    private DarkFreeze plugin;
    private FrozenManager frozenManager;
    private PlayerManager playerManager;
    private SnapshotManager snapshotManager;
    private ConfigBuilder configFile, langFile;

    public ManagerHandler(DarkFreeze plugin) {
        this.plugin = plugin;
        loadManagers();
        loadConfigs();
    }

    private void loadManagers() { // This loads managers
        frozenManager = new FrozenManager(plugin);
        playerManager = new PlayerManager(plugin);
        snapshotManager = new SnapshotManager(plugin);
    }

    private void loadConfigs() { // This loads configuration files
        langFile = new ConfigBuilder(plugin, "lang");
        configFile = new ConfigBuilder(plugin, "config");
    }

    public void disable() { // This is for when the server shuts down
        this.frozenManager.unfreezeAll();
        this.snapshotManager.clearSnapshots();
    }
}