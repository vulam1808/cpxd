package com.ita.cpxd.lib;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ACER on 9/29/2016.
 */
public class Utility {
    public static <T> void sortList(List<T> list, final String propertyName) {

        if (list.size() > 0) {
            Collections.sort(list, new Comparator<T>() {
                @Override
                public int compare(final T object1, final T object2) {
                    String property1 = (String) Utility.getSpecifiedFieldValue(propertyName, object1);
                    String property2 = (String) Utility.getSpecifiedFieldValue(propertyName, object2);
                    return property1.compareToIgnoreCase(property2);
                }
            });
        }
    }
    public static Object getSpecifiedFieldValue (String property, Object obj) {

        Object result = null;

        try {
            Class<?> objectClass = obj.getClass();
            Field objectField = getDeclaredField(property, objectClass);
            if (objectField!=null) {
                objectField.setAccessible(true);
                result = objectField.get(obj);
            }
        } catch (Exception e) {
        }
        return result;
    }

    public static Field getDeclaredField(String fieldName, Class<?> type) {

        Field result = null;
        try {
            result = type.getDeclaredField(fieldName);
        } catch (Exception e) {
        }

        if (result == null) {
            Class<?> superclass = type.getSuperclass();
            if (superclass != null && !superclass.getName().equals("java.lang.Object")) {
                return getDeclaredField(fieldName, type.getSuperclass());
            }
        }
        return result;
    }
}
