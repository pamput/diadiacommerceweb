package modello;

public class RigaOrdine {
	private Prodotto prodotto = null;
	private int quantita = 0;
	private int numeroRiga = 0;
	private int id = 0;

	//Metodi GET
	public Prodotto getProdotto () {
		return this.prodotto;
	}
	
	public int getID(){
		return this.id;
	}
	
	public int getQuantita() {
		return this.quantita;
	}

	public int getNumeroRiga() {
		 return this.numeroRiga;
	}
	
	//Metodi SET
	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public void setQuantita(int quantita) {
		 this.quantita = quantita;
	}

	public void setNumeroRiga(int numeroRiga) {
		this.numeroRiga = numeroRiga;
	}

    public String toString(){
        return getProdotto() + " x " + getQuantita();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RigaOrdine other = (RigaOrdine) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.prodotto != null ? this.prodotto.hashCode() : 0);
        hash = 41 * hash + this.quantita;
        hash = 41 * hash + this.numeroRiga;
        hash = 41 * hash + this.id;
        return hash;
    }
}

