package se.lexicon.jennie;

import java.util.Arrays;

public class NameRepository {
    private static String[] names = new String[0];

    // Returns number of elements in the array
    public static int getSize() {
        return names.length;
    }

    // Sends in an array that set the private static array.
    // This replaces all existing names.
    public static void setNames(String[] names) {
        NameRepository.names = names;
    }

    // Completely empties the array.
    public static void clear() {
        names = new String[0];
    }

    // Returns all names in a new array
    public static String[] findAll() {

        return Arrays.copyOf(names, names.length);

        /*
       Alt.:
       String[] temp = new String[names.length];

        for(int i = 0; i < (names.length); i++) {
            temp[i] = names[i];
        }
        return temp;
        */
    }

    // Returns name if found and null if not found.
    public static String find(final String fullName) {
        for(int i = 0; i < names.length; i++) {
            if(names[i].equals(fullName)) {
                return fullName;
            }
        }
        return null;
    }

    // Adds a new name to the array.
    // Returns true when name was added and false when the array contains the name.
    public static boolean add(final String fullName) {
        if(find(fullName) == null) {

            String[] temp = new String[names.length + 1];

            for(int i = 0; i < (names.length); i++) {
                temp[i] = names[i];
            }
            temp[temp.length - 1] = fullName;
            names = temp;
            return true;
        } else {
            return false;
        }
    }

    // Searches the array trying to find all names that have the passed in first name.
    // Returns a String array containing all matches
    public static String[] findByFirstName(final String firstName) {
        String s = "";

        for(int i = 0; i < names.length; i++) {
            String[] fullName = names[i].split(" ");
            if(fullName[0].equals(firstName)) {
                s = s + fullName[0] + " " + fullName[1] + ",";
            }
        }
        s = s.substring(0, s.length()-1);
        return s.split(",");
    }

    // Searches the array trying to find all names that have the passed in last name.
    // Returns a String array containing all matches
    public static String[] findByLastName(final String lastName) {
        String s = "";

        for(int i = 0; i < names.length; i++) {
            String[] fullName = names[i].split(" ");
            if(fullName[1].equals(lastName)) {
                s = s + fullName[0] + " " + fullName[1] + ",";
            }
        }
        s = s.substring(0, s.length()-1);
        return s.split(",");
    }

    // Finds a name and replaces it with new fullName.
    // Returns true if name was found and updated with the new name.
    // Returns false if name could not be updated because name wasn't found or name was found,
    // but an existing name matching the updatedName already exists.
    public static boolean update(final String original, final String updatedName) {
        if (find(original) != null && find(updatedName) == null) {
            for (int i = 0; i < names.length; i++) {
                if (names[i].equals(original)) {
                    names[i] = updatedName;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    // Removes a name from the array.
    // Returns true if name was removed and false if the name was not removed for some reason.
    public static boolean remove(final String fullName) {
        String[] temp = new String[names.length-1];
        int j = 0;

        if(find(fullName) != null) {
            for(int i = 0; i < names.length; i++) {
                if(!names[i].equals(fullName)) {
                    temp[j] = names[i];
                    j++;
                }
            }
            names = temp;
            return true;
        } else {
            return false;
        }
    }
}