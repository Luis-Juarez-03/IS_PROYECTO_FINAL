package mx.unam.aragon.metztli.computerapi.services.interfaces;

import mx.unam.aragon.metztli.computerapi.entities.Computadora;

import java.util.Optional;

public interface IComputerService {
    public abstract Optional<Computadora> findById(Long id);

    public abstract Iterable<Computadora> findAll();

    public abstract Computadora save(Computadora computadora);

    public abstract Computadora update(Long id, Computadora computadora);

    public abstract void delete(Long id);
}
