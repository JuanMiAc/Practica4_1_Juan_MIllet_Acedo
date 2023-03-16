import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Scanner;
import misClases.persona.persona;
import misClases.persona.PersonException;

public class practica4 {

private static void limpiarPantalla(){
     System.out.print("\033[H\033[2J");
     System.out.flush(); 
 }
private static boolean BusquedaArray(String cadena, String busqueda){
return true;
 
}
 private static String[] regogerDatospersona(){
    Scanner teclado = new Scanner(System.in);
    String datos[] = new String[5];
    limpiarPantalla();
    System.out.println("ID: "); datos[0]= teclado.next();
    System.out.println("Nombre: "); datos[1]= teclado.next();
    System.out.println("Apellido: "); datos[2]= teclado.next();
    System.out.println("Ano de nacimiento: "); datos[3]= teclado.next();
    System.out.println("Correo electronico: "); datos[4]= teclado.next();
    return datos;

 }

 public static void main(String args[])
    {
      
        switch(args.length){
          
          case 0: System.out.println("No se encuentra el nombre del fichero"); 
            break;
              
          case 1:  //Fichero que vamos a leer
		 System.out.printf("Fichero de entrada: %s ",args[0]);  
		 Scanner fich=null;
                 Scanner teclado = new Scanner(System.in);
                 ArrayList<persona> per = new ArrayList<persona>(); 
                 int opcion=0;
             
                    try {
                           File fichero = new File("Menu.txt");
                           System.out.println("... Leyendo contenido de fichero ...");

		
                        do{
                            limpiarPantalla();
                            fich = new Scanner(fichero);
                            while (fich.hasNextLine()) {
                                    String linea = fich.nextLine();    
                                    System.out.println(linea);      
                            }
                            fich.close();
                            opcion = teclado.nextInt();
                            switch(opcion) {

                                /*--------*OPCION 1 INTRODUCIR DATOS*---------*/ 
                                case 1: 
                                    limpiarPantalla();
                                    persona person = new persona();
                                    person.capturaDatos();
                                    person.muestraDatos();
                                    per.add(person);
                                    System.out.println("\nLA PERSONA HA SIDO REGISTRADA CORRECTAMENTE");
                                    Thread.sleep(5000);
                                    break;
                                /*--------*OPCION 2 MOSTRAR DATOS*---------*/     
                                case 2: 
                                    limpiarPantalla();
                                   System.out.println("\n                   DATOS DE LAS PERSONAS REGISTRADAS HASTA AHORA");
                                   System.out.println("------------------------------------------------------------------------------------");
                                    for(persona p: per){
                                    System.out.println("Datos persona : " + p.getpersona() );
                                    }
                                    System.out.println("------------------------------------------------------------------------------------\n");
                                    Thread.sleep(4000);
                                    break;
                                /*--------*OPCION 3 BUSCAR DATOS DE UNA PERSONA*---------*/     
                                case 3: {
                                    String busqueda;
                                    List<persona> encontrados = new ArrayList<persona>();
                                    limpiarPantalla();
                                    System.out.print("\n Introduzca un dato de la persona desea encontrar: \n");
                                    busqueda = teclado.next();
                                    String busqueda1 ="["+busqueda+"]";
                                    
                                    
                                    per.forEach((c) -> { 
                                        String registro;  
                                   
                                        registro =c.getpersona();
                                        boolean resultado= registro.contains(busqueda);
                                        if (resultado) { 
                                            encontrados.add(c);  
                                           
                                        } 
                                    });
                                    
                                    if(encontrados.size()>0){
                                            System.out.printf("\n  Personas que de coincidencia que tengan algun dato: ' %s ' \n",busqueda);
                                            System.out.println("-----------------------------------------------------------------------------------\n");       
                                            encontrados.forEach((c) -> { 
                                               c.muestraDatos(); System.out.println(); 
                                           });
                                    } else  System.out.printf("\n  No se ha encontrado a ninguna persona que en sus datos se encuentre: ' %s ' \n",busqueda);
                                    Thread.sleep(4000);
                                }
                                    break;
                                /*----------*OPCION 4 GENERAR UN FICHERO CON LOS USUARIOS*---------*/    
                                case 4: 
                                    limpiarPantalla();
                                    File file = new File("Usuarios.txt");
                                    try {
                                    FileOutputStream fw = new FileOutputStream(file);
                                    Writer out = new BufferedWriter(new OutputStreamWriter(fw, "UTF-8"));
                                    for (persona persona : per) {
                                    try {
                                    out.write(persona.getpersona() + "\n");
                                    } catch (Error ex) {
                                    System.out.println("Mensaje excepcion escritura: " + ex.getMessage());
                                    }
                                    }
                                    out.close();
                                    System.out.println("             ...CREANDO FICHERO USUARIOS.TXT...");
                                    System.out.println("................................................................");
                                    Thread.sleep(3000);
                                    System.out.println("\n  ...EL FICHERO USUARIOS.TXT SE HA CREADO CORRECTAMENTE...    ");
                                    Thread.sleep(1000);
                                    } catch ( IOException ex2) {
                                    System.out.println("Mensaje error 2: " + ex2.getMessage());
                                    } 
                               break;

                               /*----------*OPCION 5 SALIR*---------*/   
                               case 5:
                                System.out.println("\nGracias, hasta la proxima!!");
                                Thread.sleep(1000);
                                default: {}
                                    
                            }
                            
                            
                        } while(opcion != 5);

                    } catch (Exception ex) { 
			                            System.out.println("Mensaje: " + ex.getMessage());
                    } finally {
                            try {
                                            if (fich != null)	fich.close(); teclado.close();
                            } catch (Exception ex2) { System.out.println("Mensaje 2: " + ex2.getMessage());	}
                                    }
               break;
          default:
             {  System.out.println("Introduzca el nombre del fichero de entrada. Ejemplo--> \"nombre.txt\""); }         
      }  
    }
}

