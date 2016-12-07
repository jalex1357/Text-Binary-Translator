/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytranslation;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Johnathan
 */
public class doSomething{
    private String messageFile;

    /**
     *Initialize null variables to empty string
     */
    public doSomething(){
        messageFile = "";
    }
    
    /**
     *
     * @param fileName: Gets fileName from user
     * translateStep1: splits message into pieces of 8 (1 character)
     */
    public ArrayList<String> translateStep1(String fileName) throws FileNotFoundException{
        this.messageFile = fileName;
        
        File file = new File(messageFile);
        Scanner inputFile = new Scanner(file);
        
        String line;
        ArrayList<String> characters = new ArrayList<String>();
        //String[] characters = new String[1000];
        String character = "";
        
        while(inputFile.hasNext()){
            line = inputFile.nextLine();
            String[] parts = line.split("");
            int total = 0;
            for(int count = 0; count<=parts.length-1; count++){
                
                character+=parts[count];
                if(total == 7){
                    characters.add(character);
                    //characters[count/8] = character;
                    total = 0;
                    character = "";
                }
                else{
                    total++;
                }
            }
        }
        
        return characters;
    }
    
    public void displayMessage(ArrayList<Character> charArray){
        String message = "";
        
        for(int count = 0; count < charArray.size(); count++){
            message+=charArray.get(count);
        }
        System.out.println(message);
    }
    
    public void saveEncoded(ArrayList<String> binaryArray) throws FileNotFoundException{
        String fileName="";
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter a file(including extension) to save to:  ");
        fileName = keyboard.nextLine();
        
        while(fileName.equals("")){
            System.out.println("Enter a file(including extension) to save to:  ");
            fileName = keyboard.nextLine();
        }
            
        
        PrintWriter outputFile = new PrintWriter(fileName);
        for(int count = 0; count<binaryArray.size(); count++){
            outputFile.write(binaryArray.get(count));
        }
        outputFile.close();
        System.out.println("\nYour encoded message has been saved.");
    }
}
