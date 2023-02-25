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

    private final String BREAKING_TOOL;
    private final boolean COBBLESTONE;
    private final boolean STONE;
    private final boolean NETHERRACK;
    private final boolean SAND;
    private final boolean SANDSTONE;
    private final boolean RED_SANDSTONE;
    private final boolean QUARTZ_BLOCK;

    public BlockBreak(MeltedOresDrop plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        FileConfiguration config = plugin.getConfig();
        BREAKING_TOOL = config.getString("Breaking-tool");
        COBBLESTONE = config.getBoolean("Blocks.Cobblestone");
        STONE = config.getBoolean("Blocks.Stone");
        NETHERRACK = config.getBoolean("Blocks.Netherrack");
        SAND = config.getBoolean("Blocks.Sand");
        SANDSTONE = config.getBoolean("Blocks.Sandstone");
        RED_SANDSTONE = config.getBoolean("Blocks.Red-sandstone");
        QUARTZ_BLOCK = config.getBoolean("Blocks.Block-of-quartz");
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();
        Material material = player.getInventory().getItemInMainHand().getType();

        if (isBlockBreakValid(block.getType(), material, player.getGameMode())) {
            event.setDropItems(false);
            switch (block.getType()) {
                case COBBLESTONE -> block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.STONE));
                case STONE -> block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SMOOTH_STONE));
                case NETHERRACK -> block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.NETHER_BRICK));
                case SAND -> block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GLASS));
                case SANDSTONE -> block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SMOOTH_SANDSTONE));
                case RED_SANDSTONE -> block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SMOOTH_RED_SANDSTONE));
                case QUARTZ_BLOCK -> block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SMOOTH_QUARTZ));
            }
        }
    }

    private boolean isBlockBreakValid(Material blockMaterial, Material toolMaterial, GameMode gameMode) {
        return gameMode == GameMode.SURVIVAL && toolMaterial == Material.getMaterial(BREAKING_TOOL) && switch (blockMaterial) {
            case COBBLESTONE -> COBBLESTONE;
            case STONE -> STONE;
            case NETHERRACK -> NETHERRACK;
            case SAND -> SAND;
            case SANDSTONE -> SANDSTONE;
            case RED_SANDSTONE -> RED_SANDSTONE;
            case QUARTZ_BLOCK -> QUARTZ_BLOCK;
            default -> false;
        };
    }
}
