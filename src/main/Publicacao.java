package main;

import java.util.Date;
import java.util.Objects;

public class Publicacao {

    private Date data;
    private String evento;
    private String processo;
    private String texto;

    public Publicacao(Date data, String processo, String evento, String texto) {
        this.data = data;
        this.processo = processo;
        this.evento = evento;
        this.texto = texto;
    }

    public Publicacao(String processo, String evento, String texto) {
        this.processo = processo;
        this.evento = evento;
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publicacao)) return false;
        Publicacao that = (Publicacao) o;
        return Objects.equals(getEvento(), that.getEvento()) && Objects.equals(getProcesso(), that.getProcesso()) && Objects.equals(getTexto(), that.getTexto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEvento(), getProcesso(), getTexto());
    }
}
