package com.backend;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class HomeController
{
    private final DBService dbService;

    public HomeController(DBService dbService) {this.dbService = dbService;}

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET},consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Text> test(@RequestBody Text test){
        if(test != null && !dbService.exists(test.getId()))
        {
            dbService.save(test);
            return new ResponseEntity<>(test,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
