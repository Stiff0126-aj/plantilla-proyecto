package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Salida;

public interface SalidaRepository extends JpaRepository<Salida, Long> {
    @Query(value = "SELECT * FROM Salida", nativeQuery = true)
    Collection<Salida> darSalidas();

    @Query(value = "SELECT * FROM Salida WHERE id_punto = :id", nativeQuery = true)
    Salida darSalidaPorId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Salida WHERE id_punto = :id", nativeQuery = true)
    void eliminarSalida(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Salida SET id_punto = :idPunto WHERE id_punto = :id", nativeQuery = true)
    void actualizarSalida(@Param("id") Long id,
                          @Param("idPunto") Long idPunto);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Salida (id_punto) VALUES (:id)", nativeQuery = true)
    void insertarSalida(@Param("id") Long id);
}
