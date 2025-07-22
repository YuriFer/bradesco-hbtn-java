package provedores;

public enum TipoProvedorFrete {
    SEDEX("Sedex"),
    JADLOG("JadLog"),
    LOGGI("Loggi");

    private final String descricao;

    TipoProvedorFrete(String descricao) {
        this.descricao = descricao;
    }

    public String getValue() {
        return descricao;
    }
}
