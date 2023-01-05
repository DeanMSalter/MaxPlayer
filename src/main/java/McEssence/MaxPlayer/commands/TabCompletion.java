package McEssence.MaxPlayer.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabCompletion implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {
        List<String> list = new ArrayList<>();
        if(command.getName().equalsIgnoreCase("maxplayer")){
            if(sender instanceof Player){
                if(sender.hasPermission("maxPlayer.reload")) {
                    list.add("reload");
                }
            }
        }
        return list;
    }
}