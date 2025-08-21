package repository;
//importo o pacote repository

import model.Usuario; //importo a classe usuario, o repositorio vaio gerenciar objetos de la
import org.springframework.data.jpa.repository.JpaRepository;  //importa a interface JPa repository, fornce metodos prontos como fazer o CRUD
import org.springframework.stereotype.Repository; //marca a interface como um componente repostorio de spring, assim o spring pode gerenciar e injetar em outras classes

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {}
//UsuarioRepository herda todos os metodos de JpaRepository, Usuario vai ser a classe quie o repositorio ira gerenciar e String o tipo da chave primaria(ID)