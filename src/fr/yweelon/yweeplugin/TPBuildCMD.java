package fr.yweelon.yweeplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPBuildCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
            Player p = (Player) sender;
            p.teleport(new Location(Bukkit.getWorld("build"), 0.500, -12.500, 0.500,p.getLocation().getYaw(),p.getLocation().getPitch()));
            p.sendMessage("Téléportation vers le monde Build");
            }
        return true;
	}

}
