package com.funguyman10.expandedequipment.custom;

import com.funguyman10.expandedequipment.util.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class PaxelItem extends DiggerItem {

    protected static final Map<Block, BlockState> SHOVEL_LOOKUP = Shovel.getFlattenables();
    protected static final Map<Block, Block> BLOCK_STRIPPING_MAP = Axe.getStrippables();

    public PaxelItem(Tier tier, Properties properties) {
        super(tier, ModBlockTags.MINEABLE_WITH_PAXEL, properties);
    }

    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState blockstate = world.getBlockState(blockPos);
        BlockState resultToSet = null;
        Block strippedResult = (Block)BLOCK_STRIPPING_MAP.get(blockstate.getBlock());
        if (strippedResult != null) {
            world.playSound(player, blockPos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            resultToSet = (BlockState)strippedResult.defaultBlockState().setValue(RotatedPillarBlock.AXIS, (Direction.Axis)blockstate.getValue(RotatedPillarBlock.AXIS));
        } else if (context.getClickedFace() != Direction.DOWN) {
            BlockState foundResult = (BlockState)SHOVEL_LOOKUP.get(blockstate.getBlock());
            if (foundResult != null && world.getBlockState(blockPos.above()).isAir()) {
                world.playSound(player, blockPos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                resultToSet = foundResult;
            } else if (blockstate.getBlock() instanceof CampfireBlock && Boolean.TRUE.equals(blockstate.getValue(CampfireBlock.LIT))) {
                resultToSet = (BlockState)blockstate.setValue(CampfireBlock.LIT, false);
            }
        }

        if (resultToSet == null) {
            return InteractionResult.PASS;
        } else {
            if (!world.isClientSide()) {
                world.setBlock(blockPos, resultToSet, 11);
                if (player != null) {
                    context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                }
            }

            return InteractionResult.SUCCESS;
        }
    }

    private static final class Shovel extends ShovelItem {
        public static Map<Block, BlockState> getFlattenables() {
            return ShovelItem.FLATTENABLES;
        }

        private Shovel(Tier tier, Properties properties) {
            super(tier, properties);
        }
    }

    private static final class Axe extends AxeItem {
        public static Map<Block, Block> getStrippables() {
            return AxeItem.STRIPPABLES;
        }

        private Axe(Tier tier, Properties properties) {
            super(tier, properties);
        }
    }
}