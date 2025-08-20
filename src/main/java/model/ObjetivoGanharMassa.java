package model;

public class ObjetivoGanharMassa implements Objetivo {
    //se meu objetivo e ganhar massa, esse vai ser um multiplicador para a quantidade de carboidratos e proteinas
    public double getObjetivo(){
        return 1.2; //aumento 20% da quantidade de carboidratos e proteinas, impactando tambem no aumento da quantidade de calorias
    }

}
