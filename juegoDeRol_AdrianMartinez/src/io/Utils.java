/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;
import java.io.*;

/**
 *
 * @author tokyodownloader
 */
public class Utils {
    
    //FUNCTION READ INTEGER.
        public static int readInt(){
            int num=0;
            try {
                BufferedReader in; 
                in = new BufferedReader(new InputStreamReader(System.in));

                //Leer entero

                num = Integer.parseInt(in.readLine());   
            } 

            catch (Exception e) {
            }
            return num;
        }
        
        public static float readFloat(){
            float num=0f;
            try {
                BufferedReader in; 
                in = new BufferedReader(new InputStreamReader(System.in));

                //Leer entero

           
                num = Float.parseFloat(in.readLine());
            } 

            catch (Exception e) {
            }
            return num;
        }
        
        public static String readString(){
            String cad="";
            try {
                BufferedReader in; 
                in = new BufferedReader(new InputStreamReader(System.in));

                //Leer entero

           
                cad = in.readLine();
            } 

            catch (Exception e) {
            }
            return cad;
        }
        
        public static char readChar(){
            String cad;
            char ch=' ';
            int qmide=0;
            BufferedReader in; 
            in = new BufferedReader(new InputStreamReader(System.in));
            do{
                try {
                    
                    cad=in.readLine();
                    qmide=cad.length();
                    

                     if (qmide==1){
                         ch=cad.charAt(0);
                     }
                     else{
                         System.out.println("Introduceme solo un carácter");
                     }
                } 
                catch (Exception e) {
                }
            }
            while(qmide!=1);
            return ch;
        }
        
    
   
        
}

