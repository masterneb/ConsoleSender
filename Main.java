
package me.nebthedev.console;
/*
 * Version 1.0 (Tweaked a bit from the 0.1 and its fully up!)
 * Plugin made by NebTheDev
 * If you are reading this it means you have decompiled my plugin.
 * Cmon don't be like that.
 * Please do not copy this code for your own sake.
 * No! I said don't.
 * Watch yourself copying this code lol.
 * I hope to find this exact code somewhere else in the deep wide web.
 */

//All the imports and etc. I hope you know what this is if you have decompiled this.
import org.bukkit.Bukkit;
//another import
import org.bukkit.ChatColor;
//and another.
import org.bukkit.command.Command;
//and.... another.
import org.bukkit.command.CommandSender;
//hmm. When will this end?
import org.bukkit.plugin.java.JavaPlugin;
//Finally. Off to the main class.
public class Main extends JavaPlugin {
	
	//For those who don't know this runs when the plugin gets enabled.
	public void onEnable() {
		//For the people who decompiled my plugin, Don't remove this please?
		getLogger().info("Plugin made by NebTheDev");
		getLogger().info("Check out my other plugins at nebthedev.000webhostapp.com");
		getLogger().info("Enabling Console Sender");
		this.saveDefaultConfig();
	}
	//And this runs when the plugin gets disabled.
	public void onDisable() {
		//Don't remove this either please?
		getLogger().info("Plugin made by NebTheDev");
		getLogger().info("Check out my other plugins at nebthedev.000webhostapp.com");
		getLogger().info("Disabling Console Sender");
	}
	
	//This is the juicy stuff. Where all the commands happen and etc.
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//If you do /console.
		if(cmd.getName().equalsIgnoreCase("console")) {
			//If you are staff or some random player on the server. (I hope the owner didn't add this perm for some reason for defaults.
			if(sender.hasPermission("consolesender.use")) {
				//If you were dumb and just did /console without any commands to send.
				if (args.length == 0) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Prefix") + getConfig().getString("NoCmd")));
					return true;
				}
				//If you were smart and sent a command with /console. Good for you.
				if (args.length > 0) {
			        String command = "";
			        for (String arg : args) {
			          command = command + arg + " ";
			        }
			        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
			        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Prefix") + getConfig().getString("CommandSent") + command));
			        return true;
			        //Hmm. So much return trues. Do you think I'll ever get enough of them?
				}
				//If you are the "some random player" from the server. You get this message.
			} else sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Prefix") + getConfig().getString("NoPerm")));
			return true;
			//Nope. I'm back for more! Muhahhahahahaha!
		} //Hmm. If I did else (something) would it do that for every command except /console? Hmm. The mysteries of life.
		
		return true;
		//Ok. Enough is enough.
	}
	//Well wasn't that exciting? Now I'm off making more plugins while you read this message. Or I might be in my bed to lazy to get out.
	//Bye!
}
//Rip Plugin at this point.
