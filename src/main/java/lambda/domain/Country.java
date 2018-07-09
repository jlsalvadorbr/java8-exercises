package lambda.domain;

import java.time.LocalDate;

public class Country {
	
	public enum Government {
		Republic, Constitutional_Monarchy, Abosulute_Monarchy  
	}
	
	private String name;
	private int population;
	private String capitalCity;
	private double gdp;
	private Government government;
	private LocalDate foundation;
	private boolean island;
	
	public Country(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public int getPopulation() {
		return population;
	}
	public String getCapitalCity() {
		return capitalCity;
	}
	public double getGdp() {
		return gdp;
	}
	public Government getGovernment() {
		return government;
	}
	public LocalDate getFoundation() {
		return foundation;
	}
	public boolean isIsland() {
		return island;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public void setCapitalCity(String capitalCity) {
		this.capitalCity = capitalCity;
	}

	public void setGdp(double gdp) {
		this.gdp = gdp;
	}

	public void setGovernment(Government government) {
		this.government = government;
	}

	public void setFoundation(LocalDate foundation) {
		this.foundation = foundation;
	}

	public void setIsland(boolean island) {
		this.island = island;
	}
}
