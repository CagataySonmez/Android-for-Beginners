package org.arcelik.builder;

public class App {

	private String name, shortDesc, longDesc, locale;
	private int rate;

	private App(Builder builder) {
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
	
	public static class Builder extends org.arcelik.builder.AppBuilder {
		private String name, shortDesc, longDesc, locale;
		private int rate;
		
		public Builder(){
			this.locale = "Global";
			this.rate = 3;
			this.shortDesc = "N/A";
			this.longDesc = "N/A";
		}

        public Builder name(String name){
            this.name = name;
            return this;
        }
        
        public Builder shortDesc(String shortDesc){
            this.shortDesc = shortDesc;
            return this;
        }
        
        public Builder longDesc(String longDesc){
            this.longDesc = longDesc;
            return this;
        }
        
        public Builder locale(String locale){
            this.locale = locale;
            return this;
        }
        
        public Builder rate(int rate){
            this.rate = rate;
            return this;
        }

        public App build(){
            return new App(this);
        }
	}
}
