package se.lexicon.jennie;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(NameRepository.getSize()); // 0

        String[] names = {"Mehrdad Javan", "Simon Elbrink", "Rolf Smith"};
        NameRepository.setNames(names);
        System.out.println(NameRepository.getSize()); // 3
        System.out.println(NameRepository.add("Jennie Smith"));
        System.out.println(NameRepository.add("Jennie Test"));
        System.out.println(NameRepository.getSize()); // 4

        //... find by first name
        System.out.println(Arrays.toString(NameRepository.findByFirstName("Jennie")));

        //... find by last name
        System.out.println(Arrays.toString(NameRepository.findByLastName("Smith")));

        //... find all
        System.out.println(Arrays.toString(NameRepository.findAll()));

        //... update
        NameRepository.update("Rolf Smith", "Rolf Rolfsson");
        System.out.println(Arrays.toString(NameRepository.findAll()));

        //... find all
        System.out.println(Arrays.toString(NameRepository.findAll()));

        //... delete
        NameRepository.remove("Rolf Rolfsson");

        //... find all
        System.out.println(Arrays.toString(NameRepository.findAll()));

        // DONE
    }
}