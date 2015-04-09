package info.fges.blablacool.services;

import info.fges.blablacool.dao.ReviewDao;
import info.fges.blablacool.models.Review;
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
public class ReviewServiceTest {
    @InjectMocks
    private ReviewService reviewService;

    @Mock
    private ReviewDao reviewDao;

    @Mock
    private ServletContext servletContext;

    Review review1, review2;
    List<Review> reviews;

    @Before
    public void setUp() throws Exception {
        review1 = new Review();
        review1.setIdReview(1);

        review2 = new Review();
        review2.setIdReview(2);

        reviews = Arrays.asList(review1, review2);

        MockitoAnnotations.initMocks(this);

        Mockito.when(reviewService.findById(1)).thenReturn(review1);
        Mockito.when(reviewService.findAll()).thenReturn(reviews);

    }

    @Test
    public void testFindById() throws Exception {
        Review foundReview = reviewService.findById(1);
        assertEquals(1, foundReview.getIdReview());
    }

    @Test
    public void testFindAll() throws Exception {
        List<Review> foundReviews = reviewService.findAll();
        assertEquals(2, foundReviews.size());
    }

    @Test
    public void testCreate() throws Exception {
        reviewService.create(review1);
        verify(reviewDao).create(review1);
    }

    @Test
    public void testUpdate() throws Exception {
        reviewService.update(review1);
        verify(reviewDao).update(review1);
    }

    @Test
    public void testDelete() throws Exception {
        reviewService.delete(review1);
        verify(reviewDao).delete(review1);
    }

    @Test
    public void testDeleteById() throws Exception {
        reviewService.deleteById(1);
        verify(reviewDao).deleteById(1);
    }
}