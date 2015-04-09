package info.fges.blablacool.services;

import info.fges.blablacool.dao.CarDao;
import info.fges.blablacool.models.Car;
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
public class CarServiceTest {
    @InjectMocks
    private CarService carService;

    @Mock
    private CarDao carDao;

    @Mock
    private ServletContext servletContext;

    Car car1, car2;
    List<Car> cars;

    @Before
    public void setUp() throws Exception {
        car1 = new Car();
        car1.setId(1);

        car2 = new Car();
        car2.setId(2);

        cars = Arrays.asList(car1, car2);

        MockitoAnnotations.initMocks(this);

        Mockito.when(carService.findById(1)).thenReturn(car1);
        Mockito.when(carService.findAll()).thenReturn(cars);

    }

    @Test
    public void testFindById() throws Exception {
        Car foundCar = carService.findById(1);
        assertEquals(1, foundCar.getId());
    }

    @Test
    public void testFindAll() throws Exception {
        List<Car> foundCars = carService.findAll();
        assertEquals(2, foundCars.size());
    }

    @Test
    public void testCreate() throws Exception {
        carService.create(car1);
        verify(carDao).create(car1);
    }

    @Test
    public void testUpdate() throws Exception {
        carService.update(car1);
        verify(carDao).update(car1);
    }

    @Test
    public void testDelete() throws Exception {
        carService.delete(car1);
        verify(carDao).delete(car1);
    }

    @Test
    public void testDeleteById() throws Exception {
        carService.deleteById(1);
        verify(carDao).deleteById(1);
    }
}