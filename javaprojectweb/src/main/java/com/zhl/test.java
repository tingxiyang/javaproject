package com.zhl;

import org.springframework.util.Assert;

/**
 * Created by zhl on 18/3/15 下午7:46.
 */
public class test {
    public static void main(String[] args) {
//        String s = transformedBeanName("&beanfactory");
//        System.out.println(s);//beanfactory
        Shape shape = new Shape();
        shape.setId(4);
        shape.setName("zhl");
        testCaseOfString(shape, "5101");

    }


    public static String transformedBeanName(String name) {
        String beanName;
        for(beanName = name; beanName.startsWith("&"); beanName = beanName.substring("&".length())) {
            ;
        }
        return beanName;
    }




    public static void testCaseOfString(Shape shape, String code){
        switch (code){
            case "3101":
                System.out.println("ok. 3101");
                shape.setName("3101");
                break;
            case "4101":
                System.out.println("ok. 4101");
                shape.setName("4101");
                break;
            case "5101":
                System.out.println("ok. 5101");
                shape.setName("5101");
                if(shape.getId() == 4){
                    shape.setName("51010101");
                }
                break;
            default:
                System.out.println(code);
                shape.setName("我爱天安门");
                break;
        }
        System.out.println("shape.getName(): "+shape.getName());
    }



}

class Shape {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
