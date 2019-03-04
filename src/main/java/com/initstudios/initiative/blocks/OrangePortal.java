package com.best2327.voidmod.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.best2327.voidmod.Main;
import com.best2327.voidmod.entitys.PortalTileEntity;
import com.best2327.voidmod.init.ModBlocks;
import com.best2327.voidmod.init.ModItems;
import com.best2327.voidmod.util.IHasModel;
import com.best2327.voidmod.util.handlers.SoundHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEndPortal;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OrangePortal extends BlockBase
{
	public static int orangeX = 0;
	public static int orangeY = 0;
	public static int orangeZ = 0;
    protected static final AxisAlignedBB ORANGEPORTAL_COLLISION_AABB = new AxisAlignedBB(1D, 1D, 1D, 1D, 1D, 1D);
    protected static final AxisAlignedBB ORANGEPORTAL_AABB = new AxisAlignedBB(1D, 1D, 1D, 1D, 1D, 1D);
	
	public OrangePortal(String name, Material material) 
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
        return ORANGEPORTAL_COLLISION_AABB;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos)
    {
        return ORANGEPORTAL_AABB.offset(pos);
    }
	
	@Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
		if(!worldIn.isRemote && entityIn.getHorizontalFacing() == EnumFacing.get)
		{
			int x = BluePortal.blueX;
			int y = BluePortal.blueY;
			int z = BluePortal.blueZ;
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
		orangeX = pos.getX();
		orangeY = pos.getY();
		orangeZ = pos.getZ();
	}
}