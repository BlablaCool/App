package info.fges.blablacool.services;

import info.fges.blablacool.dao.StepDao;
import info.fges.blablacool.models.Step;
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
public class StepServiceTest {

    @InjectMocks
    private StepService stepService;

    @Mock
    private StepDao stepDao;

    @Mock
    private ServletContext servletContext;

    Step step1, step2;
    List<Step> steps;

    @Before
    public void setUp() throws Exception {
        step1 = new Step();
        step1.setIdStep(1);

        step2 = new Step();
        step2.setIdStep(2);

        steps = Arrays.asList(step1, step2);

        MockitoAnnotations.initMocks(this);

        Mockito.when(stepService.findById(1)).thenReturn(step1);
        Mockito.when(stepService.findAll()).thenReturn(steps);
    }

    @Test
    public void testFindById() throws Exception {
        Step foundStep = stepService.findById(1);
        assertEquals(1, foundStep.getIdStep());
    }

    @Test
    public void testFindAll() throws Exception {
        List<Step> foundSteps = stepService.findAll();
        assertEquals(2, foundSteps.size());
    }

    @Test
    public void testCreate() throws Exception {
        stepService.create(step1);
        verify(stepDao).create(step1);
    }

    @Test
    public void testUpdate() throws Exception {
        stepService.update(step1);
        verify(stepDao).update(step1);
    }

    @Test
    public void testDelete() throws Exception {
        stepService.delete(step1);
        verify(stepDao).delete(step1);
    }

    @Test
    public void testDeleteById() throws Exception {
        stepService.deleteById(1);
        verify(stepDao).deleteById(1);
    }
}