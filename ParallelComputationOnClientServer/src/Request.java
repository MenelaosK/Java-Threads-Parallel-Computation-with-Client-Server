import java.io.*;
import java.util.*;

public class Request implements Serializable {

   private double sum;
   
   Request(double sum) {
      this.sum=sum;
   }

public double getSum() {
	return sum;
}

public void setSum(double sum) {
	this.sum = sum;
}

  
}

