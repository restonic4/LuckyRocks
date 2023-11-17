package me.restonic4.luckyrocks.item;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.EntityEvent;
import dev.architectury.event.events.common.TickEvent;
import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.luckyrocks.LuckyRocks;
import me.restonic4.luckyrocks.creative_tab.CreativeTabManager;
import me.restonic4.restapi.item.ItemRegistry;
import me.restonic4.restapi.util.CustomItemProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class ItemManager {
    public static Object lucky_rock = ItemRegistry.CreateCustom(
            LuckyRocks.MOD_ID,
            "lucky_rock",
            () -> new LuckyRock(
                    new CustomItemProperties().tab(CreativeTabManager.tab).rarity(Rarity.RARE).stacksTo(1).build()
            )

    );

    public static Object speed_rock = ItemRegistry.CreateCustom(
            LuckyRocks.MOD_ID,
            "speed_rock",
            () -> new Item(
                    new CustomItemProperties().tab(CreativeTabManager.tab).rarity(Rarity.RARE).stacksTo(1).build()
            )

    );

    public static Object jump_rock = ItemRegistry.CreateCustom(
            LuckyRocks.MOD_ID,
            "jump_rock",
            () -> new Item(
                    new CustomItemProperties().tab(CreativeTabManager.tab).rarity(Rarity.RARE).stacksTo(1).build()
            )

    );

    public static Object haste_rock = ItemRegistry.CreateCustom(
            LuckyRocks.MOD_ID,
            "haste_rock",
            () -> new Item(
                    new CustomItemProperties().tab(CreativeTabManager.tab).rarity(Rarity.RARE).stacksTo(1).build()
            )

    );

    public static Object strength_rock = ItemRegistry.CreateCustom(
            LuckyRocks.MOD_ID,
            "strength_rock",
            () -> new Item(
                    new CustomItemProperties().tab(CreativeTabManager.tab).rarity(Rarity.RARE).stacksTo(1).build()
            )

    );

    public static Object night_vision_rock = ItemRegistry.CreateCustom(
            LuckyRocks.MOD_ID,
            "night_vision_rock",
            () -> new Item(
                    new CustomItemProperties().tab(CreativeTabManager.tab).rarity(Rarity.RARE).stacksTo(1).build()
            )

    );

    public static Object regeneration_rock = ItemRegistry.CreateCustom(
            LuckyRocks.MOD_ID,
            "regeneration_rock",
            () -> new Item(
                    new CustomItemProperties().tab(CreativeTabManager.tab).rarity(Rarity.RARE).stacksTo(1).build()
            )

    );

    public static Object slow_falling_rock = ItemRegistry.CreateCustom(
            LuckyRocks.MOD_ID,
            "slow_falling_rock",
            () -> new Item(
                    new CustomItemProperties().tab(CreativeTabManager.tab).rarity(Rarity.RARE).stacksTo(1).build()
            )

    );

    public static List<Object> rocks = new ArrayList<>(Arrays.asList(
            speed_rock,  jump_rock, haste_rock,
            strength_rock, night_vision_rock,
            regeneration_rock, slow_falling_rock
    ));

    private static boolean dropChance(int percentage) {
        Random random = new Random();
        int randomNum = random.nextInt(100) + 1;

        return randomNum <= percentage;
    }

    public static ItemEntity spawnAtLocation(ItemStack itemStack, float f, Level level, double x, double y, double z) {
        if (itemStack.isEmpty()) {
            return null;
        } else if (level.isClientSide) {
            return null;
        } else {
            ItemEntity itemEntity = new ItemEntity(level, x, y + (double)f, z, itemStack);
            itemEntity.setDefaultPickUpDelay();
            level.addFreshEntity(itemEntity);
            return itemEntity;
        }
    }

    public static void register() {
        ItemRegistry.Register(LuckyRocks.MOD_ID);

        AtomicReference<Player> localPlayer = new AtomicReference<>();

        EntityEvent.LIVING_DEATH.register(
                (entity, damageSource) -> {
                    if (entity.getMobType() == MobType.UNDEAD) {
                        if (dropChance(8)) {
                            spawnAtLocation(
                                    new ItemStack(((RegistrySupplier<Item>)lucky_rock).get()),
                                    0,
                                    entity.level(),
                                    entity.getX(),
                                    entity.getY(),
                                    entity.getZ()
                            );
                        }
                    }

                    return EventResult.pass();
                }
        );

        TickEvent.PLAYER_POST.register(
                (player) -> {
                    localPlayer.set(player);
                }
        );

        TickEvent.SERVER_PRE.register(
                (server) -> {
                    if (localPlayer.get() != null) {
                        Player player = localPlayer.get();

                        int ticks = 20 * 15 + 5;

                        for (int i = 0; i <= 50; i++) {
                            if (player.getInventory().getItem(i).getItem().getDefaultInstance().getItem() == ((RegistrySupplier<Item>)speed_rock).get()) {
                                MobEffectInstance effect = new MobEffectInstance(MobEffects.MOVEMENT_SPEED, ticks, 0);

                                player.forceAddEffect(effect, player);
                            }
                            else if (player.getInventory().getItem(i).getItem().getDefaultInstance().getItem() == ((RegistrySupplier<Item>)jump_rock).get()) {
                                MobEffectInstance effect = new MobEffectInstance(MobEffects.JUMP, ticks, 0);

                                player.forceAddEffect(effect, player);
                            }
                            else if (player.getInventory().getItem(i).getItem().getDefaultInstance().getItem() == ((RegistrySupplier<Item>)haste_rock).get()) {
                                MobEffectInstance effect = new MobEffectInstance(MobEffects.DIG_SPEED, ticks, 0);

                                player.forceAddEffect(effect, player);
                            }
                            else if (player.getInventory().getItem(i).getItem().getDefaultInstance().getItem() == ((RegistrySupplier<Item>)strength_rock).get()) {
                                MobEffectInstance effect = new MobEffectInstance(MobEffects.DAMAGE_BOOST, ticks, 0);

                                player.forceAddEffect(effect, player);
                            }
                            else if (player.getInventory().getItem(i).getItem().getDefaultInstance().getItem() == ((RegistrySupplier<Item>)night_vision_rock).get()) {
                                MobEffectInstance effect = new MobEffectInstance(MobEffects.NIGHT_VISION, ticks, 0);

                                player.forceAddEffect(effect, player);
                            }
                            else if (player.getInventory().getItem(i).getItem().getDefaultInstance().getItem() == ((RegistrySupplier<Item>)regeneration_rock).get()) {
                                MobEffectInstance effect = new MobEffectInstance(MobEffects.REGENERATION, ticks, 0);

                                player.forceAddEffect(effect, player);
                            }
                            else if (player.getInventory().getItem(i).getItem().getDefaultInstance().getItem() == ((RegistrySupplier<Item>)slow_falling_rock).get()) {
                                MobEffectInstance effect = new MobEffectInstance(MobEffects.SLOW_FALLING, ticks, 0);

                                player.forceAddEffect(effect, player);
                            }
                        }
                    }
                }
        );
    }
}
