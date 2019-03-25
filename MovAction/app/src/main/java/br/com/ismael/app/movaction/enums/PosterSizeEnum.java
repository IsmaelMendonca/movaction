package br.com.ismael.app.movaction.enums;

public enum PosterSizeEnum implements SizeEnum {
    w92("w92"),
    w154("w154"),
    w185("w185"),
    w342("w342"),
    w500("w500"),
    w780("w780"),
    original("original");

    private String tamanho;

    PosterSizeEnum(String size) {
        tamanho = size;
    }

    @Override
    public String obterTamanho() {
        return tamanho;
    }
}
