package net.victor.dogmod.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.victor.dogmod.DogMod;

public class UseItemHandler implements UseBlockCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
        if(!world.isClient() && hand == Hand.MAIN_HAND) {
            BlockPos blockPos = hitResult.getBlockPos();
            var blockState = world.getBlockState(hitResult.getBlockPos());
            if ((blockState.getBlock() instanceof CropBlock cropBlock && cropBlock.getAge(blockState) == cropBlock.getMaxAge())) {
                world.setBlockState(blockPos, cropBlock.withAge(0));
                
            }
        }
        return ActionResult.PASS;
    }
}


