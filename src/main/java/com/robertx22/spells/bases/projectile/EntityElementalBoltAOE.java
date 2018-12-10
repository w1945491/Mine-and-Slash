package com.robertx22.spells.bases.projectile;

import java.util.HashMap;
import java.util.List;

import com.robertx22.database.particle_gens.AoeProjectileParticleGen;
import com.robertx22.uncommon.enumclasses.Elements;
import com.robertx22.uncommon.utilityclasses.ParticleUtils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public abstract class EntityElementalBoltAOE extends EntityElementalBolt {

    public EntityElementalBoltAOE(World worldIn) {
	super(worldIn);

    }

    public static int radius = 3;

    public abstract Elements element();

    static class Color {
	int x;
	int y;
	int z;

	public static HashMap<Elements, Color> BY_ELEMENT = new HashMap<Elements, Color>() {
	    {
		put(Elements.Fire, new Color(0, 0, 0));
		put(Elements.Water, new Color(-1, -1, 1));
		put(Elements.Thunder, new Color(0, 1, 0));
		put(Elements.Nature, new Color(-1, 1, 0));
		put(Elements.None, new Color(0, 0, 1));

	    }
	};

	public Color(int x, int y, int z) {
	    this.x = x;
	    this.y = y;
	    this.z = z;
	}

    }

    public void SpawnRedstone(Elements element, Entity entity, int radius, int x, int y, int z) {

	ParticleUtils.spawnParticleGenerator(entity, new AoeProjectileParticleGen().Name(), entity.posX, entity.posY,
		entity.posZ, x, y, z);

    }

    @Override
    protected void onImpact(RayTraceResult result) {

	if (world.isRemote) {

	    world.playSound(this.posX, this.posY, this.posZ, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS,
		    0.1F, 0.5F, true);

	} else {
	    int x = Color.BY_ELEMENT.get(element()).x;
	    int y = Color.BY_ELEMENT.get(element()).y;
	    int z = Color.BY_ELEMENT.get(element()).z;

	    SpawnRedstone(element(), this, radius, x, y, z);

	}
	if (effect != null && data != null) {

	    double x = result.hitVec.x;
	    double y = result.hitVec.y;
	    double z = result.hitVec.z;

	    List<EntityLivingBase> entities = world.getEntitiesWithinAABB(EntityLivingBase.class,
		    new AxisAlignedBB(x - radius, y - radius, z - radius, x + radius, y + radius, z + radius));

	    if (entities != null) {
		for (EntityLivingBase entity : entities) {
		    effect.Activate(data, entity);
		}
	    }
	}

	if (!this.world.isRemote) {
	    this.world.setEntityState(this, (byte) 3);
	    this.setDead();
	}

    }
}
