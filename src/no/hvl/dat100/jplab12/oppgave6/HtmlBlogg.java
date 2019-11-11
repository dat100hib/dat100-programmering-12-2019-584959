package no.hvl.dat100.jplab12.oppgave6;

import no.hvl.dat100.jplab12.oppgave1.Innlegg;
import no.hvl.dat100.jplab12.oppgave3.Blogg;
import no.hvl.dat100.jplab12.common.TODO;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}
	
	private static String HTMLPREFIX = 
			"<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n";
	
	private static String HTMLPOSTFIX = 
			"\t</body>\n</html>";
	
	@Override
	public String toString() {
		String utString = HTMLPREFIX + getAntall() + "\n" ;
		for (Innlegg i : getSamling()) {
			if (i != null) {
				utString += i.toHTML();
			}
		}
		utString += HTMLPOSTFIX;
		return utString;
	}
}
