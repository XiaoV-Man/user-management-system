package cn.dp.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pu on 2015/11/2 0002.
 */
public class FillBeanUtil {
    public static <T> T fillBean(HttpServletRequest request, Class<T> clazz){
        try {
            T bean =clazz.newInstance();
            BeanUtils.populate(bean,request.getParameterMap());
            return bean;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
