package com.zhl.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by zhl on 18/5/28 下午8:33.
 */
public class ConfigUtils {
    private static Logger logger = LoggerFactory.getLogger(ConfigUtils.class);

    public ConfigUtils(){}

    public static Properties getPropertiesFile(String confPath) {
        Properties prop = new Properties();
        try {
            InputStreamReader is = new InputStreamReader(ConfigUtils.class.getClassLoader().getResourceAsStream(confPath), "UTF-8");
            prop.load(is);
            is.close();
            if (logger.isDebugEnabled()) {
                logger.debug("load config file success ,filePath is " + confPath);
            }

        } catch (Exception var1) {
            logger.info("try  FileInputStream  load");
            try {
                FileInputStream fileInputStream = new FileInputStream("./" + confPath);
                if (fileInputStream != null) {
                    prop.load(fileInputStream);
                    fileInputStream.close();
                    logger.info("加载成功");
                    return prop;
                }

                if (logger.isDebugEnabled()) {
                    logger.debug("load config file success ,filePath is " + confPath);
                }
            } catch (Exception var2) {
                if (logger.isErrorEnabled()) {
                    logger.error("error properties==>" + confPath, var2);
                }
            }

        }
        return prop;
    }
}
