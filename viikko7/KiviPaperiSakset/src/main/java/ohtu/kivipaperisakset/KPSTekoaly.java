package ohtu.kivipaperisakset;

public class KPSTekoaly extends Pelilogiikka {

	public Tekoaly tekoaly = new Tekoaly();

	    @Override
	    public void teeTokaSiirto() {
		tokaSiirto = tekoaly.annaSiirto();
		System.out.println("Tietokone valitsi: " + tokaSiirto);
		tekoaly.asetaSiirto(ekaSiirto);
	    }
}
