package fr.yweelon.yweeplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MapCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
            Player p = (Player) sender;
            p.sendMessage("http://yweelon.fr/minecraft.php");
            }
		return true;
	}

}
