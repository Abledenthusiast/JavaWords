
/**
 * TextCounter will take the text and count their frequency
 * 
 * @author Aaron Pitman 
 * @version 1.0
 */
import java.util.Iterator;
import java.util.Set;
import java.util.HashMap;
import java.util.Scanner;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class TextCounter
{
    
  

    /**
     * 
     */
    public TextCounter()
    {
        
    }
   /**
    * This method is the main method to count the words
    * This works by taking a list of strings and inputting them into a hashmap. 
    * each word (key) is then assigned a value of 1 and iterated through to check if there a more. 
    * each additional word found, the value it references will be increased by 1
    */
   
    public void countWords(String inputData, int limit, boolean wordLimit)
    {
        HashMap<String, Integer> inputMap = new HashMap<String, Integer>();;
        String [] inputWords = inputData.split("[ \t\n\r\f!?.]");
        Integer value = 1;
        int counter = 1;
        String html= "";
        
        for(String w: inputWords)
        {
            
            if (inputMap.containsKey(w)) // check for the key
            {
                value = inputMap.get(w);
                value = value + 1;
        
            }
        
            inputMap.put(w,value);
            
            value = 1;
        }
        
        
        
       Set<String> hashKeys = inputMap.keySet();
       Iterator<String> allKeys = hashKeys.iterator();
       while (allKeys.hasNext()&&counter<limit+1)
        {
            String key = allKeys.next();
            Integer total = inputMap.get(key);
             /**
             * check if key is empty space.
             */
            if(!key.equals(""))
           {
               html = html + "<div align="+"center><p><font size="+total*5+">"+ key + " " + total+
               "</font></p></div>"; 
               
            }
            
            if(wordLimit)
            {
                counter++;
            }
     
        }
        
        writeNewFile(html);
        
       
        
    }
    /**
     * Write a new html file with the frequencies found within TextCounter
     */
    public void writeNewFile(String content)
    {
        File file = new File("Test.html");
        
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(content);
            bw.close();
        }
    
        catch (IOException e)
        {
            e.printStackTrace();
        }
         
    }
    
}
