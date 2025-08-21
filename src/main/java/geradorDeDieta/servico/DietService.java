package geradorDeDieta.servico;

import geradorDeDieta.dto.DietRequestDTO;
import geradorDeDieta.dto.DietPlanDTO;
import model.Usuario;
import repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DietService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    

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
        double tmb = calculartmb(usuario);
        double tdee = tmb *usuario.getNivelAtividade().getMultiplier();

        //aplicar o padrão strategy aqui


        //calculo dos macros
            
        DietPlanDTO planoFinal = new DietPlanDTO();
        planoFinal.setCaloriasTotais(caloriasAlvo);
        planoFinal.setProteinasGramas(proteinasAlvo);
        planoFinal.setCaboidratoGramas(carboidratosAlvo);
        planoFinal.setGordurasGramas(gorduraAlvo);

        return planoFinal;
    }

    private double calculartmb(Usuario usuario){
        //Preciso ver como fazer a logica do tmb depois
        return 0; 
    }


}
