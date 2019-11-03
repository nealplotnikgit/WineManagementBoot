package com.plotnik.winecellar.management.services;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WineRepository extends CrudRepository<Wine, Long> {
	
	List<Wine> findByNameOrderByName(String name);
	
	List<Wine> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
	
}
