package com.language.word.web;

import com.language.word.common.result.Results;
import com.language.word.service.busservice.BusForgetService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/11.
 */
@RestController
@RequestMapping(value="/forgetapi")
public class ForgetController {

    @Autowired
    private BusForgetService busForgetService;

    @ApiOperation(value="Get all forgets",notes="requires noting")
    @RequestMapping(value="forgets", method= RequestMethod.GET)
    public Results forgets(){

        return busForgetService.listForgets();
    }
}
