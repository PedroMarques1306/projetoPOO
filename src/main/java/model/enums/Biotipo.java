package model.enums;

public enum Biotipo {
    // LISTA DE CONSTANTES FIXAS
    // A cada constante associamos o valor multiplicador correto usado cientificamente.
    //descrição/multiplicadorGordura/multiplicadorCarbo/multiplicadorProt
    ECTOMORFO("Ectomorfo", 1.2,0.9,1.05),
    ENDOMORFO("Endomorfo", 0.85,1.1,1.1),
    MESOMORFO("Mesomorfo", 1.05,1.05,1.05);

    // ATRIBUTOS PARA CADA CONSTANTE
    // Cada constante da lista acima terá esses dois atributos.
    private final String descricao;
    private final double multiplicadorCarbo;
    private final double multiplicadorGordura;
    private final double multiplicadorProteina;

    // construtor
    // Esse construtor é chamado para cada constante da lista.
    // Exemplo SEDENTARIO("Sedentário", 1.2) chama o construtor com esses valores.
    Biotipo(String descricao, double multiplicadorCarbo, double multiplicadorGordura, double multiplicadorProteina) {
        this.descricao = descricao;
        this.multiplicadorCarbo = multiplicadorCarbo;
        this.multiplicadorGordura = multiplicadorGordura;
        this.multiplicadorProteina = multiplicadorProteina;
    }

    // metodos

    public String getDescricao() {
        return descricao;
    }

    public double getMultiCarbo() {
        return multiplicadorCarbo;
    }
        public double getMultiProteina() {
        return multiplicadorProteina;
    }
        public double getMultiGordura() {
        return multiplicadorGordura;
    }
    
}
