package com.language.word.web;

import com.language.word.common.result.Results;
import com.language.word.service.busservice.BusWordService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @ApiOperation(value="Get all types",notes="requires noting")
    @RequestMapping(value="types", method= RequestMethod.GET)
    public Results types(){

        return busWordService.listTypes();
    }

    @ApiOperation(value="Get all words",notes="requires noting")
    @RequestMapping(value="words", method= RequestMethod.GET)
    public Results words(Long typeId,int pageNum){

        return busWordService.listWord(typeId,pageNum);
    }

    @ApiOperation(value="Get all words",notes="requires noting")
    @RequestMapping(value="words/{id}", method= RequestMethod.GET)
    public Results get(@PathVariable Long id){

        return busWordService.getWord(id);
    }

    @ApiOperation(value="Put word to words",notes="requires noting")
    @RequestMapping(value="addWord", method= RequestMethod.POST)
    public Results addWord(String name, String translate, Integer typeId, String synonym, String wordClasses, String shorthand, String phrases, String otherInfo){

        return busWordService.addWord(name,translate,typeId,synonym,wordClasses,shorthand,phrases,otherInfo);
    }
}
