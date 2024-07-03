package com.jamieswhiteshirt.trumpetskeleton.common.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;

import static com.jamieswhiteshirt.trumpetskeleton.TrumpetSkeleton.relativeSpawnWeight;
import static com.jamieswhiteshirt.trumpetskeleton.common.entity.TrumpetSkeletonEntityTypes.TRUMPET_SKELETON;

public class TrumpetSkeletonWorldSpawner {

    public static void init(){
        BiomeModifications.addSpawn(
                BiomeSelectors.all(),
                SpawnGroup.MONSTER,
                TRUMPET_SKELETON,
                1,
                1,
                3
        );
    }


}
