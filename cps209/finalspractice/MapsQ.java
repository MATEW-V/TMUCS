package finalspractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapsQ {
    // # Alvin and the Chipmunks (Theodore and Simon) need help figuring out the permissions on some important files. 
    // # Write a function that receives an array of 3 names and a string of 3 numbers. Return an arrayList of of 3 strings,
    // # each containing the permissions for each chipmunk. Create a map to convert a string representation of binary numbers
    // # to the associated permissions.
    
    // # The first digit represents the permissions for Theodore, the second digit represents the permissions for Simon, and the third digit represents the permissions for Alvin.
    // # Ex: getPermissions({"Theodore","Simon","Alvin"}, "035");
    // # -> ['Theodore has no permission.', 'Simon has write and execute permissions.', 'Alvin has read and execute permissions.']

    // # Use the following for reference 
    // # Decimal | Binary | Permission
    // # ------------------------------
    // #       0 | (000) | No permission.
    // #       1 | (001) | Execute permission.
    // #       2 | (010) | Write permission.
    // #       3 | (011) | Write and execute permissions.
    // #       4 | (100) | Read permission.
    // #       5 | (101) | Read and execute permissions.
    // #       6 | (110) | Read and write permissions.
    // #       7 | (111) | Read, write, and execute permissions.

    static ArrayList<String> getPermissions(String[] names, String permissionCode){
        // Given map for Decimal to Binary Conversion
        // Feel free to change from Char to String if you'd like
        Map<Character,String> decToBin = new HashMap<Character,String>();
        decToBin.put('0',"000");
        decToBin.put('1',"001");
        decToBin.put('2',"010");
        decToBin.put('3',"011");
        decToBin.put('4',"100");
        decToBin.put('5',"101");
        decToBin.put('6',"110");
        decToBin.put('7',"111");

        ArrayList<String> permissions = new ArrayList<String>();
        // Create a Map to get a string of permissions based on Binary value
        
        return permissions;
    }

    public static void main(String[] args){
        String[] chipmunks = {"Theodore","Simon","Alvin"};
        ArrayList<String> res = getPermissions(chipmunks, "035");
        System.out.println("Result:\n" + res);
        System.out.println("Expected:\n[Theodore has no permission, Simon has write and execute permissions, Alvin has read and execute permissions]");

        chipmunks = new String[] {"Simon","Alvin","Theodore"};
        res = getPermissions(chipmunks, "672");
        System.out.println("Result:\n" + res);
        System.out.println("Expected:\n[Simon has read and write permissions, Alvin has read, write, and execute permissions, Theodore has write permission]");
    }
}