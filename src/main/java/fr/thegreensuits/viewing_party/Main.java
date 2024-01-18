package fr.thegreensuits.viewing_party;

import org.bukkit.plugin.java.JavaPlugin;

import fr.thegreensuits.viewing_party.command.CommandDevmode;
import fr.thegreensuits.viewing_party.command.CommandSpawn;
import fr.thegreensuits.viewing_party.listener.AsyncPlayerChatListener;
import fr.thegreensuits.viewing_party.listener.BlockBreakListener;
import fr.thegreensuits.viewing_party.listener.EntityDamageListener;
import fr.thegreensuits.viewing_party.listener.EntityInteractListener;
import fr.thegreensuits.viewing_party.listener.PlayerInteractAtEntityListener;
import fr.thegreensuits.viewing_party.listener.PlayerInteractEntityListener;
import fr.thegreensuits.viewing_party.listener.PlayerInteractListener;
import fr.thegreensuits.viewing_party.listener.PlayerJoinListener;
import fr.thegreensuits.viewing_party.listener.PlayerQuitListener;
import fr.thegreensuits.viewing_party.managers.PlayerManager;
import lombok.Getter;

public class Main extends JavaPlugin {
    public static Main INSTANCE;

    @Getter
    public PlayerManager playerManager;

    public Main() {
        INSTANCE = this;
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void onEnable() {
        super.onEnable();

        this.playerManager = new PlayerManager();

        // - Register listeners
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), INSTANCE);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), INSTANCE);
        getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(), INSTANCE);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(), INSTANCE);
        getServer().getPluginManager().registerEvents(new PlayerInteractAtEntityListener(), INSTANCE);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), INSTANCE);
        getServer().getPluginManager().registerEvents(new EntityInteractListener(), INSTANCE);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), INSTANCE);
        getServer().getPluginManager().registerEvents(new PlayerInteractEntityListener(), INSTANCE);

        // - Register commands
        getCommand("spawn").setExecutor(new CommandSpawn());
        getCommand("devmode").setExecutor(new CommandDevmode());

        this.playerManager.init();

        getLogger().info("ViewingParty plugin enabled");
    }

    @Override
    public void onDisable() {
        super.onLoad();
        getLogger().info("ViewingParty plugin disabled");
    }

    /**
     * Set the devmode for running server.
     * 
     * Just set the server whitelist to true or false. 
     * 
     * @param devmode
     */
    public void setDevmode(boolean devmode) {
        if(devmode) {
            getServer().getOnlinePlayers().forEach(player -> {
                if(!player.isOp()) player.kickPlayer("§cLe serveur est passé en mode §a§lDEV§c. Revenez plus tard !");
            });
        }

        getServer().setWhitelist(devmode);
        getServer().broadcastMessage("§cLe serveur est passé en mode " + (devmode ? "§a§lDEV" : "§c§lPROD") + "§c.");
    }
}
