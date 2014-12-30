package com.minestellar.core.blocks.items;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.minestellar.core.proxy.ClientProxyCore;

public class ItemBlockOres extends ItemBlock
{
	private static final String[] types = new String[] 
	{
		"copper_ore",
		"tin_ore",
		"titanium_ore",
	};

	public ItemBlockOres(Block par1)
	{
		super(par1);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return ClientProxyCore.stellarItem;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		int meta = itemstack.getItemDamage();
		if (meta < 0 || meta >= ItemBlockOres.types.length)
		{
			meta = 0;
		}
		return super.getUnlocalizedName() + "." + ItemBlockOres.types[meta];
	}
}