package info.fges.blablacool.services;

import info.fges.blablacool.dao.SubscriptionDao;
import info.fges.blablacool.models.Subscription;
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
public class SubscriptionServiceTest {

    @InjectMocks
    private SubscriptionService subscriptionService;

    @Mock
    private SubscriptionDao subscriptionDao;

    @Mock
    private ServletContext servletContext;

    Subscription subscription1, subscription2;
    List<Subscription> subscriptions;

    @Before
    public void setUp() throws Exception {
        subscription1 = new Subscription();
        subscription1.setIdSubscription(1);

        subscription2 = new Subscription();
        subscription2.setIdSubscription(2);

        subscriptions = Arrays.asList(subscription1, subscription2);

        MockitoAnnotations.initMocks(this);

        Mockito.when(subscriptionService.findById(1)).thenReturn(subscription1);
        Mockito.when(subscriptionService.findAll()).thenReturn(subscriptions);
    }

    @Test
    public void testFindById() throws Exception {
        Subscription foundSubscription = subscriptionService.findById(1);
        assertEquals(1, foundSubscription.getIdSubscription());
    }

    @Test
    public void testFindAll() throws Exception {
        List<Subscription> foundSubscriptions = subscriptionService.findAll();
        assertEquals(2, foundSubscriptions.size());
    }

    @Test
    public void testCreate() throws Exception {
        subscriptionService.create(subscription1);
        verify(subscriptionDao).create(subscription1);
    }

    @Test
    public void testUpdate() throws Exception {
        subscriptionService.update(subscription1);
        verify(subscriptionDao).update(subscription1);
    }

    @Test
    public void testDelete() throws Exception {
        subscriptionService.delete(subscription1);
        verify(subscriptionDao).delete(subscription1);
    }

    @Test
    public void testDeleteById() throws Exception {
        subscriptionService.deleteById(1);
        verify(subscriptionDao).deleteById(1);
    }
}