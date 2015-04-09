package info.fges.blablacool.services;

import info.fges.blablacool.dao.PlaceDao;
import info.fges.blablacool.models.Place;
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
public class PlaceServiceTest {
    @InjectMocks
    private PlaceService placeService;

    @Mock
    private PlaceDao placeDao;

    @Mock
    private ServletContext servletContext;

    Place place1, place2;
    List<Place> places;

    @Before
    public void setUp() throws Exception {
        place1 = new Place();
        place1.setIdPlace(1);

        place2 = new Place();
        place2.setIdPlace(2);

        places = Arrays.asList(place1, place2);

        MockitoAnnotations.initMocks(this);

        Mockito.when(placeService.findById(1)).thenReturn(place1);
        Mockito.when(placeService.findAll()).thenReturn(places);

    }

    @Test
    public void testFindById() throws Exception {
        Place foundPlace = placeService.findById(1);
        assertEquals(1, foundPlace.getIdPlace());
    }

    @Test
    public void testFindAll() throws Exception {
        List<Place> foundPlaces = placeService.findAll();
        assertEquals(2, foundPlaces.size());
    }

    @Test
    public void testCreate() throws Exception {
        placeService.create(place1);
        verify(placeDao).create(place1);
    }

    @Test
    public void testUpdate() throws Exception {
        placeService.update(place1);
        verify(placeDao).update(place1);
    }

    @Test
    public void testDelete() throws Exception {
        placeService.delete(place1);
        verify(placeDao).delete(place1);
    }

    @Test
    public void testDeleteById() throws Exception {
        placeService.deleteById(1);
        verify(placeDao).deleteById(1);
    }

}