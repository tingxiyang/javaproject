package com.zhl.springAnnotation;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zhl.springModel.BookDao;
import com.zhl.springService.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by zhl on 18/4/1 下午3:31.
 */
public class IocTest_Autowired {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
         BookService bookService = (BookService) applicationContext.getBean("bookService");
        System.out.println(bookService);
//         bookService.print();
//         BookDao bookDao = applicationContext.getBean(BookDao.class);
//        System.out.println("bookDao->"+bookDao);

        Boss boss = applicationContext.getBean(Boss.class);
        Car car = boss.getCar();
        Car car1 = applicationContext.getBean(Car.class);

        System.out.println("car:"+car);
        System.out.println("car1:"+car1);

        Color color = applicationContext.getBean(Color.class);
        System.out.println("color: "+color);
    }
}
