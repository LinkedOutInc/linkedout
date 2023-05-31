package app.linkedout.backend_v2.services;

import app.linkedout.backend_v2.config.JwtUtils;
import app.linkedout.backend_v2.models.Person;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SessionService {
    private final JwtUtils jwtUtils;
    private final PersonService personService;
    private final CareerExpertService careerExpertService;
    private final RecruiterService recruiterService;

    public SessionService(JwtUtils jwtUtils, PersonService personService, CareerExpertService careerExpertService, RecruiterService recruiterService) {
        this.jwtUtils = jwtUtils;
        this.personService = personService;
        this.careerExpertService = careerExpertService;
        this.recruiterService = recruiterService;
    }

    public Object getCurrentUser() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ArrayList<GrantedAuthority> authorities = new ArrayList<>(authentication.getAuthorities());
        if(authentication.getAuthorities()==null)
            return null;

        String email = authentication.getName();
        String role = authorities.get(0).getAuthority();

        return switch (role) {
            case "ROLE_USER" -> personService.getPersonByEmail(email);
            case "ROLE_CE" -> careerExpertService.getCareerExpertByEmaill(email);
            case "ROLE_RECRUITER" -> recruiterService.getRecruiterByEmail(email);
            default -> null;
        };
    }

    public int getCurrentUserId() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ArrayList<GrantedAuthority> authorities = new ArrayList<>(authentication.getAuthorities());
        if(authentication.getAuthorities()==null)
            return -1;

        String email = authentication.getName();
        String role = authorities.get(0).getAuthority();

        return switch (role) {
            case "ROLE_USER" -> personService.getPersonByEmail(email).id();
            case "ROLE_CE" -> careerExpertService.getCareerExpertByEmaill(email).id();
            case "ROLE_RECRUITER" -> recruiterService.getRecruiterByEmail(email).id();
            default -> -1;
        };
    }
}
