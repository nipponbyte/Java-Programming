/*
BufferedReader in; 
in = new BufferedReader(new InputStreamReader(System.in));
*/
package adrianmartinezmarinnumerosenlletra;
import java.io.*;

public class AdrianMartinezMarinNumerosEnLletra {

//--------------------------------------------------
    
//Funciones | Separadores de digitos
    static int digitUnitats(int q){
        int unidades=q%10;
        return unidades;
    }
    
    static int digitDecenes(int q){
        int decenas=(q/10)%10;
        return decenas;
    }
    
    static int digitCentenes(int q){
        int centenas=(q/100)%10;
        return centenas;
    }

//--------------------------------------------------

//Funciones | Obtenedores de String
    
    //String para Decenas.
    static String decenaEnLletres(int dece, int uni){
        String decenaenlletra = null;
        if (dece==1){
            switch(uni){
                case 0: decenaenlletra = "deu";
                         break;
                case 1:  decenaenlletra = "onze";
                         break;
                case 2:  decenaenlletra = "dotze";
                         break;
                case 3:  decenaenlletra = "tretze";
                         break;
                case 4:  decenaenlletra = "catorze";
                         break;
                case 5:  decenaenlletra = "quinze";
                         break;
                case 6:  decenaenlletra = "setze";
                         break;
                case 7:  decenaenlletra = "désset";
                         break;
                case 8:  decenaenlletra = "dihuit";
                         break;
                case 9:  decenaenlletra = "dénou";
                         break;    
            }
           return decenaenlletra;
        }
        else{
            switch(dece){

                case 2:  decenaenlletra = "vint";
                         break;
                case 3:  decenaenlletra = "trenta";
                         break;
                case 4:  decenaenlletra = "quaranta";
                         break;
                case 5:  decenaenlletra = "cinquanta";
                         break;
                case 6:  decenaenlletra = "seixanta";
                         break;
                case 7:  decenaenlletra = "setanta";
                         break;
                case 8:  decenaenlletra = "huitanta";
                         break;
                case 9:  decenaenlletra = "noranta";
                         break;
                default: decenaenlletra = "";
                         break;
            }
           return decenaenlletra;
        }  
    }
          
