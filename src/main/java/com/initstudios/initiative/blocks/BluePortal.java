package com.best2327.voidmod.blocks;

import java.util.Random;

import com.best2327.voidmod.Main;
import com.best2327.voidmod.init.ModBlocks;
import com.best2327.voidmod.init.ModItems;
import com.best2327.voidmod.util.IHasModel;
import com.best2327.voidmod.util.handlers.SoundHandler;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BluePortal extends BlockBase {

	public static int blueX = 0;
	public static int blueY = 0;
	public static int blueZ = 0;
    protected static final AxisAlignedBB BLUEPORTAL_COLLISION_AABB = new AxisAlignedBB(1D, 1D, 1D, 1D, 1D, 1D);
    protected static final AxisAlignedBB BLUEPORTAL_AABB = new AxisAlignedBB(1D, 1D, 1D, 1D, 1D, 1D);

	public BluePortal(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(2.5f);
		setResistance(18000000.0f);
		setHarvestLevel("pickaxe", 2);
	}
	
	@Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return BLUEPORTAL_COLLISION_AABB;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos)
    {
        return BLUEPORTAL_AABB.offset(pos);
    }
	
	@Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
		if(!worldIn.isRemote)
		{
			int x = OrangePortal.orangeX;
			int y = OrangePortal.orangeY;
			int z = OrangePortal.orangeZ;
			entityIn.setPositionAndUpdate(x, y, z);
		}
    }
	
	@Override
	public BlockRenderLayer getBlockLayer()
    {
		return BlockRenderLayer.CUTOUT;
	}
	 
	public boolean isOpaqueCube(IBlockState iBlockState)
	{
		return false;
    }
    public boolean isFullCube(IBlockState state)
	{
	    return false;
    }   
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		blueX = pos.getX();
		blueY = pos.getY();
		blueZ = pos.getZ();
	}
}