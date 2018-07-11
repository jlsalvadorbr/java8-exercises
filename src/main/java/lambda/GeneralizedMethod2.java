package lambda;

import java.util.List;

import domain.Country;

import static domain.CountryRepository.COUNTRIES;

//More generic, but still brittle (rewrite if Country changes) and restrictive (new method for new query)
public class GeneralizedMethod2 {

	public void printCountriesWithinPopulationRange(List<Country> countries, int lowPopulation, int highPopulation)
	{
		for (Country c : countries) {
			if (c.getPopulation() >= lowPopulation && c.getPopulation() <= highPopulation)
			{
				System.out.println(c.getName());
			}
		}
	}

	public void printCountriesWithinGDPRange(List<Country> countries, int lowGDP, int highGDP)
	{
		for (Country c : countries) {
			if (c.getGdp() >= lowGDP && c.getGdp() <= highGDP)
			{
				System.out.println(c.getName());
			}
		}
	}
	
	public void execute()
	{
		System.out.println("Countries more populated than 500000");
		printCountriesWithinPopulationRange(COUNTRIES, 500000, Integer.MAX_VALUE);
		System.out.println("Countries with GDP higher than 100000");		
		printCountriesWithinGDPRange(COUNTRIES, 100000, Integer.MAX_VALUE);
		System.out.println("Countries with GDP lower than 100000");		
		printCountriesWithinGDPRange(COUNTRIES, 0, 100000);
		
	}
	
	public static void main(String[] args) {
		GeneralizedMethod2 sm = new GeneralizedMethod2();
		sm.execute();
	}
}
