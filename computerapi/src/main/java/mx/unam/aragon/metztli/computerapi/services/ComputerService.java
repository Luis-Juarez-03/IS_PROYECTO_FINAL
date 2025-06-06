package mx.unam.aragon.metztli.computerapi.services;

import mx.unam.aragon.metztli.computerapi.entities.Computadora;
import mx.unam.aragon.metztli.computerapi.repositories.IComputerRepository;
import mx.unam.aragon.metztli.computerapi.services.interfaces.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComputerService implements IComputerService {
    @Autowired
    private IComputerRepository computerRepository;

    @Override
    public Optional<Computadora> findById(Long id) {
        return computerRepository.findById(id);
    }

    @Override
    public Iterable<Computadora> findAll() {
        return computerRepository.findAll();
    }

    @Override
    public Computadora save(Computadora computadora) {
        return computerRepository.save(computadora);
    }

    @Override
    public Computadora update(Long id, Computadora computadora) {
        Optional<Computadora> OLD = computerRepository.findById(id);

        if(OLD.isPresent()) {
            Computadora NEW = OLD.get();
            NEW.setModelo(computadora.getModelo());
            NEW.setFoto(computadora.getFoto());
            NEW.setMarca(computadora.getMarca());
            NEW.setPrecio(computadora.getPrecio());
            return computerRepository.save(NEW);
        }else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
         computerRepository.deleteById(id);
    }
}
