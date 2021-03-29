package tugas_1;

public class QueueLinkedList {
	tugas_1.DoublyLinkedList learn=new DoublyLinkedList();
	int maxLength=0;
	int[] usia ;
	int[]tensi ;
	int index=0;
	tugas_1.Listing front,rear;
	
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
	public void enqueue(Object x, int usia,int tensi) {
		if(learn.size<=maxLength) {
			learn.addLast(x);
			fhrt();
			//buat yg lain
			this.usia[index]=usia;
			this.tensi[index]=tensi;
			index++;
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
	public void arrayDoubling(int x){
		int[] oldUsia = usia;
		int[] oldTensi = tensi;
		usia = new int[x];
		tensi = new int[x];
		System.arraycopy(oldUsia,0,usia,0,oldUsia.length);
		System.arraycopy(oldTensi,0,tensi,0,oldTensi.length);
		while (index<maxLength) {//2 4 | 423414  4ilang,2ilang,3ilang tunggu = 414  2slot jdi 5 == 2,4,4,2,3
			usia[index] = masuk.tunggu.umur[0];
			tensi[index] = masuk.tunggu.tensi[0];
			try {
				learn.addLast(masuk.tunggu.dequeue());
			} catch (Exception e) {
				e.printStackTrace();
			}
			index++;
		}
	}
	public void arrayDecreasing(int x){
		int[] oldUsia = usia;
		int[] oldTensi = tensi;
		int minus=0;
		while (index>maxLength) {// 5 4 3 1 | 2 1 dari 4 jadi 2 -> 5 4 | 2 1 3 1
			masuk.tunggu.enqueue(learn.removeLast(),usia[index-1],tensi[index-1]);
			index--;
			minus++;
		}
		usia = new int[x];
		tensi = new int[x];
		System.arraycopy(oldUsia,0,usia,0,oldUsia.length-minus);
		System.arraycopy(oldTensi,0,tensi,0,oldTensi.length-minus);
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
				tangkepNama = learn.removeLast();
				tunggu.enqueue(tangkepNama,this.usia[maxLength-1],this.tensi[maxLength-1]);
				System.arraycopy(this.usia,i,this.usia,i+1,i+1);
				System.arraycopy(this.tensi,i,this.tensi,i+1,i+1);
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
	public boolean checkBangkuKosong(){
		return index<maxLength;
	}
	public void bangkuKosong() throws Exception {
		int umur,tensi;
		umur = masuk.tunggu.umur[0];
		tensi = masuk.tunggu.tensi[0];
		masuk.antri.enqueue(masuk.tunggu.dequeue(),umur,tensi);
	}
	public Object selesaiByNama(String x){
		Listing p = learn.head;
		int i =0;
		while (p!=null){
			if (p.data.equals(x)){
				break;
			}
			i++;
			p=p.next;
		}
		if (p != null) {// 13 45 66
			System.arraycopy(usia,i+1,usia,i,usia.length-(1+i));
			System.arraycopy(tensi,i+1,tensi,i,tensi.length-(1+i));
			learn.removeByIndex(i);
			index--;
			return p.data;
		}
		return null;
	}
	public void skip(String nama) throws Exception {
		Listing p = learn.head;
		int i =0;
		while (p!=null){
			if (p.data.equals(nama)){
				break;
			}
			i++;
			p=p.next;
		}
		if (p != null) {
			masuk.tunggu.enqueue(p.data,usia[i],tensi[i]);
			learn.removeByIndex(i);
			System.arraycopy(usia,i+1,usia,i,usia.length-(1+i));
			System.arraycopy(tensi,i+1,tensi,i,tensi.length-(1+i));
			//angka 6 7 8 | 1 2
			this.usia[i] = masuk.tunggu.umur[0];
			tensi[i] = masuk.tunggu.tensi[0];
			learn.addLast(masuk.tunggu.dequeue());

		}
	}
}
