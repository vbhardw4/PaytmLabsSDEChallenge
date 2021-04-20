import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author Vishal
 *
 * This method uses the Queue Data Structure internally to store the incoming stream data.
 * And once it reaches the max stream size, the first element from the stream is dequeued and 
 * the new element is added to the queue using basic Mathematical operations.
 * This give us back the moving average of the last N elements present int the Stream. 
 */
public class MovingAverageImpl<T extends Number> implements MovingAverage<T> {

	private double movingAverage;
	private Queue<T> queue;
	private int streamSize;
	
	public MovingAverageImpl(int streamSize) {
		this.streamSize = streamSize;
		queue = new LinkedList<T>();
		movingAverage = 0d;
	}
	
	@Override
	public void addElement(T element) {
		if(queue.size() == streamSize) {
			double oldElement = queue.remove().doubleValue();
			movingAverage = (movingAverage*streamSize - oldElement)/(streamSize -1);
			
		}
		int currentQueueSize = queue.size(); 
		movingAverage = MovingAverage.calculateMovingAverage(currentQueueSize,movingAverage,element);
		
		queue.add(element);
	}

	@Override
	public double getMovingAverage() {
		return movingAverage;
	}

	@Override
	public List<T> getElements() {
		return new ArrayList<>(queue);
	}
	
}