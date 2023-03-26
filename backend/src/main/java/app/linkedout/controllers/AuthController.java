package app.linkedout.controllers;


import app.linkedout.models.security.Role;
import app.linkedout.models.security.User;
import app.linkedout.repositories.security.RoleRepository;
import app.linkedout.repositories.security.UserRepository;
import app.linkedout.security.JwtUtils;
import app.linkedout.security.requests.LoginRequest;
import app.linkedout.security.responses.MessageResponse;
import app.linkedout.security.responses.UserInfoResponse;
import app.linkedout.services.security.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody HashMap<String, Object> payload) {
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        User user = new User();
        user.setEmail((String) payload.get("email"));
        user.setPassword(enc.encode((String) payload.get("password")));

        HashSet<Role> roles = new HashSet<>();
        Role r = new Role();
        r.setByString((String) payload.get("role"));
        roles.add(r);
        user.setRoles(roles);

        // TODO: roleRepository.save(r);
        userRepository.save(user);

        return new ResponseEntity<>("User created with credentials:\n email: "+user.getEmail()+"\n password: "+user.getPassword()+"\n role: " + r.getName(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, String.valueOf(jwtCookie))
                .body(new UserInfoResponse(userDetails.getId(),
                        userDetails.getEmail(),
                        roles.get(0), String.valueOf(jwtCookie)));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body(new MessageResponse("Logout successful."));
    }
}
