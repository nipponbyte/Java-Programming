/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hola.mundo;
import java.io.*;

/**
 *
 * @author tokyodownloader
 */



public class HolaMundo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
BufferedReader tecladri = new BufferedReader (isr);
        // TODO code application logic here
        try{
        System.out.print("あなたの名前は何ですか？ ");
        String nom,nom2="";
        nom = tecladri.readLine();
        
        System.out.print("あなたの彼女の名前は？ ");
        nom2 = tecladri.readLine();
            System.out.println("------------------------");
        System.out.println(nom+"は"+nom2+"が愛してます♡");
        }
        catch(IOException a){
            System.out.println("Error, colega");
        }
            
        }
    
    
}
