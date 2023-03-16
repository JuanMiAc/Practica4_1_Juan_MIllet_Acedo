package misClases.persona;

 
 public class PersonaExcepcion extends Exception {
     
     private String  errorMessage;
 
     public PersonaExcepcion() {
         this.errorMessage = "Error Indefinido";
     }
 
     public PersonaExcepcion(String message) {
        this.errorMessage = message;
        
     }
     public String getMessage(){
        return this.errorMessage;   
    }
 }
 
