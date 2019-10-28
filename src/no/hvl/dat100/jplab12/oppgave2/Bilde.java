package no.hvl.dat100.jplab12.oppgave2;

import no.hvl.dat100.jplab12.common.TODO;

public class Bilde extends Tekst {

	// TODO - objekt variable
	private String url;
	
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		super(id, bruker, dato, tekst);
		this.url = url;
	}

	
	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id, bruker, dato, likes, tekst);
		this.url = url;
	}
	
	
	public String getUrl() {
		return url;

	}

	
	public void setUrl(String url) {
		this.url = url;
	}

	
	@Override
	public String toString() {
		//BILDE\n1\nOle Olsen\n23-10-2019\n0\net bilde\nhttp://www.picture.com/oo.jpg\n
		
		String tekst = super.toString();
		return "BILDE" + tekst.substring(5) + url +"\n";

	}

	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		throw new UnsupportedOperationException(TODO.method());
				
	}
}
