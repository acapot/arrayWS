package org.example;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String[] theNames = {"Erik Svensson", "Alexis Capot","Pedro Capot","Felipe Capot","Markus Capot"};
        NameRepository.setNames(theNames);
        System.out.println(Arrays.toString( NameRepository.getNames() ));
        NameRepository.add("Jaime Lopez");
        System.out.println(Arrays.toString( NameRepository.findByLastName("Capot")) );
        System.out.println(Arrays.toString( NameRepository.findByFirstName("Alexis")) );
        System.out.println(NameRepository.update("Alexis Capot", "Andres Capot") );
        NameRepository.find("Jaime Lopez");
        System.out.println(Arrays.toString( NameRepository.findAll() ));
        System.out.println("array size: " + NameRepository.getSize(theNames));
        NameRepository.clear();
        System.out.println(Arrays.toString( NameRepository.findAll() ));



    }
}

