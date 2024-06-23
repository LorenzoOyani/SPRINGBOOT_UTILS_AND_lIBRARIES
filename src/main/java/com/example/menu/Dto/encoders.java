package com.example.menu.Dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.IntStream;


public class encoders {


    /**
     * @throws JsonProcessingException - when the JSON is not parsed properly;
     **/
    public static void main(String[] args) throws JsonProcessingException, UnsupportedEncodingException {
        final Map<String, String> response = new HashMap<>();

        response.put("message", "Hello \"world");

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValueAsString(response);

        String encoded = URLEncoder.encode(response.toString(), StandardCharsets.UTF_8);
        System.out.println(encoded);

        BiConsumer<String, Integer> func = (name, age) -> System.out.println(STR."name is \{name}ages is \{age}");
        func.accept("JON", 30);

        // update age, more like to change the field value of age and set to a new value
        BiConsumer<Person, Integer> updateAge = Person::setAge;
        Person persons = new Person("Jon", 45);
        System.out.println(persons);
        Map<String , Integer> remapping = new HashMap<>();
        remapping.put("Jon", 3);
        String oldValue = String.valueOf(remapping.get(0));
        if (oldValue != null) {

        }


        // BiFunction interface can be used  concatenate two strings
        BiFunction<String, String, String> addTwoStrings = (s1, s2) -> s1 + s2;
        System.out.println(STR."Concatenation: \{addTwoStrings.apply("Hello, ", "World!")}");



        int[] arr = {1, 3, 4, 5, 6, 7, 8};
        IntStream intStream = Arrays.stream(arr).filter(x -> x % 2 == 0);

        Users user = new Users();
        Optional<String> zipCode = Optional.of(user).flatMap(Users::getAddress).flatMap(Address::getZipCode);
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return STR."Person{name='\{name}', age=\{age}\{'}'}";
        }


    }

    @Getter
    @Setter
    static class Users {
        private String name;
        @Getter
        @Setter
        private Optional<Address> address;
    }

    @Getter
    @Setter
    static class Address {
        private String name;
        private Optional<String> zipCode;
    }


}
