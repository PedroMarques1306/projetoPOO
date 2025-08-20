package model;

public class EstadoAtualFalsoMagro implements EstadoAtual {
    /*
    falso magro seria um "magro" com alta taxa de gordura,
    preciso aumentar a quantidade de proteinas, diminuir a gordura e manter a quantidade de carbo
     */

    //AQUI VAI SER UM MULTIPLICADOR PARA AS PROTEINAS
    public double getEstadoAtual() {
        return 1.15; //aumento em 15% a quantidade de proteinas
    }

    //vou fazer outra funcao, que sera um multiplicador para diminuir a quantidade de gordura
    public double diminuirGordura(){
        return 0.85;//diminuo em 15% a quantidade de gordura da dieta
    }

}
