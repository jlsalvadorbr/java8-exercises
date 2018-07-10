package lambda.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

public class Country {
	
	public enum Government {
		Republic, Constitutional_Monarchy, Abosulute_Monarchy  
	}
	
	private String name;
	private int population;
	private String capitalCity;
	private double gdp;
	private Government government;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate foundation;
	private boolean island;
	
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
