package tugas_1;
import java.util.*;

class masuk{
	QueueArray tunggu=new QueueArray();
	QueueLinkedList antri;
	String nama,antre;
	int usia,tensi;
	static int ukuran;
	public void initUkuran(int ukuran) {
		antri=new QueueLinkedList(ukuran);
	}
	public void baru(String nama, int usia, int tensi) {
		this.nama=nama;
		this.usia=usia;
		this.tensi=tensi;
	}
	public void status() {
		
	}
	public void selesai() {
		
	}
	public void ukuran() {
		
	}
	public void skip() {
		
	}
}

public class Main {
	public static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		masuk learn=new masuk();
		learn.initUkuran(scan.nextInt());
		System.out.println(learn.antri.maxLength);
	}
}
