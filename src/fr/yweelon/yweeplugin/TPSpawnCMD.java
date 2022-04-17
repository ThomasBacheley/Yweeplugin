package fr.yweelon.yweeplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPSpawnCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
            Player player = (Player) sender;
            World world = Bukkit.getWorld("world");
            Location spawn = world.getSpawnLocation();
            
            Location location = new Location(world,spawn.getX(),spawn.getY(),spawn.getZ(),player.getLocation().getYaw(),player.getLocation().getPitch());
            player.teleport(location);
            
            player.sendMessage("Téléportation vers le Spawn");
            
            }
        return true;
	}

}