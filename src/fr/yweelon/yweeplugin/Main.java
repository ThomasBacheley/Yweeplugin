package fr.yweelon.yweeplugin;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		System.out.print("Plugin Demarrer");
		
		getCommand("middmorten").setExecutor(new MiddmortenCMD(this));
		getCommand("alchea").setExecutor(new AlcheaCMD(this));
		getCommand("malamas").setExecutor(new MalamasCMD(this));
		

		getCommand("setmiddmorten").setExecutor(new setMiddmortenCMD(this));
		getCommand("setalchea").setExecutor(new setAlcheaCMD(this));
		getCommand("setmalamas").setExecutor(new setMalamasCMD(this));
		
		
		getCommand("wood").setExecutor(new TPWoodCMD());
		getCommand("build").setExecutor(new TPBuildCMD());
		getCommand("spawn").setExecutor(new TPSpawnCMD());
		
		getCommand("map").setExecutor(new MapCMD());
		getCommand("carte").setExecutor(new MapCMD());
		
		getServer().getPluginManager().registerEvents(new Events(),this);
		
		try {
			URL url = new URL("http://api.yweelon.fr/mc?state=start");
			HttpURLConnection con;
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onDisable() {
		try {
			URL url = new URL("http://api.yweelon.fr/mc?state=stop");
			HttpURLConnection con;
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("Plugin Eteint");
	}
	
	
}