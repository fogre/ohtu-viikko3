package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class Pelilogiikka{

	public static final Scanner scanner = new Scanner(System.in);
	public String ekaSiirto, tokaSiirto;
	public Tuomari tuomari;

	public void pelaa(){
		pelinAlustus();
		while (onkoOkSiirto(ekaSiirto) && onkoOkSiirto(tokaSiirto)) {
		  tuomioi();
		  teeEkaSiirto();
		  teeTokaSiirto();
		}
		pelinLopetus();
	}


	private void pelinAlustus(){
		tuomari = new Tuomari();
		teeEkaSiirto();
		teeTokaSiirto();
	}

	private void tuomioi() {
		tuomari.kirjaaSiirto(ekaSiirto, tokaSiirto);
		System.out.println(tuomari);
		System.out.println();
	}


	public void teeEkaSiirto(){
		 System.out.print("Ensimmäisen pelaajan siirto: ");
		 ekaSiirto = scanner.nextLine(); 
	}


	private void pelinLopetus(){
		System.out.println();
		System.out.println("Kiitos!");
		System.out.println(tuomari);
	}

	public abstract void teeTokaSiirto();


    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
