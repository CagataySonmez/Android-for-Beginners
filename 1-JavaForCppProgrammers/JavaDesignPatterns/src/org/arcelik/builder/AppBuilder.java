package org.arcelik.builder;

import org.arcelik.builder.App.Builder;

public abstract class AppBuilder {
	 public abstract AppBuilder name(String name);
	 
     public abstract AppBuilder shortDesc(String shortDesc);
     
     public abstract AppBuilder longDesc(String longDesc);
     
     public abstract AppBuilder locale(String locale);
     
     public abstract AppBuilder rate(int rate);

     public abstract App build();
}
