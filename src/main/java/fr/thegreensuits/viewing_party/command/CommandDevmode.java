package fr.thegreensuits.viewing_party.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.thegreensuits.viewing_party.Main;

public class CommandDevmode implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;

        if(!sender.isOp()) {
            sender.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande.");
            return true;
        }

        // - Set devmode
        if(args.length >= 1 && args[0].equals("true")) Main.INSTANCE.setDevmode(true);
        else if(args.length >= 1 && args[0].equals("false")) Main.INSTANCE.setDevmode(false);
        else sender.sendMessage("§cUsage: /devmode <true|false>");

        return true;
	}
}
