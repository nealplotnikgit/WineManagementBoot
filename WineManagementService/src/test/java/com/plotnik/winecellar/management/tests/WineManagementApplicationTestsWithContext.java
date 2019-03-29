package com.plotnik.winecellar.management.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.plotnik.winecellar.management.model.Wine;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WineManagementApplicationTestsWithContext {

	@Autowired
	private ApplicationContext applicationContext;
	
	private static Wine wine;
	@Test
	public void contextLoads() {
		assertNotNull("the context loaded", this.applicationContext);
	}
	
	@Test
	public void createWine() {
		assertNotNull("got wine", wine);
		assertNotNull("wine has a name",wine.getName());
		assertTrue("wine has a name as set",wine.getName().equals("RED"));
	}
	
	@BeforeClass
	public static void before() {
		wine = new Wine();
		wine.setName("RED");
	}
}
