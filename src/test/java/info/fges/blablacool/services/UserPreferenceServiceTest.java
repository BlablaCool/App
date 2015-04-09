package info.fges.blablacool.services;

import info.fges.blablacool.dao.UserDao;
import info.fges.blablacool.dao.UserPreferenceDao;
import info.fges.blablacool.models.UserPreference;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath*:/spring/applicationContext*.xml")
public class UserPreferenceServiceTest {

    @InjectMocks
    private UserPreferenceService userPreferenceService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Mock
    private UserPreferenceDao userPreferenceDao;

    @Mock
    private ServletContext servletContext;

    UserPreference userPreference1,userPreference2;

    @Before
    public void setUp() throws Exception {
        userPreference1 = new UserPreference();
        userPreference1.setIdUserPreference(1);

        userPreference2 = new UserPreference();
        userPreference2.setIdUserPreference(2);

        MockitoAnnotations.initMocks(this);

        List<UserPreference> usersPreferences = Arrays.asList(userPreference1, userPreference2);

        Mockito.when(userPreferenceService.findById(1)).thenReturn(userPreference1);
        Mockito.when(userPreferenceService.findAll()).thenReturn(usersPreferences);

    }

    @Test
    public void testFindById() throws Exception {
        UserPreference findUserPreference = userPreferenceService.findById(1);
        assertEquals(1, findUserPreference.getIdUserPreference());
    }

    @Test
    public void testFindAll() throws Exception {
        List<UserPreference> usersPreferences = userPreferenceService.findAll();
        assertEquals(2, usersPreferences.size());
    }

    @Test
    public void testCreate() throws Exception {
        userPreferenceService.create(userPreference1);
        verify(userPreferenceDao).create(userPreference1);
    }

    @Test
    public void testUpdate() throws Exception {
        userPreferenceService.update(userPreference1);
        verify(userPreferenceDao).update(userPreference1);
    }

    @Test
    public void testDelete() throws Exception {
        userPreferenceService.delete(userPreference1);
        verify(userPreferenceDao).delete(userPreference1);
    }

    @Test
    public void testDeleteById() throws Exception {
        userPreferenceService.deleteById(1);
        verify(userPreferenceDao).deleteById(1);
    }
}