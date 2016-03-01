import java.util.Scanner;

public class main {

	private static Scanner odczyt;

	public static void main(String[] args) {
		

	Sklep[] mapa = new Sklep[4];
	mapa[0]= new Sklep("jabl","mang","pomara","kiwi","owoc",1,4,"Owoce");
	mapa[1]= new Sklep("march","sele","papr","cebu","warzyw",2,7,"Warzywa");
	mapa[2]= new Sklep("cukie","liz","ciast","zelk","slodycz",3,5,"Slodycze");
	mapa[3]= new Sklep("mydl","prosz","szamp","bals","chem",7,20,"Chemia");
	
	mapa[0].fulnam("jablko", "mango", "pomarancz", "kiwi");
	mapa[1].fulnam("marchew", "seler", "papryka", "cebula");
	mapa[2].fulnam("cukierek", "lizak", "ciastka", "zelki");
	mapa[3].fulnam("mydlo", "proszek", "szampon", "balsam");
	
	String[] slownik = new String[16];
	slownik[0]="jabl";
	slownik[1]="mang";
	slownik[2]="pomara";
	slownik[3]="kiwi";
	slownik[4]="march";
	slownik[5]="sele";
	slownik[6]="papr";
	slownik[7]="cebu";
	slownik[8]="cukie";
	slownik[9]="liz";
	slownik[10]="ciast";
	slownik[11]="zelk";
	slownik[12]="mydl";
	slownik[13]="prosz";
	slownik[14]="szamp";
	slownik[15]="bals";
	
	String[] slowniks = new String[4];
	slowniks[0]="owoc";
	slowniks[1]="warzyw";
	slowniks[2]="slodycz";
	slowniks[3]="chem";
	
	String[] necron = new String[5];
	necron[0]="glup";
	necron[1]="debil";
	necron[2]="szlag";
	necron[3]="zabi";
	necron[4]="fraje";
	
	int[] 	 flagi= new int[10];//0-przywitanie 1-brzydkie slowa 2-kontrolna 3-kontorlna 4-napad
	for(int i=0;i<10;i++){flagi[i]=0;}

	String[] koszyk = new String[5];
	int[] 	 koszykb= new int[5];
	int plc=0;
	String polecenie="";

	String szukany_produkt="";
	String szukany_dzial="";

	
	while(polecenie.contains("koniec")==false&&polecenie.contains("papa")==false&&polecenie.contains("do zobaczenia")==false){
	odczyt = new Scanner(System.in);
	polecenie=odczyt.nextLine();
	for(int i=0;i<16;i++){
		if(polecenie.contains(slownik[i])==true){szukany_produkt=slownik[i];}//produkty
		}
	
	for(int i=0;i<4;i++){
		if(polecenie.contains(slowniks[i])==true){szukany_dzial=slowniks[i];}//dzialy
		}
	
	for(int i=0;i<5;i++){
		if(polecenie.contains(necron[i])==true){flagi[1]=1;}//brzydkie slowa
		}
	if (polecenie.contains("czesc")==true) {if(flagi[0]==1){System.out.println("juz sie witalismy");}else{ System.out.println("czesc");flagi[0]=1;}}// witanie sie
	
	if(polecenie.contains("napad")==true){System.out.println("o nie, wez nasze wszystkie pieniadze tylko nas nie formatuj");polecenie="koniec";flagi[4]=1;}
	
	if ((polecenie.contains("gdzie")==true)) {//szuka gdzie jest dany produkt
		for (int i = 0; i < 4; i++) {
			if (mapa[i].giveprodukt(szukany_produkt) == true) {	
				System.out.print("szukany przez ciebie produkt jest w dziale ");
				System.out.println(mapa[i].fullnam());
				flagi[3]=1;
			}
		}if(flagi[3]!=1)System.out.print("przykro nam ale nie mamy tego produktu w sklepie ;(");
		flagi[3]=1;
	}
	if ((polecenie.contains("dzial")==true)) {//co jest w danym dziale
		for (int i = 0; i < 4; i++) {
			if (mapa[i].givefirma() == szukany_dzial) {	
				System.out.println("produkty jakie mozesz znalezc w dziale ktory cie interesuje to:  ");
				for (int j = 0; j < 4; j++) {System.out.println(mapa[i].rzeczy(j));}
			}
		}
	}
	
	if (polecenie.contains("kup")==true) {//idzie i wklada do koszyka konkretny produkt  //wpierw szuka gdzie i czy jest produkt potem go wklada do koszyka
		for (int i = 0; i < 4; i++) {
			if (mapa[i].giveprodukt(szukany_produkt) == true) {
				if(plc<5){
					koszyk[plc]=mapa[i].pelna(szukany_produkt);
					koszykb[plc]=Sklep.produktcen();
					plc++;
					System.out.println("dodalismy "+mapa[i].pelna(szukany_produkt)+" do twojego koszyka");
					flagi[2]=1;}else{System.out.println("przykro mi ale twoj koszyk jest pelen, musisz isc do kasy");}
			}
			}
		if(flagi[2]!=1){System.out.println("przykro nam ale tego czego szukasz nie ma w naszym sklepie");}
		flagi[2]=1;
		}
	
	if (polecenie.contains("co mam")==true) {	
		System.out.println("Twoje produkty w koszyku to:");
	int k=0;
	for (int i = 0; i < 5; i++) {
		if(koszyk[i]!=null){
		System.out.println(koszyk[i]+"  "+koszykb[i]);
		k=k+koszykb[i];}
	}
	}
	/*if(polecenie.contains("odloz")){
		for(int i=0;i<5;i++){
			if(koszyk[i].contains(szukany_produkt)==true){
			koszyk[i]="";
			koszykb[i]=0;
			}
		}
	}*/
	if (polecenie.contains("idz do kas")==true) {//idzie i wklada do koszyka konkretny produkt  //wpierw szuka gdzie i czy jest produkt potem go wklada do koszyka
		System.out.println("Twoje produkty to:");
		int k=0;
			for (int i = 0; i < 5; i++) {
				if(koszyk[i]!=null){
				System.out.println(koszyk[i]+"  "+koszykb[i]);
				k=k+koszykb[i];}
			}
		System.out.println("lacznie musisz zaplacic "+k);
		System.out.println("chcesz zaplacic karta czy gotowka?");
		polecenie=odczyt.nextLine();
		if(polecenie.contains("gotowka")==true){System.out.println("włoz pieniadze do stacji dyskietek ");System.out.println("ERROR nie wykryto stacji dyskietek, nikomu o tym nie mow");}
		if(polecenie.contains("karta")==true){System.out.println("wloz karte do wejscia dyskietek i podaj pin");		polecenie=odczyt.nextLine(); System.out.println("dziekujemy za dokonanie zakupow");}
		
	}
	

	if(polecenie==null){System.out.println("co ty taki mało rozmowny?");}
	}
	if(flagi[1]!=1&&flagi[4]!=1){System.out.println("dziękujemu za używanie naszego systemu do widzenia");}
	if(flagi[4]==1){System.out.println("oto twoje pieniadze, cale "+((int )Math.random() * 10000+420)+"zlotych");}
	if(flagi[1]==1&&flagi[4]!=1){System.out.println("dziękujemu za wspolprace chamie");}
	
	System.out.println("system stwozony przez Piotr Ryzy, Gerard Smetek oraz Krzysztof Cwiertnia");
}
}


/* made by Gerard S. Piotr R. Krzysztof Ć.*/
