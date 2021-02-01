package com.arcelik.builder;

import com.arcelik.builder.Application.ApplicationBuilder;

public abstract class AppBuilder {
	 public abstract ApplicationBuilder name(String name);
	 
     public abstract ApplicationBuilder shortDesc(String shortDesc);
     
     public abstract ApplicationBuilder longDesc(String longDesc);
     
     public abstract ApplicationBuilder locale(String locale);
     
     public abstract ApplicationBuilder rate(int rate);

     public abstract Application build();
}
