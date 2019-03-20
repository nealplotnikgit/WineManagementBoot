package com.plotnik.winecellar.management.services;

//http://localhost:8080/UPC?id=xxxxxx
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import javax.ws.rs.core.Response;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plotnik.winecellar.management.model.Wine;
@RestController
//@Path("/")
public class GetWineDetailService {
@RequestMapping(value="/UPC", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public Wine getWineDetail(@RequestParam(value="id", defaultValue="1")String id) {
        Wine wine = new Wine(Integer.parseInt(id));
        wine.setCost(100.00f);
        wine.setPrice(110.00f);
        wine.setName("Le Bongo-Incredible 2");
        wine.setVintner("Apache");
        wine.setVintageYear(new Integer(LocalDate.now().getYear()).toString());
        wine.setCategory("Red");
        return wine;
//        return Response.status(200).entity(output).build();
    }

}

//@GET
//@Path("/{UPC}")
//@Produces({"application/json"})

