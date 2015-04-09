package info.fges.blablacool.controllers;

import info.fges.blablacool.models.User;
import info.fges.blablacool.models.UserPreference;
import info.fges.blablacool.services.BookingService;
import info.fges.blablacool.services.UserPreferenceService;
import info.fges.blablacool.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath*:/spring/applicationContext*.xml")
public class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private UserPreferenceService userPreferenceService;

    @Mock
    private BookingService bookingService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Mock
    private ServletContext servletContext;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    User user;
    UserPreference userPreference;

    @Before
    public void setup() {

        user = new User();
        userPreference = new UserPreference();
        user.setId(1);
        user.setNickname("Nicolas");
        user.setPreferences(userPreference);

        // Process mock annotations
        MockitoAnnotations.initMocks(this);

        Authentication auth = new UsernamePasswordAuthenticationToken(user,null);
        SecurityContextHolder.getContext().setAuthentication(auth);

        // Setup Spring test in standalone mode
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        Mockito.when(userService.findById(1)).thenReturn(user);
    }


    @Test
    public void testGetUserSettings() throws Exception {
        User userToEdit = userService.findById(1);
        mockMvc.perform(get("/users/settings"))
                .andExpect(model().attribute("user", any(User.class)));
               // .andExpect(status().isOk())
//                .andExpect(model().attribute("user", any(User.class)));

/*                .andExpect(view().name("users/settings"))
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attributeExists("userPreferences"))
                .andExpect(model().attributeExists("musicStyles"))
                .andExpect(model().attributeExists( "temperaments"))
                .andExpect(model().attributeExists("talkingLevels"))
                .andExpect(model().attributeExists("drivingStyles"));*/
    }

    @Test
    public void testGetUser() throws Exception {

        mockMvc.perform(get("users/1"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attribute("viewedUser",user.getId()));

    }

    @Test
    public void testGetLoggedInUser() throws Exception {

    }

    @Test
    public void testGetUserPastTrips() throws Exception {

    }

    @Test
    public void testGetPlans() throws Exception {

    }

    @Test
    public void testGetDriver() throws Exception {

    }

    @Test
    public void testGetPassenger() throws Exception {

    }

    @Test
    public void testPostUpdateUser() throws Exception {

    }

    @Test
    public void testPostUpdateUserPreferences() throws Exception {

    }
}