    //String para Digito.
    static String digitEnLletres(int dig){
        String digitenlletra = null;
        
        switch(dig){
            case 1:  digitenlletra = "un";
                     break;
            case 2:  digitenlletra = "dos";
                     break;
            case 3:  digitenlletra = "tres";
                     break;
            case 4:  digitenlletra = "quatre";
                     break;
            case 5:  digitenlletra = "cinc";
                     break;
            case 6:  digitenlletra = "sis";
                     break;
            case 7:  digitenlletra = "set";
                     break;
            case 8:  digitenlletra = "huit";
                     break;
            case 9:  digitenlletra = "nou";
                     break;
            case 10: digitenlletra = "deu";
                     break;
            default: digitenlletra = "";
                     break;
        }
            return digitenlletra;
    }

//--------------------------------------------------

//String para 3 DIGITOS. (tresDigitsEnLletres)
    
static String tresDigitsEnLletres(int q){
    String devolver="";
    int dig_uni = digitUnitats(q); 
    int dig_dec = digitDecenes(q);
    int dig_cent = digitCentenes(q);
    String uni = digitEnLletres(dig_uni);
    String dec = decenaEnLletres(dig_dec, dig_uni); //Le introduzco las 2 para que me diga las irregularidades de el numero diez.
    String cent = digitEnLletres(dig_cent);
    
        
        //Centenas: Irregularidades.
            if(dig_cent!=0){ //Si no entra, evitamos que nos escriba ningún "cent" si no existe digito de centenas.
                if(dig_cent==1){ //Con esta, nos pondrá "cent" si corresponde al 1, y "x-cents" si corresponde al resto.
                    devolver+="cent "; 
                }
                else{
                    devolver+=cent+"-cents ";
                }
            }

        //Decenas: Irregularidades
            if(dig_dec!=0){
                if(dig_dec==2&&dig_uni!=0){ //1º Comtemplamos la irregularidad del "-i-" que hay en el 20. Ej: vint-i-dos. 2º Evitamos que nos ponga guión si la unidad es 0.
                    devolver+=dec+"-i";
                }
                else{
                    devolver+=dec;
                }
            }
        //Unidades:Irregularidades
            if(dig_dec!=1){ //Evitamos que nos añada la unidad si la decima es de 1. ej: Evitamos que escriba "catorce-quatre" en vez de "catorce". 

                if(dig_dec!=0&&dig_uni!=0){ //Evitamos que nos escriba un guión si la decima es 0. Evitar: "cent -cinc" en vez de "cent cinc". 2º Evitamos que nos ponga guión si la unidad es 0.(evitar: "vint-" en vez de "vint".
                    devolver+="-"+uni;
                }
                else{
                    devolver+=uni;
                }
            }
    
    return devolver;
}
    
//--------------------------------------------------

//String para 9 DIGITOS. (nouDigitsEnLletres)

static String nouDigitsEnLletres(int q){
    String devolver="";
    int num_op=q; //Es un operador temporal, va almacenando el numero cada vez sin 3 cifras menos.
    int sep_millon;
    int sep_mil;
    int sep_cent;
    
    //-------------
    //Separadores de grupos de números.
    //-------------
        sep_cent = num_op%1000; //De 123456789 cogería el 789
        num_op /= 1000;
        //-----------
        sep_mil=num_op%1000; //De 123456789 cogería el 456
        num_op /= 1000;
        //-----------
        sep_millon=num_op%1000; //De 123456789 cogería el 123
    //-----------------------------------
    
    //Con los numeros ya separados por grupos, obtenemos sus strings.
        String millon=tresDigitsEnLletres(sep_millon);
        String mil=tresDigitsEnLletres(sep_mil);
        String cent=tresDigitsEnLletres(sep_cent);

    //-------------
    //IRREGULARIDADES
    //-------------
        
        if(q==0){
            devolver="zero";
        }
        else{
            if(sep_millon==1){ //Para que diga "un milló" en vez de "un millons"
                devolver=millon+" milló "+mil+" mil "+cent;
                if(sep_mil==0){ //Para que no nos escriba "un milló mil" en vez de "un milló" si los miles están vacios.
                    devolver=millon+" milló "+cent;
                }
            }
            else if(sep_millon==0){//Con esta condición evitamos que nos escriba "millons", al no tener.
                devolver=mil+" mil "+cent;
                if(sep_mil==1){ //Si es 1000, Nos escribiría "mil" en vez de "un mil"
                    devolver=" mil "+cent;
                }
                else if(sep_mil==0){ //Si el numero solo tiene 3 digitos, que nos escriba solo hasta 999            
                    devolver=cent;
                }    
            }    
            else{
                if(sep_mil==0){//Para que no nos escriba los miles si los miles están vacios. Evitar: "20 millons mil" en vez de "20 millons" (20.000.000)
                    devolver=millon+" millons "+cent;
                }
                else{
                    devolver=millon+" millons "+mil+" mil "+cent;
                }
            }
        }
        
    return devolver;
}

    
//--------------------------------------------------
    
//FUNCIÓN PRINCIPAL (MAIN)
    
    public static void main(String[] args) {
        BufferedReader in; 
        in = new BufferedReader(new InputStreamReader(System.in));
        
        int numGlobal=0;
       
        
        System.out.print("Introduixme un número de 0 fins a 999.999.999, i et diré com es diu en Valencià -> ");
        try {
            numGlobal=Integer.parseInt(in.readLine());
        } 
        catch (IOException | NumberFormatException e) {
            System.out.println("Error!");
        }
        
        if (numGlobal<0||numGlobal>999999999){
            System.out.println("El número introducido no está entre 0 y 999999999, se saldrá del programa.");
        }
        else{
        System.out.println("Es diu -> "+nouDigitsEnLletres(numGlobal));
        }
        
         
    }

   

}
