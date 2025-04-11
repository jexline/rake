package com.exline.rake.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeafLitterBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Set;

public class NetheriteRakeItem extends Item {
    private static final Set<Block> PICKABLE_BLOCKS = Set.of(
            Blocks.LEAF_LITTER,
            Blocks.DEAD_BUSH
    );

    public NetheriteRakeItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();

        if (!world.isClient) {
            // Loop through the 3x3 area (this includes the clicked block and the 8 surrounding blocks)
            for (int x = -4; x <= 4; x++) {
                for (int y = -1; y <= 1; y++) {
                    for (int z = -4; z <= 4; z++) {
                        BlockPos offsetPos = pos.add(x, y, z);
                        BlockState state = world.getBlockState(offsetPos);
                        Block block = state.getBlock();

                        // Check if the block is in the PICKABLE_BLOCKS set
                        if (PICKABLE_BLOCKS.contains(block)) {
                            // For LeafLitterBlock, check its pile amount
                            if (block instanceof LeafLitterBlock litterBlock) {
                                IntProperty amountProperty = litterBlock.getAmountProperty();
                                int amount = state.get(amountProperty);

                                // Drop the entire pile of LeafLitter
                                ItemStack dropped = new ItemStack(block.asItem(), amount);
                                if (!player.getInventory().insertStack(dropped)) {
                                    player.dropItem(dropped, false);
                                }

                                // Remove the block entirely
                                world.breakBlock(offsetPos, false);
                            } else {
                                // For other blocks like Dead Bush, drop 1 item (or customize as needed)
                                ItemStack dropped = new ItemStack(block.asItem());
                                if (!player.getInventory().insertStack(dropped)) {
                                    player.dropItem(dropped, false);
                                }

                                // Remove the block entirely
                                world.breakBlock(offsetPos, false);
                            }
                        }
                    }
                }
            }
        }

        return ActionResult.SUCCESS;
    }
}