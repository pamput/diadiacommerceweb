package modello;

import java.sql.Date;
import java.util.List;

public class Ordine {
	private String codice = "Not Present";
	private int id = 0;
	private Date data = null;
	private String stato = "chiuso";
	private Cliente cliente = null;
	private List<RigaOrdine> righeOrdine = null;

	//Metodi GET
	public String getCodice() {
		return this.codice;
	}
	
	public Date getData() {
		return this.data;
	}
	
	public int getID(){
		return id;
	}

    public int getId(){
		return id;
	}
	
	public String getStato() {
		return this.stato;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public List<RigaOrdine> getRigheOrdine(){
		return this.righeOrdine;
	}
	
	//Metodi SET
	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public  void setCliente(Cliente cliente) {
		 this.cliente = cliente;
	}
	
	public  void setStato(String stato) {
		 this.stato = stato;
	}
	
	public void setID(int id){
		this.id = id;
	}

    public void setId(int id){
		this.id = id;
	}
	
	public void setRigheOrdine(List<RigaOrdine> righeOrdine){
		this.righeOrdine = righeOrdine;
	}
	
	public void addRigaOrdine(int quantita,Prodotto prodotto){
		RigaOrdine rigaOrdine = new RigaOrdine();
        rigaOrdine.setNumeroRiga(this.getRigheOrdine().size());
        rigaOrdine.setProdotto(prodotto);
        rigaOrdine.setQuantita(quantita);
        this.getRigheOrdine().add(rigaOrdine);
	}

        @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ordine other = (Ordine) obj;
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
        hash = 97 * hash + (this.data != null ? this.data.hashCode() : 0);
        hash = 97 * hash + (this.stato != null ? this.stato.hashCode() : 0);
        hash = 97 * hash + (this.cliente != null ? this.cliente.hashCode() : 0);
        return hash;
    }
}
