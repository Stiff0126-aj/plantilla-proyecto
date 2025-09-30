package uniandes.edu.co.proyecto.Repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
     // Comentario del cliente al conductor
     @Modifying
     @Transactional
     @Query(value = "INSERT INTO Comentario (id, calificacion, descripcion, usuario_asignado, servicio_asignado, tipo_usuario) VALUES (:id, :calificacion, :descripcion, :usuario, :servicio, 'CLIENTE')", nativeQuery = true)
     void insertarComentarioCliente(@Param("id") Long id,
                                   @Param("calificacion") int calificacion,
                                   @Param("descripcion") String descripcion,
                                   @Param("usuario") Long usuario,
                                   @Param("servicio") Long servicio);

     // Comentario del conductor al cliente
     @Modifying
     @Transactional
     @Query(value = "INSERT INTO Comentario (id, calificacion, descripcion, usuario_asignado, servicio_asignado, tipo_usuario) VALUES (:id, :calificacion, :descripcion, :usuario, :servicio, 'CONDUCTOR')", nativeQuery = true)
     void insertarComentarioConductor(@Param("id") Long id,
                                   @Param("calificacion") int calificacion,
                                   @Param("descripcion") String descripcion,
                                   @Param("usuario") Long usuario,
                                   @Param("servicio") Long servicio);



     @Query(value = "SELECT * FROM Comentario", nativeQuery = true)
    Collection<Comentario> darComentarios();

    @Query(value = "SELECT * FROM Comentario WHERE id = :id", nativeQuery = true)
    Comentario darComentarioPorId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Comentario WHERE id = :id", nativeQuery = true)
    void eliminarComentario(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Comentario SET calificacion = :calificacion, descripcion = :descripcion, usuario_asignado = :usuario, servicio_asignado = :servicio WHERE id = :id", nativeQuery = true)
    void actualizarComentario(@Param("id") Long id,
                              @Param("calificacion") int calificacion,
                              @Param("descripcion") String descripcion,
                              @Param("usuario") Long usuario,
                              @Param("servicio") Long servicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Comentario (id, calificacion, descripcion, usuario_asignado, servicio_asignado) VALUES (:id, :calificacion, :descripcion, :usuario, :servicio)", nativeQuery = true)
    void insertarComentario(@Param("id") Long id,
                            @Param("calificacion") int calificacion,
                            @Param("descripcion") String descripcion,
                            @Param("usuario") Long usuario,
                            @Param("servicio") Long servicio);
}
