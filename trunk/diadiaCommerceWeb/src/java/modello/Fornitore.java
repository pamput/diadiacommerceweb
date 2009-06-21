package modello;

import java.util.LinkedList;
import java.util.List;

public class Fornitore {
    private String nome = "Not Present";
    private String indirizzo = "Not Present";
    private String telefono = "Not Present";
    protected List<Prodotto> listaProdotti = new LinkedList<Prodotto>();
    private int id = 0;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    public void setListaProdotti(List<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addProdotto(Prodotto prodotto){
        this.getListaProdotti().add(prodotto);
    }

        @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fornitore other = (Fornitore) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 31 * hash + (this.indirizzo != null ? this.indirizzo.hashCode() : 0);
        hash = 31 * hash + (this.telefono != null ? this.telefono.hashCode() : 0);
        hash = 31 * hash + this.id;
        return hash;
    }
}
