package fr.thegreensuits.viewing_party.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import fr.thegreensuits.viewing_party.Main;
import fr.thegreensuits.viewing_party.data.player.DataPlayer;
import lombok.Getter;

public class PlayerManager implements IManager, Listener {
    private JavaPlugin pluginInstance;
    @Getter
    private List<DataPlayer> players = new ArrayList<>();
    
    public PlayerManager() {
        super();

        this.pluginInstance = Main.INSTANCE;

        this.pluginInstance.getServer().getPluginManager().registerEvents(this, this.pluginInstance);
    }

    @Override
    public void init() {}

    public void addPlayer(DataPlayer player) {
        players.add(player);
    }

    public void removePlayer(DataPlayer player) {
        players.remove(player);
    }

    public void removePlayerByUUID(String uuid) {
        DataPlayer player = getPlayerByUUID(uuid);

        if (player != null) {
            removePlayer(player);
        }
    }

    public DataPlayer getPlayer(String name) {
        for (DataPlayer player : players) {
            if (player.getBukkitPlayer().getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public DataPlayer getPlayerByUUID(String uuid) {
        for (DataPlayer player : players) {
            if (player.getBukkitPlayer().getUniqueId().toString().equals(uuid)) {
                return player;
            }
        }
        return null;
    }

    public boolean isPlayerExist(String name) {
        for (DataPlayer player : players) {
            if (player.getBukkitPlayer().getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPlayerExistByUUID(String uuid) {
        for (DataPlayer player : players) {
            if (player.getBukkitPlayer().getUniqueId().toString().equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public void givePermissionToPlayer(String permission, Player player) {
        player.addAttachment(pluginInstance, permission, true);
    }

    public void hasPermission(String permission, Player player) {
        player.hasPermission(permission);
    }

    public void removePermissionFromPlayer(String permission, Player player) {
        player.addAttachment(pluginInstance, permission, false);
    }

    public void clear() {
        players.clear();
    }

    public int size() {
        return players.size();
    }

    private DataPlayer getPlayerOrCreate(Player player) {
        DataPlayer dataPlayer = getPlayerByUUID(player.getUniqueId().toString());

        if (dataPlayer == null) {
            dataPlayer = new DataPlayer.DataPlayerImpl(player);
            addPlayer(dataPlayer);
        }

        return dataPlayer;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        this.removePlayerByUUID(event.getPlayer().getUniqueId().toString());
        this.getPlayerOrCreate(event.getPlayer());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerQuit(PlayerJoinEvent event) {
        this.removePlayerByUUID(event.getPlayer().getUniqueId().toString());
    }
}
