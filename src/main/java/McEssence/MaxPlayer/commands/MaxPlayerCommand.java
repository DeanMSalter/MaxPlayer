package McEssence.MaxPlayer.commands;

import McEssence.MaxPlayer.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MaxPlayerCommand implements CommandExecutor {

    private Main plugin;
    public MaxPlayerCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can run this command!");
            return false;
        }
        if (args.length == 0 || args[0].equalsIgnoreCase("help")) { // if no args or help
            help(sender);
        } else {
            switch(args[0]){
                case "reload":
                    return new reloadCommand(plugin).execute(sender, command, label, args);
                default:
                    help(sender);
                    return false;
            }
        }
        return false;
    }
    private void help(CommandSender sender){
        sender.sendMessage("maxplayer available commands:\n" +
                "/maxplayer");
    }
}
