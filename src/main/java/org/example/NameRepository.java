package org.example;

import java.util.Arrays;

public class NameRepository {
    private static String[] names;

    public static int getSize(String[] arr){
        return arr.length;
    }
    // Returns number of elements in the array

    public static void setNames(String[] names){
        NameRepository.names = names;
    }
    // Sends in an array that set the private static array

    public static String[] getNames(){
        return names;
    }

    public static void clear(){
        names = new String[0];
    }
    // Should completely empty the array.
    public static String[] findAll(){
        return Arrays.copyOf(names, names.length);
    }
    //Returns all names in a new arra

    public static String find(final String fullName){
        for (String s: names) {
            if (s.equalsIgnoreCase(fullName))
                return fullName;
        }
        return null;

    }
    //Returns name if found and null if not found.

    public static boolean add(final String fullName){
        boolean ifContain = NameRepository.find(fullName) == null ? false : true;
        if(ifContain){
            return false;
        }

        String[] temp = Arrays.copyOf(names, names.length+1);
        temp[temp.length-1]= fullName;
        names = temp;
        System.out.println(names);
        return true;
    }
    /*Should add a new name to the array. Returns true when name was added and false when the array contains
        the name*/

    public static String[] findByFirstName(final String firstName){
        String[] result = {};
        for(String fullName : names){
            String fName = fullName.substring(0, fullName.indexOf(" "));
            if(fName.equalsIgnoreCase(firstName)){
                result = addToArray(result, fName);
            }
        }
        return result;
    }

    private static String[] addToArray(String[] source, String string) {
        String[] temp= Arrays.copyOf(source, source.length+1 );
        temp[temp.length-1] = string;
        return temp;
    }

    /*Searches the array trying to find all names that has passed in first name. Returns a String array containing all
    matches.*/


    public static String[] findByLastName(final String lastName){
        String[] result = {};
        for(String fullName : names){
            String lName = fullName.substring(fullName.indexOf(" ")+1,fullName.length());
            if(lName.equalsIgnoreCase(lastName)){
                result = addToArray(result, lName);
            }
        }
        return result;
    }
    /*Searches the array trying to find all names that has passed in last name. Returns a String array containing all
    matches.*/

    public static int indexOfName(String newName){
        int index = -1;
        for(int i=0; i < names.length; i++){
            //String n = namesDB[i];
            if(names[i].equalsIgnoreCase(newName)){
                return i;
            }
        }
        return index;
    }

    public static String update(final String original, final String updatedName){
        String result = "Name not found";
        int i = indexOfName(original);
        if(i > -1){
            names[i] = updatedName;
            result = " The name: " + original + " has been replaced by " + updatedName;

        }
        return result;
    }
    // I changed from boolean to an String return
    /*Should find a name and replace it with new fullName if available. Returns true if name was found and updated
    with the new name. False if name could not be updated because name wasn’t found or name was found but an
    existing name matching the updatedName already exists.*/
}
