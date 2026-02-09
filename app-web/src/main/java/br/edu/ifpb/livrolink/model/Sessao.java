package br.edu.ifpb.livrolink.model;

public class Sessao {
    private int idSessao;
    private String generoSessao;
    private int quantidadeDeLivrosGenero;

    public int getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    public String getGeneroSessao() {
        return generoSessao;
    }

    public void setGeneroSessao(String generoSessao) {
        this.generoSessao = generoSessao;
    }

    public int getQuantidadeDeLivrosGenero() {
        return  quantidadeDeLivrosGenero;
    }

    public void setQuantidadeDeLivrosGenero(int quantidadeDeLivrosGenero) {
        this.quantidadeDeLivrosGenero = quantidadeDeLivrosGenero;
    }
}
