package com.robertx22.database.stats.types;

import com.robertx22.enums.*;
import com.robertx22.stats.Stat;

public class Armor extends Stat {

	@Override
	public String Name() {
		return "Armor";
	}

	@Override
	public boolean ScalesToLevel() {		
		return false;
	}

	@Override
	public Elements Element() {		
		return null;
	}

	@Override
	public boolean IsPercent() {		
		return true;
	}
	
}
