package com.plotnik.winecellar.management.services;


import java.util.ArrayList;


//import javax.ws.rs.core.Response;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plotnik.winecellar.management.model.Order;
import com.plotnik.winecellar.management.model.Wine;
@RestController
//@Path("/order")
public class WineOrderController {
	@RequestMapping(value="/order", 
            method=RequestMethod.POST, 
            produces=MediaType.APPLICATION_JSON_VALUE,
            consumes=MediaType.APPLICATION_JSON_VALUE)

//    @POST
//    @Consumes({"application/json"})
//    @Produces({"application/json"})
    public Order submitOrder(@RequestBody Order order) throws Exception{ 
        if ((order == null)){
        	throw new Exception("Empty Order!");
        }
        return order;
//        return Response.status(200).entity(output).build();
    }

}


