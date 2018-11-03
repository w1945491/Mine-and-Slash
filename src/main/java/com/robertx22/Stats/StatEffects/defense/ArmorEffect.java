package com.robertx22.stats.StatEffects.defense;

import com.robertx22.effectdatas.EffectData;
import com.robertx22.effectdatas.interfaces.IArmorReducable;
import com.robertx22.effectdatas.interfaces.IPenetrable;
import com.robertx22.saveclasses.Unit;
import com.robertx22.stats.IStatEffect;
import com.robertx22.stats.Stat;
import com.robertx22.stats.UsableStat;

public class ArmorEffect implements IStatEffect {

	@Override
	public int GetPriority() {
		return 10;
	}

	@Override
	public EffectSides Side() {
		return EffectSides.Target;
	}

	@Override
	public EffectData TryModifyEffect(EffectData Effect, Unit source, Stat stat) {

		try {
			if (Effect instanceof IArmorReducable) {

				int pene = 0;

				if (Effect instanceof IPenetrable) {
					IPenetrable ipen = (IPenetrable) Effect;
					pene = ipen.GetArmorPenetration();
				}

				Unit target = Effect.GetTarget();

				UsableStat armor = (UsableStat) stat;

				float EffectiveArmor = armor.GetUsableValue(target.level, (int) (armor.Value - pene));

				if (EffectiveArmor < 0) {
					EffectiveArmor = 0;
				}

				float old = Effect.Number;

				Effect.Number -= EffectiveArmor * Effect.Number;

				// System.out.println("Reducing dmg by armor from: " + old + " to " +
				// Effect.Number + "(" + EffectiveArmor
				// + ") armor");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Effect;
	}

}
