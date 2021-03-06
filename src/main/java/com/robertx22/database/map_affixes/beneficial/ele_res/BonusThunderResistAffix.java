package com.robertx22.database.map_affixes.beneficial.ele_res;

import java.util.Arrays;
import java.util.List;

import com.robertx22.database.map_affixes.bases.BaseBeneficialEleAffix;
import com.robertx22.database.map_mods.bonus.ele_res.BonusThunderResistMap;
import com.robertx22.saveclasses.gearitem.StatModData;

public class BonusThunderResistAffix extends BaseBeneficialEleAffix {

	@Override
	public String Name() {
		return "BonusThunderResistAffix";
	}

	@Override
	public List<StatModData> Stats(int percent) {
		return Arrays.asList(StatModData.NewStatusEffect(percent, new BonusThunderResistMap()));

	}

}
