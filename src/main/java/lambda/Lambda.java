package lambda;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lambda.domain.Country;

public class Lambda {
	
	public final static List<Country> COUNTRIES = readCountries();

    private static List<Country> readCountries()
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
    	
    	return countries;
    }
    
    public static void main(String[] args) {
    	SimpleMethod1 sm = new SimpleMethod1();
    	sm.execute();
	}
	
	
	
	
}
