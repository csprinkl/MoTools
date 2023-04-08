package me.minibabybell.motools;

import me.minibabybell.motools.items.ModToolMaterials;
import me.minibabybell.motools.items.ModArmorMaterials;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe", new PickaxeItem(ModToolMaterials.COPPER, 1, -2.8f, new FabricItemSettings()));
    public static final Item COPPER_AXE = registerItem("copper_axe", new AxeItem(ModToolMaterials.COPPER, 5, -3.0f, new FabricItemSettings()));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel", new ShovelItem(ModToolMaterials.COPPER, 1, -3.0f, new FabricItemSettings()));
    public static final Item COPPER_SWORD = registerItem("copper_sword", new SwordItem(ModToolMaterials.COPPER, 4, -2.4f, new FabricItemSettings()));
    public static final Item COPPER_HOE = registerItem("copper_hoe", new HoeItem(ModToolMaterials.COPPER, 1, -3.0f, new FabricItemSettings()));
    public static final Item COPPER_HELMET = registerItem("copper_helmet", new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate", new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings", new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item COPPER_BOOTS = registerItem("copper_boots", new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MoToolsMain.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.TOOLS, COPPER_PICKAXE);
        addToItemGroup(ItemGroups.TOOLS, COPPER_AXE);
        addToItemGroup(ItemGroups.TOOLS, COPPER_SHOVEL);
        addToItemGroup(ItemGroups.TOOLS, COPPER_HOE);
        addToItemGroup(ItemGroups.COMBAT, COPPER_SWORD);
        addToItemGroup(ItemGroups.COMBAT, COPPER_HELMET);
        addToItemGroup(ItemGroups.COMBAT, COPPER_CHESTPLATE);
        addToItemGroup(ItemGroups.COMBAT, COPPER_LEGGINGS);
        addToItemGroup(ItemGroups.COMBAT, COPPER_BOOTS);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> {
            entries.add(item);
        });
    }
    public static void registerModItems() {
        MoToolsMain.LOGGER.info("Registering Mod Items for " + MoToolsMain.MOD_ID);

        addItemsToItemGroup();
    }
}
