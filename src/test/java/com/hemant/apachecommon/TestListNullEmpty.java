package com.hemant.apachecommon;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 class TestListNullEmpty {

    static List<String> getList() {
        List<String> strings = new ArrayList<>();
        strings.add("hemant");
        return strings;
    }

    static <E> boolean checkNotEmpty(Collection<E> list) {
        return !((list == null) ? true : (list.isEmpty() ? true : false));

    }



    @Test
     void main() {
        List<String> list = getList();
        System.out.println("Non-Empty List Check: " + checkNotEmpty(list));
    }
}

