package me.trent;

import me.trent.holograms.HologramManager;
import me.trent.json.JSONUtils;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

public class Framework {

    private static Framework framework;
    private Plugin plugin;
    private HologramManager hologramManager;
    private JSONUtils jsonUtils;

    public Framework(Plugin plugin){
        this.plugin = plugin;
        this.framework = new Framework(plugin);
        this.hologramManager = new HologramManager();
        this.jsonUtils = new JSONUtils();
    }

    public static Framework getFramework() {
        return framework;
    }

    public Plugin getPlugin() {
        return plugin;
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
}