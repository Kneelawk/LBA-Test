package com.kneelawk.lbatest;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LBATest implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("lba-test");

    public static final LBATestBlock BLOCK = new LBATestBlock(FabricBlockSettings.of(Material.STONE));
    public static final BlockEntityType<LBATestBlockEntity> BLOCK_ENTITY_TYPE =
        FabricBlockEntityTypeBuilder.create(LBATestBlockEntity::new, BLOCK).build();

    @Override
    public void onInitialize() {
        LOGGER.info("Loading LBA Test");

        Registry.register(Registry.BLOCK, id("lba-test-block"), BLOCK);
        Registry.register(Registry.ITEM, id("lba-test-block"), new BlockItem(BLOCK, new FabricItemSettings()));
        Registry.register(Registry.BLOCK_ENTITY_TYPE, id("lba-test-block-entity"), BLOCK_ENTITY_TYPE);
    }

    public static Identifier id(String path) {
        return new Identifier("lba-test", path);
    }
}
