package net.oculate.darkfreeze;

import lombok.Getter;
import net.oculate.darkfreeze.commands.FreezeCommand;
import net.oculate.darkfreeze.listeners.FrozenListener;
import net.oculate.darkfreeze.listeners.PlayerListener;
import net.oculate.darkfreeze.manager.ManagerHandler;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class DarkFreeze extends JavaPlugin {

    private ManagerHandler managerHandler;

    @Override
    public void onEnable() {
        managerHandler = new ManagerHandler(this);
        this.registerListeners();
        this.getCommand("freeze").setExecutor(new FreezeCommand(this));
    }

    @Override
    public void onDisable() {
        managerHandler.disable();
    }

    private void registerListeners() {
        final PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new FrozenListener(this), this);
        pm.registerEvents(new PlayerListener(this), this);
    }
}
