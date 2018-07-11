package domain;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lambda.Lambda;

public class CountryRepository {

	private final static Map<String, Country> COUNTRY_MAP = loadCountries();
	public final static List<Country> COUNTRIES = new ArrayList<Country>(COUNTRY_MAP.values());

    private static Map<String, Country> loadCountries()
    {
    	List<Country> countries = new ArrayList<>();
    	
    	InputStream jsonInput = Lambda.class.getResourceAsStream("/countries.json");
    	ObjectMapper mapper = new ObjectMapper();
    	try
    	{ 
    		countries.addAll(mapper.readValue(jsonInput, new TypeReference<List<Country>>(){}));
    	}	
    	catch (IOException e)
    	{
    		throw new RuntimeException(e);
    	}
    	
    	Map<String, Country> result = countries.stream().collect(
    			Collectors.toMap(Country::getName, country -> country));
    	
    	return result;
    }
    
    public static Country getCountry(String name)
    {
    	return COUNTRY_MAP.get(name);
    }
    
    
}
