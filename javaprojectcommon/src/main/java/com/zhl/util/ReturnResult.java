package com.zhl.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.regexp.internal.RE;

import java.util.List;

/**
 * Created by zhl on 18/5/28 下午7:40.
 * 自定义响应结构
 */
public class ReturnResult {

    private static final Integer SUCCESS_CODE = 200;

    //定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //响应业务状态
    private Integer status;

    //响应消息
    private String msg;

    //响应数据
    private Object data;


    public static ReturnResult build(Integer status, String msg, Object data) {
        return new ReturnResult(status, msg, data);
    }


    public ReturnResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static ReturnResult ok(Object data) {
        return new ReturnResult(data);
    }

    public static ReturnResult ok() {
        return new ReturnResult(null);
    }

    public ReturnResult(Object data) {
        this.status = SUCCESS_CODE;
        this.msg = "OK";
        this.data = data;
    }

    public ReturnResult(){

    }

    public static ReturnResult build(Integer status, String msg){
        return new ReturnResult(status, msg, null);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 将json结果集转化为ReturnResult对象
     * @param jsonData json数据
     * @param clazz ReturnResult中的object类型
     * @return
     */
    public static ReturnResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, ReturnResult.class);
            }

            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if(clazz != null) {
                if(data.isObject()){
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()){
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     * @param json
     * @return
     */
    public static ReturnResult format(String json) {
        try {
            return MAPPER.readValue(json, ReturnResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Object 是集合转化
     *
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static ReturnResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if(data.isArray() && data.size() > 0){
                obj = MAPPER.readValue(data.traverse(), MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }




}
