package generics;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import domain.Country;
import domain.Country.Government;
import domain.CountryRepository;

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
	
	public List<U> invariance(List<U> items)
	{
		return items;
	}
	
	public List<U> covariance(List<? extends U> items)
	{
		return null;
	}
	
	public List<U> contravariance(List<? super U> items)
	{
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
		
		
		CommentedCountry commentedCountry = new CommentedCountry(CountryRepository.getCountry("Spain"), "This is a comment");
	}
}
