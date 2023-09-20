package chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingDemo {
    static List<String> MONTHS = new ArrayList<>(
            List.of("January", "February", "March", "April", "May", "June"));

    public static void main(String[] args) {
        Comparable<String> month = MONTHS.get(0);
        Collections.sort(MONTHS, new ByLengthComparator());
        System.out.println(MONTHS);
        Collections.sort(MONTHS, String.CASE_INSENSITIVE_ORDER);
        System.out.println(MONTHS);
        
    }
}
class ByLengthComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}
