package me.masterneb.queerhut;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin{

	public Permission masterbug = new Permission("nebubug.report");
	public Permission masterview = new Permission("nebubug.view");
	public Permission masterdel = new Permission("nebubug.delete");
	public Permission masterversion = new Permission("nebubug.version");
	public Permission masterstaff = new Permission("nebubug.staff");
	public Permission masterrandomteleport = new Permission ("nebubug.rtp");
	public Permission masterrandomteleportother = new Permission ("nebubug.rtpother");
	public Permission masterhug = new Permission ("nebubug.hug");
	public Permission masterkiss = new Permission ("nebubug.kiss");
	@Override
	public void onEnable() {

		PluginManager pm = getServer().getPluginManager();
		pm.addPermission(masterbug);
		pm.addPermission(masterview);
		pm.addPermission(masterdel);
		pm.addPermission(masterversion);
		pm.addPermission(masterstaff);
		pm.addPermission(masterrandomteleport);
		pm.addPermission(masterrandomteleportother);
		pm.addPermission(masterhug);
		pm.addPermission(masterkiss);
		
	}
	@Override
	public void onDisable() {
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player player = (Player) sender;		

		FileConfiguration config = this.getConfig();

		if (cmd.getName().equalsIgnoreCase("bug") && sender instanceof Player) {
			
			if (args.length >= 1) {
				
				String bugMessage = "";
				
				for (String arg : args) {
					bugMessage = bugMessage + arg + " ";
				}
				
				if (!config.contains(player.getName())) {
					config.set(player.getName(),  bugMessage);
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "Q" + ChatColor.GOLD + ChatColor.BOLD + "u" + ChatColor.YELLOW+ ChatColor.BOLD + "e" + ChatColor.GREEN + ChatColor.BOLD + "e" + ChatColor.AQUA + ChatColor.BOLD + "r" + ChatColor.BLUE + ChatColor.BOLD + "h" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "u" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "t" + ChatColor.GRAY + "] " + ChatColor.RED + " The Bug Report has been sent successfully. Thank you for your assistance");
				} else player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "Q" + ChatColor.GOLD + ChatColor.BOLD + "u" + ChatColor.YELLOW+ ChatColor.BOLD + "e" + ChatColor.GREEN + ChatColor.BOLD + "e" + ChatColor.AQUA + ChatColor.BOLD + "r" + ChatColor.BLUE + ChatColor.BOLD + "h" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "u" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "t" + ChatColor.GRAY + "] " + ChatColor.RED + " It seems like you have sent a bug report recently. If you feel that this is a mistake, Ask a high rank staff ingame or Skype.");
			} else player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "Q" + ChatColor.GOLD + ChatColor.BOLD + "u" + ChatColor.YELLOW+ ChatColor.BOLD + "e" + ChatColor.GREEN + ChatColor.BOLD + "e" + ChatColor.AQUA + ChatColor.BOLD + "r" + ChatColor.BLUE + ChatColor.BOLD + "h" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "u" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "t" + ChatColor.GRAY + "] " + ChatColor.RED + "  [Error] Enter your bug report after the /bug command.");

			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("viewbug")) {
			
			if (player.hasPermission(masterview)) {
				
				for (String key : config.getKeys(false)) {
					player.sendMessage(ChatColor.AQUA + key + ">> " + ChatColor.GREEN + config.getString(key));
					
				}
				
				if (config.getKeys(false).isEmpty()) {
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "Q" + ChatColor.GOLD + ChatColor.BOLD + "u" + ChatColor.YELLOW+ ChatColor.BOLD + "e" + ChatColor.GREEN + ChatColor.BOLD + "e" + ChatColor.AQUA + ChatColor.BOLD + "r" + ChatColor.BLUE + ChatColor.BOLD + "h" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "u" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "t" + ChatColor.GRAY + "] " + ChatColor.GREEN + " No bug report has been sent yet.");
				}

			} else player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "Q" + ChatColor.GOLD + ChatColor.BOLD + "u" + ChatColor.YELLOW+ ChatColor.BOLD + "e" + ChatColor.GREEN + ChatColor.BOLD + "e" + ChatColor.AQUA + ChatColor.BOLD + "r" + ChatColor.BLUE + ChatColor.BOLD + "h" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "u" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "t" + ChatColor.GRAY + "] " + ChatColor.RED + " You do not have permission to use this command. If you believe this is an error, Please contact any of the senior staff members for assistance");
			
			return true;
			
		}
		if (cmd.getName().equalsIgnoreCase("bugversion")) {
			
			if (player.hasPermission(masterversion)) {
				player.sendMessage(ChatColor.RED + "[----------------Queerhut Custom Plugin------------]");
				player.sendMessage(ChatColor.AQUA + "[---------------Plugin Version 1.5----------------]");
				player.sendMessage(ChatColor.GOLD + "[-------Custom Plugin made by Master_Nebulon-------]");
				player.sendMessage(ChatColor.RED + "[-If you have any questions or suggestions contact me with skype at" + ChatColor.GOLD + " live:techwizandrew" + ChatColor.GOLD + " I hope to hear from you soon -]");

			} else player.sendMessage(ChatColor.GREEN + "[Queerhut] " + ChatColor.RED + " You do not have permission to use this command. If you believe this is an error, Please contact any of the senior staff members for assistance");
			
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("staff")) {
			if (player.hasPermission(masterstaff)) {
				player.sendMessage(ChatColor.AQUA + "-------------" + ChatColor.RED + "" + ChatColor.BOLD + "Q" + ChatColor.GOLD + ChatColor.BOLD + "u" + ChatColor.YELLOW+ ChatColor.BOLD + "e" + ChatColor.GREEN + ChatColor.BOLD + "e" + ChatColor.AQUA + ChatColor.BOLD + "r" + ChatColor.BLUE + ChatColor.BOLD + "h" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "u" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "t" + ChatColor.AQUA + "Official Staff Team-------------");
				player.sendMessage(ChatColor.DARK_RED + "[Owner] " + ChatColor.GOLD + " Goldenphelix " + ChatColor.AQUA + " Owner of Queerhut");
				player.sendMessage(ChatColor.DARK_RED + "[Owner] " + ChatColor.GOLD + " slowsnake12 " + ChatColor.AQUA + " 2nd Owner of Queerhut");
				player.sendMessage(ChatColor.AQUA + "[Dev] " + ChatColor.GOLD + " Master_Nebulon " + ChatColor.AQUA + " Head Plugin Developer");
				player.sendMessage(ChatColor.RED + "[Admin] " + ChatColor.GOLD + " Ashykit " + ChatColor.AQUA + " Administrates Server");
				player.sendMessage(ChatColor.RED + "[Admin] " + ChatColor.GOLD + " Blondyke_ " + ChatColor.AQUA + " Administrates Server");
				player.sendMessage(ChatColor.RED + "[Admin] " + ChatColor.GOLD + " LieutenantSweet " + ChatColor.AQUA + " Administrates Server");
				player.sendMessage(ChatColor.RED + "[Admin] " + ChatColor.GOLD + " RyleeGames " + ChatColor.AQUA + " Administrates Server");
				player.sendMessage(ChatColor.AQUA + "[Mod] " + ChatColor.GOLD + " StrawberryLiz " + ChatColor.AQUA + " Moderates Server");
				player.sendMessage(ChatColor.AQUA + "[Mod] " + ChatColor.GOLD + " fallenshadowfbc " + ChatColor.AQUA + " Moderates Server");
				player.sendMessage(ChatColor.RED + "If you are staff but not on the Staff Team page, Please contact Master_Nebulon or report it on /bug");
			} else player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "Q" + ChatColor.GOLD + ChatColor.BOLD + "u" + ChatColor.YELLOW+ ChatColor.BOLD + "e" + ChatColor.GREEN + ChatColor.BOLD + "e" + ChatColor.AQUA + ChatColor.BOLD + "r" + ChatColor.BLUE + ChatColor.BOLD + "h" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "u" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "t" + ChatColor.GRAY + "] " + ChatColor.RED + " You do not have permission to use this command. If you believe this is an error, Please contact any of the senior staff members for assistance");

			return true;
	
		}
		if (cmd.getName().equalsIgnoreCase("hug")) {
			if (player.hasPermission(masterhug)) {
 				int length = args.length;
 				if (length == 1) {
 					for (Player playertoHug : Bukkit.getServer().getOnlinePlayers()) {
 						if(playertoHug.getName().equalsIgnoreCase(args[0])) {
 							playertoHug.sendMessage(ChatColor.AQUA + "?? " + ChatColor.LIGHT_PURPLE + "You have been hugged by " + ChatColor.BOLD + player.getName() + ChatColor.AQUA + " ??");
 							player.sendMessage(ChatColor.AQUA + "?? " + ChatColor.LIGHT_PURPLE + "You have hugged " + ChatColor.BOLD + playertoHug.getName() + ChatColor.AQUA + " ??");
 							
 						
 						}
					}
 				} else player.sendMessage(ChatColor.RED + "[Error] " + ChatColor.AQUA + "Incorrect Arguments. The correct way is /hug [Player]");
			} else player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "Q" + ChatColor.GOLD + ChatColor.BOLD + "u" + ChatColor.YELLOW+ ChatColor.BOLD + "e" + ChatColor.GREEN + ChatColor.BOLD + "e" + ChatColor.AQUA + ChatColor.BOLD + "r" + ChatColor.BLUE + ChatColor.BOLD + "h" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "u" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "t" + ChatColor.GRAY + "] " + ChatColor.RED + " You do not have permission to use this command. If you believe this is an error, Please contact Master_Nebulon or any of the senior staff members");
			
			return true;			
		}
		if (cmd.getName().equalsIgnoreCase("kiss")) {
			if (player.hasPermission(masterhug)) {
 				int length = args.length;
 				if (length == 1) {
 					for (Player playertoHug : Bukkit.getServer().getOnlinePlayers()) {
 						if(playertoHug.getName().equalsIgnoreCase(args[0])) {
 							playertoHug.sendMessage(ChatColor.AQUA + "?? " + ChatColor.LIGHT_PURPLE + "You have been kissed by " + ChatColor.BOLD + player.getName() + ChatColor.AQUA + " ??");
 							player.sendMessage(ChatColor.AQUA + "?? " + ChatColor.LIGHT_PURPLE + "You have kissed " + ChatColor.BOLD + playertoHug.getName() + ChatColor.AQUA + " ??");
 							
 						
 						}
					}
 				} else player.sendMessage(ChatColor.RED + "[Error] " + ChatColor.AQUA + "Incorrect Arguments. The correct way is /kiss [Player]");
			} else player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "Q" + ChatColor.GOLD + ChatColor.BOLD + "u" + ChatColor.YELLOW+ ChatColor.BOLD + "e" + ChatColor.GREEN + ChatColor.BOLD + "e" + ChatColor.AQUA + ChatColor.BOLD + "r" + ChatColor.BLUE + ChatColor.BOLD + "h" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "u" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "t" + ChatColor.GRAY + "] " + ChatColor.RED + " You do not have permission to use this command. If you believe this is an error, Please contact Master_Nebulon or any of the senior staff members");
			
			return true;			
			}
		if (cmd.getName().equalsIgnoreCase("rtp") && sender instanceof Player) {
	
			if (player.hasPermission(masterrandomteleport)) {			
	
		    Random random = new Random();
			
			Location teleportLocation = null;
			
			int x = random.nextInt(10000) + 1;
			int y = 150;
			int z = random.nextInt(10000) + 1;
			
			boolean isOnLand = false;
			
			while (isOnLand == false) {

				teleportLocation = new Location(player.getWorld(), x, y, z);
				
				if (teleportLocation.getBlock().getType() != Material.AIR) {
					isOnLand = true;
				} else y--;
			} 
			
			player.teleport(new Location(player.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1, teleportLocation.getZ()));
			
			player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "Q" + ChatColor.GOLD + ChatColor.BOLD + "u" + ChatColor.YELLOW+ ChatColor.BOLD + "e" + ChatColor.GREEN + ChatColor.BOLD + "e" + ChatColor.AQUA + ChatColor.BOLD + "r" + ChatColor.BLUE + ChatColor.BOLD + "h" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "u" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "t" + ChatColor.GRAY + "] " + ChatColor.GREEN + "You have been teleported to a random location");
			} else player.sendMessage(ChatColor.RED + "Q" + ChatColor.GOLD + "u" + ChatColor.YELLOW + "e" + ChatColor.GREEN + "e" + ChatColor.AQUA + "r" + ChatColor.BLUE + "h" + ChatColor.LIGHT_PURPLE + "u" + ChatColor.DARK_PURPLE + "t" + ChatColor.RED + " You do not have permission to use this command. If you believe this is an error, Please contact any of the senior staff members for assistance");
			return true;
			
			
		}
		if (cmd.getName().equalsIgnoreCase("rtpother")) {
			if (player.hasPermission(masterrandomteleportother)) {
 				int length = args.length;
 				if (length == 1) {
 					for (Player playertoTeleport : Bukkit.getServer().getOnlinePlayers()) {
 						if(playertoTeleport.getName().equalsIgnoreCase(args[0])) {
 						    Random random = new Random();
 							
 							Location teleportLocation = null;
 							
 							int x = random.nextInt(10000) + 1;
 							int y = 150;
 							int z = random.nextInt(10000) + 1;
 							
 							boolean isOnLand = false;
 							
 							while (isOnLand == false) {

 								teleportLocation = new Location(playertoTeleport.getWorld(), x, y, z);
 								
 								if (teleportLocation.getBlock().getType() != Material.AIR) {
 									isOnLand = true;
 								} else y--;
 							} 
 							
 							playertoTeleport.teleport(new Location(player.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1, teleportLocation.getZ()));
 						}
 					}
 				} else player.sendMessage(ChatColor.RED + "[Error] " + ChatColor.AQUA + "Incorrect Arguments. The correct way is /rtpother [Player]");
			} else player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "Q" + ChatColor.GOLD + ChatColor.BOLD + "u" + ChatColor.YELLOW+ ChatColor.BOLD + "e" + ChatColor.GREEN + ChatColor.BOLD + "e" + ChatColor.AQUA + ChatColor.BOLD + "r" + ChatColor.BLUE + ChatColor.BOLD + "h" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "u" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "t" + ChatColor.GRAY + "] " + ChatColor.RED + " You do not have permission to use this command. If you believe this is an error, Please contact Master_Nebulon or any of the senior staff members");
			
			return true;			
			
		}
		if (cmd.getName().equalsIgnoreCase("delbug"))
			
			if (args.length == 1 && player.hasPermission(masterdel)) {
				
				if (config.contains(args[0])) {
					
					config.set(args[0], null);
					saveConfig();
					player.sendMessage(ChatColor.RED + "Q" + ChatColor.GOLD + "u" + ChatColor.YELLOW + "e" + ChatColor.GREEN + "e" + ChatColor.AQUA + "r" + ChatColor.BLUE + "h" + ChatColor.LIGHT_PURPLE + "u" + ChatColor.DARK_PURPLE + "t" + ChatColor.AQUA + " Player's bug report has been deleted successfully. The player will now be able to make another bug report if they wish.");
	
				} else player.sendMessage(ChatColor.RED + "Q" + ChatColor.GOLD + "u" + ChatColor.YELLOW + "e" + ChatColor.GREEN + "e" + ChatColor.AQUA + "r" + ChatColor.BLUE + "h" + ChatColor.LIGHT_PURPLE + "u" + ChatColor.DARK_PURPLE + "t" + ChatColor.RED + " [Error]" + ChatColor.AQUA + " Player could not be found. Parhaps there wasn't a bug report from the player in the first place?");
				
			} else player.sendMessage(ChatColor.RED + "Q" + ChatColor.GOLD + "u" + ChatColor.YELLOW + "e" + ChatColor.GREEN + "e" + ChatColor.AQUA + "r" + ChatColor.BLUE + "h" + ChatColor.LIGHT_PURPLE + "u" + ChatColor.DARK_PURPLE + "t" + ChatColor.RED + " You do not have permission to use this command. If you believe this is an error, Please contact any of the senior staff members for assistance");
		
		
		return false;
	}
}

// Queerhut wrote in Bold and in correct Colors - player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "Q" + ChatColor.GOLD + ChatColor.BOLD + "u" + ChatColor.YELLOW+ ChatColor.BOLD + "e" + ChatColor.GREEN + ChatColor.BOLD + "e" + ChatColor.AQUA + ChatColor.BOLD + "r" + ChatColor.BLUE + ChatColor.BOLD + "h" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "u" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "t" + ChatColor.GRAY + "] " + 