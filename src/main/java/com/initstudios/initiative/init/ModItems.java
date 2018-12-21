package com.initstudios.initiative.init;

import java.util.ArrayList;
import java.util.List;

import com.initstudios.initiative.items.ItemBase;

import net.minecraft.item.Item;

public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	//Moon
	public static final Item MD_ROCK_REFINED = new ItemBase("md_rock_refined");
	//Normal
	public static final Item OW_BH_DUST = new ItemBase("ow_bh_dust");
	public static final Item OW_BH_UNSTABLE = new ItemBase("ow_bh_unstable");
	public static final Item OW_BH_STABLE = new ItemBase("ow_bh_stable");
	public static final Item OW_BH_CRYSTAL = new ItemBase("ow_bh_crystal");
	public static final Item OW_STEEL_INGOT = new ItemBase("ow_steel_ingot");
	public static final Item OW_RFSTEEL_INGOT = new ItemBase("ow_rfsteel_ingot");
	//Laboratory
	public static final Item LB_PG_NORMAL = new ItemBase("lb_pg_normal");
}