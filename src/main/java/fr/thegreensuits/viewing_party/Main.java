package fr.thegreensuits.viewing_party;

import org.bukkit.plugin.java.JavaPlugin;

import fr.thegreensuits.viewing_party.listener.AsyncPlayerChatListener;
import fr.thegreensuits.viewing_party.listener.EntityDamageListener;
import fr.thegreensuits.viewing_party.listener.PlayerInteractAtEntityListener;
import fr.thegreensuits.viewing_party.listener.PlayerJoinListener;
import fr.thegreensuits.viewing_party.listener.PlayerQuitListener;

public class Main extends JavaPlugin {
    public static Main INSTANCE;

    public Main() {
        INSTANCE = this;
    }

    @Override
    public void onEnable() {
        super.onEnable();

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), INSTANCE);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), INSTANCE);
        getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(), INSTANCE);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(), INSTANCE);
        getServer().getPluginManager().registerEvents(new PlayerInteractAtEntityListener(), INSTANCE);

        getLogger().info("ViewingParty plugin enabled");
    }

    @Override
    public void onDisable() {
        super.onLoad();
        getLogger().info("ViewingParty plugin disabled");
    }
}
