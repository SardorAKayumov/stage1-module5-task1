package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String str : x) {
                for (char c : str.toCharArray()) {
                    if (Character.isDigit(c)) {
                        return false;
                    }
                }

                if (str.charAt(0) == str.toUpperCase().charAt(0)) {
                    return true;
                }
            }

            return false;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> list = new ArrayList<>();
            for (Integer integer : x) {
                if (integer % 2 == 0) {
                    list.add(integer);
                }
            }
            x.addAll(list);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> list = new ArrayList<>();
            for(String str : values) {
                String[] strArr = str.split(" ");
                if (strArr.length <= 3) {
                    continue;
                }

                if (str.charAt(0) == str.toUpperCase().charAt(0)) {
                    if (str.charAt(str.length() - 1) == '.') {
                        list.add(str);
                    }
                }
            }

            return list;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for (String str : x) {
                map.put(str, str.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> list = new ArrayList<>();
            list.addAll(list1);
            list.addAll(list2);
            return list;
        };
    }
}
