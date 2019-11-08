package com.robertx22.mine_and_slash.database.stats.mods.multi.offence;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.types.offense.PhysicalDamage;
import com.robertx22.mine_and_slash.uncommon.enumclasses.StatTypes;

public class LessPhysicalDamageMulti extends StatMod {

    @Override
    public String GUID() {
        return "LessPhysicalDamageMulti";
    }

    @Override
    public float Min() {
        return -5;
    }

    @Override
    public float Max() {
        return -10;
    }

    @Override
    public StatTypes Type() {
        return StatTypes.Multi;
    }

    @Override
    public Stat GetBaseStat() {
        return PhysicalDamage.INSTANCE;
    }

}