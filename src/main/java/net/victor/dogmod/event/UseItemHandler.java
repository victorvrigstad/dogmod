package net.victor.dogmod.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class UseItemHandler implements UseBlockCallback {

    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
        BlockPos blockPos = hitResult.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        ItemStack itemInHand = player.getMainHandStack();

        if(world.isClient() || hand != Hand.MAIN_HAND) {
            return ActionResult.PASS;
        }

        if(itemInHand.getItem() != Items.AIR)
        {
            return ActionResult.PASS;
        }

        if (!(blockState.getBlock() instanceof CropBlock cropBlock)) {
            return ActionResult.PASS;
        }

        if (cropBlock.getAge(blockState) != cropBlock.getMaxAge()) {
            return ActionResult.PASS;
        }

        if ((cropBlock.getAge(blockState) >= 7)) {
            world.setBlockState(blockPos.down(1), cropBlock.withAge(0));
            Block.dropStacks(blockState, world, blockPos);
        }

        else {
            world.setBlockState(blockPos, cropBlock.withAge(0));
            Block.dropStacks(blockState, world, blockPos);
        }

        return ActionResult.SUCCESS;
    }

}


