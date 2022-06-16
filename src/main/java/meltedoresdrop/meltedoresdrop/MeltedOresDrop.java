package meltedoresdrop.meltedoresdrop;

import meltedoresdrop.meltedoresdrop.events.BlockBreak;
import meltedoresdrop.meltedoresdrop.events.OreBreak;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MeltedOresDrop extends JavaPlugin {

    @Override
    public void onEnable() {
        Metrics metrics = new Metrics(this, 15492);
        // Plugin startup logic
        Bukkit.getLogger().info("[MOD] MeltedOresDrop Enabled");
        saveDefaultConfig();
        new OreBreak(this);
        new BlockBreak(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("[MOD] Shutting Down");
    }
}
