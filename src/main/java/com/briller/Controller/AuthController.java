package com.briller.Controller;

import com.briller.Response.SampleResponse;
import com.briller.Config.AuthenticationTokenService;
import com.briller.Model.generalUserDetails;
import com.briller.Model.Users;
import com.briller.Repository.UserRepository;
import com.briller.Service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api("Authentication Service for backend base project")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private UserDetailsService GeneralUserDetailsService;


    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private AuthenticationTokenService authenticationTokenService;


    @Value("${briller.jwt.token.header}")
    private String tokenHeader;
    /**
     *
     * @param user
     * @return Response of signed in user's data
     * @throws Exception
     */

    @Async
    @PostMapping(value = "/user/signUp")
    public ResponseEntity<?> signupUser(@RequestBody Users user) throws Exception {
        Map<String, Object> signupResponse = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        boolean success = userService.registerUser(user);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @PostMapping(value="/user/sampleLogin")
    public ResponseEntity<?> sampleLogin(@RequestBody Users user){
        try{
            System.out.println("user name"+user.getUserName());
            System.out.println("password"+user.getPassword());
            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUserName(),
                            user.getPassword()
                    )
            );
            System.out.println("after authentication");
            SecurityContextHolder.getContext().setAuthentication(authentication);
            final UserDetails userDetails = GeneralUserDetailsService.loadUserByUsername(user.getUserName());
            System.out.println("after loading the username from the generaluserdetailsservice");
            final String token = authenticationTokenService.generateToken(userDetails);
            System.out.println("token generated"+token);
            generalUserDetails loggedinUser = (generalUserDetails) authentication.getPrincipal();
            HttpHeaders headers = new HttpHeaders();
            if(token !=null) {
                headers.add(tokenHeader, token);
            }
            return new ResponseEntity<>( new SampleResponse(loggedinUser,token),headers, HttpStatus.OK);
        }
        catch(BadCredentialsException e){
            return new ResponseEntity<>( new SampleResponse("Enter valid username and password"), HttpStatus.UNAUTHORIZED);}
    }

}
