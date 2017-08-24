package net.oculate.darkfreeze.commands;

import net.oculate.darkfreeze.DarkFreeze;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeCommand implements CommandExecutor {

    private DarkFreeze plugin;

    public FreezeCommand(DarkFreeze plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] arguments) {
        if (!commandSender.hasPermission("oculate.staff.freeze")) {
            commandSender.sendMessage(plugin.getManagerHandler().getLangFile().getString("NO_PERMISSION"));
            return true;
        }

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Only players can do this. Fuck off");
            return false;
        }

        if (arguments.length != 1) {
            commandSender.sendMessage(plugin.getManagerHandler().getLangFile().getString("INVALID_ARGUMENTS"));
            return false;
        }

        if(plugin.getServer().getPlayer(arguments[0]) == null) {
            commandSender.sendMessage(plugin.getManagerHandler().getLangFile().getString("INVALID_ARGUMENTS"));
            return true;
        }
        // This is to unfreeze players
        if (plugin.getManagerHandler().getFrozenManager().isFrozen(plugin.getServer().getPlayer(arguments[0]).getUniqueId())) {
            commandSender.sendMessage(plugin.getManagerHandler().getLangFile().getString("FROZEN.STAFF.UNFROZEN") // This sends msg to the sender
                    .replace("%sender", commandSender.getName())
                    .replace("%player%", plugin.getServer().getPlayer(arguments[0]).getName()));
            plugin.getManagerHandler().getFrozenManager().unfreezePlayer(plugin.getServer().getPlayer(arguments[0]).getPlayer()); // Messages are set inside the manager
            return true;
        }
        commandSender.sendMessage(plugin.getManagerHandler().getLangFile().getString("FROZEN.STAFF.FROZEN") // This sends msg to the sender
                .replace("%sender", commandSender.getName())
                .replace("%player%", plugin.getServer().getPlayer(arguments[0]).getName()));

        plugin.getManagerHandler().getFrozenManager().freezePlayer(((Player) commandSender).getPlayer()); // Messages are set inside the manager
        return true;
    }
}
