package info.fges.blablacool.dao;

import info.fges.blablacool.models.Message;
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

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath*:/spring/applicationContext*.xml")
public class MessageDaoTest {

    @InjectMocks
    private MessageDao messageDao;

    Message message1, message2;
    List<Message> messages;

    @Before
    public void setUp() throws Exception {
        message1 = new Message();
        message1.setIdMessage(1);
        message2 = new Message();
        message2.setIdMessage(2);

        messages = Arrays.asList(message1, message2);

        MockitoAnnotations.initMocks(this);

        Mockito.when(messageDao.findById(1)).thenReturn(message1);
        Mockito.when(messageDao.findAll()).thenReturn(messages);

    }

    @Test
    public void testFindById() throws Exception {
        Message foundMessage = messageDao.findById(1);
        assertEquals(1, foundMessage.getIdMessage());
    }

    @Test
    public void testFindAll() throws Exception {

    }

    @Test
    public void testDeleteById() throws Exception {

    }
}