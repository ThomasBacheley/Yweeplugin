package fr.yweelon.yweeplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BankCMD implements CommandExecutor {
	
	private final Main main;
	private final FileConfiguration config;

	public BankCMD(Main main) {
		this.main = main;
		this.config = main.getConfig();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			
            Player p = (Player) sender;
        	
        	if(args.length > 0) {
        		switch(args[0]) {
                case "put":
                	put(p,args);
                	break;
                case "get":
                	get(p,args);
                	break;
                case "list":
                	list(p);
                	break;
                case "help":
                	p.sendMessage("/bank [get,put,list,help,pay]");
                	break;
                case "pay":
                	pay(p,args);
                	break;
                default:
                	check(p);
                	break;
                }
        	}else {
        		check(p);
        	}
		}
		return true;
	}
	
	private void put(Player p, String[] args) {
		
		int diamant_arg = Integer.parseInt(args[1]);
		Inventory inv = p.getInventory();
		
		ItemStack diams = new ItemStack(Material.DIAMOND);
		
    	if(inv.containsAtLeast(diams,diamant_arg)) {
    		
    		int new_bank_diamants = config.getInt("bank."+p.getName(),0) + diamant_arg;
    		
    		ItemStack diams_a_retirer = new ItemStack(Material.DIAMOND, diamant_arg);
    		
    		inv.removeItem(diams_a_retirer);
    		p.updateInventory();
    		
    		config.set("bank."+p.getName(), new_bank_diamants);
    		
    		main.saveDefaultConfig();
            main.saveConfig();
    		
    		p.sendMessage(String.format("%s diamants ajoutés à ta banque (nouveau solde:%s)",diamant_arg,new_bank_diamants));
    	}else {
    		p.sendMessage(String.format("Action imposible car tu ne possede pas %s diamants dans ton inventaire", diamant_arg));
    	}
	}
	
	private void get(Player p,String[] args) {
		int diamant_arg = Integer.parseInt(args[1]);
		int new_bank_diamants = config.getInt("bank."+p.getName(),0) - diamant_arg;
    	if(new_bank_diamants < 0) {
    		p.sendMessage(String.format("tu ne peux pas retirer %s diamants dans la banque car tu en possede que %s",diamant_arg,config.getInt("bank."+p.getName(),0)));
    	}else {
    		config.set("bank."+p.getName(), new_bank_diamants);
            
            main.saveDefaultConfig();
            main.saveConfig();

            ItemStack diams = new ItemStack(Material.DIAMOND, diamant_arg);
            
            p.getInventory().addItem(diams);
            
            p.sendMessage(String.format("tu viens de retirer %s diamants de ta banque (nouveau solde:%s)", diamant_arg, new_bank_diamants));
    	}
	}
	
	private void list(Player p) {
		String Yweelon = ChatColor.WHITE + "Yweelon : " + ChatColor.DARK_AQUA + config.getInt("bank.Yweelon") + " diamant(s)\n";
		String Tato = ChatColor.WHITE + "Tato : " + ChatColor.DARK_AQUA + " " + config.getInt("bank.Tato") + " diamant(s)\n";
		String Malamas = ChatColor.WHITE + "Malamas : " + ChatColor.DARK_AQUA + " " + config.getInt("bank.Malamas") + " diamant(s)\n";
		
		p.sendMessage(Yweelon + Tato + Malamas);
	}
	
	private void check(Player p) {
	
		int diamants_bank = config.getInt("bank."+p.getName(),0);
		
		if(diamants_bank>=1) {
			p.sendMessage("Tu possèdes "+ChatColor.DARK_AQUA+diamants_bank+ " diamant(s)");
		}else {
			p.sendMessage(ChatColor.RED + "Tu ne possèdes pas de diamants");
		}
		
	}
	
	private void pay(Player p, String[] args) {
		if(p.getName() != args[1]) {
			int diamants_bank = config.getInt("bank."+p.getName(),0);
			int diamants_a_donner = Integer.parseInt(args[2]);
			if(diamants_bank>=diamants_a_donner) {
				switch(args[1]) {
				case "Yweelon":
					config.set("bank.Yweelon", (config.getInt("bank.Yweelon") + diamants_a_donner));
					config.set("bank."+p.getName(), (diamants_bank-diamants_a_donner));
					p.sendMessage(String.format("Tu as payer %s diamants à Yweelon", diamants_a_donner));
					if(main.getServer().getPlayer("Yweelon") != null) {
						main.getServer().getPlayer("Yweelon").sendMessage(ChatColor.GREEN + p.getName() + "t'as donner "+diamants_a_donner+" diamant(s)");
					}
					break;
				case "Tato":
					config.set("bank.Tato", (config.getInt("bank.Tato") + diamants_a_donner));
					config.set("bank."+p.getName(), (diamants_bank-diamants_a_donner));
					p.sendMessage(String.format("Tu as payer %s diamants à Tato", diamants_a_donner));
					if(main.getServer().getPlayer("Tato") != null) {
						main.getServer().getPlayer("Tato").sendMessage(ChatColor.GREEN + p.getName() + "t'as donner "+diamants_a_donner+" diamant(s)");
					}
					break;
				case "Malamas":
					config.set("bank.Malamas", (config.getInt("bank.Malamas") + diamants_a_donner));
					config.set("bank."+p.getName(), (diamants_bank-diamants_a_donner));
					p.sendMessage(String.format("Tu as payer %s diamants à Malamas", diamants_a_donner));
					if(main.getServer().getPlayer("Malamas") != null) {
						main.getServer().getPlayer("Malamas").sendMessage(ChatColor.GREEN + p.getName() + "t'as donner "+diamants_a_donner+" diamant(s)");
					}
					break;
				default:
					p.sendMessage(ChatColor.RED + "Cette personne n'est pas recenser dans la banque");
					break;
				}
				main.saveDefaultConfig();
	            main.saveConfig();
			}else {
				p.sendMessage(ChatColor.RED + "Tu ne possèdes pas assez de diamants pour payer");
			}
		}else {
			p.sendMessage(ChatColor.RED + "Tu ne peux pas te payer toi meme");
		}
	}

}
