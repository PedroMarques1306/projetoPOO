//vai ser utiliuzado para mandar a dieta CALCULADA de volta para o usuario


package dto; //criado para lidar com a entrada e saida de dados do usuario

public class DietPlanDTO {
    public double caloriasTotais;
    public double caboidratoGramas;
    public double proteinasGramas;
    public double gordurasGramas;


    //CONSTRUTOR
    public DietPlanDTO(double caloriasTotais, double caboidratoGramas, double proteinasGramas   , double gordurasgramas) {
        this.caloriasTotais = caloriasTotais;
        this.caboidratoGramas = caboidratoGramas;
        this.proteinasGramas = proteinasGramas;
        this.gordurasGramas = gordurasgramas;
    }

    //GETTERS E SETTERS
    public double getCaloriasTotais() {
        return caloriasTotais;
    }


    public double getCaboidratoGramas() {
        return caboidratoGramas;
    }


    public double getProteinasGramas() {
        return proteinasGramas;
    }


    public double getGordurasGramas() {
        return gordurasGramas;
    }


    public void setCaloriasTotais(double caloriasTotais) {
        this.caloriasTotais = caloriasTotais;
    }


    public void setCaboidratoGramas(double caboidratoGramas) {
        this.caboidratoGramas = caboidratoGramas;
    }


    public void setProteinasGramas(double proteinasGramas) {
        this.proteinasGramas = proteinasGramas;
    }


    public void setGordurasGramas(double gordurasGramas) {
        this.gordurasGramas = gordurasGramas;
    }










}