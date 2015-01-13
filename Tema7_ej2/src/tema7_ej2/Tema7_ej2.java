package tema7_ej2;
import java.io.*;
/**
 *
 * @author tokyodownloader
 */
public class Tema7_ej2 {

   
    public static void main(String[] args) {
        final int N=10;
        String v[] = new String[N];
        int i;
        String nom="";
        int vec;
        
       BufferedReader teclat = new BufferedReader(new InputStreamReader(System.in) );
       
      try{
        for(i=1;i<N;i++){
            System.out.println("Disme un algo per a guardarlo en "+i+" : ");
            nom=teclat.readLine();
            v[i]=nom;
        }
        
        for (String vec:v[]) {
            System.out.println(vec+", ");
        }
    }
       
    }
      
      catch(IOException e){
          System.out.println("Errorcito!");
      }
     
     
        
       
       }
    }   
