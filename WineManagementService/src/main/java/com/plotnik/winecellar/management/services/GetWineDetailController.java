package com.plotnik.winecellar.management.services;

//http://localhost:8080/UPC?id=xxxxxx
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.ws.rs.core.Response;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plotnik.winecellar.management.model.Wine;
@RestController
//@Path("/")
public class GetWineDetailController {

@Autowired
	private WineService service;
	
@RequestMapping(value="/UPC", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public Wine getWineDetail(@RequestParam(value="id")String id) throws Exception{
        if (id == null) {
        	throw new WineException("id is null");
        }
		try{
			Wine result = getService().getWineDetail(id);
			return result;
		} catch (WineDataException w) {
			throw new WineException("data error", w);
		}
    }

private WineService getService() {
	return service;
}

private void setService(WineService service) {
	this.service = service;
}

}

//@GET
//@Path("/{UPC}")
//@Produces({"application/json"})

