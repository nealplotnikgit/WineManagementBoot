package com.plotnik.winecellar.management.services;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.plotnik.winecellar.management.model.Wine;

@Repository
public class WineDaoImpl implements WineDao {

	
NamedParameterJdbcTemplate template;  

public WineDaoImpl(NamedParameterJdbcTemplate template) {  
    this.template = template;  
}  
	

	/* (non-Javadoc)
	 * @see com.plotnik.winecellar.management.services.WineDao#getWineList(com.plotnik.winecellar.management.services.SearchCriteria)
	 */
	@Override
	public ArrayList<Wine> getWineList(long upc, String category, String name, String year) throws WineDataException {
		//TODO need to fix to handle other criteria
		String query = "select upc, varietal, vintner, category,size from prod.wine_master where upc = " + upc;
		try { 
			  List<Wine> l = template.query(query,new WineRowMapper());
			  if (l.size() == 0) {
				  throw new WineDataException("no data"); //TODO Fix this!
			  }
			  return new ArrayList<Wine>(l);
		} catch (DataAccessException d) {
			throw new WineDataException("Data Exception finding Wine",d); //TODO add logging somewhere
		} catch (Exception e) {
			throw new WineDataException("Exception finding Wine",e);
		}
	/*
		ArrayList<Wine> wineList = new ArrayList<Wine>();
		Wine wine = new Wine(Integer.parseInt(searchCriteria.getId()));
	    wine.setCost(100.00f);
	    wine.setPrice(110.00f);
	    wine.setName(searchCriteria.getName());
	    wine.setVintner("Apache");
	    wine.setVintageYear(Year.now().toString());
	    wine.setCategory(searchCriteria.getCategory());
	    wineList.add(wine);
	    return wineList;
	    */
	}

	@Override
	public Wine getWineDetail(long UPC) throws WineDataException {
		String query = "select upc, varietal, vintner, category,size from prod.wine_master where upc = " + UPC;
		try { 
			  
			List<Wine> l = template.query(query,new WineRowMapper());
			  if (l.size() == 0) {
				  throw new WineDataException("no data"); //TODO Fix this!
			  } else {//assume one row
				  return l.get(0);
			  }
		} catch (DataAccessException d) {
			throw new WineDataException("Data Exception finding Wine",d); //TODO add logging somewhere
		} catch (Exception e) {
			throw new WineDataException("Exception finding Wine",e);
		}
	}
	
/*		Wine wine = new Wine(Integer.parseInt(id));
		wine.setCost(100.00f);
		wine.setPrice(110.00f);
		wine.setName("Le Bongo-Incredible 2");
		wine.setVintner("Apache");
		wine.setVintageYear(new Integer(LocalDate.now().getYear()).toString());
		wine.setCategory("Red");
		return wine; */
	}
	
	

