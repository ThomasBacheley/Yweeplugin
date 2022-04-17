package fr.yweelon.yweeplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class Events implements Listener {
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer(); 
		e.setJoinMessage(null);
		Bukkit.broadcastMessage(ChatColor.GREEN + " + "+ ChatColor.WHITE + player.getName() + " a rejoint le serveur");
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player player = e.getPlayer(); 
		e.setQuitMessage(null);
		Bukkit.broadcastMessage(ChatColor.RED + " - "+ ChatColor.WHITE + player.getName() + " a quitter le serveur");
	}
}