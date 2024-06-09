package com.example.CDGSimpleWebApp.basicControllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/*
@RestController.md è un'annotazione di Spring che combina @Controller e @ResponseBody.
Indica che questa classe è un controller che gestisce richieste HTTP e che i metodi
di questa classe restituiscono direttamente dati JSON o XML.
 */
@RestController
@RequestMapping("/v1")
public class HelloController {

    @Value("${spring.helloMessageValue}")
    private String helloMessage;

    @Value("${myKeys.greet}")
    private String myKey;

    @RequestMapping(method=GET, path="/helloWorld")
    public String helloWorld() {
        return helloMessage + ", " +  myKey;
    }


    @Operation(summary = "Get a greet personalized")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Perfect! Everything works well.",
                    content = { @Content(mediaType = "text/plain",
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid request supplied. Yes, it's your fault.",
                    content = @Content) })
    @GetMapping(path="/greetPersonalized")
    public String greetPersonalized(@Parameter(description = "this parameter is your name") @RequestParam(required = true) String name,@Parameter(description = "this parameter is your surname") @RequestParam(required = false, defaultValue = "") String surname) {
        if (! surname.isEmpty()){
            surname=" " + surname;
        }
        return "Hello " + name + surname + "!";
    }


    @Operation(summary = "Get the User instance that you create")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Perfect! Everything works well.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid request supplied. Yes, it's your fault.",
                    content = @Content) })
    @GetMapping(path = "/returnJsonUser/{id}")
    public User returnJsonUser(
            @PathVariable long id,
            @RequestParam(value = "name", required = true) String userName,
            @RequestParam(value = "surname", required = false, defaultValue = "") String userSurname
    ) {
        return new User(id, userName, userSurname);
    }



}