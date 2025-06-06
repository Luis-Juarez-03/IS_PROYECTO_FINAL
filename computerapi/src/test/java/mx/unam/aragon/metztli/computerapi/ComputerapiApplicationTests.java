package mx.unam.aragon.metztli.computerapi;

import mx.unam.aragon.metztli.computerapi.entities.Computadora;
import mx.unam.aragon.metztli.computerapi.repositories.IComputerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComputerapiApplicationTests {

	/* SE COMENTARON CON EL FIN DE GENERAR EL SNAPSHOT PARA EL BUILD DE COMPOSE
	@Autowired
	private IComputerRepository computerRepository;


	@Test
	void contextLoads() {
	}

	@Test
	void insertComputadora() {
		Computadora computadora = new Computadora(null,"HP","Pavillion 2000", null, 13000.0f);
		computerRepository.save(computadora);
	}

	@Test
	void getComputadora() {
		Long claveTmp = 1l;
		Computadora computadora = computerRepository.findById(claveTmp).get();
		System.out.println(computadora);
	}

	@Test
	void deleteComputadora() {
		Long claveTmp = 2l;
		computerRepository.deleteById(claveTmp);
	}

	@Test
	void updateComputadora() {
		Long claveTmp = 1l;
		Computadora computadora = computerRepository.findById(claveTmp).get();
		computadora.setModelo("Modelo actualizado");
		computerRepository.save(computadora);
	}

	 */

}
