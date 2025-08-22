package geradorDeDieta.servico;

import geradorDeDieta.dto.DietRequestDTO;
import geradorDeDieta.dto.DietPlanDTO;
import geradorDeDieta.servico.estrategia.*;
import model.Usuario;
import model.enums.Genero;
import model.enums.Objetivo;
import repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DietService{
    
    
    private  UsuarioRepository usuarioRepository;
    private  Map<String,DietStrategy> dietStrategies;

    public DietService(UsuarioRepository usuarioRepository, Map<String, DietStrategy> dietStrategies){
        this.usuarioRepository = usuarioRepository;
        this.dietStrategies = dietStrategies;
    }
    

    public DietPlanDTO generateDietPlan(DietRequestDTO requestDTO){
        Usuario usuario = new Usuario();
        //Aqui faz o request do dietRequestDTO para setar todos os dados que o usuario passou
        usuario.setAnos(requestDTO.getIdade());
        usuario.setPeso(requestDTO.getPeso());
        usuario.setAltura(requestDTO.getAltura());
        usuario.setBiotipo(requestDTO.getBiotipo());
        usuario.setEstadoAtual(requestDTO.getEstadoAtual());
        usuario.setGenero(requestDTO.getGenero());
        usuario.setNivelAtividade(requestDTO.getNivelAtividade());
        usuario.setObjetivo(requestDTO.getObjetivo());

        //Agora fazer os calculos base (estamos usando o metodo cientifico de uns carinhas aí que depois eu coloco nome aqui :) )   
        //tmb taxa metabolica basal a formula é de Mifflin St Jewor
        //tdee Total daily energi expenditure ou seja o gasto diario
        double tmb = calculartmb(usuario);
        double tdee = tmb *usuario.getNivelAtividade().getMultiplier(); //nivel de atividade influencia no tdee

        DietStrategy strategy = dietStrategies.get(usuario.getObjetivo().name());
        if (strategy == null) {
        throw new IllegalArgumentException("Objetivo não suportado");
        }
        int caloriasAlvo = strategy.calcularObjetivoCalorico(tdee);
        //ajustar as calorias com base no objetivo
        /*double caloriasAlvo;
        if(usuario.getObjetivo()== Objetivo.GANHARMASSA){
            caloriasAlvo = tdee +300; //superavit calorico
        }
        else if(usuario.getObjetivo()==Objetivo.PERDERPESO){
            caloriasAlvo = tdee -500; //deficit calorico
        }
        else {
            caloriasAlvo = tdee; //manetenho o tdee
        }
        If e else do jeito que tava aqui não condizia com o padrão strategy :( */
        //calcular os macronutrientes em gramas e em calorasi

        //Proteina, usando 2g/kg como base.
        double proteinasGramas = usuario.getPeso() *2;

        //gorduras, usando 25% das calorias totais
        double gorduraCalorias = caloriasAlvo * 0.25;
        double gorduraGramas = gorduraCalorias / 9; //1g de gordura = 9kcal

        //carboidratos, o restante das calorias
        double proteinasCalorias = proteinasGramas *4; //1g / 4kcal
        double carboidratoCalorias = caloriasAlvo - proteinasCalorias -  gorduraCalorias;
        double carboidratoGramas = carboidratoCalorias / 4; //1g = 4kcal


        //Aplicando os MULTIPLICADORES de biotipo e estado atual
        double multiplicadoresProteina = usuario.getBiotipo().getMultiProteina() * usuario.getEstadoAtual().getMultiplicadorProteina();
        double multiplicadoresGorduras = usuario.getBiotipo().getMultiGordura() * usuario.getEstadoAtual().getMultiplicadorGordura();
        double multiplicadoresCarboidratos = usuario.getBiotipo().getMultiCarbo() * usuario.getEstadoAtual().getMultiplicadorCarboidrato();

        //novas variaveis totais
        double proteinasTotais = proteinasGramas * multiplicadoresProteina;
        double gordurasTotais = gorduraGramas * multiplicadoresGorduras;
        double carboidratosTotais =  carboidratoGramas * multiplicadoresCarboidratos;



        //calculo dos macros

        DietPlanDTO planoFinal = new DietPlanDTO();
        planoFinal.setCaloriasTotais(caloriasAlvo);
        planoFinal.setProteinasGramas(proteinasTotais);
        planoFinal.setCaboidratoGramas(carboidratosTotais);
        planoFinal.setGordurasGramas(gordurasTotais);

        return planoFinal;
    }

    private double calculartmb(Usuario usuario){
        //Formula para Homens: (10 * peso em kg) + (6.25 * altura em cm) - (5 * idade em anos) +5
        //Formula para Mulheres: (10* peso em kg) + (6.25 * altura em cm) - (5 * idade em anos) - 161
        if(usuario.getGenero()== Genero.MASCULINO){
            return (10*usuario.getPeso()) + (6.25*usuario.getAltura()) - (5* usuario.getAnos()) + 5;//DAR A ALTURA EM CM
        }
        else{
            return (10*usuario.getPeso()) + (6.25*usuario.getAltura()) - (5* usuario.getAnos()) - 161;
        }


    }


}
