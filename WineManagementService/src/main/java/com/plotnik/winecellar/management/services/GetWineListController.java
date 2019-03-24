package com.plotnik.winecellar.management.services;

//http://localhost:8080/search?--parameters
import java.time.LocalDate;
import java.util.ArrayList;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.ws.Response;

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

	@RequestMapping(value="/search", 
            method=RequestMethod.GET, 
                  produces=MediaType.APPLICATION_JSON_VALUE)
//    @GET
//    @Produces({"application/json"})
    public ArrayList<Wine> getWineList(@RequestParam(value="id", required=false)String id, 
    		@RequestParam(value="name",required=false) String name,
    		@RequestParam(value="year",required=false) String year,
    		@RequestParam(value="category",required=false) String category) throws Exception{
        ArrayList<Wine> wineList = new ArrayList<Wine>();
        if ((id == null) && (name == null) && (year == null) && (category == null)) {
        	throw new Exception("The search criteria is invalid");
        }
        Wine wine = new Wine(Integer.parseInt(id));
        wine.setCost(100.00f);
        wine.setPrice(110.00f);
        wine.setName(name);
        wine.setVintner("Apache");
        wine.setVintageYear(year);
        wine.setCategory(category);
        wineList.add(wine);
        return wineList;
//        return Response.status(200).entity(output).build();
    }

}

