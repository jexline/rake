package com.exline.rake;

import com.exline.rake.init.ItemInit;
import com.exline.rake.sounds.ModSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModMain implements ModInitializer {
	public static final String MOD_ID = "rake";

	public static final ItemGroup MOD_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
			Identifier.of(MOD_ID,"tab"),
			FabricItemGroup.builder().icon(()-> new ItemStack(ItemInit.IRON_RAKE))
					.displayName(Text.translatable("itemGroup.rake.tab"))
					.entries((displayContext, entries) -> {
						entries.add(ItemInit.IRON_RAKE);
						entries.add(ItemInit.GOLDEN_RAKE);
						entries.add(ItemInit.DIAMOND_RAKE);
						entries.add(ItemInit.NETHERITE_RAKE);
					}).build());

	@Override
	public void onInitialize(){
		ModSounds.registerSounds();
		ItemInit.registerItems();
		System.out.println("Initializing: " + MOD_ID);
	}
}