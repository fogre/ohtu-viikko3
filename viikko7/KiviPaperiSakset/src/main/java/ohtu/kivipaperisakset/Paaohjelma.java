package ohtu.kivipaperisakset;



public class Paaohjelma {

    public static void main(String[] args) {

	Lukija lukija = new Lukija();

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

	if(!lukija.play()) break;

        }

    }
}
