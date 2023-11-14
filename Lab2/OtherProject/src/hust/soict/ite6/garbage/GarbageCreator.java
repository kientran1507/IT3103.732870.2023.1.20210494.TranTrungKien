package hust.soict.ite6.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "Test.exe";
        byte[] inputBytes = {0};
        long startTime, endTime;
     
        try {
			inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
			e.printStackTrace();
		}
        
	    startTime = System.currentTimeMillis();
	        
	    /* Garbage creator using +
	    String outputString = "";
	    for (byte b : inputBytes) {
	    	outputString += (char) b;
	    }
	    */
	        
	    StringBuilder outputStringBuilder = new StringBuilder();
	    for (byte b : inputBytes)
	        outputStringBuilder.append((char)b);
	    
	    /* Another method to create garbage
	    for (int i = 0; i < 1000000; i++) {
            // Create objects here that contribute to garbage
            String garbage = new String("This is garbage");
        }
	    */
	   
	    endTime = System.currentTimeMillis();
	    System.out.println(endTime - startTime);
    }
}
