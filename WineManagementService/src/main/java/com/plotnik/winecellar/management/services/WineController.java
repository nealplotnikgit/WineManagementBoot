package com.plotnik.winecellar.management.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plotnik.winecellar.management.model.WineDTO;

import java.util.List;
@CrossOrigin(origins = "https://wine-application.cfapps.io")
@RestController
@RequestMapping("/wines")
public class WineController {
    @Autowired WineServiceJPA service;
    @GetMapping
    public List<Wine> getWines() {
        return service.getWines();
    }
    @PostMapping
    public void postWine(@RequestBody WineDTO dto) {
        service.add(dto);
    }
    @GetMapping("/{id}")
    public Wine getById(@PathVariable(required = true) long id) throws WineNotFoundException {
        return service.getWineById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        service.delete(id);
    }
    @GetMapping("/name/{name}")
    public List<Wine> getByName(@PathVariable(required = true) String name) throws WineNotFoundException {
        return service.findWineByName(name);
    }
}
