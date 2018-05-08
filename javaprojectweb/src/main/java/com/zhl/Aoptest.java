package com.zhl;


import com.zhl.aop.MathCalculator;
import com.zhl.springAnnotation.MainConfigOfAOP;
import com.zhl.testAop.Dao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhl on 18/5/3 下午8:20.
 */
public class Aoptest {


    @Test
    public void testAop(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
        Dao dao = (Dao) ac.getBean("daoImpl");
        dao.insert();
        System.out.println("---------------");
        dao.update();
        System.out.println("---------------");
    }


    @Test
    public void testAop01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        //1.不要自己创建对象
//        MathCalculator calculator = new MathCalculator();
//        calculator.div(4,3);

//        MathCalculator mathCalculator = (MathCalculator) applicationContext.getBean("mathCalculator");
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(5,3);

        applicationContext.close();
    }
}
