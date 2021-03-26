package tugas_1;
import java.util.*;
import java.io.*;

class masuk{
	static QueueArray tunggu=new QueueArray();
	static QueueLinkedList antri;
	String nama,antre;
	int usia,tensi;
	static int ukuran;
	boolean isBolehVaksin; /*buat check this boleh di vaksin atau engga*/
	boolean isLansia;     /*buat check this lansia atau bukan*/


	public void initUkuran(int ukuran) {
		antri=new QueueLinkedList(ukuran);
	}
	public void baru(String nama, int usia, int tensi) {
		this.nama=nama;
		this.usia=usia;
		this.tensi=tensi;
		//manggil boolean buat this.baru nya
		checkIsBolehVaksin();
		checkIsLansia();
	}
	public static String status() {
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
				Listing currentNode = masuk.antri.front;
				while(currentNode!=null){
					daftarAntre+=currentNode.data.nama+" "+currentNode.data.isLansia+" "+currentNode.data.tensi+" ";
					currentNode=currentNode.next;
				}
			}
			String daftarTunggu = "DAFTAR_TUNGGU ";
			
			if(masuk.tunggu.isEmpty()){
				daftarTunggu+="-";
			}
			else{
				for(int i =0;i<masuk.tunggu.itemCount+1;i++){
					daftarTunggu+=masuk.tunggu.learn[i].nama+" "+masuk.tunggu.learn[i].isLansia+" "+masuk.tunggu.learn[i].tensi+" ";
				}
			}
			return daftarAntre+"\n"+daftarTunggu;
	
	
		}
	public void selesai(int N) {//ini tolong diubah jadi selesai(String nama)
		/*
		Menghapus (selesai memvaksin) sebanyak N penerima vaksin di
		Ruang Antre sesuai urutan. Misalnya N=2, maka selesai memvaksin
		2 orang pertama yang ada di antrean.
		 */

		//init buat ngapus array
		if (!antri.isEmpty()) {
			for (int i = 0; i < N; i++) {
// 				manggil QueueArray
// 				trus diapus ampe < N
// 				panggil methodnya..
// 				...
				antri.dequeue();
				System.out.println();//print klo dah keluar
				//"SELESAI_VAKSIN+" "+this.name+" "+...
			}
		}else{
			System.out.println("ANTRE KOSONG");
		}
	}
	public void ukuran(int ukuran) {

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
		return "ANTRE"+" "+this.nama+" "+tulisanLansia()+" "+tulisanTensi();
	}
	public String tungguPasien(){
		return "TUNGGU"+" "+this.nama+" "+tulisanLansia()+" "+tulisanTensi();
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
		masuk learn=new masuk();
        FileReader fr = new FileReader("/direktori/file/yang/di/test/tes.txt");
        Scanner inFile = new Scanner(fr);
        while (inFile.hasNext())
        {
            String line = inFile.nextLine();
            if(line.length()<4) {
            	int a=Integer.parseInt(line);
            	learn.initUkuran(a);
            }else {
            	String[] words = line.trim().split(" ");
            	if(words[0].equalsIgnoreCase("Baru")) {
            		String nama=words[1];
                	int usia=Integer.parseInt(words[2]);
                	int tensi=Integer.parseInt(words[3]);
                	learn.baru(nama, usia, tensi);
            	}else if(words[0].equalsIgnoreCase("status")) {
            		learn.status();
            	}else if(words[0].equalsIgnoreCase("selesai")) {
            		String nama=words[1];
            		learn.selesai(nama);
            	}else if(words[0].equalsIgnoreCase("ukuran")) {
            		int ukuran=Integer.parseInt(words[1]);
            		learn.ukuran(ukuran);
            	}else if(words[0].equalsIgnoreCase("skip")) {
            		String nama=words[1];
            		learn.skip(nama);
            	}
            }
        }
        inFile.close();
	}
}
