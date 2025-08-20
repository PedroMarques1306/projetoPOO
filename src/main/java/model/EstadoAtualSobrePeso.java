package model;

public class EstadoAtualSobrePeso implements EstadoAtual {

    //nesse caso, devo aumentar a quantidade de proteinas, diminuir a de gordura e a de carbo

    //VAI SER UM MULTIPLICADOR DA PROTEINA
    public double getEstadoAtual(){
        return 1.25; //aumento em 25% a quantidade de PROTEINAS da dieta
    }

    //diminuo quantidade de carbo, MULTIPLICADOR DO CARBO
    public double diminuirCarboidrato(){
        return 0.8; //diminuo a quantidade de carboidrato da dieta em 20%
    }

    //diminuo a quantidade de gordura, MULTIPLICADOR DA GORDURA
    public double diminuirGordura(){
        return 0.75; //diminuo em 25% a quantidade de gordura na dieta
    }


}
