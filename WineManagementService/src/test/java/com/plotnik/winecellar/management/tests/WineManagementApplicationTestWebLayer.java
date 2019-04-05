package com.plotnik.winecellar.management.tests;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.plotnik.winecellar.management.model.Wine;
import com.plotnik.winecellar.management.services.GetWineDetailController;
import com.plotnik.winecellar.management.services.SearchCriteria;
import com.plotnik.winecellar.management.services.WineDao;
import com.plotnik.winecellar.management.services.WineService;

import static org.mockito.BDDMockito.given;

import java.time.Year;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@WebMvcTest(value = GetWineDetailController.class, secure = false)
public class WineManagementApplicationTestWebLayer {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private WineService wineService;
	
	Wine mockWine = new Wine(2, "Le Bongo", 110, 100, "2019", "Apache", "Red" );

	String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
	
	@Before
	public void before() {
		//
	}
	
	@Test
	public void testGetDetail() throws Exception {
		
		Mockito.when(wineService.getWineDetail(Mockito.anyString())).thenReturn(mockWine);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/detail?id=11111").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"upc\":2,\"name\":\"Le Bongo\",\"price\":110.0,\"cost\":100.0,\"vintageYear\":\"2019\",\"vintner\":\"Apache\",\"category\":\"Red\"}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
					
	}
	@Test
	public void testGetDetailNullId() throws Exception {
		
		Mockito.when(wineService.getWineDetail(Mockito.anyString())).thenReturn(mockWine);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/detail").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "id is null";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}
		assertEquals(result.getResponse().getStatus(),404);
		assertEquals("error message", expected, result.getResponse().getContentAsString());
					
	}
	
	@Test
	@Ignore
	public void testGetWineList() throws Exception {
		
		//fill in
		
		
	}
	
}
