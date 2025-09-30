package uniandes.edu.co.proyecto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Conductor;

import java.util.Collection;

public interface ConductorRepository extends JpaRepository<Conductor, Long> {

    @Query(value = "SELECT * FROM Conductor", nativeQuery = true)
    Collection<Conductor> darConductores();

    @Query(value = "SELECT * FROM Conductor WHERE id_usuario = :idUsuario", nativeQuery = true)
    Conductor darConductorPorId(@Param("idUsuario") Long idUsuario);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Conductor WHERE id_usuario = :idUsuario", nativeQuery = true)
    void eliminarConductor(@Param("idUsuario") Long idUsuario);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Conductor SET id_usuario = :nuevoIdUsuario WHERE id_usuario = :idUsuario", nativeQuery = true)
    void actualizarConductor(@Param("idUsuario") Long idUsuario,
                             @Param("nuevoIdUsuario") Long nuevoIdUsuario);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Conductor (id_usuario) VALUES (:idUsuario)", nativeQuery = true)
    void insertarConductor(@Param("idUsuario") Long idUsuario);
}
