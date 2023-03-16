package misClases.persona;

  public class PersonException extends Exception {
     
     private String  errorMessage;
 
     public PersonException() {
         this.errorMessage = "Error Indefinido";
     }
 
     public PersonException(String message) {
        this.errorMessage = message;
        
     }
     public String getMessage(){
        return this.errorMessage;   
    }
 }
 
