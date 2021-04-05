package com.bjut.fit.sse.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;


public class WebUtils {

    /**
     * 将map中的值注入到bean对象中
     *
     * @param bean
     * @param para
     * @param <T>
     * @return
     */
    public static <T> T copyParamToBean(T bean, Map para) {
        try {
            // 将请求参数注入到 nameEntry 对象中
            // 此函数靠的是调用set方法
            BeanUtils.populate(bean, para);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(bean);
        return bean;
    }

    /**
     * 将字符串转换为Integer类型
     *
     * @return
     */
    public static Integer parseInt(String intStr, Integer defaultValue) {
        try {
            return Integer.parseInt(intStr);
        } catch (NumberFormatException e) {
            System.out.println(" [" + intStr + "] 转换为Integer 失败 . 使用默认值 : " + defaultValue);
        }
        return defaultValue;
    }

}
