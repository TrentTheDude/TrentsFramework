package me.trent;

import me.trent.command.CommandExecutors;
import me.trent.holograms.HologramManager;
import me.trent.json.JSONUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.InvocationTargetException;

public class Framework {

    private static Framework framework;
    private Plugin plugin;
    private HologramManager hologramManager;
    private JSONUtils jsonUtils;
    private CommandExecutors commandExecutors;

    public Framework(Plugin plugin){
        this.plugin = plugin;
        framework = new Framework(plugin);
        this.hologramManager = new HologramManager();
        this.jsonUtils = new JSONUtils();
        this.commandExecutors = new CommandExecutors();


        getCommandExecutors().registerDefaultCommands();
    }

    public static Framework getFramework() {
        return framework;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public CommandExecutors getCommandExecutors() {
        return commandExecutors;
    }

    public JSONUtils getJsonUtils() {
        return jsonUtils;
    }

    public HologramManager getHologramManager() {
        return hologramManager;
    }

    public String color(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public int getPing(Player p){
        try {
            Object entityPlayer = p.getClass().getMethod("getHandle").invoke(p);
            return (int) entityPlayer.getClass().getField("ping").get(entityPlayer);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return 0;
    }
}