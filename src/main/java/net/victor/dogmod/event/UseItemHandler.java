package net.victor.dogmod.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.victor.dogmod.DogMod;
import net.victor.dogmod.block.ModBlocks;
import net.victor.dogmod.block.custom.crops.CornCropBlock;

import java.util.List;

public class UseItemHandler implements UseBlockCallback {

    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
        if(world.isClient() || hand != Hand.MAIN_HAND) {
            return ActionResult.PASS;
        }
        BlockPos blockPos = hitResult.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
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


