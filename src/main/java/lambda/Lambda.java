package lambda;

import java.util.Arrays;
import java.util.List;

import lambda.domain.Country;
import lambda.domain.Country.Government;

import java.time.LocalDate;

public class Lambda {
	
	final static List<Country> COUNTRIES = createCountries();

    private static List<Country> createCountries()
    {
    	Country unitedKingdom = new Country("United Kingdom");
    	unitedKingdom.setPopulation(1000);
    	unitedKingdom.setCapitalCity("London");
    	unitedKingdom.setGdp(150000);
    	unitedKingdom.setGovernment(Government.Constitutional_Monarchy);
    	unitedKingdom.setFoundation(LocalDate.of(1900, 12, 13));
    	unitedKingdom.setIsland(true);
   	
    	Country spain = new Country("Spain");
    	Country germany = new Country("Germany");
    	
    	final List<Country> countries = Arrays.asList(
    		unitedKingdom,
    		spain,
    		germany);
    	
    	return countries;
    }
    
    public static void main(String[] args) {
		
	}
	
	
	
	
}
