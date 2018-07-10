package lambda;

import java.util.List;

import lambda.domain.Country;

import static lambda.Lambda.COUNTRIES;

//One method per characteristic / matching condition
//Makes application brittle (rewrite if Country changes) and restrictive (new method for new query)
public class SimpleMethod1 {

	public void printCountriesMorePopulatedThan(List<Country> countries, int population)
	{
		for (Country c : countries) {
			if (c.getPopulation() > population)
			{
				System.out.println(c.getName());
			}
		}
	}
	
	public void printCountriesWithGDPHigherThan(List<Country> countries, int gdp)
	{
		for (Country c : countries) {
			if (c.getGdp() > gdp)
			{
				System.out.println(c.getName());
			}
		}
	}
	
	public void printCountriesWithGDPLowerThan(List<Country> countries, int gdp)
	{
		for (Country c : countries) {
			if (c.getGdp() < gdp)
			{
				System.out.println(c.getName());
			}
		}
	}
	
	public void execute()
	{
		System.out.println("Countries more populated than 500000");
		printCountriesMorePopulatedThan(COUNTRIES, 500000);
		System.out.println("Countries with GDP higher than 100000");		
		printCountriesWithGDPHigherThan(COUNTRIES, 100000);
		System.out.println("Countries with GDP lower than 100000");		
		printCountriesWithGDPLowerThan(COUNTRIES, 100000);
		
	}
	
	public static void main(String[] args) {
		SimpleMethod1 sm = new SimpleMethod1();
		sm.execute();
	}
}
