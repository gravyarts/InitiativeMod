package com.initiate.initiativemod.init;

import java.util.ArrayList;
import java.util.List;

import com.initiate.initiativemod.items.ItemBase;

import net.minecraft.item.Item;

public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Items
	public static final Item DARK_MATTER = new ItemBase("dark_matter");
	public static final Item DARK_ENERGY = new ItemBase("dark_energy");
	public static final Item PORTAL_GUN = new ItemBase("portal_gun");
	
	//Materials
	public static final Item STEEL_INGOT = new ItemBase("steel_ingot");
	public static final Item REFINED_IRON_INGOT = new ItemBase("refined_iron_ingot");

}