package tugas_1;

public class QueueArray {
	private static final int initSize=1;
	Object[] learn;
	int front,rear,itemCount;
	
	public QueueArray() {
		makeEmpty();
	}
	public boolean isFull() {
		return itemCount==learn.length-1;
	}
	public boolean isEmpty() {
		return itemCount==0;
	}
	public void makeEmpty() {
		learn=new Object[initSize];
		front=0;
		rear=-1;
		itemCount=0;
	}
	public void arrayDoubling() {
		Object[] tmp=learn;
		learn=new Object[tmp.length*2];
		System.arraycopy(tmp, 0, learn, 0, tmp.length);
	}
	public void enqueue(Object x) {
		if(!isFull()) {
			learn[++rear]=x;
			itemCount++;	
		}else {
			arrayDoubling();
			learn[++rear]=x;
			itemCount++;
		}
	}
	public Object dequeue() throws Exception{
		if(!isEmpty()) {
			Object tmp=learn[front];
			for(int i=0;i<itemCount;i++)
				learn[i]=learn[i+1];
			learn[rear--]=null;
			itemCount--;
			return tmp;
		}else {
			throw new Exception("quewe kosong, gada yang keluar");
		}
	}
	public Object peek() throws Exception{
		if(!isEmpty()) {
			return learn[front];
		}else {
			throw new Exception("gaada isinya, mau ngintip apa?");
		}
	}
	public void print() {
		for(int i=0;i<itemCount;i++) {
			System.out.print(learn[i] + " ");
		}
	}
}
