package info.fges.blablacool.services;

import info.fges.blablacool.dao.BookingDao;
import info.fges.blablacool.models.Booking;
import info.fges.blablacool.models.User;
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
public class BookingServiceTest {
    @InjectMocks
    private BookingService bookingService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Mock
    private BookingDao bookingDao;

    @Mock
    private ServletContext servletContext;

    Booking booking1,booking2;
    User booking;

    @Before
    public void setup() {

        booking1 = new Booking();
        booking1.setId(1);


        booking2 = new Booking();
        booking2.setId(2);

        booking = new User();
        booking.setId(1);


        MockitoAnnotations.initMocks(this);

        List<Booking> bookings = Arrays.asList(booking1, booking2);

        List<Booking> pendingBookings = Arrays.asList(booking1);


        Mockito.when(bookingService.findById(1)).thenReturn(booking1);
        Mockito.when(bookingService.findAll()).thenReturn(bookings);
        Mockito.when(bookingService.alreadyExists(2,1)).thenReturn(true);
        Mockito.when(bookingService.findPendingForUser(1)).thenReturn(pendingBookings);
        //Mockito.when(bookingService.emailAlreadyExists("nducom@gmail.com")).thenReturn(true);
        //Mockito.when(bookingService.nicknameAlreadyExists("Nicolas")).thenReturn(true);
    }

    @Test
    public void testFindById() throws Exception {
        Booking findBooking = bookingService.findById(1);
        assertEquals(1, findBooking.getId());
    }

    @Test
    public void testFindAll() throws Exception {
        List<Booking> bookings = bookingService.findAll();
        assertEquals(2, bookings.size());
    }

    @Test
    public void testFindToReviewForUser() throws Exception {
        bookingService.findToReviewForUser(booking.getId());
        verify(bookingDao).findToReviewForUser(booking.getId());
    }

    @Test
    public void testCreate() throws Exception {
        //CAN'T TEST : MANDRILL HELPER
        //bookingService.create(booking1);
        //verify(bookingDao).create(booking1);
    }

    @Test
    public void testUpdate() throws Exception {
        bookingService.update(booking1);
        verify(bookingDao).update(booking1);
    }

    @Test
    public void testDelete() throws Exception {
        bookingService.delete(booking1);
        verify(bookingDao).delete(booking1);
    }

    @Test
    public void testDeleteById() throws Exception {
        bookingService.deleteById(1);
        verify(bookingDao).deleteById(1);
    }

    @Test
    public void testAlreadyExists() throws Exception {
       boolean exists = bookingService.alreadyExists(2,1);
        verify(bookingDao).alreadyExists(2,1);
        assertEquals(true, exists);
    }

    @Test
    public void testFindPendingForUser() throws Exception {
        List<Booking> bookings = bookingService.findPendingForUser(1);
        verify(bookingDao).findPendingForUser(1);
        assertEquals(1,bookings.size());
    }
}