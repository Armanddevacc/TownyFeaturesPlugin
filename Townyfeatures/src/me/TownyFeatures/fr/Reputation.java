package me.TownyFeatures.fr;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.libs.jline.console.KillRing;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import com.google.common.base.CaseFormat;


public class Reputation implements Listener{
   
	
	
	public static int getReputation(Player player) {
		try {
			Configs.getCustomfile().get(player.getName());
		} catch (NullPointerException e) {
			setReputation(player, 5);
		}
		return (int) Configs.getCustomfile().get(player.getName());
	}
	public static void setReputation(Player p, int x) {
		Configs.setCustomfile(p, x);
		Configs.save();
	}
	public static void addReputationPoints(Player p, int x) {
		if (getReputation(p) >= 0) {
			
		} 
		switch (getReputation(p))
		{
		  case 0:
			  if (x>0) {
					int i = getReputation(p) +x;
					Configs.setCustomfile(p, i);
					Configs.save();  
			}
		    break;   
		  case 10:
			  if (x<10) {
					int i = getReputation(p) +x;
					Configs.setCustomfile(p, i);
					Configs.save();  
			}
			  break;
		  default:
				int i = getReputation(p) +x;
				Configs.setCustomfile(p, i);
				Configs.save();            
		}

	}
	
	public static String ranking(Player p) {
		int rep = getReputation(p);
		String rank;
		switch (rep)
		{
		  case 0:
			  rank = ChatColor.DARK_RED+"Criminal";
		    break;   
		  case 1:
			  rank = ChatColor.RED+"Criminal";
			    break;
		  case 2:
			  rank = ChatColor.RED+"Criminal";
			    break;
		  case 3:
			  rank = ChatColor.YELLOW+"Fugitive";
			    break;
		  case 4:
			  rank = ChatColor.YELLOW+"Fugitive";
			    break;
		  case 8:
			  rank = ChatColor.GREEN+"Virtuous";
			    break;
		  case 9:
			  rank = ChatColor.DARK_GREEN+"Vigilante";
			    break;
		  case 10:
			  rank = ChatColor.DARK_GREEN+"Hero";
			  break;
		  default:
			  rank = ChatColor.GREEN+"Neutral";
		}
		
		return rank;
	}
	
	
	
	
	@SuppressWarnings("unlikely-arg-type")
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event){
		EntityType e = event.getEntityType();

			if(event.getEntity().getKiller() instanceof Player)
			{

				if (e.equals(EntityType.ZOMBIE)) {
					Player p = (Player) event.getEntity().getKiller();


					addReputationPoints(p, 1);
					
				}
				if (e.equals(EntityType.SKELETON)) {
					Player p = (Player) event.getEntity().getKiller();

					addReputationPoints(p, -1);
					
				

			
			}
                }
        }


}
