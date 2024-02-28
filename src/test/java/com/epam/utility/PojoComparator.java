package com.epam.utility;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PojoComparator<T> {
    private Class<T> type;

    public PojoComparator(Class<T> type) {
        this.type = type;
    }

    public String compare(T pojo1, T pojo2) {
        Field[] fields = type.getDeclaredFields();
        List<String> differences = new ArrayList<>();
        if(pojo1.equals(pojo2)){
            return "Matched";
        }

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value1 = field.get(pojo1);
                Object value2 = field.get(pojo2);
                if (!value1.equals(value2)) {
                    differences.add("Field '" + field.getName() + "' differs: "
                            + "Value in pojo1: " + value1 + ", Value in pojo2: " + value2);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
            return String.join("\n", differences);
    }

}