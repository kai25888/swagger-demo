package com.soldier.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author soldier
 * @Date 2020/3/11 11:18
 * @Version 1.0
 * @Description:
 */
@ApiModel(value = "名称:人类", description = "描述")
public class People {
    private Long id;
    @ApiModelProperty(value = "描述:姓名", name = "重写属性名:name", required = true, example = "张三")
    private String name;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
