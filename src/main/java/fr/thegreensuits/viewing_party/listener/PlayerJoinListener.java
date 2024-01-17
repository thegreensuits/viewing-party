package fr.thegreensuits.viewing_party.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Boolean isOp = player.isOp();

        event.setJoinMessage("§8[§b+§8] §b" + player.getDisplayName() + "§7 a rejoint le serveur !");

        String color = isOp ? "§c" : "§7";

        player.setDisplayName(String.format("%s%s", color, player.getName()));
        player.setPlayerListName(String.format("%s%s", color, player.getName()));

		player.setHealth(2.0);
		player.setFoodLevel(20);
		player.setExp(0);

        if(!isOp) {
            player.setGameMode(GameMode.ADVENTURE);
        }

        //TODO: TP to spawn on command
    }
}
