package modello;

public class Prodotto {
	private String codice = "Not Present";
	private String nome = "Not Present";
	private String descrizione = "Not Present";
	private int prezzo = 0;
	private int id = 0;
    private int quantita = 0;
	
	//Metodi GET
	public String getCodice() {
		return this.codice;
	}

	public String getNome() {
		return this.nome;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

    public int getId(){
		return this.id;
	}
	
	public int getPrezzo(){
		return this.prezzo;
	}

	public int getQuantita(){
		return quantita;
	}
	
	//Metodi SET
	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescrizione(String descrizione) {
		 this.descrizione = descrizione;
	}

	public void setPrezzo(int prezzo){
		 this.prezzo = prezzo;
	}

	public void setId(int id){
		 this.id = id;
	}

	public void setQuantita(int quantita){
		this.quantita = quantita;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prodotto other = (Prodotto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.codice != null ? this.codice.hashCode() : 0);
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.prezzo;
        hash = 97 * hash + this.quantita;
        hash = 97 * hash + (this.descrizione != null ? this.descrizione.hashCode() : 0);
        hash = 97 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString(){
        return getNome() + " (" + getCodice() + ")";
    }
}