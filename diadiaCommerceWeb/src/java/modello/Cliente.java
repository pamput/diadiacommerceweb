package modello;

import java.util.List;

public class Cliente {
	private String codice = "Not Present";
	private String nome = "Not Present";
	private String partitaiva = "Not Present";
	private String indirizzo = "Not Present";
	private List<Ordine> ordini = null;
	private int id = 0;

	//Metodi GET
	public String getCodice() {
		return this.codice;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getID(){
		return this.id;
	}
	
	public String getIndirizzo() {
		return this.indirizzo;
	}

	public String getPartitaiva() {
		return this.partitaiva;
	}
	
	public List<Ordine> getOrdini() {
		return this.ordini;
	}
	
	//Metodi SET
	public void setPartitaiva(String partitaiva) {
		this.partitaiva = partitaiva;
	}
	
	public void setCodice(String codice) {
		this.codice = codice;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public  void setIndirizzo(String indirizzo) {
		 this. indirizzo = indirizzo;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}

	public void addOrdine(Ordine ordine) {
		this.getOrdini().add(ordine);
	}

    @Override
    public String toString(){
        return this.getNome();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.codice != other.codice && (this.codice == null || !this.codice.equals(other.codice))) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.codice != null ? this.codice.hashCode() : 0);
        hash = 29 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 29 * hash + (this.partitaiva != null ? this.partitaiva.hashCode() : 0);
        hash = 29 * hash + (this.indirizzo != null ? this.indirizzo.hashCode() : 0);
        hash = 29 * hash + this.id;
        return hash;
    }
}

