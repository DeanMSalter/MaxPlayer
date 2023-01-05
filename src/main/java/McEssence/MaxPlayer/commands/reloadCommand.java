package McEssence.MaxPlayer.commands;

import McEssence.MaxPlayer.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class reloadCommand {
    Main plugin;
    public reloadCommand(Main plugin) {
        this.plugin = plugin;
    }

    public boolean execute(CommandSender sender, Command command, String label, String[] args){
        if (sender.hasPermission("maxPlayer.reload")) {
            plugin.reloadConfig();
            sender.sendMessage("Reload Complete");
        }
        return true;
    }

}
