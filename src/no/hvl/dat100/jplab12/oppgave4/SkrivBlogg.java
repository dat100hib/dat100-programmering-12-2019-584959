package no.hvl.dat100.jplab12.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab12.oppgave3.*;
import no.hvl.dat100.jplab12.common.TODO;

public class SkrivBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	public static boolean skriv(Blogg samling, String filnavn) {
		boolean skrevet = false;
		try {
			PrintWriter skriver = new PrintWriter(filnavn);
			skriver.toString();
//			String[] linjer = Blogg.class.getMethods().toString().split("\n");
////			String[] linjer = samling.toString().split("\n");
//			for (String i : linjer) {
//				skriver.println(i);
//			}
			skriver.close();
			skrevet = true;
		} catch (FileNotFoundException e) {
			System.out.println("Filen finnes ikke");
		}
		return skrevet;
	}
}
