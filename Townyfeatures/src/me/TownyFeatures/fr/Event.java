package me.TownyFeatures.fr;

import java.awt.image.RescaleOp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerCommandEvent;

import com.palmergames.bukkit.towny.event.NationSpawnEvent;
import com.palmergames.bukkit.towny.event.NewTownEvent;
import com.palmergames.bukkit.towny.event.PreNewNationEvent;
import com.palmergames.bukkit.towny.event.PreNewTownEvent;
import com.palmergames.bukkit.towny.event.TownInvitePlayerEvent;
import com.palmergames.bukkit.towny.object.Resident;

public class Event implements Listener{

    @EventHandler
    public void onInviting(final TownInvitePlayerEvent event) {
		Resident res = event.getInvite().getReceiver();
		Player p = Bukkit.getServer().getPlayer(res.getName());
		
		if (Reputation.getReputation(p) >= 5) {
			event.getInvite().decline(true);
			p.sendMessage(ChatColor.RED+"You don't have enough reputation to enter a town, you need at least 5 points, you have "+ChatColor.DARK_RED+ Reputation.getReputation(p));
		}
		
		
		
	}
	

	
	
	
    @EventHandler
    public void onjoin(PlayerJoinEvent event) {
    	Player player = event.getPlayer();

    	try {
	    	Reputation.getReputation(player);
		} catch (NullPointerException e) {
	    	Reputation.setReputation(player, 5);
		}
		System.out.println("yes"+ Reputation.getReputation(player));
	}
	

    @EventHandler
    public void onSpawnNation(NationSpawnEvent event) {
    	Player player = event.getPlayer();
    	if (Reputation.getReputation(player) < 3) {
    		event.setCancelMessage(ChatColor.RED + "Your reputation is too low, you need at least 3 points of reputation to tp to an nation's spawn. You reputation is "+ Reputation.getReputation(player));
    		event.setCancelled(true);

		}
    	
    }

    
    
    //instance creation
    @EventHandler
    public void onNewNation(PreNewNationEvent event) {
    	Resident res = event.getTown().getMayor();
    	Player p = Bukkit.getServer().getPlayer(res.getName());
    	if (Reputation.getReputation(p) < 5) {
    		event.setCancelled(true);
    		event.setCancelMessage(ChatColor.RED+"You don't have enough reputation to create a Nation, you need at least 5 points, you have "+ChatColor.DARK_RED+ Reputation.getReputation(p));
		}
    }
    @EventHandler
    public void onNewTown(PreNewTownEvent event) {
		Player p = (Player) event.getPlayer();
			if (Reputation.getReputation(p) < 5) {
				event.setCancelled(true);
				event.setCancelMessage(ChatColor.RED+"You don't have enough reputation to create a Town, you need at least 5 points, you have "+ChatColor.DARK_RED+ Reputation.getReputation(p));
			}
	}
    //end instance creation


}
