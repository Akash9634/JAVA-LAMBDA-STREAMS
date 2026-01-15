package org.example.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,12);
        int result = numbers.stream().filter(x -> x%2==0).mapToInt(x->x).sum();
        System.out.println(result);

        int arr[] = {1,2,3,4,5,6,7,8};
        int sum2 = Arrays.stream(arr).filter(x -> x%2==0).sum();
        System.out.println(sum2);

        List<Integer> list = Arrays.asList(1,2,3,45678,53,9,242,673,837);
        List<Integer> filteredList = list.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x/2)
                .distinct()
                .sorted((a,b) -> (b-a))
                .limit(2)
                .skip(1)
                .collect(Collectors.toList());
        System.out.println(filteredList);

        List<Integer> list1 = Stream.iterate(0, x -> x + 1)
                .limit(101)
                .skip(1)
                .filter(x -> x%2==0)
                .map(x -> x/10)
                .distinct()
                .sorted()
                .peek(x -> System.out.println(x))
                .toList();
        System.out.println(list1);
    }


}
