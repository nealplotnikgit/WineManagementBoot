package com.plotnik.winecellar.management.services;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WineRepository extends CrudRepository<Wine, Long> {}
