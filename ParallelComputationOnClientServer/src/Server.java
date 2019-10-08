import java.io.*;
import java.net.*;


public class Server {
   private static final int PORT = 1234;

   public static void main(String[] arg) throws IOException, ClassNotFoundException {

         ServerSocket socketConnection = new ServerSocket(PORT);

         System.out.println("Server Waiting for clients");
         
         //pipe0
         Socket pipe = socketConnection.accept();

         ObjectInputStream serverInputStream = new    
            ObjectInputStream(pipe.getInputStream());

         ObjectOutputStream serverOutputStream = new 
            ObjectOutputStream(pipe.getOutputStream());
         System.out.println("Client 1 accepted, waiting for second client");
         
         //pipe1
         Socket pipe1 = socketConnection.accept();

         ObjectInputStream serverInputStream1 = new    
            ObjectInputStream(pipe1.getInputStream());

         ObjectOutputStream serverOutputStream1 = new 
            ObjectOutputStream(pipe1.getOutputStream());
         
         System.out.println("Client 2 accepted, work starts now");
         

         long numSteps = 1000000000;
         double sum = 0.0;
         
         
         //block slicing 2 clients
         long block = numSteps/2;
         
        
         /* start timing */
         long startTime = System.currentTimeMillis();
         
         //step
         double step = 1.0 / (double)numSteps;

         
         Reply rep = new Reply(step,0,block);
         serverOutputStream.writeObject(rep);
         

         Reply rep1 = new Reply(step,block,numSteps);
         serverOutputStream1.writeObject(rep1);

         
         Request req = (Request) serverInputStream.readObject();
         Request req1 = (Request) serverInputStream1.readObject();
         
         sum=req.getSum()+req1.getSum();
         
         double pi = sum * step;

         /* end timing and print result */
         long endTime = System.currentTimeMillis();
         System.out.printf("sequential program results with %d steps\n", numSteps);
         System.out.printf("computed pi = %22.20f\n" , pi);
         System.out.printf("difference between estimated pi and Math.PI = %22.20f\n", Math.abs(pi - Math.PI));
         System.out.printf("time to compute = %f seconds\n", (double) (endTime - startTime) / 1000);
         
         
         serverInputStream.close();
         serverOutputStream.close();
         serverInputStream1.close();
         serverOutputStream1.close();


	 pipe.close();
	 pipe1.close();

   }

}

