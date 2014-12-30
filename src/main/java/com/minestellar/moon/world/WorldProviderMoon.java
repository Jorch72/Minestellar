package com.minestellar.moon.world;

import net.minecraft.entity.Entity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.common.DimensionManager;

import com.minestellar.moon.ConfigManagerMoon;
import com.minestellar.moon.world.gen.ChunkProviderMoon;
import com.minestellar.moon.world.gen.WorldChunkManagerMoon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderMoon extends WorldProvider
{
	/** tells Minecraft to use our new Terrain Generator */
	@Override
	public IChunkProvider createChunkGenerator() 
	{
		return new ChunkProviderMoon(this.worldObj, this.worldObj.getSeed(), true);
	}

	@Override
	/** tells Minecraft to use our new WorldChunkManager **/
	public void registerWorldChunkManager() 
	{
		this.worldChunkMgr = new WorldChunkManagerMoon();
		this.dimensionId = ConfigManagerMoon.idDimensionMoon;
	}

	/** Get Provider for Dimension **/
	public static WorldProvider getProviderForDimension(int id)
	{
		return DimensionManager.createProviderFor(ConfigManagerMoon.idDimensionMoon);
	}

	@Override
	/**
	 * @return the name of the dimension
	 */
	public String getDimensionName() 
	{
		return "Moon";
	}

	@Override
	/** sets/creates the save folder */
	public String getSaveFolder() 
	{
		return "DIM" + ConfigManagerMoon.idDimensionMoon;
	}

	@SideOnly(Side.CLIENT)
	/** should stars be rendered? */
	public boolean renderStars() 
	{
		return true;
	}

	@SideOnly(Side.CLIENT)
	/** @return the player speed */
	public double getMovementFactor() 
	{
		return 0.04D;
	}

	@SideOnly(Side.CLIENT)
	/** @return the light value of the stars*/
	public float getStarBrightness(World world, float f) 
	{
		return 3.0F;
	}

	@SideOnly(Side.CLIENT)
	/** should clouds be rendered? */
	public boolean renderClouds() 
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	public boolean renderVoidFog() 
	{
		return false;
	}

	/** should the end sky be rendered or the overworld sky? */
	@SideOnly(Side.CLIENT)
	public boolean renderEndSky() 
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	/** @return the size of the sun */
	public float setSunSize() 
	{
		return 0.5F;
	}

	/** @return the size of the moon */
	@SideOnly(Side.CLIENT)
	public float setMoonSize() 
	{
		return 9.0F;
	}

	/**
	 * @return the sky color
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public Vec3 getSkyColor(Entity cameraEntity, float partialTicks) 
	{
		return Vec3.createVectorHelper(0.01F, 0.01F, 0.01F);
	}

	@SideOnly(Side.CLIENT)
	/** should a color for the sky be rendered? */
	public boolean isSkyColored()
	{
		return true;
	}

	/** can the player respawn in this dimension? */
	@Override
	public boolean canRespawnHere()
	{
		return true;
	}

	/** is this a surface world or an underworld */
	@Override
	public boolean isSurfaceWorld()
	{
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	/** @return the high of the clouds */
	public float getCloudHeight()
	{
		return 0;
	}

	@Override
	public ChunkCoordinates getEntrancePortalLocation()
	{
		return new ChunkCoordinates(50, 5, 0);
	}


	/** the light value in this dimension */
	@Override
	protected void generateLightBrightnessTable()
	{
		float f = 0.0F;

		for (int i = 0; i <= 15; ++i)
		{
			float f1 = 1.0F - (float)i / 15.0F;
			this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
		}
	}

	/** @return the dimension join message */
	@Override
	@SideOnly(Side.CLIENT)
	public String getWelcomeMessage()
	{
		return "Entering the Dimension";
	}

	/** @return the dimension leave message */
	@Override
	@SideOnly(Side.CLIENT)
	public String getDepartMessage()
	{
		return "Leaving the Dimension";
	}

	@Override
	public IRenderHandler getSkyRenderer() 
	{
		return new SkyRendererMoon();
	}

	@Override
	public IRenderHandler getCloudRenderer() 
	{
		return null;
	}

	@Override
	public IRenderHandler getWeatherRenderer() 
	{
		return null;
	}

	@Override
	public Vec3 drawClouds(float partialTicks)
	{
		return super.drawClouds(partialTicks);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Vec3 getFogColor(float par1, float par2)
	{
		return Vec3.createVectorHelper(0.0F, 0.0F, 0.0F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public float[] calcSunriseSunsetColors(float p_76560_1_, float p_76560_2_){
		
		float[] sunriseColors = new float[4];
		
		sunriseColors[0] = 0.0F;
		sunriseColors[1] = 0.0F;
		sunriseColors[2] = 0.0F;
		sunriseColors[3] = 0.0F;
		
		return sunriseColors;
	}
	
}