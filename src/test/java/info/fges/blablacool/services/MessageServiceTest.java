package info.fges.blablacool.services;

import info.fges.blablacool.dao.MessageDao;
import info.fges.blablacool.models.*;
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
public class MessageServiceTest {
    @InjectMocks
    private MessageService messageService;

    @Mock
    private MessageDao messageDao;

    @Mock
    private ServletContext servletContext;

    Message message1, message2;
    User user;
    Trip trip;
    Step step1,step2;
    Place place1, place2;
    List<Message> messages;
    List<Step> steps;

    @Before
    public void setUp() throws Exception {
        message1 = new Message();
        message1.setIdMessage(1);

        user = new User();
        step1 = new Step();
        step2 = new Step();
        trip = new Trip();
        place1 = new Place();
        place2 = new Place();
        place1.setCity("A");
        place2.setCity("B");
        user.setId(1);
        user.setNickname("Nicolas");
        step1.setPlace(place1);
        step2.setPlace(place2);
        steps = Arrays.asList(step1,step2);
        trip.setIdTrip(1);
        trip.setDriver(user);
        trip.setSteps(steps);

        message1.setTrip(trip);
        message1.setSender(user);

        message2 = new Message();
        message2.setIdMessage(2);

        messages = Arrays.asList(message1, message2);

        MockitoAnnotations.initMocks(this);

        Mockito.when(messageService.findById(1)).thenReturn(message1);
        Mockito.when(messageService.findAll()).thenReturn(messages);

    }

    @Test
    public void testFindById() throws Exception {
        Message foundMessage = messageService.findById(1);
        assertEquals(1, foundMessage.getIdMessage());
    }

    @Test
    public void testFindAll() throws Exception {
        List<Message> foundMessages = messageService.findAll();
        assertEquals(2, foundMessages.size());
    }

    @Test
    public void testCreate() throws Exception {
        //CAN'T TEST : MANDRILL HELPER

       // messageService.create(message1);
       // verify(messageDao).create(message1);
    }

    @Test
    public void testUpdate() throws Exception {
        messageService.update(message1);
        verify(messageDao).update(message1);
    }

    @Test
    public void testDelete() throws Exception {
        messageService.delete(message1);
        verify(messageDao).delete(message1);
    }

    @Test
    public void testDeleteById() throws Exception {
        messageService.deleteById(1);
        verify(messageDao).deleteById(1);
    }

}