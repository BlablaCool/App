package info.fges.blablacool.services;

import info.fges.blablacool.dao.TripDao;
import info.fges.blablacool.models.Trip;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.servlet.ServletContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath*:/spring/applicationContext*.xml")
public class TripServiceTest {
    @InjectMocks
    private TripService tripService;

    @Mock
    private TripDao tripDao;

    @Mock
    private ServletContext servletContext;

    Trip trip1, trip2;
    List<Trip> trips;

    @Before
    public void setUp() throws Exception {
        trip1 = new Trip();
        trip1.setIdTrip(1);

        trip2 = new Trip();
        trip2.setIdTrip(2);

        trips = Arrays.asList(trip1, trip2);

        MockitoAnnotations.initMocks(this);

        Mockito.when(tripService.findById(1)).thenReturn(trip1);
        Mockito.when(tripService.findAll()).thenReturn(trips);

    }

    @Test
    public void testFindById() throws Exception {
        Trip foundTrip = tripService.findById(1);
        assertEquals(1, foundTrip.getIdTrip());
    }

    @Test
    public void testFindAll() throws Exception {
        List<Trip> foundTrips = tripService.findAll();
        assertEquals(2, foundTrips.size());
    }

    @Test
    public void testCreate() throws Exception {
        tripService.create(trip1);
        verify(tripDao).create(trip1);
    }

    @Test
    public void testUpdate() throws Exception {
        tripService.update(trip1);
        verify(tripDao).update(trip1);
    }

    @Test
    public void testDelete() throws Exception {
        tripService.delete(trip1);
        verify(tripDao).delete(trip1);
    }

    @Test
    public void testDeleteById() throws Exception {
        tripService.deleteById(1);
        verify(tripDao).deleteById(1);
    }

    @Test
    public void testFindRecents() throws Exception {

    }
}