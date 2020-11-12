package me.TownyFeatures.fr;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command label, String cmd, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
            if (cmd.equalsIgnoreCase("reputation") || cmd.equalsIgnoreCase("rep")) {
            	try {
                	if (args[0].equalsIgnoreCase("information") || args[0].equalsIgnoreCase("info")) {
                		p.sendMessage(ChatColor.GOLD+".oOo.___________.[ Reputation's Towny Help ].___________.oOo."+ChatColor.GREEN+
                		"\nReputation is a system added in towny to make big killers less advantageous."+
                		"\nSo if you have a high reputation you will have a advantage over those who have low reputation." + 
                		"\nFor instance, you won't be able to tp to nation's spawn or create a town/Nation if you /rep is bellow 5.");
                	}
				} catch (ArrayIndexOutOfBoundsException e) {
					String rep;
                	if (Reputation.getReputation(p) < 5) {
                    	 rep = ChatColor.RED + " "+ Reputation.getReputation(p) ;

    				} else {
    					rep = ChatColor.DARK_GREEN+" "+Reputation.getReputation(p);
    				}
                    p.sendMessage(ChatColor.GOLD+"[Towny] "+ChatColor.GREEN+"You are a " + Reputation.ranking(p) + " and you have reputation(s) points "+rep );				
                    }


                
            }
			
            
			
		}
		return false;
	}

}
