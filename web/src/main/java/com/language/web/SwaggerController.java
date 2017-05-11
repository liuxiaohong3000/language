package com.language.web;

import com.language.domain.BType;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
@RestController
@RequestMapping(value="/users")
public class SwaggerController {
    /*
     *  http://localhost:8080/swagger/index.html
     */

    @ApiOperation(value="Get all users",notes="requires noting")
    @RequestMapping(method= RequestMethod.GET)
    public List<BType> getUsers(){
        List<BType> list=new ArrayList<BType>();

        BType btype=new BType();
        btype.setName("hello");
        list.add(btype);

        BType btype2=new BType();
        btype2.setName("hello");
        list.add(btype2);
        return list;
    }

    @ApiOperation(value="Get user with id",notes="requires the id of user")
    @RequestMapping(value="/{name}",method=RequestMethod.GET)
    public BType getUserById(@PathVariable String name){
        BType btype2=new BType();
        btype2.setName("hello");
        return btype2;
    }
}
