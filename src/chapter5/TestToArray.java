package chapter5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestToArray {
    public static void main(String[] args) {

        new TestToArray().testToArray_SameSize();
        new TestToArray().testToArray_TooSmall();
    }
    
    @Test
    public void testToArray_TooSmall() {
        List<String> list2 = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");

        String[] array3 = new String[0];
        String[] array4 = list2.toArray(array3);

        System.out.println(array3 != array4);
    }

    @Test
    public void testToArray_SameSize() {
        List<String> list = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");

        String[] array1 = new String[3];
        String[] array2 = list.toArray(array1);

        System.out.println(array1 == array2);
    }
}
