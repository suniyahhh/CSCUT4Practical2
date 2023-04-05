import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FilesInOut {

    public static void main(String[] args) throws FileNotFoundException {
        // Replace this with statements to set the file name (input) and file name (output).
//    	String inputName = args[0];
//    	String outputName = args[1];
    	
        // Initially it will be easier to hardcode suitable file names.
//    	Scanner console = new Scanner(System.in);
//    	System.out.println("Input file: ");
//    	String inputName = console.next();
//    	System.out.println("Output file: ");
//    	String outputName = console.next();
//    	
    	String inputName = "input.txt";
    	String outputName = "output.txt";
    	File inputFile = new File(inputName);
    	File outputFile = new File(outputName);
    	
        // Set up a new Scanner to read the input file. 
		Scanner in = new Scanner(inputFile);
		
		// Processing line by line would be sensible here.
	    // Initially, echo the text to System.out to check you are reading correctly.
	    // Then add code to modify the text to the output format.
       

        // Set up a new PrintWriter to write the output file.
    	PrintWriter out = new PrintWriter(outputFile);
        // Add suitable code into the above processing (because you need to do this line by line also.
        // That is, read a line, write a line, loop.
    	
    	StringTokenizer st;
    	
	    while (in.hasNextLine()) {
	    	st = new StringTokenizer(in.nextLine());
	    	
	    	while (st.hasMoreTokens()) {
	    		String token = st.nextToken();
	    		//If it is a date, add slash
	    		try {
	    		  int i = Integer.parseInt(token);
	    		  String date = token.substring(0,5).replaceAll("..", "$0/") + token.substring(5);
	    		  
	    		  System.out.println(date);
	    		  out.print(date);

	    		} catch (NumberFormatException nfe) {
	    			// If it is not a date, capitalise word
	    			String name = capitalise(token);
		    		out.print(name + " ");
		    		System.out.print(name + " ");
	    		}
	    		
	    	}
	    	System.out.println();
	    	out.print("\n");
	    }
    	
    	in.close();
    	out.close();
        // Finally, add code to read the filenames as arguments from the command line.

        System.out.println("You need to add your own code to do anything");

    } // main
    
    
    public static final String capitalise(String str)   
    {  
	    if (str == null || str.length() == 0) return str;  
	    return str.substring(0, 1).toUpperCase() + str.substring(1);  
	}
    


} // FilesInOut




