package info.fges.blablacool.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath*:/spring/applicationContext*.xml")
public class SearchServiceTest {


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetSearchUrlForTripsWithAddresses() throws Exception {

    }

    @Test
    public void testGetSearchUrlForTripsNearbyLocation() throws Exception {

    }

    @Test
    public void testFindTripsWithAddresses() throws Exception {

    }

    @Test
    public void testFindTripsNearbyLocation() throws Exception {

    }
}