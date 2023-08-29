package com.jamieswhiteshirt.trumpetskeleton.common.item;

import com.jamieswhiteshirt.trumpetskeleton.common.entity.TrumpetSkeletonEntityTypes;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class TrumpetSkeletonItems {
    public static final Item TRUMPET = register("trumpet", new TrumpetItem(new FabricItemSettings()));


    public static final Item TRUMPET_SKELETON_SPAWN_EGG = register("trumpet_skeleton_spawn_egg", new SpawnEggItem(TrumpetSkeletonEntityTypes.TRUMPET_SKELETON, 0xC1C1C1, 0xFCFC00, (new Item.Settings())));

    private static Item register(String id, Item item) {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.add(TRUMPET);
        });
        return register(new Identifier("trumpet-skeleton", id), item);
    }

    private static Item register(Identifier id, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, id, item);
    }

    public static void init() { }
}
