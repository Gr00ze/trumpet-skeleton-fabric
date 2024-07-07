package com.grooze.trumpetskeleton.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.world.World;

import java.util.List;

public class Scare {
    public static void scare(World world, LivingEntity user) {
        if (!world.isClient) {
            List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, user.getBoundingBox().expand(5.0D), EntityPredicates.VALID_ENTITY);
            for (LivingEntity spookedEntity : entities) {
                if (spookedEntity == user) continue;
                double deltaX = spookedEntity.getX() - user.getX() + world.random.nextDouble() - world.random.nextDouble();
                double deltaZ = spookedEntity.getZ() - user.getZ() + world.random.nextDouble() - world.random.nextDouble();
                double distance = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);
                spookedEntity.velocityModified = true;
                spookedEntity.addVelocity(deltaX / (10.0D + distance), 5.0D / (10.0D + distance), deltaZ / (10.0D + distance));
                spookedEntity.setAttacker(user);
            }
        }
    }
}