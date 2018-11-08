package com.robertx22.database.stats.mods.flat;

import com.robertx22.database.stats.types.offense.ArmorPenetration;
import com.robertx22.stats.Stat;
import com.robertx22.stats.StatMod;
import com.robertx22.uncommon.enumclasses.StatTypes;
import com.robertx22.uncommon.utilityclasses.IWeighted;

public class ArmorPeneFlat extends StatMod {

	public ArmorPeneFlat() {
	}

	@Override
	public String GUID() {
		return "Armor Penetration";
	}

	@Override
	public int Min() {
		return 2;
	}

	@Override
	public int Max() {
		return 10;
	}

	@Override
	public StatTypes Type() {
		return StatTypes.Flat;
	}

	@Override
	public Stat GetBaseStat() {
		return new ArmorPenetration();
	}

	@Override
	public int Weight() {
		return IWeighted.UncommonWeight;
	}

}
