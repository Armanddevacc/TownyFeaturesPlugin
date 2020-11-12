package me.TownyFeatures.fr;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.object.Resident;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	

	public static Main instance;


    public static Main getInstance(){
        return instance;
}

    		
	@Override
	public void onEnable() {
		instance = this;
	
		getServer().getConsoleSender().sendMessage("["+ChatColor.RED+"TownyFeatures"+ChatColor.GRAY+"] is enable, a doct_fr plugin");

        this.getCommand("reputation").setExecutor(new Commands());
        this.getCommand("rep").setExecutor(new Commands());

        //this.getCommand("townylocations").setTabCompleter(new CommandsCompleter());
        getServer().getPluginManager().registerEvents(new Event(), this);
        getServer().getPluginManager().registerEvents(new Reputation(), this);

		Configs.setup();
		Configs.getCustomfile().options().copyDefaults(true);
		Configs.save();
	}
	
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("["+ChatColor.RED+"TownyFeatures"+ChatColor.GRAY+"] is disable");
	}

}
