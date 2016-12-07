/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytranslation;
import java.util.ArrayList;
/**
 *
 * @author Johnathan
 */
public class messageConversions {
    private ArrayList<Integer> integerArray = new ArrayList<Integer>();
    
    public ArrayList<Integer> binaryTOInteger(ArrayList<String> messageArray){
        for(int count = 0; count<messageArray.size(); count++){
            String binary = messageArray.get(count);
            String[] splitBinary = binary.split("");
            

            int total = 0;
            for(int counter = 0; counter<8; counter++){
                total = 0;
                if(splitBinary[0].equals("1")){
                    total += 128;
                    
                }
                if(splitBinary[1].equals("1")){
                    total += 64;
                    
                }
                if(splitBinary[2].equals("1")){
                    total += 32;
                    
                }
                if(splitBinary[3].equals("1")){
                    total += 16;
                    
                }
                if(splitBinary[4].equals("1")){
                    total += 8;
                    
                }
                if(splitBinary[5].equals("1")){
                    total += 4;
                    
                }
                if(splitBinary[6].equals("1")){
                    total += 2;
                    
                }
                if(splitBinary[7].equals("1")){
                    total += 1;
                    
                }
            }
            integerArray.add(count, total);
            
        }
        
        return integerArray;
        
        
    }
    public ArrayList<Character> integerTOChar(ArrayList<Integer> integerArray){
        ArrayList<Character> charArray = new ArrayList<>();
        
        for(int count = 0; count<integerArray.size(); count++){
            int number = integerArray.get(count);
            char character = (char)number;
            charArray.add(character);
        }
        
        
        return charArray;
    }
    public ArrayList<String> toBinary(ArrayList<Integer> integerArray){
        ArrayList<String> binaryArray = new ArrayList<>();
        //split translate to binary save return
        for(int count = 0; count < integerArray.size(); count++){
            int ascii = integerArray.get(count);
            
            //convert to binary
            String binary = "";
            if(ascii >= 128){
                binary+="1";
                ascii -= 128;
            }
            else{
                binary+="0";
            }
            if(ascii >= 64){
                binary+="1";
                ascii -= 64;
            }
            else{
                binary+="0";
            }
            if(ascii >= 32){
                binary+="1";
                ascii -= 32;
            }
            else{
                binary+="0";
            }
            if(ascii >= 16){
                binary+="1";
                ascii -= 16;
            }
            else{
                binary+="0";
            }
            if(ascii >= 8){
                binary+="1";
                ascii -= 8;
            }
            else{
                binary+="0";
            }
            if(ascii >= 4){
                binary+="1";
                ascii -= 4;
            }
            else{
                binary+="0";
            }
            if(ascii >= 2){
                binary+="1";
                ascii -= 2;
            }
            else{
                binary+="0";
            }
            if(ascii >= 1){
                binary+="1";
                ascii -= 1;
            }
            else{
                binary+="0";
            }
            //save binary to array
            binaryArray.add(binary);
        }
        return binaryArray;
    }
}
