package com.zhl.springModel;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * Created by zhl on 18/4/1 下午3:24.
 */

@Repository
public class BookDao {

    private String lable = "1";

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "lable='" + lable + '\'' +
                '}';
    }
}
