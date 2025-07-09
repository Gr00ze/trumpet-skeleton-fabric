package com.grooze.trumpetskeleton;

import com.grooze.trumpetskeleton.item.TrumpetItem;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.ModelProvider;
import net.minecraft.client.data.Models;
import net.minecraft.data.DataOutput;

import static com.grooze.trumpetskeleton.item.TrumpetSkeletonItems.TRUMPET;
import static com.grooze.trumpetskeleton.item.TrumpetSkeletonItems.TRUMPET_SKELETON_SPAWN_EGG;

public class Generator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.createPack().addProvider(ModelGenerator::new);
    }


    class ModelGenerator extends FabricModelProvider {


        public ModelGenerator(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        }

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {
            itemModelGenerator.register(TRUMPET, Models.GENERATED);
            itemModelGenerator.register(TRUMPET_SKELETON_SPAWN_EGG, Models.GENERATED_TWO_LAYERS);
        }
    }
}
