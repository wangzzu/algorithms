package other;

import java.util.Objects;

/**
 * 循环顺序队列
 * Created by matt on 4/25/16.
 */
public class CircleSequenceQueue implements Queue {
	private static final int defaultSize=10;
	private int front;
	private int last;
	private int count;
	private int maxSize;
	private Object[] queue;
	public CircleSequenceQueue(){
		init(defaultSize);
	}
	public CircleSequenceQueue(int size){
		init(size);
	}
	public void init(int size){
		maxSize=size;
		front=last=0;
		count=0;
		queue=new Object[size];
	}
	@Override
	public void add(Object obj) throws Exception {
		if(count>0&&front==last){
			throw new Exception("The queue is full!");
		}
		queue[last]=obj;
		count++;
		last=(last+1)%maxSize;
	}

	@Override
	public Object delete() throws Exception {
		if(isEmpty()){
			throw new Exception("The queue is empty!");
		}
		Object obj=queue[front];
		front=(front+1)%maxSize;
		count--;
		return obj;
	}

	@Override
	public Object getFront() throws Exception {
		if(!isEmpty()){
			return queue[front];
		}else {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		return count==0;
	}
}
