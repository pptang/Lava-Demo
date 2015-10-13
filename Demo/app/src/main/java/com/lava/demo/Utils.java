package com.lava.demo;

import java.util.ArrayList;

/**
 * Created by Bible on 10/13/15.
 */
public class Utils {

    public static String implode(ArrayList<String> list, String delimiter) {
        String result = "";

        for (int index = 0 ; index < list.size() ; index++) {
            if (result.length() == 0) {
                result = list.get(index);
            } else {
                result = result + delimiter + list.get(index);
            }
        }

        return result;
    }

    public static Integer formatInteger(String value) {
        Integer integer;

        try {
            integer = Integer.parseInt(value);
        } catch(NumberFormatException exception) {
            integer = -1;
        }

        return integer;
    }
}
