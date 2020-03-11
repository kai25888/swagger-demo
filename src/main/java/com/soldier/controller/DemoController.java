package com.soldier.controller;

import com.soldier.interfaceDemo.NotIncludeSwagger;
import com.soldier.pojo.People;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author soldier
 * @Date 2020/3/11 11:19
 * @Version 1.0
 * @Description:
 */
@RestController
@RequestMapping("/people")
@Api(tags = {"myDemo"}, description = "DemoController描述")
public class DemoController {

    @RequestMapping("/getPeople")
    @ApiOperation(value = "接口描述", notes = "提示信息")
    public People getPeople(Long id, @ApiParam(value = "姓名 这个是参数描述", required = true) String name) {
        People people = new People();
        people.setId(id);
        people.setName(name);
        people.setAddress("南宁");
        return people;
    }

    @NotIncludeSwagger
    @RequestMapping("/getPeople2")
//    @ApiImplicitParam(name = "address",value = "地址",required = true,paramType = "query",dataType = "string")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="id",value = "编号",required = true),
            @ApiImplicitParam(name="name",value = "姓名",required = true)
    })
    public People getPeople2(Long id, String name, String address) {
        People people = new People();
        people.setId(id);
        people.setName(name);
        people.setAddress(address);
        return people;
    }
}
