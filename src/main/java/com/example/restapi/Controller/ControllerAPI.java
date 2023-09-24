package com.example.restapi.Controller;


import com.example.restapi.Utility.CountChars;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerAPI {

    //main address
    @PostMapping("/count")
    public Object sortString(@RequestBody(required = false) String string) {
        //if string is empty, then drop exception, else run logic
        if (string == null) throw new RuntimeException("Empty string in request body.");
        return CountChars.countChars(string);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException(RuntimeException e) {
        return e.getMessage();
    }

}
