package me.restonic4.luckyrocks.forge;

import dev.architectury.platform.forge.EventBuses;
import me.restonic4.luckyrocks.LuckyRocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LuckyRocks.MOD_ID)
public class LuckyRocksForge {
    public LuckyRocksForge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(LuckyRocks.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        LuckyRocks.init();
    }
}