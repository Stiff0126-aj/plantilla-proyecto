package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Llegada;

public interface LlegadaRepository extends JpaRepository<Llegada, Long> {
    @Query(value = "SELECT * FROM Llegada", nativeQuery = true)
    Collection<Llegada> darLlegadas();

    @Query(value = "SELECT * FROM Llegada WHERE id_punto = :id", nativeQuery = true)
    Llegada darLlegadaPorId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Llegada WHERE id_punto = :id", nativeQuery = true)
    void eliminarLlegada(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Llegada SET id_punto = :idPunto WHERE id_punto = :id", nativeQuery = true)
    void actualizarLlegada(@Param("id") Long id,
                           @Param("idPunto") Long idPunto);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Llegada (id_punto) VALUES (:id)", nativeQuery = true)
    void insertarLlegada(@Param("id") Long id);
}
