package other;

/**
 * Created by matt on 4/25/16.
 */
//队列接口
public interface Queue {
	//入队
	public void add(Object obj) throws Exception;

	//出队
	public Object delete() throws Exception;

	//获得队头元素
	public Object getFront() throws Exception;

	//判断对列是否为空
	public boolean isEmpty();
}
