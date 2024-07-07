package com.grooze.trumpetskeleton.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.grooze.trumpetskeleton.TrumpetSkeleton.MOD_ID;
import static net.minecraft.registry.Registries.ENTITY_TYPE;

public class TrumpetSkeletonEntityTypes {
    public static final EntityType<TrumpetSkeletonEntity> TRUMPET_SKELETON =
            register("trumpet_skeleton", EntityType.Builder.create( TrumpetSkeletonEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6F, 1.99F));

    private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder) {
        return register(Identifier.of(MOD_ID, id), builder);
    }

    private static <T extends Entity> EntityType<T> register(Identifier id, EntityType.Builder<T> builder) {
        return Registry.register(ENTITY_TYPE, id, builder.build());
    }

    public static void init() { }
}
