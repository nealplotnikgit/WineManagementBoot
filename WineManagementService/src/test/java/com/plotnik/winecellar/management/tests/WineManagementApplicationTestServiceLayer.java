package com.plotnik.winecellar.management.tests;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.plotnik.winecellar.management.model.Wine;
import com.plotnik.winecellar.management.services.SearchCriteria;
import com.plotnik.winecellar.management.services.WineDao;
import com.plotnik.winecellar.management.services.WineService;

import static org.mockito.BDDMockito.given;

import java.time.Year;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
//@SpringBootTest  --> no context
public class WineManagementApplicationTestServiceLayer {
	
	@MockBean
	private WineDao wineDao;
	
	private WineService wineService;
	
	@Before
	public void before() {
		wineService = new WineService(wineDao);
	}
	
	@Test
	public void testGetDetail() throws Exception {
		given(this.wineDao.getWineDetail("123")).willReturn(new Wine(123));
		
		String id = "123";
		Wine wine = wineService.getWineDetail(id);
		
		assertNotNull("got wine", wine);
		assertNotNull("has id", wine.getUpc());
		assertNull("wine has no name",wine.getName());
		assertTrue("wine has id",wine.getUpc() == 123);
		
	}
	
	@Test
	public void testGetWineList() throws Exception {
		
		SearchCriteria s = new SearchCriteria();
		s.setCategory("Port");
		s.setId("123");
		s.setName("SweetStuff");
		s.setYear("1968");
		
		ArrayList<Wine> wineList = new ArrayList<Wine>();
		Wine wine = new Wine(Integer.parseInt(s.getId()));
	    wine.setCost(100.00f);
	    wine.setPrice(110.00f);
	    wine.setName(s.getName());
	    wine.setVintner("Apache");
	    wine.setVintageYear(s.getYear());
	    wine.setCategory(s.getCategory());
	    wineList.add(wine);
	    
		given(wineDao.getWineList(BDDMockito.any(SearchCriteria.class))).willReturn(wineList);
				
		ArrayList<Wine> result = wineService.getWineList(s);
		
		assertNotNull("got wine", wineList);
		assertTrue(wineList.size() == 1);
		assertNotNull("has wine", wineList.get(0));
		assertNotNull("wine has a name",wineList.get(0).getName());
		assertEquals(wineList.get(0).getName(), "SweetStuff");
		
		
	}
	
}
