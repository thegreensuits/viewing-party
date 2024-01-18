package fr.thegreensuits.viewing_party;

import org.bukkit.plugin.java.JavaPlugin;

import fr.thegreensuits.viewing_party.listener.AsyncPlayerChatListener;
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

        this.playerManager = new PlayerManager();
    }

    @Override
    public void onEnable() {
        super.onEnable();

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), INSTANCE);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), INSTANCE);
        getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(), INSTANCE);

        this.playerManager.init();

        getLogger().info("ViewingParty plugin enabled");
    }

    @Override
    public void onDisable() {
        super.onLoad();
        getLogger().info("ViewingParty plugin disabled");
    }
}
