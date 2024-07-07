package com.grooze.trumpetskeleton;

import com.grooze.trumpetskeleton.entity.TrumpetSkeletonEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;

public class TrumpetSkeletonClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(TrumpetSkeletonEntityTypes.TRUMPET_SKELETON, SkeletonEntityRenderer::new);
	}
}