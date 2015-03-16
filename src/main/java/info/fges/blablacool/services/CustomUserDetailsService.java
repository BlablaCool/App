package info.fges.blablacool.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import info.fges.blablacool.dao.UserDao;
import info.fges.blablacool.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Valentin on 15/03/15.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private UserDao userService;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(final String email)
            throws UsernameNotFoundException {

        info.fges.blablacool.models.User user = userService.findByEmail(email);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());

        return buildUserForAuthentication(user, authorities);
    }

    private User buildUserForAuthentication(info.fges.blablacool.models.User user,
                                            List<GrantedAuthority> authorities)
    {
        return new User(user.getEmail(), user.getPassword(),
                true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(List<Role> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        for (Role userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

}
