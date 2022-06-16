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

public class BlockBreak implements Listener {

    public BlockBreak(MeltedOresDrop plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    Plugin plugin = MeltedOresDrop.getPlugin(MeltedOresDrop.class);

    Boolean cobblestone = plugin.getConfig().getBoolean("Blocks.Cobblestone");
    Boolean stone = plugin.getConfig().getBoolean("Blocks.Stone");
    Boolean netherrack = plugin.getConfig().getBoolean("Blocks.Netherrack");
    Boolean sand = plugin.getConfig().getBoolean("Blocks.Sand");
    Boolean sandstone = plugin.getConfig().getBoolean("Blocks.Sandstone");
    Boolean redsandstone = plugin.getConfig().getBoolean("Blocks.Red-sandstone");
    Boolean blockofquartz = plugin.getConfig().getBoolean("Blocks.Block-of-quartz");

    String tool = plugin.getConfig().getString("Breaking-tool");

    @EventHandler
    public void onOreBreak(BlockBreakEvent event){
        Block block = event.getBlock();
        Player player =  event.getPlayer();
        Material material = player.getInventory().getItemInMainHand().getType();

        if(block.getType() == Material.COBBLESTONE && material == Material.getMaterial(tool) && player.getGameMode() == GameMode.SURVIVAL && cobblestone){
            event.setDropItems(false);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.STONE));
        }

        if(block.getType() == Material.STONE && material == Material.getMaterial(tool) && player.getGameMode() == GameMode.SURVIVAL && stone){
            event.setDropItems(false);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SMOOTH_STONE));
        }

        if(block.getType() == Material.NETHERRACK && material == Material.getMaterial(tool) && player.getGameMode() == GameMode.SURVIVAL && netherrack){
            event.setDropItems(false);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.NETHER_BRICK));
        }
        if(block.getType() == Material.SAND && material == Material.getMaterial(tool) && player.getGameMode() == GameMode.SURVIVAL && sand){
            event.setDropItems(false);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GLASS));
        }
        if(block.getType() == Material.SANDSTONE && material == Material.getMaterial(tool) && player.getGameMode() == GameMode.SURVIVAL && sandstone){
            event.setDropItems(false);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SMOOTH_SANDSTONE));
        }
        if(block.getType() == Material.RED_SANDSTONE && material == Material.getMaterial(tool) && player.getGameMode() == GameMode.SURVIVAL && redsandstone){
            event.setDropItems(false);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SMOOTH_RED_SANDSTONE));
        }
        if(block.getType() == Material.QUARTZ_BLOCK && material == Material.getMaterial(tool) && player.getGameMode() == GameMode.SURVIVAL && redsandstone){
            event.setDropItems(false);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SMOOTH_QUARTZ));
        }
    }
}
