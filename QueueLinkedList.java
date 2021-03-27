package tugas_1;

public class QueueLinkedList {
	DoublyLinkedList learn=new DoublyLinkedList();
	Listing front,rear;
	int maxLength=0;
	int[] usia ;
	int[]tensi ;
	int index=0;
	
	public QueueLinkedList(int a) {
		this.maxLength=a;
		usia = new int[maxLength];
		tensi = new int[maxLength];
		makeEmpty();
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
			//buat yg lain
			this.usia[index]=usia;
			this.tensi[index]=tensi;
		}else {
			System.out.println("List penuh");
		}
	}
	public Object dequeue() throws Exception{
		if(!isEmpty()){
			Object tmp=front.data;
			learn.removeFirst();
			fhrt();
			//itemlainnya
			if (maxLength==1){
				usia[index]=0;
				tensi[index]=0;
			}else {
				System.arraycopy(usia,1,usia,0,usia.length-1);
				System.arraycopy(tensi,1,tensi,0,usia.length-1);
			}
			index--;
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
	//check prioritas lansia
	public void checkPriority(){
		boolean aktif=false;
		int index=0;
		int temp=0;
		int temp2=0;
		Object nangkepNama=0;//salom
		for (int i =0;i<maxLength; i++){//42 45 60 | salmon salman salom
			if (usia[i]<60){
				aktif = true;
				index = i;
				temp=usia[i];
				temp2=tensi[i];
				nangkepNama = learn.getNamaByIndex(i);
			}
			if (aktif&&usia[i]>=60){//2
				usia[index]=usia[i];
				tensi[index]=tensi[i];
				usia[i]=temp;
				tensi[i]=temp2;
				learn.removeByIndex(i);// hapus salom
				learn.insertBefore(nangkepNama,i-1);// insert sebelum index ke 1
				aktif = false;
				i=-1;
				}
			}
		}
	public void lansiaDarurat(Object x, int usia, int tensi,QueueArray tunggu){
		boolean aktif = false;
		for (int i =0;i< maxLength;i++){//60 24 44 55 43| 60 .. index = 1; salam salem slmon salon
			int temp;					//60 60 24 44 55
			int tempp;
			Object tangkepNama;
			if (this.usia[i]<60){
//				temp = this.usia[i];
//				tempp = this.tensi[i];
				learn.insertByIndex(i+1,x);
				tangkepNama = learn.tail.data;
				learn.removeLast();
				tunggu.enqueue(tangkepNama,maxLength-1,maxLength-1);
				System.arraycopy(this.usia,i,this.usia,i+1,i+1);
				this.usia[i]=usia;
				this.tensi[i] = tensi;
				aktif = true;
				System.out.println("ANTRE "+x+" TUNGGU "+tangkepNama);
				break;
			}
		}
		if (!aktif){
			tunggu.enqueue(x, usia, tensi);
			System.out.println("ANTRE"+x);
		}
	}
}
