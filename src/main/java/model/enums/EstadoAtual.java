package model.enums;

public enum EstadoAtual {
    // preciso de descricao, Multiplicador Proteina, Multiplicador Carboidrato, Multiplicador Gordura
    // falso magro é proteína +15%, Gordura -15%, Carbo mantém
    FALSO_MAGRO("Falso Magro", 1.15, 1.0, 0.85),
    // Carboidrato +15%, Proteína e Gordura se mantem
    MAGRO("Magro", 1.0, 1.15, 1.0),
    // proteína +25%, Carbo -20%, Gordura -25%
    SOBREPESO("Sobrepeso", 1.25, 0.8, 0.75);
    // TRÊS ATRIBUTOS UM PARA CADA MACRO
    private final String descricao;
    private final double multiplicadorProteina;
    private final double multiplicadorCarboidrato;
    private final double multiplicadorGordura;

    //  construtor para os atributos
    EstadoAtual(String descricao, double multiplicadorProteina, double multiplicadorCarboidrato, double multiplicadorGordura) {
        this.descricao = descricao;
        this.multiplicadorProteina = multiplicadorProteina;
        this.multiplicadorCarboidrato = multiplicadorCarboidrato;
        this.multiplicadorGordura = multiplicadorGordura;
    }

    // 4. GETS PARA CADA ATRIBUTO
    public String getDescricao() {
        return descricao;
    }
    public double getMultiplicadorProteina() {
        return multiplicadorProteina;
    }

    public double getMultiplicadorCarboidrato() {
        return multiplicadorCarboidrato;
    }
    public double getMultiplicadorGordura() {
        return multiplicadorGordura;
    }
}