package com.zhl.springService;

import com.zhl.springModel.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by zhl on 18/4/1 下午3:22.
 */

@Service
public class BookService {

    /**
     * @Qualifier
     */
//    @Qualifier("bookDao2")
    @Autowired(required = false)
    private BookDao bookDao;

    public void print(){
        System.out.println("bookDao: "+bookDao);

    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
