import java.io.*;
import java.util.*;

public class Reply implements Serializable {

   private double step;
   private long start,stop;

 

public Reply(double step, long start, long stop) {
	this.step = step;
	this.start = start;
	this.stop = stop;
}

public double getStep() {
	return step;
}

public long getStart() {
	return start;
}


public long getStop() {
	return stop;
}

   
   
}

