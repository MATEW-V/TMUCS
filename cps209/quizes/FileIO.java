package quizes;

import java.io.*;
import java.util.*;

public class FileIO {
    public static void main(String args[]) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("words.txt"));
            int line = in.read();
            String word = "";
            List<String> words = new ArrayList<String>();
            List<Double> dubs = new ArrayList<Double>();

            Writer out1 = new FileWriter("outstir.txt") ;
            Writer out2 = new FileWriter("doubles.txt") ;

            while (line != -1){
                word += (char) line;
                line = in.read();
                if (line == 32 || line == 10 || line == -1) {
                    if (!word.isBlank()) {
                        words.add(word.strip());
                    }  
                    word="";
            }}
            in.close();
            Iterator<String> it = words.iterator();
            while (it.hasNext()) {
                String s = it.next();
                try {
                    dubs.add(Double.parseDouble(s));
                    it.remove(); 
                } catch (Exception e) {
                }
            }
        Collections.sort(dubs);
        Collections.sort(words);
        for (String s: words) {
            out1.write(s+"\n");
        }
        for (Double s: dubs) {
            out2.write(""+s+"\n");
        }
        out1.close();
        out2.close();
        } catch (IOException ex) {
            System.err.println("File not Found");
            System.exit(0);
        }
    }
}
