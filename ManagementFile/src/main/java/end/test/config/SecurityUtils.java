package end.test.config;

import java.util.Optional;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Utility class for Spring Security.
 */
public class SecurityUtils {
	  /**
     * Get the login of the current user.
     *
     * @return the login of the current user
     */
    public static Optional<Object> getCurrentUserIDLogin() {
    	SecurityContext securityContext = SecurityContextHolder.getContext();
    	return Optional.ofNullable(securityContext.getAuthentication())
    	        .map(authentication -> {
    	            if (authentication.getPrincipal() instanceof UserDetails) {
    	                UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
    	                return springSecurityUser.getUsername();
    	            } else if (authentication.getPrincipal() instanceof String) {
    	                return (String) authentication.getPrincipal();
    	            }
    	            return null;
    	        });
    }
}
