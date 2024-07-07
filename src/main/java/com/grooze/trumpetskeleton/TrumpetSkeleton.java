package com.grooze.trumpetskeleton;

import com.grooze.trumpetskeleton.biome.BiomeModifier;
import com.grooze.trumpetskeleton.entity.TrumpetSkeletonEntityTypes;
import com.grooze.trumpetskeleton.item.TrumpetSkeletonItems;
import com.grooze.trumpetskeleton.mixin.ParrotEntityAccessor;
import com.grooze.trumpetskeleton.sound.TrumpetSkeletonSoundEvents;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class TrumpetSkeleton implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "trumpet-skeleton";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static double relativeSpawnWeight = 1D;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		setUpProperties();

		LOGGER.info("Initializing");
		TrumpetSkeletonSoundEvents.init();
		TrumpetSkeletonItems.init();
		TrumpetSkeletonEntityTypes.init();

        assert ParrotEntityAccessor.trumpetskeleton$getMobSounds() != null;
        ParrotEntityAccessor.trumpetskeleton$getMobSounds().put(TrumpetSkeletonEntityTypes.TRUMPET_SKELETON, TrumpetSkeletonSoundEvents.ENTITY_PARROT_IMITATE_TRUMPET_SKELETON);

		BiomeModifier.init();

	}

	public static void setUpProperties(){
		Properties configuration = new Properties();
		configuration.setProperty("relativeSpawnWeight", String.valueOf(relativeSpawnWeight));
		Path configurationFile = FabricLoader.getInstance().getConfigDir().resolve("trumpet-skeleton.properties");

		if (Files.exists(configurationFile)) {
			try (InputStream in = Files.newInputStream(configurationFile)) {
				configuration.load(in);
				LOGGER.info("Loaded configuration file \"" + configurationFile + "\"");
			} catch (IOException e) {
				LOGGER.error("Could not read configuration file \"" + configurationFile + "\"", e);
			}
		} else {
			try (OutputStream out = Files.newOutputStream(configurationFile)) {
				configuration.store(out, "Trumpet Skeleton configuration");
				LOGGER.info("Generated configuration file \"" + configurationFile + "\"");
			} catch (IOException e) {
				LOGGER.error("Could not write configuration file \"" + configurationFile + "\"", e);
			}
		}

		String relativeSpawnRateString = configuration.getProperty("relativeSpawnWeight");
		try {
			relativeSpawnWeight = Double.parseDouble(relativeSpawnRateString);

		} catch (NumberFormatException e) {
			LOGGER.error("Error processing configuration file \"" + configurationFile + "\".");
			LOGGER.error("Expected configuration value for relativeSpawnWeight to be a number, found \"" + relativeSpawnRateString + "\".");
			LOGGER.error("Using default value \"" + relativeSpawnWeight + "\" instead.");
		}
	}
}