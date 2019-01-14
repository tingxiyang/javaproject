package com.zhl;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhl on 18/7/20 下午3:19.
 */
public class testJsonObject {

    public static void main(String[] args) {
        Location l1 = new Location();
        l1.setId("1");
        l1.setName("北京市");
        Location l2 = new Location();
        l2.setId("2");
        l2.setName("上海市");

        List<Location> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);

        LocationVo vo = new LocationVo();
        vo.setCode("10000");
        vo.setList(list);
        String json = JSONObject.toJSONString(vo);
        System.out.println("json: "+json);
    }
}


class Location{
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class LocationVo{
    private String code;
    private List<Location> list;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Location> getList() {
        return list;
    }

    public void setList(List<Location> list) {
        this.list = list;
    }
}