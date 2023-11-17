package me.restonic4.luckyrocks.item;

import me.restonic4.luckyrocks.LuckyRocks;
import me.restonic4.luckyrocks.creative_tab.CreativeTabManager;
import me.restonic4.restapi.item.ItemRegistry;
import me.restonic4.restapi.util.CustomItemProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ItemManager {
    public static Object lucky_rock = ItemRegistry.CreateCustom(
            LuckyRocks.MOD_ID,
            "lucky_rock",
            () -> new Item(
                    new CustomItemProperties().tab(CreativeTabManager.tab).rarity(Rarity.RARE).stacksTo(1).build()
            )

    );

    public static void register() {
        ItemRegistry.Register(LuckyRocks.MOD_ID);
    }
}
