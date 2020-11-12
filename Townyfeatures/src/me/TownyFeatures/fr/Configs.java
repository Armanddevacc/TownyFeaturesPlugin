package me.TownyFeatures.fr;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Configs
{
    private static File file;
    private static FileConfiguration configfile;
    
    public static void setup() {
        Configs.file = new File(Bukkit.getServer().getPluginManager().getPlugin("TownyFeatures").getDataFolder(), "data.yml");
        if (!Configs.file.exists()) {
            try {
                Configs.file.createNewFile();
            }
            catch (IOException ex) {}
        }
        Configs.configfile = (FileConfiguration)YamlConfiguration.loadConfiguration(Configs.file);
    }
    

    
    public static void save() {
        try {
            Configs.configfile.save(Configs.file);
        }
        catch (IOException e) {
            System.out.println("cannot save");
        }
    }
    
    public static void reload() {
        Configs.configfile = (FileConfiguration)YamlConfiguration.loadConfiguration(Configs.file);
    }
    
    
    
   
    public static FileConfiguration getCustomfile() {
        return Configs.configfile;
    }
    
    
    
    public static void setCustomfile(final Player player, final int reputation) {
        Configs.configfile.set(player.getName(), (int)reputation);
    }
}