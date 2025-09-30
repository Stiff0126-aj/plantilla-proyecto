package uniandes.edu.co.proyecto.controller;

import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.Repositorio.ComentarioRepository;
import uniandes.edu.co.proyecto.modelo.Comentario;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioRepository comentarioRepository;

    public ComentarioController(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @PostMapping("/cliente")
    public String comentarioCliente(@RequestBody Comentario comentario) {
        comentarioRepository.insertarComentarioCliente(
            comentario.getId(),
            comentario.getCalificacion(),
            comentario.getDescripcion(),
            comentario.getUsuario().getId(),
            comentario.getServicio().getId()
        );
        return "Comentario de cliente registrado";
    }

    @PostMapping("/conductor")
    public String comentarioConductor(@RequestBody Comentario comentario) {
        comentarioRepository.insertarComentarioConductor(
            comentario.getId(),
            comentario.getCalificacion(),
            comentario.getDescripcion(),
            comentario.getUsuario().getId(),
            comentario.getServicio().getId()
        );
        return "Comentario de conductor registrado";
    }
}

