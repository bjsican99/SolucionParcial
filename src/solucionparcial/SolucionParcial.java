package solucionparcial;
import java.util.*;
/**
 *Software de Gestion de notas para 10 alumnos.
 *Mostrando si aprovo o reprovo
 *Mostrando el promedio.
 *Variante B
 * @author alumno
 * Billy Jeshua Sican Matias 
 * 0901-17-16250
 * Ingenieria en sistemas
 */
public class SolucionParcial {
    public static void main(String[] args) {
        //Declaracion de Variables, vectores y matrices.
        double dblNotas [] = new double[10];
        String strNombreAproRepro [][] = new String[10][2];
        IngresoDeNotas(strNombreAproRepro, dblNotas);
        Mostrar(strNombreAproRepro, dblNotas);
    }
    //Metodo para el ingreso de nombres y notas, con llamamiento a otras funciones
    public static void IngresoDeNotas( String [][] strNombreAproRepro, double [] dblNotas){
        Scanner scnGuardar = new Scanner(System.in);
        int iConteo=1;
        for(int iFila = 0; iFila <10; iFila++){
            System.out.println("Ingrese el nombre del Alumno #"+iConteo+": ");
            strNombreAproRepro[iFila][0] = scnGuardar.next();
            dblNotas[iFila] = Notas();//llamamiento de funcion Notas
            strNombreAproRepro[iFila][1] = AproRepro(dblNotas, iFila);//llmado con parametros de la funcion AproRepro          
            iConteo++;        
        }
    }
    
    /*funcion para ingreso de notas con rago de 1-10
      Para una mejor gestion   
    */
    public static int Notas() {
        Random rdmNotas = new Random();
        return rdmNotas.nextInt(99)+1;
    }
    
    //Funcion para averiguar si el alumno aprovo o reprovo, con la posicion del
    //vector y el valor del mismo
    public static String AproRepro(double[] dblNotas, int iFila) {
        if(dblNotas[iFila] < 61){
            return "Reprovado";
        }else{
            return "Aprovado";
        }
    }
    
    //Metodo para mostrar en pantalla el nombre, nota y estado (Aprovado/Reprovado)
    public static void Mostrar(String [][] strNombreAproRepro, double [] dblNotas){
        double dblPromedio;
        System.out.println("\n");
        for(int iFila=0; iFila<10; iFila++){
            System.out.println("Nombre: "+strNombreAproRepro[iFila][0]);
            System.out.println("Nota: "+dblNotas[iFila]+"\tEstado: "+strNombreAproRepro[iFila][1]);
            System.out.println("----------------------------------------------------------------");
        }
        dblPromedio = Promedio(dblNotas);
        System.out.println("\nEl Promedio de notas de la clase es de: "+dblPromedio);
    }
    
    //funcion para el calculo del promedio de los alumnos
    private static double Promedio(double[] dblNotas) {
        int intTotalNotas = 0;
        double dblPromedio;
        //sumatoria de todas las notas
        for(int iPosicion = 0; iPosicion<10; iPosicion++){
            intTotalNotas += dblNotas[iPosicion];
        }
        //calculo del promedio
        dblPromedio = intTotalNotas/10;
        return  dblPromedio;//valor retornado
    }
    
}
