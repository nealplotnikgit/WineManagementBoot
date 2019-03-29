package com.plotnik.winecellar.management.services;

//http://localhost:8080/search?--parameters
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.ws.rs.core.Response;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plotnik.winecellar.management.model.Wine;
@RestController
//@Path("/search")
public class GetWineListController {
	
	@Autowired
	WineService service;

	@RequestMapping(value="/search", 
            method=RequestMethod.GET, 
                  produces=MediaType.APPLICATION_JSON_VALUE)
//    @GET
//    @Produces({"application/json"})
    public ArrayList<Wine> getWineList(@RequestParam(value="id", required=false)String id, 
    		@RequestParam(value="name",required=false) String name,
    		@RequestParam(value="year",required=false) String year,
    		@RequestParam(value="category",required=false) String category) throws Exception{
		if ((id == null) && (name == null) && (year == null) && (category == null)) {
        	throw new WineException("The search criteria is invalid");
        }
        SearchCriteria searchCriteria = new SearchCriteria();
        ArrayList<Wine> result = null;
        searchCriteria.setId(id);
        searchCriteria.setName(name);
        if (year != null) { 
        	try {
        		Year y = Year.parse(year);
            	if (y.isAfter(Year.now())) {
        			throw new WineException("Enter a year before current year");
        		}
            	searchCriteria.setYear(year);
        		
        		
        	} catch (DateTimeParseException d){
        		throw new WineException("invalid year entered");
        	}
        }
        searchCriteria.setCategory(category);
		
        try {
        	result = service.getWineList(searchCriteria);
		} catch (WineDataException wd) {
			throw new WineException("data exception", wd);
		}
        return result;
//        return Response.status(200).entity(output).build();
    }
	
	

}

