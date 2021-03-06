package info.fges.blablacool.controllers;

import info.fges.blablacool.models.Car;
import info.fges.blablacool.models.User;
import info.fges.blablacool.services.CarService;
import org.apache.commons.io.IOUtils;
import org.apache.tiles.request.servlet.ServletUtil;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Nicolas on 3/26/2015.
 */
@Controller
@RequestMapping("/cars")
@Secured("ROLE_USER")
public class CarController implements ServletContextAware {
    @Autowired
    private CarService carService;
    private ServletContext servletContext;

    /**
     *
     * @param modelAndView
     * @return the view used to create a new car
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView getNew(ModelAndView modelAndView)
    {
        modelAndView.setViewName("cars/new");
        modelAndView.addObject("newCar", new Car());
        return modelAndView;
    }

    /**
     * Uses CarQuery Api to return a list of car Makes
     * @return a JSON list of car makes
     */
    @RequestMapping(value = "/makes", method = RequestMethod.GET)
    public ResponseEntity<String> getCarMakes() {
        return getApiResponse(servletContext.getInitParameter("carQueryApiUrl")+"&cmd=getMakes");
    }

    /**
     * Uses CarQuery Api to return a list of models belonging to a car make
     * @param make
     * @return a JSON list of car Models
     */
    @RequestMapping(value = "/models/{make}", method = RequestMethod.GET)
    public ResponseEntity<String> getCarsByMake(@PathVariable("make") String make) {
        return getApiResponse("&cmd=getModels&make="+make);
    }

    /**
     * Uses carQuery Api to return a list of trims belonging to a car model
     * @param make
     * @param model
     * @return a JSON list of car Trims
     */
    @RequestMapping(value = "/model/{make}/{model}", method = RequestMethod.GET)
    public ResponseEntity<String> getCarTrims(@PathVariable("make") String make, @PathVariable("model") String model) {
        return getApiResponse("&cmd=getTrims&make="+make+"&model="+model);
    }

    /**
     * Calls the CarQuery Api using params
     * @param queryParams
     * @return the Api's response
     */
    public ResponseEntity<String> getApiResponse(String queryParams){
        try {
            URL carQueryUrl = new URL(servletContext.getInitParameter("carQueryApiUrl")+queryParams);

            InputStream in = carQueryUrl.openStream();
            try {
                return new ResponseEntity<String>( IOUtils.toString(in), HttpStatus.OK);
            } finally {
                IOUtils.closeQuietly(in);
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Creates a new car
     * @param car
     * @param bindingResult
     * @param user
     * @param modelAndView
     * @return the page listing the authenticated user's cars
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("newCar") Car car, BindingResult bindingResult, @AuthenticationPrincipal User user,ModelAndView modelAndView){
        car.setOwner(user);
        carService.create(car);
        return "redirect:/users/cars";
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
