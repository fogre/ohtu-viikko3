package ohtu.kivipaperisakset;


import java.util.Scanner;

public class Lukija{

	private static final Scanner scanner = new Scanner(System.in);;
	private Kps pelimuoto;

	public boolean play(){
	    String vastaus = scanner.nextLine();
	    if (vastaus.equals("a")) {
		pelimuoto = Kps.pelaaKaksinpeli();
	    } else if (vastaus.equals("b")) {
		pelimuoto = Kps.pelaaTekoalyaVastaan();
	    } else if (vastaus.equals("c")) {
		pelimuoto = Kps.pelaaParempaaTekoalyaVastaan();
	    } else {
		return false;
	    }
	    pelimuoto.pelaaKps();
	    return true;

	}


}
