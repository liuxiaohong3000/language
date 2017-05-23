package com.language.word.web;

import com.language.word.common.result.Results;
import com.language.word.service.busservice.BusWordService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/11.
 */
@RestController
@RequestMapping(value="/wordapi")
public class WordController {


    @Autowired
    private BusWordService busWordService;

    @ApiOperation(value="Get all words",notes="requires noting")
    @RequestMapping(method= RequestMethod.GET)
    public Results words(){

        return busWordService.listWord();
    }
}
