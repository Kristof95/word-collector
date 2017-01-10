package com.backend;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
public class HomeController
{
    private final DBService dbService;

    public HomeController(DBService dbService) {this.dbService = dbService;}

    @RequestMapping(value = "/save", method = {RequestMethod.POST, RequestMethod.GET},consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Text> addWord(@RequestBody Text test){
        long id = test.getId() == null ? randomID(): test.getId();
        if(test != null && !dbService.exists(id))
        {
            dbService.save(test);
            return new ResponseEntity<>(test,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

//    @RequestMapping(method=RequestMethod.GET)
//    public List<Text> getAll() {
//        List<Text> textContainer = (ArrayList<Text>) dbService.findAll();
//        return  textContainer;
//    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String deployed(){
        return "Deployed!";
    }

    private int randomID(){
        Random rnd = new Random();
        return rnd.nextInt(800000);
    }
}
