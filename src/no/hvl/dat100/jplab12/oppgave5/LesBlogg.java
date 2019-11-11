package no.hvl.dat100.jplab12.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.*;
import no.hvl.dat100.jplab12.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String filnavn) {
		try {
			Scanner filen = new Scanner(new File(MAPPE + filnavn));
			Blogg enBlogg = new Blogg(Integer.parseInt(filen.nextLine()));

			while (filen.hasNextLine()) {
				String type = filen.nextLine();
				int id = Integer.parseInt(filen.nextLine());
				String bruker = filen.nextLine();
				String dato = filen.nextLine();
				int likes = Integer.parseInt(filen.nextLine());
				String tekst = filen.nextLine();
				
				if (type.equals(BILDE)) {
					String url = filen.nextLine();
					Bilde bildeObjekt = new Bilde(id, bruker, dato, likes, tekst, url);
					enBlogg.leggTil(bildeObjekt);
				} else if (type.equals(TEKST)){
					Tekst tekstObjekt = new Tekst(id, bruker, dato, likes, tekst);
					enBlogg.leggTil(tekstObjekt);
				}
			}
			filen.close();
			return enBlogg;
		} catch (FileNotFoundException e) {
			System.out.println("Filen finnes ikke");
			System.err.println(e);
		}
		return new Blogg();
	}
}
