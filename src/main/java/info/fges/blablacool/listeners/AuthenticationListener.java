package info.fges.blablacool.listeners;

import info.fges.blablacool.models.User;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;

/**
 * Created by Nicolas on 3/28/2015.
 */
public class AuthenticationListener implements ApplicationListener<AuthenticationSuccessEvent> {

    private static final Logger logger = Logger.getLogger(AuthenticationListener.class);
    @Override
    public void onApplicationEvent(final AuthenticationSuccessEvent event) {
        UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();
        System.out.println("LISSSSSTENER");
        logger.info("User:"+userDetails.getUsername()+" logged in");
    }

}
