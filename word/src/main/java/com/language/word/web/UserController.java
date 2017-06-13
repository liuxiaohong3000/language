package com.language.word.web;

import com.language.word.common.result.Results;
import com.language.word.service.busservice.BusUserService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/11.
 */
@RestController
@RequestMapping(value="/userapi")
public class UserController {

    @Autowired
    private BusUserService busUserService;

    @ApiOperation(value="Get all user userWords",notes="requires noting")
    @RequestMapping(value="words", method= RequestMethod.GET)
    public Results userWords(Long userId, Long wordType, Integer pageNum){

        return busUserService.listAllowRecallWord(userId,wordType,pageNum);
    }

    @ApiOperation(value="Put word to userWords",notes="requires noting")
    @RequestMapping(value="addWord", method= RequestMethod.POST)
    public Results addWord(Long userId,Long forgetId,Long wordId){

        return busUserService.addUserWord(userId,forgetId,wordId);
    }

    @ApiOperation(value="Put word to userWords",notes="requires noting")
    @RequestMapping(value="modifyWord", method= RequestMethod.POST)
    public Results modifyWord(Long userWordId,Long forgetId){

        return busUserService.modifyUserWord(userWordId,forgetId);
    }

    @ApiOperation(value="Get all user userWords",notes="requires noting")
    @RequestMapping(value="word", method= RequestMethod.GET)
    public Results userWord(Long userId, Long wordId){

        return busUserService.findByUserIdAndWordId(userId,wordId);
    }
}
