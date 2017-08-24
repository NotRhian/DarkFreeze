package net.oculate.darkfreeze;

import lombok.Getter;
import net.oculate.darkfreeze.manager.ManagerHandler;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class DarkFreeze extends JavaPlugin {

    private ManagerHandler managerHandler;

    @Override
    public void onEnable() {
        managerHandler = new ManagerHandler(this);
    }

    @Override
    public void onDisable() {
        managerHandler.disable();
    }
}
