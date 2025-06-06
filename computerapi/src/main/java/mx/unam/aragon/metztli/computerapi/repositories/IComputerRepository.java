package mx.unam.aragon.metztli.computerapi.repositories;

import mx.unam.aragon.metztli.computerapi.entities.Computadora;
import org.springframework.data.repository.CrudRepository;

public interface IComputerRepository extends CrudRepository<Computadora, Long> {
    public Computadora deleteByClave(long clave);
}
