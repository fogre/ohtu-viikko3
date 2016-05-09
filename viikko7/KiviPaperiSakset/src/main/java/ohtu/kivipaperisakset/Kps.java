package ohtu.kivipaperisakset;

public class Kps{

	private Pelilogiikka peli;

	protected Kps(Pelilogiikka peli){
		this.peli = peli;
	}

	public static Kps pelaaKaksinpeli(){
		return new Kps(new KPSPelaajaVsPelaaja());
	}

	public static Kps pelaaTekoalyaVastaan(){
		return new Kps(new KPSTekoaly());
	}

	public static Kps pelaaParempaaTekoalyaVastaan(){
		return new Kps(new KPSParempiTekoaly());
	}

	public void pelaaKps(){
		this.peli.pelaa();
	}
}
