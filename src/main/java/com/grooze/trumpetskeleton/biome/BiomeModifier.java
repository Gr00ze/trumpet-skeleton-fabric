package com.grooze.trumpetskeleton.biome;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;

import static com.grooze.trumpetskeleton.TrumpetSkeleton.relativeSpawnWeight;
import static com.grooze.trumpetskeleton.entity.TrumpetSkeletonEntityTypes.TRUMPET_SKELETON;

public class BiomeModifier {

    public static void init(){
        //this fix spawn skeleton with same weight everywhere
        BiomeModifications.addSpawn(
                BiomeSelectors.spawnsOneOf(EntityType.SKELETON),
                SpawnGroup.MONSTER,
                TRUMPET_SKELETON,
                (int)Math.ceil(100 * relativeSpawnWeight),
                1,
                1
        );
    }
}
