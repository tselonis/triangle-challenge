package com.example.triangle;

import com.example.triangle.business.rest.facade.api.TriangleFacade;
import com.example.triangle.controllers.rest.TriangleController;
import com.example.triangle.response.rest.TriangleResponse;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TriangleControllerTests {

    private final String REST_API_CONTEXT_PATH = "/triangle/type/evaluate";
    private final String QUERY_PARAM_SEPARATOR = "&";

    private MockMvc mockMvc;

    @Mock
    private TriangleFacade triangleFacade;

    @InjectMocks
    private TriangleController triangleController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(triangleController).build();
    }

    @Test
    public void testEquilateral() throws Exception {
        int a=1, b=1, c=1;
        TriangleResponse answer = new TriangleResponse(true, "Equilateral triangle");

        Mockito.when(triangleFacade.evaluateTriangle(a, b, c)).thenReturn(answer);

        mockMvc.perform(MockMvcRequestBuilders.get(createRequestUrl(a,b,c))).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.triangle", Matchers.is(true)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description", Matchers.is("Equilateral triangle")));

        Mockito.verify(triangleFacade).evaluateTriangle(a, b, c);
    }

    @Test
    public void testIsosceles() throws Exception {
        int a=5, b=4, c=5;
        TriangleResponse answer = new TriangleResponse(true, "Isosceles triangle");

        Mockito.when(triangleFacade.evaluateTriangle(a, b, c)).thenReturn(answer);

        mockMvc.perform(MockMvcRequestBuilders.get(createRequestUrl(a,b,c))).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.triangle", Matchers.is(true)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description", Matchers.is("Isosceles triangle")));

        Mockito.verify(triangleFacade).evaluateTriangle(a, b, c);
    }

    @Test
    public void testScalene() throws Exception {
        int a=7, b=4, c=5;
        TriangleResponse answer = new TriangleResponse(true, "Scalene triangle");

        Mockito.when(triangleFacade.evaluateTriangle(a, b, c)).thenReturn(answer);

        mockMvc.perform(MockMvcRequestBuilders.get(createRequestUrl(a,b,c))).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.triangle", Matchers.is(true)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description", Matchers.is("Scalene triangle")));

        Mockito.verify(triangleFacade).evaluateTriangle(a, b, c);
    }

    @Test
    public void testNoTriangle() throws Exception {
        int a=7, b=1, c=2;
        TriangleResponse answer = new TriangleResponse(true, "No triangle");

        Mockito.when(triangleFacade.evaluateTriangle(a, b, c)).thenReturn(answer);

        mockMvc.perform(MockMvcRequestBuilders.get(createRequestUrl(a,b,c))).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.triangle", Matchers.is(true)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description", Matchers.is("No triangle")));
        
        Mockito.verify(triangleFacade).evaluateTriangle(a, b, c);
    }

    @Test
    public void testBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(createBadRequestUrl())).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    private String createRequestUrl(int a, int b, int c) {
        String url = REST_API_CONTEXT_PATH + "?" +
                "a=" + a + QUERY_PARAM_SEPARATOR +
                "b=" + b + QUERY_PARAM_SEPARATOR +
                "c=" + c;
        return url;
    }

    private String createBadRequestUrl() {
        String url = REST_API_CONTEXT_PATH + "?" +
                "a=" + 1 + QUERY_PARAM_SEPARATOR +
                "b=" + 1 + QUERY_PARAM_SEPARATOR +
                "c=";
        return url;
    }

}
