package geradorDeDieta.controlador;
import geradorDeDieta.dto.DietRequestDTO;
import geradorDeDieta.model.Usuario;
import geradorDeDieta.dto.DietPlanDTO;
import geradorDeDieta.servico.DietService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//Aqui é pra ser o controlador de dietas pra conectar a API ao projeto
@RestController //'tranformando' a classe em um controlador API REST Pra garantir que DietPlanDTO vire json pra o futuro front-
@RequestMapping("/api/diets") //pelas minhas pesquisas, isso aqui é necessario para poder separar as URL's
public class ControladorDeDieta {
    private final DietService dietservice;

    public ControladorDeDieta(DietService dietservice) {
        this.dietservice = dietservice;
    }
    @GetMapping("/history")
    public ResponseEntity<List<Usuario>> getHistory(){
        List<Usuario> history = dietservice.getHistory();
        return ResponseEntity.ok(history);
    }
    @PostMapping("/generate") //conecta a classe a url 
    //Aqui embaixo é a assinatura do metodo, é um objeto Spring que representa a resposta HTTP
    public ResponseEntity<DietPlanDTO> generateDiet(@RequestBody DietRequestDTO requestDTO){
        DietPlanDTO plano = dietservice.generateDietPlan(requestDTO);
        return ResponseEntity.ok(plano);
    }    
}
