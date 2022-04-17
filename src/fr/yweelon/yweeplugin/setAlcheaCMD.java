package fr.yweelon.yweeplugin;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class setAlcheaCMD implements CommandExecutor {
	
	private final Main main;

	public setAlcheaCMD(Main main) {
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
            
            config.set("tp.alchea.world", world);
            config.set("tp.alchea.x", x);
            config.set("tp.alchea.y", y);
            config.set("tp.alchea.z", z);
            config.set("tp.alchea.yaw", yaw);
            config.set("tp.alchea.pitch", pitch);
            
            main.saveDefaultConfig();
            main.saveConfig();
            
            p.sendMessage("Alchea set");
		}
		return true;
	}

}
