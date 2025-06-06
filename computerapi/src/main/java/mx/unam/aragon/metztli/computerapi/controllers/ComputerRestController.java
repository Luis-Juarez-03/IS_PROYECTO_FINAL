package mx.unam.aragon.metztli.computerapi.controllers;

import jakarta.validation.Valid;
import mx.unam.aragon.metztli.computerapi.entities.Computadora;
import mx.unam.aragon.metztli.computerapi.services.interfaces.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/computer")
public class ComputerRestController {

    @Autowired
    private IComputerService computadoraService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Computadora>> getAllComputer() {
        return new ResponseEntity<>(computadoraService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{clave}")
    public ResponseEntity<Computadora> getComputer(@PathVariable Long clave) {
        Optional<Computadora> tmp = computadoraService.findById(clave);
        return tmp.isPresent() ? new ResponseEntity<>(tmp.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Computadora> createComputer(@Valid @RequestBody Computadora computadora) {
        return new ResponseEntity<>(computadoraService.save(computadora), HttpStatus.CREATED);
    }

    @PostMapping("/{clave}")
    public ResponseEntity<String> noExists(){
        return new ResponseEntity<>("End Point no soportado", HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{clave}")
    public ResponseEntity<Computadora> patchComputer(@PathVariable Long clave, @RequestBody Computadora NEW) {
        Computadora OLD = computadoraService.findById(clave).orElse(null);

        if (OLD == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(NEW.getMarca() != null) OLD.setMarca(NEW.getMarca());
        if(NEW.getModelo() != null) OLD.setModelo(NEW.getModelo());
        if(NEW.getPrecio() != null) OLD.setPrecio(NEW.getPrecio());
        if(NEW.getFoto() != null) OLD.setFoto(NEW.getFoto());

        return new ResponseEntity<>(computadoraService.save(OLD), HttpStatus.OK);
    }

    @PutMapping("/{clave}")
    public ResponseEntity<Computadora> editComputer(@PathVariable Long clave, @RequestBody Computadora NEW) {
        Computadora OLD = computadoraService.findById(clave).orElse(null);

        if (OLD == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        OLD.setMarca(NEW.getMarca());
        OLD.setModelo(NEW.getModelo());
        OLD.setPrecio(NEW.getPrecio());
        OLD.setFoto(NEW.getFoto());
        return new ResponseEntity<>(computadoraService.save(OLD), HttpStatus.OK);
    }

    @DeleteMapping("/{clave}")
    public ResponseEntity<Computadora> deleteComputer(@PathVariable Long clave) {
        Computadora OLD = computadoraService.findById(clave).orElse(null);
        if (OLD == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        computadoraService.delete(clave);

        return new ResponseEntity<>(OLD, HttpStatus.OK);
    }
}
