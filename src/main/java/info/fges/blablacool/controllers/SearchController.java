package info.fges.blablacool.controllers;

import info.fges.blablacool.models.Search;
import info.fges.blablacool.models.Trip;
import info.fges.blablacool.services.SearchService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by Valentin on 04/04/15.
 */
@Controller
@RequestMapping("/search")
@Scope("request")
public class SearchController
{
    @Autowired
    private SearchService searchService;

    /**
     *
     * @param departureLatitude
     * @param departureLongitude
     * @param arrivalCity
     * @param departureTime
     * @param modelAndView
     * @return the trips list, filtered by geolocation
     */
    @RequestMapping("/{departureLatitude}/{departureLongitude}/{arrivalCity}/{departureTime}")
    public ModelAndView getSearchWithGeolocation(@PathVariable String departureLatitude,
                                                 @PathVariable String departureLongitude,
                                                 @PathVariable String arrivalCity,
                                                 @PathVariable String departureTime,
                                                 ModelAndView modelAndView)
    {
        modelAndView.setViewName("trips/list");
        modelAndView.addObject("trips", searchService.findTripsNearbyLocation(
                        new BigDecimal(departureLatitude),
                        new BigDecimal(departureLongitude),
                        URLDecoder.decode(arrivalCity),
                        departureTime)
        );

        return modelAndView;
    }

    /**
     *
     * @param departureCity
     * @param arrivalCity
     * @param departureTime
     * @param modelAndView
     * @return the trips list, filtered by address
     */
    @RequestMapping("/{departureCity}/{arrivalCity}/{departureTime}")
    public ModelAndView getSearchWithAddresses(@PathVariable String departureCity,
                                         @PathVariable String arrivalCity,
                                         @PathVariable String departureTime,
                                         ModelAndView modelAndView)
    {
        modelAndView.setViewName("trips/list");
        modelAndView.addObject("trips", searchService.findTripsWithAddresses(
                URLDecoder.decode(departureCity),
                URLDecoder.decode(arrivalCity),
                departureTime)
        );

        return modelAndView;
    }


}
