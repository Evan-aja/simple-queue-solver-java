package tugas_1;

public class QueueArray {
	private static final int initSize=1;
	Object[] learn;
	int[]umur;
	int[]tensi;
	int front,rear,itemCount;
	
	public QueueArray() {
		makeEmpty();
	}
	
	public QueueArray(String nama, int usia, int tensi) {
		enqueue(nama);
		this.usia=usia;
		this.tensi=tensi;
	}
	public boolean isFull() {
		return itemCount==learn.length-1;
	}
	public boolean isEmpty() {
		return itemCount==0;
	}
	public void makeEmpty() {
		learn=new Object[initSize];
		umur = new int[initSize];
		tensi = new int[initSize];
		front=0;
		rear=-1;
		itemCount=0;
	}
	public void arrayDoubling() {
		Object[] tmp=learn;
		learn=new Object[tmp.length*2];
		umur = new int[tmpp.length*2];
		tensi = new int[tmppp.length*2];
		System.arraycopy(tmp, 0, learn, 0, tmp.length);
		System.arraycopy(tmpp, 0, umur, 0, tmpp.length);
		System.arraycopy(tmppp, 0, tensi, 0, tmppp.length);
	}
	public void enqueue(Object x,int usia, int tensi) {
		if(!isFull()) {
			learn[++rear]=x;
			umur[rear]=usia;
			this.tensi[rear]=tensi;
			itemCount++;	
		}else {
			arrayDoubling();
			learn[++rear]=x;
			umur[rear]=usia;
			this.tensi[rear]=tensi;
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
