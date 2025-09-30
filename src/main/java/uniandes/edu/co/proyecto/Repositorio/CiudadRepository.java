package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
    //RF1
    @Query(value = "SELECT * FROM Ciudad WHERE nombre = :nombre", nativeQuery = true)
    Ciudad buscarPorNombre(@Param("nombre") String nombre);
    //////
    /// 

    @Query(value = "SELECT * FROM Ciudad", nativeQuery = true)
    Collection<Ciudad> darCiudades();

    @Query(value = "SELECT * FROM Ciudad WHERE id = :id", nativeQuery = true)
    Ciudad darCiudadPorId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Ciudad WHERE id = :id", nativeQuery = true)
    void eliminarCiudad(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Ciudad SET nombre = :nombre, pais = :pais, region = :region WHERE id = :id", nativeQuery = true)
    void actualizarCiudad(@Param("id") Long id,
                          @Param("nombre") String nombre,
                          @Param("pais") String pais,
                          @Param("region") String region);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Ciudad (id, nombre, pais, region) VALUES (:id, :nombre, :pais, :region)", nativeQuery = true)
    void insertarCiudad(@Param("id") Long id,
                        @Param("nombre") String nombre,
                        @Param("pais") String pais,
                        @Param("region") String region);
}
