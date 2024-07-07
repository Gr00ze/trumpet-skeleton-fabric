package com.grooze.trumpetskeleton.item;

import com.grooze.trumpetskeleton.sound.TrumpetSkeletonSoundEvents;
import com.grooze.trumpetskeleton.util.Scare;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class TrumpetItem extends Item {
    public TrumpetItem(Settings settings) {
        super(settings);

    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.NONE;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 55;
    }

    @Override
    public void usageTick(World world, LivingEntity entity, ItemStack stack, int useTimeLeft) {
        super.usageTick(world, entity, stack, useTimeLeft);
        int useTime = getMaxUseTime(stack, entity) - useTimeLeft;
        if (useTime == 10) {
            entity.playSound(TrumpetSkeletonSoundEvents.TRUMPET_USE, 1.0F, 0.9F + world.random.nextFloat() * 0.2F);
            Scare.scare(world, entity);
            stack.damage(1, entity, entity.getPreferredEquipmentSlot(stack));
        } else if (useTime >= 15) {
            entity.stopUsingItem();
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.setCurrentHand(hand);
        return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
    }
}