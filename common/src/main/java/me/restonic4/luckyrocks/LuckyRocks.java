package me.restonic4.luckyrocks;

import me.restonic4.luckyrocks.creative_tab.CreativeTabManager;
import me.restonic4.luckyrocks.item.ItemManager;
import me.restonic4.restapi.creative_tab.CreativeTabRegistry;
import me.restonic4.restapi.item.ItemRegistry;

public class LuckyRocks
{
	public static final String MOD_ID = "luckyrocks";

	public static void init() {
		ItemRegistry.CreateRegistry(MOD_ID);
		CreativeTabRegistry.CreateRegistry(MOD_ID);

		ItemManager.register();
		CreativeTabManager.register();
	}
}
