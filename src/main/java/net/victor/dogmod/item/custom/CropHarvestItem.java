package net.victor.dogmod.item.custom;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.victor.dogmod.DogMod;
import net.victor.dogmod.util.ModTags;

public class CropHarvestItem extends Item {
    public CropHarvestItem(Settings settings) {
        super(settings);
    }


    //public void onPlayerInteract(Eve)

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;
            DogMod.LOGGER.info("test");
            BlockState state = context.getWorld().getBlockState(positionClicked);

            if (isValuableBlock(state)) {
                DogMod.LOGGER.info(state.toString());

            }

            //for (int i = 0; i <= positionClicked.getY() + 64; i++) {
            //    BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

            //    if (isValuableBlock(state)) {
            //        outputValuableCoordinates(positionClicked.down(i), player, state.getBlock());
            //        foundBlock = true;

            //        break;
            //    }
            //}

            //if (!foundBlock) {
            //    player.sendMessage(Text.literal("No Valuables Found!"));
            //}
        }

        context.getStack().damage(1, context.getPlayer(), EquipmentSlot.MAINHAND);

        return ActionResult.SUCCESS;
    }

    //public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, )

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"), false);
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isIn(ModTags.Blocks.HARVESTABLE_CROPS);
    }
}
