package me.restonic4.luckyrocks.creative_tab;

import me.restonic4.luckyrocks.LuckyRocks;
import me.restonic4.restapi.creative_tab.CreativeTabRegistry;

public class CreativeTabManager {
    public static Object tab = CreativeTabRegistry.CreateCreativeTab(LuckyRocks.MOD_ID, LuckyRocks.MOD_ID, "lucky_rock");

    public static void register() {
        CreativeTabRegistry.Register(LuckyRocks.MOD_ID);
    }
}
