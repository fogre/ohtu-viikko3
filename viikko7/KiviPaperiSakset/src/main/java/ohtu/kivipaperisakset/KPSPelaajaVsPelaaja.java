package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends Pelilogiikka {


	    @Override
	    public void teeTokaSiirto() {
		System.out.print("Toisen pelaajan siirto: ");
		tokaSiirto = scanner.nextLine();
	    }
}
