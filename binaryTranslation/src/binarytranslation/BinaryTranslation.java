
package binarytranslation;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Johnathan
 */
public class BinaryTranslation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        
        
        
        String fileName;
        Scanner keyboard = new Scanner(System.in);
        
        
        System.out.println("Menu");
        System.out.println("1. Convert text to binary");
        System.out.println("2. Convert binary to text");
        
        System.out.println("\n\n");
        
        int choice = keyboard.nextInt();
        
        if(choice == 1){
            translateTOBinary encode = new translateTOBinary();
            ArrayList<String> message= new ArrayList<>();
            message = encode.getText();
            
            ArrayList<Integer> IntegerArray = new ArrayList<Integer>();
            IntegerArray = encode.binaryTranslation(message);
            
            System.gc();
            //Translate to binary
            messageConversions b = new messageConversions();
            ArrayList<String> binaryArray = new ArrayList<>(); 
            binaryArray = b.toBinary(IntegerArray);
            
            //Save binary to external file.
            doSomething save = new doSomething();
            save.saveEncoded(binaryArray);
            
        }
        else{
        
        
        
            doSomething translate = new doSomething();
            System.out.println("Enter file name where encoded message is in (Include the extension)");
            fileName = keyboard.nextLine();

            while(fileName.equals("")){
                System.out.println("Enter a file name that contains the encoded message.  ex. message.txt");
                fileName = keyboard.nextLine();
            }

            //This sends the file to split it into byte characters
            ArrayList<String> messageArray = new ArrayList<>();
            messageArray = translate.translateStep1(fileName);

            System.gc();

            //This sends the byte characters (01110000) to be converted into integers(ASCII)
            messageConversions convert = new messageConversions();
            ArrayList<Integer> integerArray = new ArrayList<>();
            integerArray = convert.binaryTOInteger(messageArray);

            System.gc();

            //This converts the integers(ASCII) into characters
            ArrayList<Character> charArray = new ArrayList<>();
            charArray = convert.integerTOChar(integerArray);


            //This displays the converted message
            translate.displayMessage(charArray);
        
        }
    }    
}
