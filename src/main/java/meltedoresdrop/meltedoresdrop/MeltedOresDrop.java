package meltedoresdrop.meltedoresdrop;

import meltedoresdrop.meltedoresdrop.events.OreBreak;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MeltedOresDrop extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("MeltedOresDrop Enabled");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        new OreBreak(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("MeltedOresDrop Disabled");
    }
}
