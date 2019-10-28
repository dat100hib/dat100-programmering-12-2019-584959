package no.hvl.dat100.jplab12.oppgave3;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.Bilde;
import no.hvl.dat100.jplab12.oppgave2.Tekst;

public class Blogg {

	// TODO: objektvariable 
	Innlegg[] innleggtabell;
	int nesteledig;

	public Blogg() {
		this.innleggtabell =  new Innlegg[20];
		this.nesteledig = 0;
	}

	
	public Blogg(int lengde) {
		this.innleggtabell =  new Innlegg[lengde];
		this.nesteledig = 0;
	}

	
	public int getAntall() {
		int antall = 0;
		for (Innlegg i : innleggtabell) {
			if (i != null) {
				antall++;
			}
		}
		return antall;
	}
	
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	
	public int finnInnlegg(Innlegg innlegg) {
		int index = -1;
		for (Innlegg i : innleggtabell) {
			if (innlegg.erLik(i)) {
				index = i.getId();
				break;
			}
		}
		return index;
	}

	
	public boolean finnes(Innlegg innlegg) {
		boolean finnes = false;
		for (Innlegg i : innleggtabell) {
			if (innlegg.erLik(i)) {
				finnes = true;
				break;
			}
		}
		return finnes;
	}

	
	public boolean ledigPlass() {
		boolean ledig = false;
		for (Innlegg i : innleggtabell) {
			if (i == null) {
				ledig = true;
				break;
			}
		}
		return ledig;
	}
	
	
	public boolean leggTil(Innlegg innlegg) {
		boolean leggTil = false;
		if (!ledigPlass() || finnes(innlegg)) {
			return leggTil;
		}
		innleggtabell[nesteledig] = innlegg;
		leggTil = true;
		nesteledig++;
//		for (Innlegg i : innleggtabell) {
//			if (i == null) {
//				i = innlegg;
//				leggTil = true;
//				break;
//			}
//		}
		return leggTil;
	}
	
	
	public String toString() {
		//2\nTEKST\n1\nOle Olsen\n23-10-2019\n0\nen tekst\nBILDE\n2\nOline Olsen\n24-10-2019\n0\net bilde\nhttp://www.picture.com/oo.jpg\n
		String utString = "" + innleggtabell.length + "\n";
		for (Innlegg i : innleggtabell) {
			utString += i.toString();
		}
		return utString;
	}

	// valgfrie oppgaver nedenfor
	
	
	public void utvid() {
		Innlegg[] ny = new Innlegg[innleggtabell.length * 2];
		for (int i = 0; i < innleggtabell.length; i++) {
			ny[i] = innleggtabell[i];
		}
		innleggtabell = ny;
	}
	
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		boolean lagtTil = leggTil(innlegg);
		leggTil(innlegg);
		
		if (!lagtTil && !finnes(innlegg)) {
			utvid();
			leggTil(innlegg);
		}
		return lagtTil;
	}
	
	
	public boolean slett(Innlegg innlegg) {
		boolean slettet = false;
		
		if (finnes(innlegg)) {
			Innlegg[] ny = new Innlegg[innleggtabell.length-1];
			
			for (int i = 0, k = 0; i < innleggtabell.length; i++) {
				if(!innleggtabell[i].erLik(innlegg)) {
					ny[k++] = innleggtabell[i];
				}
			}
			
			innleggtabell = ny;
			slettet = true;
		}
		return slettet;
	}
	
	
	public int[] search(String keyword) {
		int[] id = new int[innleggtabell.length];
		int index = 0;
		for (Innlegg i : innleggtabell) {
			if (i.toString().contains(keyword)) {
				id[index++] = i.getId();
			}
		}
		
		int[] nyId = new int[index+1];
		for (int i = 0; i < nyId.length; i++) {
			nyId[i] = id[i];
		}
		return nyId;
	}
}