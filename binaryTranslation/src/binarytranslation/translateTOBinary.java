/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytranslation;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Owner
 */
public class translateTOBinary {
    
    public ArrayList<String> getText(){
        String getText;
        Scanner keyboard = new Scanner(System.in);
        
        ArrayList<String> message = new ArrayList<>();
        
        System.out.println("Type END to stop entering a message\n\n");
        
        getText = "";
        while(!getText.equals("END")){
            getText = keyboard.nextLine();
            message.add(getText);
        }
        return message;
        
        
    }
    
    public ArrayList<Integer> binaryTranslation(ArrayList<String> message){
        ArrayList<Integer> integerArray = new ArrayList<>();
        for(int count = 0; count<message.size(); count++){
            String words = message.get(count);
            
            
            String[] split = words.split("");
            
            int c;
            for(int counter = 0; counter<split.length; counter++){
                try{
                    if(split[counter] == null)
                        break;

                    //System.out.println(counter);
                    c = (int)split[counter].charAt(count);

                    integerArray.add(c);

                    
                }
                catch(StringIndexOutOfBoundsException e){
                    break;
                }
            }
            
            
        }
        return integerArray;
    }
}
