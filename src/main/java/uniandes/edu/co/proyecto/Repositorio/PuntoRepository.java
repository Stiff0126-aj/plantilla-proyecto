package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Punto;

public interface PuntoRepository extends JpaRepository<Punto, Long> {
    @Query(value = "SELECT * FROM Punto", nativeQuery = true)
    Collection<Punto> darPuntos();

    @Query(value = "SELECT * FROM Punto WHERE id = :id", nativeQuery = true)
    Punto darPuntoPorId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Punto WHERE id = :id", nativeQuery = true)
    void eliminarPunto(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Punto SET nombreReferencia = :nombre, direccion = :direccion, latitud = :lat, longitud = :lon WHERE id = :id", nativeQuery = true)
    void actualizarPunto(@Param("id") Long id,
                         @Param("nombre") String nombre,
                         @Param("direccion") String direccion,
                         @Param("lat") Double latitud,
                         @Param("lon") Double longitud);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Punto (id, nombreReferencia, direccion, latitud, longitud) VALUES (:id, :nombre, :direccion, :lat, :lon)", nativeQuery = true)
    void insertarPunto(@Param("id") Long id,
                       @Param("nombre") String nombre,
                       @Param("direccion") String direccion,
                       @Param("lat") Double latitud,
                       @Param("lon") Double longitud);
}
