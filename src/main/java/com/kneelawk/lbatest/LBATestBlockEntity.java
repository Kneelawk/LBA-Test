package com.kneelawk.lbatest;

import alexiil.mc.lib.attributes.mixin.api.UnloadableBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class LBATestBlockEntity extends BlockEntity implements UnloadableBlockEntity {
    public LBATestBlockEntity(BlockPos pos, BlockState state) {
        super(LBATest.BLOCK_ENTITY_TYPE, pos, state);
    }

    @Override
    public void markRemoved() {
        super.markRemoved();
        LBATest.LOGGER.info("# markRemoved ({})", this);
    }

    @Override
    public void cancelRemoval() {
        super.cancelRemoval();
        LBATest.LOGGER.info("# cancelRemoval ({})", this);
    }

    @Override
    public void onChunkUnload() {
        LBATest.LOGGER.info("# onChunkUnload ({})", this);
    }
}
