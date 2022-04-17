package fr.yweelon.yweeplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class AlcheaCMD implements CommandExecutor {
	
	private final Main main;

	public AlcheaCMD(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
            Player p = (Player) sender;
            FileConfiguration config = main.getConfig();
            double x = config.getDouble("tp.alchea.x", 10);
            double y = config.getDouble("tp.alchea.y", 10);
            double z = config.getDouble("tp.alchea.z", 10);
            
            float yaw = p.getLocation().getYaw();
            float pitch = p.getLocation().getPitch();
            
            p.teleport(new Location(Bukkit.getWorld(config.getString("tp.alchea.world")), x,y,z,yaw,pitch));
            p.sendMessage(ChatColor.DARK_PURPLE + "Téléportation vers Alchea");
            }
        return true;
	}

}
