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
				Node currentNode = masuk.antri.front;
				while(currentNode!=null){
					daftarAntre+=currentNode.nama+"^"+currentNode.isLansia+"^"+currentNode.tensi+" ";
					currentNode=currentNode.next;
				}
			}
			String daftarTunggu = "DAFTAR_TUNGGU ";
			
			if(masuk.tunggu.isEmpty()){
				daftarTunggu+="-";
			}
			else{
				for(int i =0;i<masuk.tunggu.itemCount+1;i++){
					daftarTunggu+=masuk.tunggu.learn[i].nama+"^"+masuk.tunggu.learn[i].isLansia+"^"+masuk.tunggu.learn[i].tensi+" ";
				}
			}
			return daftarAntre+"\n"+daftarTunggu;
	
	
		}
	public void selesai() {

	}
	public void ukuran() {

	}
	public void skip() {

	}
	/*check kondisi orang yang masuk
	pertama boleh vaksn atau engga
	kedua lansia atau engga
	 */
	public boolean checkIsBolehVaksin(){
		return this.tensi<180;
	}
	public boolean checkIsLansia(){
		return this.usia>=60;
	}
	/*String buat tulisan2
	pertama tulisan vaksin
	kedua tulisan lansia
	ketiga tulisan pasien ditolak
	keempat tulisan pasien antri
	kelima tulisan pasien tunggu
	 */
	public String tulisanTensi(){
		return (this.isBolehVaksin ? "TENSI_BOLEH_DIVAKSIN":"TENSI_TIDAKBOLEH_DIVAKSIN");
	}
	public String tulisanLansia(){
		return (this.isLansia?"LANSIA":"BUKAN_LANSIA");
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
	public static void main(String[] args) {
		//this is for testing on your own computer
		FileReader fr = new FileReader("/dir/milik/anda/tes.txt");
        	Scanner inFile = new Scanner(fr);
        	while (inFile.hasNext())
	        {
	            String line = inFile.nextLine();
	            System.out.println(line);
	        }
	        inFile.close();
	}
}
