package org.arcelik.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeSetting implements Setting{
	
	//collection of settings
	private List<Setting> settings = new ArrayList<Setting>();

	@Override
	public void reset() {
		for(Setting s : settings)
		{
			s.reset();
		}
	}
	
	//adding setting
	public void add(Setting s){
		this.settings.add(s);
	}
	
	//removing setting
	public void remove(Setting s){
		settings.remove(s);
	}
	
	//removing setting
	public void clear(){
		System.out.println("Clearing all the settings from composite");
		this.settings.clear();
	}

}
