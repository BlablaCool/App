package info.fges.blablacool.controllers;

import info.fges.blablacool.services.CarService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.servlet.ServletContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration (locations = "classpath*:/spring/applicationContext*.xml")
public class CarControllerTest {
    @Mock
    private CarService carService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Mock
    private ServletContext servletContext;

    @InjectMocks
    private CarController carController;

    private MockMvc mockMvc;

    @Before
    public void setup() {

        // Process mock annotations
        MockitoAnnotations.initMocks(this);

        // Setup Spring test in standalone mode
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();

    }

    @Test
    public void testGetNew() throws Exception {
        mockMvc.perform(get("/cars/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("newCar"));
    }

    @Test
    public void testGetCarMakes() throws Exception {
    }

    @Test
    public void testGetCarsByMake() throws Exception {

    }

    @Test
    public void testGetCarTrims() throws Exception {

    }

    @Test
    public void testGetApiResponse() throws Exception {

    }

    @Test
    public void testCreate() throws Exception {

    }

    @Test
    public void testSetServletContext() throws Exception {

    }
}