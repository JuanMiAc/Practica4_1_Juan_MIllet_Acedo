package misClases.persona;
import java.util.Calendar;
import java.util.Scanner;

public class persona { 

/*-------ATRIBUTOS DE LA CLASE PERSONA-----------*/
    private int ID;
    private String Nombre;
    private String Apellido;
    private int Nac;
    private String correo;
    private int edad;
    
    public persona(){}

/*--------FUNCION PARA RECIBIR LOS DATOS---------*/    
    public persona(int ID, String Nombre, String Apellido, int Nac, String correo, int edad) {
      this.ID = ID;
      this.Nombre = Nombre;
      this.Apellido = Apellido;
      this.Nac = Nac;
      this.correo = correo;
      this.edad = edad;
    }

/*--------FUNCIÓN PARA CALCULAR LA FECHA---------*/
      private int calcularEdad(int Nac){
      Calendar fechaActual = Calendar.getInstance();
      int edad = fechaActual.get(Calendar.YEAR) - Nac;    
      return edad;
    }
    public persona( int ID) {
      this.ID = ID;
    }

/*--------METODOS PARA RECOGER DATOS----------*/
    public int getID()
    {return this.ID;}
    public String getNombre()
    {return this.Nombre;}
    public String getApellido()
    {return this.Apellido;}
    public int getaNac()
    {return this.Nac;}
    public String getcorreo()
    {return this.correo;}
    public int getedad()
    {return this.edad;}
 
/*--------*METODO PARA INTRODUCIR LOS DATOS---------*/  
     public void setID(int ID)
     {this.ID=ID;}
     public void setNombre(String Nombre)
     {this.Nombre=Nombre;}
     public void setapellidos(String Apellido)
     {this.Apellido=Apellido;}
     public void setcorreo(String correo)
     {this.correo=correo;}
     public void setanoNac(int anoNac)
     {this.Nac=anoNac; this.edad=calcularEdad(anoNac);}
     
/*--------*OPCION 1 INTRODUCIR DATOS---------*/ 
  public void capturaDatos(){
     Scanner teclado = new Scanner(System.in);
     System.out.print("\nIntroduzca de los datos de la persona ha registrar:  ");
     boolean entero=false;


/*--------*CONTROL DE EXCEPCIONES EN LA INTRODUCCION DE LOS DATOS---------*/ 
     do{
        try {                         
          System.out.print("\n\nID: "); String s = teclado.next();
          entero = s.matches("[0-9]+");
                          
          if (!entero){
               System.out.printf("Error, dato introducido no valido ",s);
               System.out.println("    Entero = " + entero);
               throw  new PersonException("  Error, el numero que tiene que introducir debe ser de tipo entero");
          }else
          {
          this.ID=Integer.valueOf(s);
          }
          if (!entero) throw  new PersonException(" Error, el numero que tiene que introducir debe ser de tipo entero");
          } catch(PersonException e){
               System.out.println("Mensaje: " + e.getMessage());   
          }finally {}
     }while(!entero);
     System.out.print("\nNombre: "); this.Nombre= teclado.next();System.out.print("\n");
     System.out.print("Apellido: "); this.Apellido = teclado.next();System.out.print("\n");
     System.out.print("Correo electronico: "); this.correo = teclado.next(); 
                    
     do{
          try {
          System.out.print("\nFecha de nacimiento: "); String s = teclado.next();
          entero = s.matches("[0-9]+");                
          if (!entero){
               System.out.printf("Error, numero incorrecto: ",s);
               System.out.println("     isint = " + entero);
               throw  new PersonException("Tiene que introducir un numero entero.");
               }
          else{
               this.Nac=Integer.valueOf(s);
          }
          if (!entero) throw  new PersonException(" Numero incorrecto, que tiene que introducir ha ser entero");
          } catch(PersonException e){
          System.out.println("Mensaje: " + e.getMessage());   
          }finally {}
     }while(!entero);
  }

     /*--------*METODO PARA MOSTRAR LOS DATOS DE UNA PERSONA---------*/    
     public void muestraDatos(){
        System.out.print("....................................................................................................................................");
        System.out.print("\n\nDatos de la persona registrada:  ");
        System.out.print("\n - ");
        System.out.print("ID: " + this.ID +"\n - ");
        System.out.print("Nombre: " + this.Nombre +"\n - ");
        System.out.print("Apellido: " + this.Apellido +"\n - ");
        System.out.print("Fecha de nacimiento: " + this.Nac +"\n - ");
        System.out.println("Correo: " + this.correo);
        System.out.println("Edad: " + calcularEdad(Nac));
    }

    /*--------*METODO PARA OBTENER LOS DATOS DE UNA PERSONA---------*/  
    public String getpersona(){ 
      return "\n   - ID: " + this.ID +
             "\n   - Nombre: " + this.Nombre +
             "\n   - Apellidos: " +this.Apellido +
             "\n   - Año de nacimiento: " + this.Nac +
             "\n   - Correo electrónico: " + this.correo +
             "\n   - Edad: " + calcularEdad(Nac) +"\n";
     }    
}  
