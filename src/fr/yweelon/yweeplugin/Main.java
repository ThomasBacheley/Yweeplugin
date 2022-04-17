package fr.yweelon.yweeplugin;

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
		
		getCommand("bank").setExecutor(new BankCMD(this));
		
		getServer().getPluginManager().registerEvents(new Events(),this);
	}
	
	@Override
	public void onDisable() {
		System.out.print("Plugin Eteint");
	}
	
}