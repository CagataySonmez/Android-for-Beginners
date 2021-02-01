package com.arcelik.builder;

public class Application {

	private String name, shortDesc, longDesc, locale;
	private int rate;

	private Application(ApplicationBuilder builder) {
        this.name = builder.name;
        this.shortDesc = builder.shortDesc;
        this.longDesc = builder.longDesc;
        this.locale = builder.locale;
        this.rate = builder.rate;
    }
	
	public String toString(){
		return "App Name: " + name + "\n" +
				"Short Description: " + shortDesc + "\n" +
				"Long Description: " + longDesc + "\n" +
				"Locale: " + locale + "\n" +
				"Rate: " + rate;
	}
	
	public static class ApplicationBuilder extends com.arcelik.builder.AppBuilder {
		private String name, shortDesc, longDesc, locale;
		private int rate;
		
		public ApplicationBuilder(){
			this.locale = "Global";
			this.rate = 3;
			this.shortDesc = "N/A";
			this.longDesc = "N/A";
		}

        public ApplicationBuilder name(String name){
            this.name = name;
            return this;
        }
        
        public ApplicationBuilder shortDesc(String shortDesc){
            this.shortDesc = shortDesc;
            return this;
        }
        
        public ApplicationBuilder longDesc(String longDesc){
            this.longDesc = longDesc;
            return this;
        }
        
        public ApplicationBuilder locale(String locale){
            this.locale = locale;
            return this;
        }
        
        public ApplicationBuilder rate(int rate){
            this.rate = rate;
            return this;
        }

        public Application build(){
            return new Application(this);
        }
	}
}
