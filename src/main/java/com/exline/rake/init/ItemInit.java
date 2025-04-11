package com.exline.rake.init;

import com.exline.rake.ModMain;
import com.exline.rake.items.DiamondRakeItem;
import com.exline.rake.items.GoldenRakeItem;
import com.exline.rake.items.NetheriteRakeItem;
import com.exline.rake.items.RakeItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ItemInit {
    public static final Item IRON_RAKE = createIronRakeItem("iron_rake");
    public static final Item GOLDEN_RAKE = createGoldRakeItem("golden_rake");
    public static final Item DIAMOND_RAKE = createDiamondRakeItem("diamond_rake");
    public static final Item NETHERITE_RAKE = createNetheriteRakeItem("netherite_rake");
    private static Item createIronRakeItem(String name){
        Identifier id = Identifier.of(ModMain.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item item = new RakeItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, id)));
        Registry.register(Registries.ITEM, key, item);
        return item;
    }
    private static Item createGoldRakeItem(String name){
        Identifier id = Identifier.of(ModMain.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item item = new GoldenRakeItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, id)));
        Registry.register(Registries.ITEM, key, item);
        return item;
    }
    private static Item createDiamondRakeItem(String name){
        Identifier id = Identifier.of(ModMain.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item item = new DiamondRakeItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, id)));
        Registry.register(Registries.ITEM, key, item);
        return item;
    }
    private static Item createNetheriteRakeItem(String name){
        Identifier id = Identifier.of(ModMain.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item item = new NetheriteRakeItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, id)));
        Registry.register(Registries.ITEM, key, item);
        return item;
    }
    public static void registerItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(ItemInit.IRON_RAKE);
            entries.add(ItemInit.GOLDEN_RAKE);
            entries.add(ItemInit.DIAMOND_RAKE);
            entries.add(ItemInit.NETHERITE_RAKE);
        });
        System.out.println("Registering Items for: " + ModMain.MOD_ID);
    }
}