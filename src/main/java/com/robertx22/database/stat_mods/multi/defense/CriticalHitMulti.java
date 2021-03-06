package com.robertx22.database.stat_mods.multi.defense;

import com.robertx22.database.stat_types.offense.CriticalHit;
import com.robertx22.database.stats.Stat;
import com.robertx22.database.stats.StatMod;
import com.robertx22.uncommon.enumclasses.StatTypes;

public class CriticalHitMulti extends StatMod {

    @Override
    public String GUID() {
	return "CriticalHitMulti";
    }

    @Override
    public float Min() {
	return 5;
    }

    @Override
    public float Max() {
	return 10;
    }

    @Override
    public StatTypes Type() {
	return StatTypes.Multi;
    }

    @Override
    public Stat GetBaseStat() {
	return new CriticalHit();
    }

}
