package domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

public class Country {
	
	public enum Government {
		Republic, Constitutional_Monarchy, Abosulute_Monarchy  
	}
	
	protected String name;
	protected int population;
	protected String capitalCity;
	protected double gdp;
	protected Government government;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate foundation;
	protected boolean island;
	
	public Country() {
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
}
