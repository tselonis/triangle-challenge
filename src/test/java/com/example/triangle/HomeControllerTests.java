package com.example.triangle;

import com.example.triangle.controllers.HomeController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeControllerTests {

	private MockMvc mockMvc;

	@InjectMocks
	private HomeController homeController;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
	}

	@Test
	public void testHomeController() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("home"));
	}
}
