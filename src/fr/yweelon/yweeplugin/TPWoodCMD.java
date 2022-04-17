package fr.yweelon.yweeplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPWoodCMD implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
            Player p = (Player) sender;
            p.teleport(new Location(Bukkit.getWorld("tree_map"), -670.500, 11.500, 453.500,p.getLocation().getYaw(),p.getLocation().getPitch()));
            p.sendMessage(ChatColor.GREEN + "Téléportation vers La map Tree");
            }
        return true;
	}
}