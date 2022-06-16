package meltedoresdrop.meltedoresdrop.events;

import meltedoresdrop.meltedoresdrop.MeltedOresDrop;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class OreBreak implements Listener {

    public OreBreak(MeltedOresDrop plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    Plugin plugin = MeltedOresDrop.getPlugin(MeltedOresDrop.class);

    Boolean iron = plugin.getConfig().getBoolean("Ores.Iron");
    Boolean gold = plugin.getConfig().getBoolean("Ores.Gold");
    Boolean copper = plugin.getConfig().getBoolean("Ores.Copper");
    Boolean debris = plugin.getConfig().getBoolean("Ores.Debris");

    @EventHandler
    public void onOreBreak(BlockBreakEvent event){
        Block block = event.getBlock();
        Player player =  event.getPlayer();
        Material material = player.getInventory().getItemInMainHand().getType();



        if(block.getType() == Material.IRON_ORE && material == Material.DIAMOND_PICKAXE && player.getGameMode() == GameMode.SURVIVAL && iron){
            event.setDropItems(false);
            event.setExpToDrop(4);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.IRON_INGOT));
        }
        if(block.getType() == Material.COPPER_ORE && material == Material.GOLDEN_PICKAXE && player.getGameMode() == GameMode.SURVIVAL && copper){
            event.setDropItems(false);
            event.setExpToDrop(3);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COPPER_INGOT));
        }
        if(block.getType() == Material.GOLD_ORE && material == Material.GOLDEN_PICKAXE && player.getGameMode() == GameMode.SURVIVAL && gold){
            event.setDropItems(false);
            event.setExpToDrop(4);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GOLD_INGOT));
        }
        if(block.getType() == Material.COBBLESTONE && material == Material.GOLDEN_PICKAXE && player.getGameMode() == GameMode.SURVIVAL){
            event.setDropItems(false);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.STONE));
        }
        if(block.getType() == Material.STONE && material == Material.GOLDEN_PICKAXE && player.getGameMode() == GameMode.SURVIVAL){
            event.setDropItems(false);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SMOOTH_STONE));
        }
        if(block.getType() == Material.ANCIENT_DEBRIS && material == Material.GOLDEN_PICKAXE && player.getGameMode() == GameMode.SURVIVAL && debris){
            event.setDropItems(false);
            event.setExpToDrop(12);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.NETHERITE_SCRAP));
        }
        if(block.getType() == Material.NETHERRACK && material == Material.GOLDEN_PICKAXE && player.getGameMode() == GameMode.SURVIVAL){
            event.setDropItems(false);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.NETHER_BRICK));
        }
    }
}
