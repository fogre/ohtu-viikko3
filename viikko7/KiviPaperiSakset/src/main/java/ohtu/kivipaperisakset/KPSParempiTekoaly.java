package ohtu.kivipaperisakset;


// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends Pelilogiikka {

	public TekoalyParannettu tekoaly = new TekoalyParannettu(20);

	    @Override
	    public void teeTokaSiirto() {
		tokaSiirto = tekoaly.annaSiirto();
		System.out.println("Tietokone valitsi: " + tokaSiirto);
		tekoaly.asetaSiirto(ekaSiirto);
	    }
}
