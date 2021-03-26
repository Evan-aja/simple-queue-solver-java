package tugas_1;
import java.util.*;
import java.io.*;

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
	public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("/dir/milik/anda/tes.txt");
        Scanner inFile = new Scanner(fr);
	//ini tes, bukan final
        while (inFile.hasNext())
        {
            String line = inFile.nextLine();
            System.out.println(line);
        }
        inFile.close();
	}
}
