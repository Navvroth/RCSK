
public class Sklep{
	private String[] produkty = new String[4];
	private String[] truename = new String[4];	
	private String firma;
	private String pelnafirma;
	private static int x;
	private static int y;
	
	public 			Sklep(String i,String j,String k,String l,String name,int a, int b,String hue){firma =name; produkty[0]=i; produkty[1]=j; produkty[2]=k; produkty[3]=l;x=a;y=b;pelnafirma=hue;}//koństruktor
	public			void fulnam(String a, String b, String c, String d){truename[0]=a;truename[1]=b;truename[2]=c;truename[3]=d;}
	public 			String givefirma() { return firma; }//zwraca nazwę sklepu
	public			String rzeczy(int a){return truename[a];}

	public boolean 	giveprodukt(String name) {
										for(int i=0;i<4;i++){
											if(produkty[i]==name){return true;}
												
												}
													return false;//zwraca czy produkt o podanej nazwie jest w sklepie
												}
	public String 	pelna(String name) {
		for(int i=0;i<4;i++){
			if(produkty[i]==name){return truename[i];}}return"";}
	
	public static int 		produktcen(){return (int )(Math.random() * y+x);}

	public String fullnam(){return pelnafirma;}

};

/*Made by Gerard S. Piotr R. Krzysztof Ć.*/
