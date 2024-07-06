package com.jamieswhiteshirt.trumpetskeleton.common.biome;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;

import static com.jamieswhiteshirt.trumpetskeleton.TrumpetSkeleton.relativeSpawnWeight;
import static com.jamieswhiteshirt.trumpetskeleton.common.entity.TrumpetSkeletonEntityTypes.TRUMPET_SKELETON;

public class BiomeModifier {

    public static void init(){
        BiomeModifications.addSpawn(
                BiomeSelectors.all(),
                SpawnGroup.MONSTER,
                TRUMPET_SKELETON,
                (int)Math.ceil(100 * relativeSpawnWeight),
                1,
                1
        );
    }


}
