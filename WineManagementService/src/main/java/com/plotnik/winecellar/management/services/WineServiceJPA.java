package com.plotnik.winecellar.management.services;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.plotnik.winecellar.management.model.WineDTO;

import java.util.List;
import java.util.Optional;
@Service
public class WineServiceJPA {
		
	@Autowired WineRepository repository;

	
	public void add(WineDTO wine) {
        repository.save(toEntity(wine));
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
    public List<Wine> getWines() {
        return (List<Wine>) repository.findAll();
    }
    public Wine getWineById(long id) throws WineNotFoundException {
        Optional<Wine> optionalWine = repository.findById(id);
        return optionalWine.orElseThrow(() -> new WineNotFoundException("Couldn't find Wine with id: " + id));
    }
    private Wine toEntity(WineDTO wine) {
        Wine entity = new Wine();
        entity.setName(wine.getName());
        entity.setUpc(wine.getUpc());
        entity.setCategory(wine.getCategory());
        entity.setCost(wine.getCost());
        entity.setPrice(wine.getPrice());
        entity.setVintageYear(wine.getVintageYear());
        entity.setVintner(wine.getVintner());
        return entity;
    }
}
