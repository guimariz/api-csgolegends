package com.csgolegends.api.model;


import javax.persistence.*;

@Entity
@Table(name = "proplayer")
public class ProPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nomeJogador")
    private String nomeJogador;

    @Column(name = "fotoJogador")
    private String fotoJogador;

    @Column(name = "timeJogador")
    private String timeJogador;

    @Column(name = "kdJogador")
    private String kdJopgador;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public String getFotoJogador() {
        return fotoJogador;
    }

    public void setFotoJogador(String fotoJogador) {
        this.fotoJogador = fotoJogador;
    }

    public String getTimeJogador() {
        return timeJogador;
    }

    public void setTimeJogador(String timeJogador) {
        this.timeJogador = timeJogador;
    }

    public String getKdJopgador() {
        return kdJopgador;
    }

    public void setKdJopgador(String kdJopgador) {
        this.kdJopgador = kdJopgador;
    }
}
