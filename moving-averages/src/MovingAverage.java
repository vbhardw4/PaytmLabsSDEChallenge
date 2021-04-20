import java.util.List;
/**
 * 
 * @author Vishal
 * 
 * This interface exposes the common functionality i.e. to calculate the Moving Average to all the implementation classes
 * Also, it provides the common functionality to print the current elements in the stream.
 * 
 */
public interface MovingAverage<T extends Number> {
	
	void addElement(T data);
	double getMovingAverage();
	List<T> getElements();
	default void printElementsInCurrentWindow(List<Integer> list) {
		list.stream().
			forEach(e->System.out.println(e+" "));
		// For the new line
		System.out.println();
	}
	
	public static <E> double calculateMovingAverage(int size, double movingAverage, E element) {
		
		if(element instanceof Double) {
			return (size * movingAverage+((Double) element)) /
					   (size +1);	
		}
		
		if(element instanceof Integer) {
			return (size * movingAverage+((Integer) element)) /
					   (size +1);	
		}
		
		return (size * movingAverage+((Float) element)) /
				   (size +1);	
		
	}
}
