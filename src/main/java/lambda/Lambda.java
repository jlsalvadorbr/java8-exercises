package lambda;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import domain.Country;

public class Lambda {
	
    public static void main(String[] args) {
    	SimpleMethod1 sm = new SimpleMethod1();
    	sm.execute();
	}
}
