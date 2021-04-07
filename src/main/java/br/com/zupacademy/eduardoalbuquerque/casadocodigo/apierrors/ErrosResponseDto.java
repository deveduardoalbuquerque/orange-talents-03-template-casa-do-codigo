package br.com.zupacademy.eduardoalbuquerque.casadocodigo.apierrors;

public class ErrosResponseDto {

    private String campo;
    private String mensagem;

    public ErrosResponseDto(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
