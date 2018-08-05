package generics;

import static domain.CountryRepository.getCountry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.Country;

public class Generic<T> {
	
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
	
	public void invariance(List<Country> items)
	{
		CommentedCountry commentedCountryChina = new CommentedCountry(getCountry("China"), "This is a comment for China");
		items.add(commentedCountryChina); //fails
		items.add(getCountry("China"));
		System.out.println(items.get(0).getName());
		System.out.println(items.get(0).getClass().getName());
	}
	
	public void covariance(List<? extends Country> items)
	{
		CommentedCountry commentedCountryChina = new CommentedCountry(getCountry("China"), "This is a comment for China");
		//items.add(commentedCountryChina); //fails
		//items.add(getCountry("China")); //fails
		System.out.println(items.get(0).getName());
	}
	
	public void contravariance(List<? super CommentedCountry> items)
	{
		CommentedCountry commentedCountryChina = new CommentedCountry(getCountry("China"), "This is a comment for China");
		//items.add(getCountry("China")); //fails
		items.add(commentedCountryChina);
		//System.out.println(items.get(0).getName()); //fails
		System.out.println(items.get(0).getClass().getName()); //fails
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
		
		Generic<String> generic = new Generic<>();
		Generic<String>.EvenFilter evenFilter = generic.new EvenFilter();
				
		List<String> results = evenFilter.filterList(items);
		generic.printList(results);
		
		CommentedCountry commentedCountrySpain = new CommentedCountry(getCountry("Spain"), "This is a comment for Spain");
		CommentedCountry commentedCountryUK = new CommentedCountry(getCountry("United Kingdom"), "This is a comment for United Kingdom");
		CommentedCountry commentedCountryGermany = new CommentedCountry(getCountry("Germany"), "This is a comment for Germany");
		
		generic.invariance(Arrays.asList(commentedCountrySpain, commentedCountryUK, commentedCountryGermany));
		
		generic.covariance(Arrays.asList(commentedCountrySpain, commentedCountryUK, commentedCountryGermany));
		
		generic.contravariance(Arrays.asList(commentedCountrySpain, commentedCountryUK, commentedCountryGermany));
	}
}
