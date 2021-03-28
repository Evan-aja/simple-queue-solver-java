package tugas_1;
import java.util.*;
import java.io.*;

class masuk{
	static QueueArray tunggu;
	static QueueLinkedList antri;
	static int ukuran;
	String nama;
	int usia, tensi;

	masuk(){
		/*ini buat invoke QueueArray biar ga null
		ntar eror soalnya klo ga di set
	 	*/
		tunggu = new QueueArray();
	}
	public void initUkuran(int ukuran) {
		antri=new QueueLinkedList(ukuran);
	}
	public void baru(String nama, int usia, int tensi) {
		this.nama=nama;
		this.usia=usia;
		this.tensi=tensi;

		//buat cek masuk ke baris mana
		if (!checkIsBolehVaksin()){
			System.out.println(tolakPasien());
		}else if (antri.learn.size!=antri.maxLength){
			antri.enqueue(this.nama,this.usia,this.tensi);
			System.out.println(antrePasien()); //45 42 | 60
			antri.checkPriority();
		}else if (this.usia>=60){
			antri.lansiaDarurat(this.nama,this.usia,this.tensi,tunggu);
		}else{
			tunggu.enqueue(this.nama,this.usia,this.tensi);
			System.out.println(tungguPasien());
		}
	}		
	public void status() {
		// CONTOH RETURN
			//DAFTAR_ANTRE Ana^BUKAN_LANSIA^110 Caca^BUKAN_LANSIA^140
			// DAFTAR_TUNGGU Dodo^BUKAN_LANSIA^120	
		// KASUS KOSONG
			// Jika Queue (Ruang Antre atau Daftar Tunggu) kosong, cukup
			// cetak "-" . Contoh:
			// DAFTAR_ ANTRE <spasi> -
			// DAFTAR_TUNGGU <spasi> -
			String daftarAntre = "DAFTAR_ANTRE ";
			if(masuk.antri.isEmpty()){
				daftarAntre+="-";
			}
			else{
				for(int i = 0; i<antri.index;i++){
					daftarAntre+=antri.learn.getNamaByIndex(i)+"^"+(antri.usia[i]>=60?"LANSIA":"BUKAN_LANSIA")+"^"+antri.tensi[i]+" ";
				}
			}
			String daftarTunggu = "DAFTAR_TUNGGU ";
			
			if(masuk.tunggu.isEmpty()){
				daftarTunggu+="-";
			}
			else{
				for(int i =0;i<masuk.tunggu.itemCount;i++){
					daftarTunggu+=tunggu.learn[i]+"^"+(tunggu.umur[i]>=60?"LANSIA":"BUKAN_LANSIA")+"^"+tunggu.tensi[i]+" ";
				}
			}
			System.out.println(daftarAntre+"\n"+daftarTunggu) ;
	
	
		}
		public void selesai(int N) throws Exception {

		//init buat ngapus array
// 			manggil QueueArray
// 			trus diapus ampe < N
// 			panggil methodnya..
// 			...
		//"SELESAI_VAKSIN+" "+this.name+" "+...
		if (!antri.isEmpty()) {
			for (int i = 0; i < N; i++) {
				System.out.print(" "+antri.learn.head.data);
				antri.dequeue();
			}
			while (antri.checkBangkuKosong()){
				antri.bangkuKosong();
			}
		}else{
			System.out.println("ANTRE KOSONG");
		}
		System.out.println();
	}
	//buat STRING_NAMA
	public void selesai(String  x) {
		System.out.println("SELESAI_NAMA");
		if (!antri.isEmpty()) {
// 			manggil QueueArray
// 			ampe namanya sama
			antri.selesaiByNama(x);
			antri.checkBangkuKosong();
			System.out.print(" "+x);//print klo dah keluar
		}else{
			System.out.println("ANTRE KOSONG");
		}
	}
	
	public void ukuran(int ukuran) {
		System.out.println("SUKSES UBAH " + antri.maxLength + " " + ukuran);
		if (antri.maxLength<ukuran){
			antri.maxLength=ukuran;
			antri.arrayDoubling(antri.maxLength);
		}else {
			antri.maxLength=ukuran;
			antri.arrayDecreasing(antri.maxLength);
		}
	}
	public void skip(String nama) {

	}
// 	check kondisi orang yang masuk
// 	pertama boleh vaksn atau engga
// 	kedua lansia atau engga
	
	public boolean checkIsBolehVaksin(){
		return this.tensi<180;
	}
	public boolean checkIsLansia(){
		return this.usia>=60;
	}
// 	String buat tulisan2
// 	pertama tulisan vaksin
// 	kedua tulisan lansia
// 	ketiga tulisan pasien ditolak
// 	keempat tulisan pasien antri
// 	kelima tulisan pasien tunggu
	
	public String tulisanTensi(){
		return (this.checkIsBolehVaksin() ? "TENSI_BOLEH_DIVAKSIN":"TENSI_TIDAKBOLEH_DIVAKSIN");
	}
	public String tulisanLansia(){
		return (this.checkIsLansia()?"LANSIA":"BUKAN_LANSIA");
	}
	public String tolakPasien(){
		return "TOLAK"+" "+this.nama+" "+tulisanLansia()+" "+tulisanTensi();
	}
	public String antrePasien(){
		return "ANTRE"+" "+this.nama;
	}
	public String tungguPasien(){
		return "TUNGGU"+" "+this.nama;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		masuk learn=new masuk();
        FileReader fr = new FileReader("../ASD/src/tugas_1/tes.txt");
        Scanner inFile = new Scanner(fr);
        while (inFile.hasNext())
        {
            String line = inFile.nextLine();
            String[] words = line.trim().split(" ");
            if(words[0].length()<=3) {
            	int ukuran=Integer.parseInt(words[0]);
            	learn.initUkuran(ukuran);
            }else if(words[0].equalsIgnoreCase("Baru")) {
            	String nama=words[1];
               	int usia=Integer.parseInt(words[2]);
               	int tensi=Integer.parseInt(words[3]);
               	learn.baru(nama, usia, tensi);
            }else if(words[0].equalsIgnoreCase("status")) {
            	learn.status();
            }else if(words[0].equalsIgnoreCase("selesai")) {
            	if(words[1].length()<=2) {
            		int index=Integer.parseInt(words[1]);
			System.out.print("SELESAI_VAKSIN");	
            		try{
			   for (int i =0;i<index;i++){
				learn.selesai(index);
			   }
            		}catch(Exception e) {
            			System.err.println(e.getMessage());
            		}
            	}else if(words[1].length()>=3) {
            		String nama=words[1];
            		learn.selesai(nama);
            	}
            }else if(words[0].equalsIgnoreCase("ukuran")) {
            	int ukuran=Integer.parseInt(words[1]);
            	learn.ukuran(ukuran);
            }else if(words[0].equalsIgnoreCase("skip")) {
            	String nama=words[1];
            	learn.skip(nama);
            }
        }
        inFile.close();
	}
}
