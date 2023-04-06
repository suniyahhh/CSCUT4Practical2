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
    	String uppercase="";
    	String inputName="";
    	String outputName="";
    	if (args.length==3) {
    		uppercase = args[0];
        	inputName = args[1];
        	outputName = args[2];
    	}
    	else if (args.length==2) {
    		inputName = args[0];
        	outputName = args[1];
    	}
    	
    	

//    	Scanner console = new Scanner(System.in);
//    	System.out.println("Input file: ");
//    	String inputName = console.next();
//    	System.out.println("Output file: ");
//    	String outputName = console.next();
//    	

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
    	
    	System.out.println(">>> Starting to write new file . . . \n");
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
	    			String name;
	    			if (uppercase.equals("-u")) {			// If -u flag is not included
	    				name = token.toUpperCase();
	    				if(token.length()==1) name = name+".";
	    			}
	    			else {									// If -u flag is included
	    				name = capitalise(token);
	    			}
	    			
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
    	System.out.println(">>> New file written successfully. ");

    } // main
    
    
    public static final String capitalise(String str)   
    {  
	    if (str == null || str.length() == 0) return str;
	    
	    String result = str.substring(0, 1).toUpperCase() + str.substring(1);
	    if (str.length()==1) {
	    	result = result + ".";
	    }
	    
	    return result;
	}
    


} // FilesInOut




