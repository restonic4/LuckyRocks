package me.restonic4.luckyrocks.item;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;

import java.util.Random;

public class LuckyRock extends Item {
    public LuckyRock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        if (useOnContext.getPlayer() != null) {
            useOnContext.getItemInHand().setCount(0);
            useOnContext.getPlayer().getInventory().add(new ItemStack(getRandomItem(), 1));
        }

        return InteractionResult.PASS;
    }

    public static Item getRandomItem() {
        Random random = new Random();
        int randomIndex = random.nextInt(ItemManager.rocks.size());
        return ((RegistrySupplier<Item>)ItemManager.rocks.get(randomIndex)).get();
    }
}
