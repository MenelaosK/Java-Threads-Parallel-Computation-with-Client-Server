import java.io.*;
import java.net.*;

public class Client { 
   private static final String HOST = "localhost";
   private static final int PORT = 1234;

   public static void main(String[] arg) throws IOException, ClassNotFoundException {
           
	 Socket socketConnection = new Socket(HOST, PORT);

         ObjectOutputStream clientOutputStream = new
            ObjectOutputStream(socketConnection.getOutputStream());
         ObjectInputStream clientInputStream = new 
            ObjectInputStream(socketConnection.getInputStream());
      
     double sum=0.0;
	 Reply rep = (Reply)clientInputStream.readObject();
	 double step=rep.getStep();
	 long start=rep.getStart();
	 long stop=rep.getStop();
	 
	 for (long i = start; i < stop; ++i) {
         double x = ((double)i+0.5)*step;
         sum += 4.0/(1.0+x*x);
     }
    
	 
	
         Request req = new Request(sum);
         clientOutputStream.writeObject(req);
         clientOutputStream.close();
         clientInputStream.close();

	 socketConnection.close();
   }
}

