import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Vishal
 *
 * This implementation class uses the CircularList of ArrayList Type type where the elements are getting added as per the value of rolling index.
 * This rolling index keeps track of the oldest element in the stream and replace it with the upcoming element.
 * 
 * We can also use the Arrays to implement this functionality. However, it would be difficult to support the Generic on Arrays.
 * 
 */
public class CircularList<T extends Number> implements MovingAverage<T> {

	List<T> circularList;
	int streamSize;
	double movingAverage;
	int rollingIndex;
	
	public CircularList(int streamSize) {
		circularList = new ArrayList<>(streamSize);
		this.streamSize = streamSize;
		movingAverage = 0.0d;
		rollingIndex = 0;
	}
	
	@Override
	public void addElement(T data) {
		int size = circularList.size();
		rollingIndex %= streamSize;
		if(size >= streamSize) {
			circularList.remove(rollingIndex);
		}
		
		movingAverage = MovingAverage.calculateMovingAverage(rollingIndex, movingAverage, data);
		circularList.add(rollingIndex, data);
		rollingIndex++;
		
	}

	@Override
	public double getMovingAverage() {
		return movingAverage;
	}

	@Override
	public List<T> getElements() {
		return circularList;
	}
	
}


//0 -> 1
//1 -> 2
//2 -> 3
//4 -> 0
//5 ->