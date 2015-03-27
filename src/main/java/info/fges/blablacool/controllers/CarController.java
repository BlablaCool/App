package info.fges.blablacool.controllers;

import info.fges.blablacool.models.Car;
import info.fges.blablacool.services.CarService;
import org.apache.commons.io.IOUtils;
import org.apache.tiles.request.servlet.ServletUtil;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Nicolas on 3/26/2015.
 */
@Controller
@RequestMapping("/cars")
public class CarController implements ServletContextAware {
    @Autowired
    private CarService carService;
    private ServletContext servletContext;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView getNew(ModelAndView modelAndView)
    {
        modelAndView.setViewName("cars/new");
        modelAndView.addObject("newCar", new Car());
        return modelAndView;
    }

    @RequestMapping(value = "/brands", method = RequestMethod.GET)
    public ResponseEntity<String> getCareBrands() {
        try {
            URL edmundsUrl = new URL(this.servletContext.getInitParameter("edmundsApiUrl") + "makes?fmt=json&api_key=" + this.servletContext.getInitParameter("edmundsApiKey"));
            InputStream in = edmundsUrl.openStream();
            try {
                return new ResponseEntity<String>(IOUtils.toString(in), HttpStatus.OK);
            } finally {
                IOUtils.closeQuietly(in);
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(ModelAndView modelAndView){
        return "hello";
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
