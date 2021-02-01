package org.arcelik.builder;

import org.arcelik.builder.Application.ApplicationBuilder;

public abstract class AppBuilder {
	 public abstract ApplicationBuilder name(String name);
	 
     public abstract ApplicationBuilder shortDesc(String shortDesc);
     
     public abstract ApplicationBuilder longDesc(String longDesc);
     
     public abstract ApplicationBuilder locale(String locale);
     
     public abstract ApplicationBuilder rate(int rate);

     public abstract Application build();
}
