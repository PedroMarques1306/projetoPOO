package geradorDeDieta.model.enums;

/*Pesquisando achei esse tipo 'enum' que é um enumerador que é melhor para o tipo de projeto que estamos querendo criar já que a parte de sexo,
nivel de atividade e objetivo serão como constantes*/

public enum NivelAtividade{

    // LISTA DE CONSTANTES FIXAS
    // A cada constante associamos o valor multiplicador correto usado cientificamente.
    // valores ajustados
    SEDENTARIO("Sedentário", 1.2),
    LEVEMENTE_ATIVO("Levemente Ativo", 1.375),
    MODERADAMENTE_ATIVO("Moderadamente Ativo", 1.55), 
    MUITO_ATIVO("Muito Ativo", 1.725),           
    EXTREM_ATIVO("Extremamente Ativo", 1.9);

    // ATRIBUTOS PARA CADA CONSTANTE
    // Cada constante da lista acima terá esses dois atributos.
    private final String descricao;
    private final double multiplicador;
    // CONSTRUTOR
    // Esse construtor é chamado para cada constante da lista.
    // Exemplo SEDENTARIO("Sedentário", 1.2) chama o construtor com esses valores.
    NivelAtividade(String descricao, double multiplicador) {
        this.descricao = descricao;
        this.multiplicador = multiplicador;
    }

    // metodos
    public String getDescription() {
        return descricao;
    }

    public double getMultiplier() {
        return multiplicador;
    }
}
