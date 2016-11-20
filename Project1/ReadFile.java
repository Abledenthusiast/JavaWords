
/**
 * Reads a a text file.
 * 
 * @author Aaron Pitman
 * @version 1.0
 */
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.*;

public class ReadFile
{

    /**
     * Constructor for objects of class ReadFile
     */
    public ReadFile()
    {
        
    }

    /**
     *  
     */
    public void readIt(Scanner inFile, int wordLimit)
    {
       String word = "";
       while (inFile.hasNext())
       {
          word = word + " " + inFile.next();
           
        }
       TextCounter scanner = new TextCounter();
       if(wordLimit==-1)
       {
           scanner.countWords(word, 2, false);
        }
        else
        {
            scanner.countWords(word, wordLimit+1, true);
        }
        
    }
    
    public static void main(String [] args)
    {
        if(args.length<1)
        {
            System.out.println("Please give a file name");
        }
        
        else 
        {
            File fileToRead = new File(args[0]);
            
            Integer limit = -1;
            
            if(args.length>1)
            {
                ;
                try
                {
                    limit = Integer.parseInt(args[1]);
                }
                catch(NumberFormatException n)
                {
                    System.out.println("oops: "+n);
                }
                
                try
                {
                    Scanner in = new Scanner(fileToRead);
                    ReadFile mainObject = new ReadFile();
                    mainObject.readIt(in, limit);
                }
                catch(IOException e)
                {
                    System.out.println("oops: "+e);
                }
                
            }
            
            else
            {
                try
                {
                    Scanner in = new Scanner(fileToRead);
                    ReadFile mainObject = new ReadFile();
                    mainObject.readIt(in, limit);
                }
                catch(IOException e)
                {
                    System.out.println("oops: "+e);
                }
            }
            
        }
    }
    
    
    
    
}
