package API_Stream.Ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ej3 {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));


        System.out.println(nums.stream().collect(Collectors.summingInt(n -> n * n)));

    }
}
