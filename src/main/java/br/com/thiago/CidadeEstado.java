package br.com.thiago;

/**
 * Created by thiago on 8/27/18.
 */
public class CidadeEstado {
    private String estado;
    private int total;

    public CidadeEstado(int qtd, String uf) {
        this.estado = uf;
        this.total=qtd;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
