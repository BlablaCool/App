package info.fges.blablacool.listeners;

import info.fges.blablacool.configuration.AppConfig;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

/**
 * Created by Nicolas on 3/29/2015.
 */
@Component
public class LoginSuccessListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

    private static final Logger logger = Logger.getLogger(AppConfig.class);

    @Override
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event)
    {
        UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();
        logger.warn("User : " + userDetails.getUsername() + " logged in");
    }
}
