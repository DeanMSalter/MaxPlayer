package McEssence.MaxPlayer;

import McEssence.MaxPlayer.commands.MaxPlayerCommand;
import McEssence.MaxPlayer.commands.TabCompletion;
import McEssence.MaxPlayer.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main INSTANCE;
    Config config;
    @Override
    public void onLoad() {
        INSTANCE = this;
    }
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();
        config = new Config(this);
        getServer().getPluginManager().registerEvents(new Listeners(INSTANCE, config), this);
        registerCommands();
    }
    public String getDataFolderPath(){
        return getDataFolder().getPath();
    }
    @Override
    public void onDisable() {
        Bukkit.getLogger().info(ChatColor.GREEN + "Disabled " + this.getName());
    }

    private void registerCommands(){
        getCommand("maxplayer").setTabCompleter(new TabCompletion());
        getCommand("maxplayer").setExecutor(new MaxPlayerCommand(INSTANCE));
    }

    public int getPlayerCount() {
        return getServer().getOnlinePlayers().size();
    }
}
