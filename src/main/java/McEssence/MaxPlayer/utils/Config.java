package McEssence.MaxPlayer.utils;

import McEssence.MaxPlayer.Main;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    Main plugin;
    public Config(Main plugin) {
        this.plugin = plugin;
    }

    public boolean isENABLED() {
        return plugin.getConfig().getBoolean("enabled");
    }

    public int getMAXSLOTS() {
        return plugin.getConfig().getInt("maxSlots");
    }

    public int getMINSLOTS() {
        return plugin.getConfig().getInt("minSlots");
    }


}
