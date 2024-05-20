package com.aquaticplus.items;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;

// TODO: When this mod gets updated, add extra build reach.
public class CrabClawItem extends SwordItem {
	public CrabClawItem() {
		super(ToolMaterials.WOOD, 3, 1, new Item.Settings().maxCount(1).maxDamage(130));
	}
}