package uniandes.edu.co.proyecto.controller;

import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.Repositorio.UsuarioRepository;
import uniandes.edu.co.proyecto.modelo.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}
