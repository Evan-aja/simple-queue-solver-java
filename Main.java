package tugas_1;
import java.util.*;

class masuk{
	QueueArray tunggu=new QueueArray();
	QueueLinkedList antri;
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
	public void status() {
		//asfafuyiasihfisadfish
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
	public static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		masuk learn=new masuk();
		learn.initUkuran(scan.nextInt());
		System.out.println(learn.antri.maxLength);
	}
}
