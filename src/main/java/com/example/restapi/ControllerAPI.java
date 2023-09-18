package com.example.restapi;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerAPI {

    @PostMapping("/count")
    public Object sortString(@RequestBody(required = false) String string) {
        if(string==null) throw new RuntimeException("Empty string in request body.");
        return CountChars.countChars(string);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException(RuntimeException e) {
        return e.getMessage();
    }

}
