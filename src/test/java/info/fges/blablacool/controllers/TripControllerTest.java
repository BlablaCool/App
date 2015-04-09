package info.fges.blablacool.controllers;

import info.fges.blablacool.models.Place;
import info.fges.blablacool.models.Trip;
import info.fges.blablacool.models.User;
import info.fges.blablacool.services.MessageService;
import info.fges.blablacool.services.StepService;
import info.fges.blablacool.services.TripService;
import info.fges.blablacool.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath*:/spring/applicationContext*.xml")
public class TripControllerTest {

    @Mock
    private TripService tripService;

    @Mock
    private UserService userService;

    @Mock
    private StepService stepService;

    @Mock
    private MessageService messageService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Mock
    private ServletContext servletContext;

    @InjectMocks
    private TripController tripController;

    @Mock
    MockHttpSession session;


    private MockMvc mockMvc;

    Trip trip;
    Place place1, place2;
    User user;
    TestingAuthenticationToken auth;

    @Before
    public void setup() {

        trip = new Trip();
        trip.setIdTrip(1);
        place1 = new Place();
        place2 = new Place();
        user = new User();
        user.setId(1);
        user.setPassword("monmdp");
        user.setNickname("Nicolas");
        user.setEmail("nducom@gmail.com");

        // Process mock annotations
        MockitoAnnotations.initMocks(this);
        session = new MockHttpSession();

        // Setup Spring test in standalone mode
        mockMvc = MockMvcBuilders.standaloneSetup(tripController).build();
        Mockito.when(tripService.findById(1)).thenReturn(trip);
        Mockito.when(userService.findById(1)).thenReturn(user);
    }

    @Test
    public void testGetIndex() throws Exception {
        mockMvc.perform(get("/trips/"))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetNew() throws Exception {
        session.setAttribute("user", user);

        mockMvc.perform(get("/trips/new")
                .session(session))
                .andExpect((status().isOk()))
                .andExpect(model().attributeExists("departureAddress"))
                .andExpect(model().attributeExists("arrivalAddress"))
                .andExpect(model().attributeExists("driver"))
                .andExpect(model().attribute("driver",user));

    }

    @Test
    public void testGetTrip() throws Exception {
        mockMvc.perform(get("/trips/1"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("trip"))
                .andReturn();
    }

    @Test
    public void testAddMessageToTrip() throws Exception {

    }

    @Test
    public void testGetCopyTrip() throws Exception {

    }
}