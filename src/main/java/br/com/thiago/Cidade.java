package br.com.thiago;

/**
 * Created by thiago on 8/27/18.
 */
public class Cidade {

    private String nome;
    private int ibge;
    private String UF;
    private boolean capital;
    private float longitude;
    private float latitude;
    private String nomeCompleto;
    private String nomeAlternativo;
    private String microregiao;
    private String mesoregiao;

    public Cidade() {
    }

    public Cidade(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIbge() {
        return ibge;
    }

    public void setIbge(int ibge) {
        this.ibge = ibge;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public boolean isCapital() {
        return capital;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getNomeAlternativo() {
        return nomeAlternativo;
    }

    public String getMicroregiao() {
        return microregiao;
    }

    public String getMesoregiao() {
        return mesoregiao;
    }
}
