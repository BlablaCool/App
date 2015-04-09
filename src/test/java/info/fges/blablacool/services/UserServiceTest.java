package info.fges.blablacool.services;

import info.fges.blablacool.dao.UserDao;
import info.fges.blablacool.models.User;
import junit.framework.Assert;
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

import java.util.*;

import static org.junit.Assert.*;

import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath*:/spring/applicationContext*.xml")
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Mock
    private UserDao userDao;

    @Mock
    private ServletContext servletContext;

    User user1,user2;

    @Before
    public void setup() {

        user1 = new User();
        user1.setId(1);
        user1.setNickname("Nicolas");
        user1.setEmail("nducom@gmail.com");

        user2 = new User();
        user2.setId(2);
        user2.setNickname("bar");
        user2.setEmail("foo@bar.com");

        MockitoAnnotations.initMocks(this);

        List<User> users = Arrays.asList(user1, user2);

        Mockito.when(userService.findById(2)).thenReturn(user2);
        Mockito.when(userService.findByEmail("nducom@gmail.com")).thenReturn(user1);
        Mockito.when(userService.findAll()).thenReturn(users);
        Mockito.when(userService.emailAlreadyExists("nducom@gmail.com")).thenReturn(true);
        Mockito.when(userService.nicknameAlreadyExists("Nicolas")).thenReturn(true);
    }

    @Test
    public void testFindByEmail() throws Exception {
        User findUser = userService.findByEmail("nducom@gmail.com");
        assertEquals(1, findUser.getId());
    }

    @Test
    public void testFindById() throws Exception {
        User findUser = userService.findById(2);
        assertEquals("foo@bar.com", findUser.getEmail());
    }

    @Test
    public void testFindAll() throws Exception {
        List<User> users = userService.findAll();
        assertEquals(2, users.size());
    }

    @Test
    public void testCreate() throws Exception {
        userService.create(user1);
        verify(userDao).create(user1);
    }

    @Test
    public void testUpdate() throws Exception {
        userService.update(user1);
        verify(userDao).update(user1);
    }

    @Test
    public void testDelete() throws Exception {
        userService.delete(user1);
        verify(userDao).delete(user1);
    }

    @Test
    public void testDeleteById() throws Exception {
        userService.deleteById(1);
        verify(userDao).deleteById(1);
    }

    @Test
    public void testNicknameAlreadyExists() throws Exception {
        boolean result = userService.nicknameAlreadyExists("Nicolas");
        verify(userDao).nicknameAlreadyExists("Nicolas");
        assertEquals(true,result);
    }

    @Test
    public void testEmailAlreadyExists() throws Exception {
        boolean result = userService.emailAlreadyExists("nducom@gmail.com");
        verify(userDao).emailAlreadyExists("nducom@gmail.com");
        assertEquals(true,result);
    }
}