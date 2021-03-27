package tugas_1;

public class QueueLinkedList {
	DoublyLinkedList learn=new DoublyLinkedList();
	int maxLength=0,usia,tensi;
	Listing front,rear;
	String nama;
	
	public QueueLinkedList(int a) {
		this.maxLength=a;
		makeEmpty();
	}
	public QueueLinkedList(String nama,int usia, int tensi) {
		enqueue(nama);
		this.usia=usia;
		this.tensi=tensi;
	}
	public void makeEmpty() {
		learn.makeEmpty();
		fhrt();
	}
	public void fhrt() {
		front=learn.head;
		rear=learn.tail;
	}
	public boolean isEmpty() {
		return learn.isEmpty();
	}
	public void enqueue(Object x) {
		if(learn.size<=maxLength) {
			learn.addLast(x);
			fhrt();
		}else {
			System.out.println("List penuh");
		}
	}
	public Object dequeue() throws Exception{
		if(!isEmpty()){
			Object tmp=front.data;
			learn.removeFirst();
			fhrt();
			return tmp;
		}else {
			throw new Exception("List kosong");
		}
	}
	public Object peek() throws Exception{
		if(!isEmpty()){
			return front.data;
		}else {
			throw new Exception("List kosong");
		}
	}
	public void print() {
		learn.printToTail();
	}
}
