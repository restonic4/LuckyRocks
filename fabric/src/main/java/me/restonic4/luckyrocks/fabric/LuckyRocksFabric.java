package me.restonic4.luckyrocks.fabric;

import me.restonic4.luckyrocks.LuckyRocks;
import net.fabricmc.api.ModInitializer;

public class LuckyRocksFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        LuckyRocks.init();
    }
}