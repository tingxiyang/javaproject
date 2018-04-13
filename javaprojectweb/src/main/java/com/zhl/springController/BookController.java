package com.zhl.springController;

import com.zhl.springService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by zhl on 18/4/1 下午3:25.
 */

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
}
