package com.zhl.annotation;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by zhl on 18/8/17 下午4:53.
 */

@Component(identifier = "upper")
public class UpperCaseComponent {

    public String doWork(String input) {
        if(StringUtils.isNotEmpty(input)) {
            return input.toUpperCase();
        }
        return null;
    }
}
