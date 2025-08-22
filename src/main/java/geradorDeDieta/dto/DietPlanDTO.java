//vai ser utiliuzado para mandar a dieta CALCULADA de volta para o usuario


package geradorDeDieta.dto; //criado para lidar com a entrada e saida de dados do usuario

public class DietPlanDTO {
    private double caloriasTotais;
    private double carboidratoGramas;
    private double proteinasGramas;
    private double gordurasGramas;

    public DietPlanDTO(){

    }

    //CONSTRUTOR
    public DietPlanDTO(double caloriasTotais, double carboidratoGramas, double proteinasGramas   , double gordurasgramas) {
        this.caloriasTotais = caloriasTotais;
        this.carboidratoGramas = carboidratoGramas;
        this.proteinasGramas = proteinasGramas;
        this.gordurasGramas = gordurasgramas;
    }

    //GETTERS E SETTERS
    public double getCaloriasTotais() {
        return caloriasTotais;
    }


    public double getCarboidratoGramas() {
        return carboidratoGramas;
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


    public void setCarboidratoGramas(double caboidratoGramas) {
        this.carboidratoGramas = caboidratoGramas;
    }


    public void setProteinasGramas(double proteinasGramas) {
        this.proteinasGramas = proteinasGramas;
    }


    public void setGordurasGramas(double gordurasGramas) {
        this.gordurasGramas = gordurasGramas;
    }










}