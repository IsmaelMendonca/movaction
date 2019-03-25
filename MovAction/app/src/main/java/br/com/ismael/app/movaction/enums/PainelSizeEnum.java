package br.com.ismael.app.movaction.enums;

public enum PainelSizeEnum implements SizeEnum {
    w300("w300"),
    w780("w780"),
    w1280("w1280"),
    original("original");

    private String tamanho;

    PainelSizeEnum(String size) {
        tamanho = size;
    }

    @Override
    public String obterTamanho() {
        return tamanho;
    }
}
