package no.hvl.dat100.jplab12.oppgave1;

import no.hvl.dat100.jplab12.common.TODO;

public abstract class Innlegg {
	
	// TODO - deklarering av objektvariable
	private int id;
	private String bruker;
	private String dato;
	private int likes;
	
	
	public Innlegg() {
		
	}
	
	
	public Innlegg(int id, String bruker, String dato) {

		// TODO 
		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		likes = 0;
	}

	
	public Innlegg(int id, String bruker, String dato, int likes) {

		// TODO - START
		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		this.likes = likes;
	}
	
	
	public String getBruker() {
		
		return bruker;
	}

	
	public void setBruker(String bruker) {
		
		this.bruker = bruker;
	}

	
	public String getDato() {

		return dato;	
	}

	
	public void setDato(String dato) {

		this.dato = dato;
	}

	
	public int getId() {

		return id;
	}
	
	
	public void setId(int id) {
		
		this.id = id;
	}

	
	public int getLikes() {

		return likes;
	}
	
	
	public void doLike () {
		
		likes++;
	}
	
	
	public boolean erLik(Innlegg innlegg) {
		boolean erLik = false;
		if (innlegg != null) {
			erLik = id == innlegg.getId();
		}
		return erLik;
	}
	
	
	@Override
	public String toString() {
		//"1\nOle Olsen\n23-10-2019\n7\n"
		
		return ""+getId() + "\n" + getBruker() + "\n" + getDato() + "\n" + getLikes() + "\n";
		
	}
	
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		String utString = "<h2>" + getBruker() + "@" + getDato() + "[" + getLikes() + "]" + "</h2>" + "\n"
						+ "<hr>" + "\n";
		return utString;
				
	}
}
