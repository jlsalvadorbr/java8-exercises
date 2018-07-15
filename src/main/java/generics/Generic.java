package generics;

import domain.Country;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static domain.CountryRepository.getCountry;

public class Generic<T, U> {
	
	public interface FilterList<T>  {
		List<T> filterList(List<T> items);
	}

	public class EvenFilter implements FilterList<T> 
	{

		@Override
		public List<T> filterList(List<T> items) {
			
			List<T> result = new ArrayList<>();
			
			int i = 0;
			for (T t : items)
			{
				if (i++ % 2 == 0)
				{
					result.add(t);
				}
			}
			
			return result;
		}
	}

	//To both get and put values from/into a structure
    //Unbounded wildcard
    //invariant means that the type must be exactly as specified
	public List<U> invariance(List<U> items)
	{

	    return items;
	}

	//PEcs: Producer Extends
    //To only get values out of a structure
    //Wildcard with upper bound
    //arrays are covariant because String[] is a subtype of Object[],
    //but collections are not covariant unless we use the extends keyword with a wildcard.
	public List<U> covariance(List<? extends Country> items)
	{
		//items.add(getCountry("China"));
		for (Country c : items)
		{
			System.out.println(c.getName());
		}
		return null;
	}

	//peCS: Consumer Super
    //To only put values into a structure
    //Wildcard with lower bound
	public List<U> contravariance(List<? super CommentedCountry> items)
	{
        Country china = getCountry("China");
        CommentedCountry commentedChina = new CommentedCountry(china, "This is a comment for China");
        items.add(commentedChina);
        //items.add(china);
        //CommentedCountry item = items.get(0);
        //Country item = items.get(0);
        Object item = items.get(0);

	    return null;
	}
	
	private void printList(List<String> results) {
		for (String result : results)
		{
			System.out.println(result);
		}
	}
	
	static class CommentedCountry extends Country {
		private String comment;
		
		public CommentedCountry(Country country, String comment) {
			this.name = country.getName();
			this.population = country.getPopulation();
			this.capitalCity = country.getCapitalCity();
			this.gdp = country.getGdp();
			this.government = country.getGovernment();
			this.foundation = country.getFoundation();
			this.island = country.isIsland();
			this.comment = comment;
		}

		public String getComment() {
			return comment;
		}
	}
	
	public static void main(String[] args) {
		
		List<String> items = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine");
		
		Generic generic = new Generic<String, Country>();
		Generic.EvenFilter evenFilter = generic.new EvenFilter();
				
		List<String> results = evenFilter.filterList(items);
		generic.printList(results);

		Country spain = getCountry("Spain");
		Country uk = getCountry("United Kingdom");
		Country germany = getCountry("Germany");

		CommentedCountry commentedCountry1 = new CommentedCountry(spain, "This is a comment for Spain");
		CommentedCountry commentedCountry2 = new CommentedCountry(uk, "This is a comment for UK");
		CommentedCountry commentedCountry3 = new CommentedCountry(germany, "This is a comment for Germany");

		generic.covariance(Arrays.asList(spain, uk, germany));
		generic.covariance(Arrays.asList(commentedCountry1, commentedCountry2, commentedCountry3));

        generic.contravariance(Arrays.asList(spain, uk, germany));
        generic.contravariance(Arrays.asList(commentedCountry1, commentedCountry2, commentedCountry3));



	}
}
