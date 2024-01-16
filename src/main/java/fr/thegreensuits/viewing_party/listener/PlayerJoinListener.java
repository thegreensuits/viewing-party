package fr.thegreensuits.viewing_party.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage("§8[§b+§8] §b" + event.getPlayer().getDisplayName() + "§7 a rejoint le serveur !");

        String color = event.getPlayer().isOp() ? "§c" : "§7";

        event.getPlayer().setDisplayName(String.format("%s%s", color, event.getPlayer().getName()));
        event.getPlayer().setPlayerListName(String.format("%s%s", color, event.getPlayer().getName()));
    }
}
