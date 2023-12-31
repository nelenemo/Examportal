package com.exam.examserver.auth;

import com.exam.examserver.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthenticationController {
    private final AuthenticationService service;
    private final UserDetailsService userDetailsService;

//    @PostMapping("/register")
//    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
//        return ResponseEntity.ok(service.register(request));
//    }
@CrossOrigin("*")
    @PostMapping("/generate-token")
    @Operation(
            description = "Generate Token Service",
            responses ={
                  @ApiResponse(
                          responseCode = "200",
                          description = "Successfully token generated",
                          content=@Content(
                                  mediaType = "application/json",
                                  examples = {
                                          @ExampleObject(
                                                  value = "{\"code\" : 200, \"status\" : Ok, \"Message\" : \"Successful token Generated!!!\"}"
                                          )
                                  }
                          )
                  )
            }
    )
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }
//return the details of current user
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
        return ((User)this.userDetailsService.loadUserByUsername(principal.getName()));
    }



}
