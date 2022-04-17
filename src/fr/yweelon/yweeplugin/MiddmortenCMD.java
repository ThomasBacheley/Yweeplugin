package fr.yweelon.yweeplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class MiddmortenCMD implements CommandExecutor {
	
	private final Main main;

	public MiddmortenCMD(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
            Player p = (Player) sender;
            FileConfiguration config = main.getConfig();
            double x = config.getDouble("tp.middmorten.x", 10);
            double y = config.getDouble("tp.middmorten.y", 10);
            double z = config.getDouble("tp.middmorten.z", 10);
            
            float yaw = p.getLocation().getYaw();
            float pitch = p.getLocation().getPitch();
            
            p.teleport(new Location(Bukkit.getWorld(config.getString("tp.middmorten.world")), x,y,z,yaw,pitch));
            p.sendMessage(ChatColor.GOLD + "Téléportation vers Middmorten");
            }
        return true;
	}

}
