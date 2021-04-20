import java.util.Random;

/**
 * 
 * @author Vishal
 *
 * This is the Driver class which is capable of adding the Data to the Stream irrespective of the implementation type support. (Due to Generics).
 * Some of the basic common properties are configurable and can be moved to a separate Constants.java file. For the sake of brevity, I have included it here.
 * 
 */


public class Driver {

	public static final int STREAM_SIZE = 3;
	public static final int NUM_ITERATIONS = 10;
	public static final int UPPER_BOUND = 100;
	
	
	public static void main(String[] args) {
		MovingAverage<Integer> movingAverageInts = new MovingAverageImpl<Integer>(STREAM_SIZE);
		Random random = new Random();
		
		for(int i=0;i<NUM_ITERATIONS;i++) {
			int randomNumber = random.nextInt(UPPER_BOUND);
			System.out.printf("Adding %s in the stream ",randomNumber);
			movingAverageInts.addElement(randomNumber);
			
			System.out.println("Printing the stream");
			
			movingAverageInts.printElementsInCurrentWindow(movingAverageInts.getElements());
			
			System.out.println("Moving Average of current Stream is  "+movingAverageInts.getMovingAverage());
		}
		
		System.out.println("Using circular list to process data");
		
		MovingAverage<Integer> circularList = new CircularList<Integer>(STREAM_SIZE);
		
		for(int i=0;i<NUM_ITERATIONS;i++) {
			int randomNumber = random.nextInt(UPPER_BOUND);
			System.out.printf("Adding %s in the stream ",randomNumber);
			circularList.addElement(randomNumber);
			
			System.out.println("Printing the stream");
			
			circularList.printElementsInCurrentWindow(circularList.getElements());
			
			System.out.println("Moving Average of current Stream is  "+circularList.getMovingAverage());
		}
	}
	
	
}
