package br.edu.ifpb.livrolink.model;

public class Livro {
    private int codLivro;
    private String nomeDoLivro;
    private String generoDoLivro;
    private String autorDoLivro;
    private String editoraDoLivro;
    private Boolean ocupado;
    private Integer idUsuario;
    private int idSessao;

    public int getCodLivro() {
        return codLivro;
    }

    public void setCodLivro(int codLivro) {
        this.codLivro = codLivro;
    }

    public String getNomeDoLivro() {
        return nomeDoLivro;
    }

    public void setNomeDoLivro(String nomeDoLivro) {
        this.nomeDoLivro = nomeDoLivro;
    }

    public String getGeneroDoLivro() {
        return generoDoLivro;
    }

    public void setGeneroDoLivro(String generoDoLivro) {
        this.generoDoLivro = generoDoLivro ;
    }

    public String getAutorDoLivro() {
        return autorDoLivro;
    }

    public void setAutorDoLivro(String autorDoLivro) {
        this.autorDoLivro = autorDoLivro;
    }

    public String getEditoraDoLivro() {
        return editoraDoLivro;
    }

    public void setEditoraDoLivro(String editoraDoLivro) {
        this.editoraDoLivro = editoraDoLivro;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }
}
