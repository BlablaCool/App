package info.fges.blablacool.services;

import info.fges.blablacool.dao.PaymentDao;
import info.fges.blablacool.models.Payment;
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
public class PaymentServiceTest {
    @InjectMocks
    private PaymentService paymentService;

    @Mock
    private PaymentDao paymentDao;

    @Mock
    private ServletContext servletContext;

    Payment payment1, payment2;
    List<Payment> payments;

    @Before
    public void setUp() throws Exception {
        payment1 = new Payment();
        payment1.setIdPayment(1);

        payment2 = new Payment();
        payment2.setIdPayment(2);

        payments = Arrays.asList(payment1, payment2);

        MockitoAnnotations.initMocks(this);

        Mockito.when(paymentService.findById(1)).thenReturn(payment1);
        Mockito.when(paymentService.findAll()).thenReturn(payments);

    }

    @Test
    public void testFindById() throws Exception {
        Payment foundPayment = paymentService.findById(1);
        assertEquals(1, foundPayment.getIdPayment());
    }

    @Test
    public void testFindAll() throws Exception {
        List<Payment> foundPayments = paymentService.findAll();
        assertEquals(2, foundPayments.size());
    }

    @Test
    public void testCreate() throws Exception {
        paymentService.create(payment1);
        verify(paymentDao).create(payment1);
    }

    @Test
    public void testUpdate() throws Exception {
        paymentService.update(payment1);
        verify(paymentDao).update(payment1);
    }

    @Test
    public void testDelete() throws Exception {
        paymentService.delete(payment1);
        verify(paymentDao).delete(payment1);
    }

    @Test
    public void testDeleteById() throws Exception {
        paymentService.deleteById(1);
        verify(paymentDao).deleteById(1);
    }

}