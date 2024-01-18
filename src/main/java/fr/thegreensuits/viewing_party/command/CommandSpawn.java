package fr.thegreensuits.viewing_party.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpawn implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        player.teleport(player.getWorld().getSpawnLocation());
        player.sendMessage("§6Vous avez été téléporté au point d'apparition.");

        return true;
	}
}
