package uniandes.edu.co.proyecto.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.Repositorio.CiudadRepository;
import uniandes.edu.co.proyecto.modelo.Ciudad;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {

    private final CiudadRepository ciudadRepository;

    public CiudadController(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    // RF1: Registrar ciudad
    @PostMapping
    public Ciudad registrarCiudad(@RequestBody Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    // Consultar todas
    @GetMapping
    public List<Ciudad> obtenerCiudades() {
        return ciudadRepository.findAll();
    }
}