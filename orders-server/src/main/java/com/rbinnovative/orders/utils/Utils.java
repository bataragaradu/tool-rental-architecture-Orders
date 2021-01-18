package com.rbinnovative.orders.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import java.util.function.Consumer;

public class Utils {

    public static void copyProperties(Object src, Object trg, Iterable<String> props) {
        BeanWrapper srcWrap = PropertyAccessorFactory.forBeanPropertyAccess(src);
        BeanWrapper trgWrap = PropertyAccessorFactory.forBeanPropertyAccess(trg);

        props.forEach(getStringConsumer(srcWrap, trgWrap));
    }

    private static Consumer<String> getStringConsumer(BeanWrapper srcWrap, BeanWrapper trgWrap) {
        return p -> copyProperty(srcWrap, trgWrap, p);
    }

    private static void copyProperty(BeanWrapper srcWrap, BeanWrapper trgWrap, String p) {
        if ((srcWrap.getPropertyValue(p) instanceof String && StringUtils.isNotEmpty((String) srcWrap.getPropertyValue(p)))) {
            trgWrap.setPropertyValue(p, srcWrap.getPropertyValue(p));
        }
        if (srcWrap.getPropertyValue(p) instanceof Integer && (srcWrap.getPropertyValue(p) != null && (Integer) srcWrap.getPropertyValue(p) != -1)) {
            trgWrap.setPropertyValue(p, srcWrap.getPropertyValue(p));
        }
        if (srcWrap.getPropertyValue(p) != null) {
            trgWrap.setPropertyValue(p, srcWrap.getPropertyValue(p));
        }
    }
}
