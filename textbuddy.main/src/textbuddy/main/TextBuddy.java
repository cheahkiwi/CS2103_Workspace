package textbuddy.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * <h1>TextBuddy</h1>
 * TextBuddy application that performs functions
 * as described in CE1.
 * <p>
 * Assupmtions:
 * -> If any exceptions/errors are encountered, default action is to quit program
 * -> Only files with extension txt, will be accepted
 * -> If file already exist, file content must only contain text
 * 
 * @author Cheah Kit Weng, A0059806W
 *
 */
public class TextBuddy {
    
    public static String currentFilename = "";
    
    /**
     * Main Method
     * 
     * @param args  Command-line arguments
     */
    public static void main(String[] args) {
        checkArguments(args);
        
        currentFilename = args[0];
        
        displayGreeting();
        
        processUserInput();

    }

    /**
     * Method to check if arguments are valid
     * 
     * @param args  Array to be checked
     */
    private static void checkArguments(String[] args) {
        if(args.length < 1 ){
            exitApplication(Messages.INCORRECT_ARGUMENTS);
        }
        
        if(!isValidFile(args[0])){
            exitApplication(Messages.INVALID_FILENAME);
        }
        
    }
    
    /**
     * Method to check that the filename is valid
     * 
     * @param filename  Filename to be checked
     * @return          True if filename is valid; False otherwise
     */
    private static boolean isValidFile(String filename) {
        String regexMatcher = "(.*)[a-zA-Z1-9]+\\.txt";  // Regular expression that matches any filename that ends with txt
        
        if(filename.matches(regexMatcher) && isValidDirectory(filename)){
            return true;
        }
        return false;
    }

    /**
     * Method to check if directory is valid (if any)
     * 
     * @param filename  File to be checked
     * @return          True if directory is valid; False otherwise
     */
    private static boolean isValidDirectory(String filename) {
        File file = new File(filename);
        File parentDirectory = file.getParentFile();
        
        if(parentDirectory != null && !parentDirectory.isDirectory()){
            return false;
        }
        
        return true;
    }

    /**
     * Method to display Greeting to the user
     * 
     */
    private static void displayGreeting() {
        System.out.println("Welcome to TextBuddy. "+currentFilename+" is ready for use");
    }
    
    /**
     * Method to process commands entered by the user
     * 
     */
    private static void processUserInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Object to capture keyboard input
        
        boolean isExit = false;
        
        do{
            System.out.print(Messages.PROMPT_COMMAND);
            try{
                String command = reader.readLine();
                
                switch (command){
                    default:
                        printHelp();
                }
            }catch(Exception err){
                exitApplication(Messages.UNKNOWN_ERROR);
            }
        }while(!isExit);
        
    }
    
    /**
     * Method to display a message then quit the application
     * 
     * @param msg Message to be printed before quitting
     */
    private static void exitApplication(String msg) {
        System.out.println(msg);
        System.exit(0);
    }
}
