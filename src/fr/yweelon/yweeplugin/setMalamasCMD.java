package fr.yweelon.yweeplugin;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class setMalamasCMD implements CommandExecutor {
	
	private final Main main;

	public setMalamasCMD(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
            Player p = (Player) sender;
            Location playerlocation = p.getLocation();
            String world  = playerlocation.getWorld().getName();
            
            double x = playerlocation.getX();
            double y = playerlocation.getY();
            double z = playerlocation.getZ();
            float yaw = playerlocation.getYaw();
            float pitch = playerlocation.getPitch();
            
            FileConfiguration config = main.getConfig();
            
            config.set("tp.malamas.world", world);
            config.set("tp.malamas.x", x);
            config.set("tp.malamas.y", y);
            config.set("tp.malamas.z", z);
            config.set("tp.malamas.yaw", yaw);
            config.set("tp.malamas.pitch", pitch);
            
            main.saveDefaultConfig();
            main.saveConfig();
            
            p.sendMessage("malamas set");
		}
		return true;
	}

}
