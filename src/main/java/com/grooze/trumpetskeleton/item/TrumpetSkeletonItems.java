package com.grooze.trumpetskeleton.item;

import com.grooze.trumpetskeleton.entity.TrumpetSkeletonEntityTypes;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.BiFunction;
import java.util.function.Function;

import static com.grooze.trumpetskeleton.TrumpetSkeleton.MOD_ID;

public class TrumpetSkeletonItems {
    public static final Item TRUMPET = register("trumpet", TrumpetItem::new, new Item.Settings().maxCount(1).maxDamage(200));


    //public static final Item TRUMPET_SKELETON_SPAWN_EGG = register("trumpet_skeleton_spawn_egg", new SpawnEggItem(TrumpetSkeletonEntityTypes.TRUMPET_SKELETON, 0xC1C1C1, 0xFCFC00, new Item.Settings())));
    public static final Item TRUMPET_SKELETON_SPAWN_EGG = registerEgg("trumpet_skeleton_spawn_egg", SpawnEggItem::new, new Item.Settings(), TrumpetSkeletonEntityTypes.TRUMPET_SKELETON);

    private static <E extends EntityType<M>, M extends MobEntity> Item registerEgg(String name, BiFunction<E, Item.Settings, Item> itemConstructor, Item.Settings settings, E entitytype) {
        Identifier id = Identifier.of(MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        settings.registryKey(key);
        return Registry.register(Registries.ITEM, RegistryKey.of(RegistryKeys.ITEM, id), itemConstructor.apply(entitytype, settings));
    }
    private static Item register(String name, Function<Item.Settings, Item> itemConstructor, Item.Settings settings) {
        /*
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.add(TRUMPET);
        });
        */

        Identifier id = Identifier.of(MOD_ID, name);
        /*
        if (item instanceof BlockItem) {
            ((BlockItem) item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
        */

        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        settings.registryKey(key);
        return Registry.register(Registries.ITEM, RegistryKey.of(RegistryKeys.ITEM, id), itemConstructor.apply(settings));
        //return Registry.register(Registries.ITEM, id, item);
    }

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.add(TRUMPET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> {
            content.add(TRUMPET_SKELETON_SPAWN_EGG);
        });
    }
}