package dk.hoggins.healthgraph;

import dk.hoggins.healthgraph.listeners.DamageListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class HealthGraph extends JavaPlugin {
    public static Plugin plugin;

    @Override
    public void onEnable() {
        this.plugin = this;
        getConfig().options().copyDefaults(true);
        saveConfig();
        System.out.println("[HealthGraph]: Plugin Loaded");
        System.out.println("[HealthGraph]: Current token - "+getConfig().getString("Token"));
        Bukkit.getPluginManager().registerEvents(new DamageListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
