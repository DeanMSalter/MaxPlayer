package McEssence.MaxPlayer;

import McEssence.MaxPlayer.utils.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class Listeners implements Listener {
    Main instance;
    Config config;
    public Listeners(Main plugin, Config config) {
        this.instance = plugin;
        this.config = config;
    }

    @EventHandler
    public void onPing(ServerListPingEvent event) {
        if (!this.config.isENABLED()){
            return;
        }
        if(instance.getPlayerCount() < this.config.getMINSLOTS()){
            event.setMaxPlayers(this.config.getMINSLOTS());
            return;
        } else if (instance.getPlayerCount() >= this.config.getMINSLOTS() && instance.getPlayerCount() < this.config.getMAXSLOTS()) {
            event.setMaxPlayers(instance.getPlayerCount() + 1);
            return;
        }
        event.setMaxPlayers(this.config.getMAXSLOTS());
    }
}
