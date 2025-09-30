package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //RF2
    @Query(value = "SELECT * FROM Usuario WHERE correo = :correo", nativeQuery = true)
    Usuario buscarPorCorreo(@Param("correo") String correo);

    @Query(value = "SELECT * FROM Usuario WHERE cedula = :cedula", nativeQuery = true)
    Usuario buscarPorCedula(@Param("cedula") String cedula);
    //////////////
    @Query(value = "SELECT * FROM Usuario", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT * FROM Usuario WHERE id = :id", nativeQuery = true)
    Usuario darUsuarioPorId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Usuario WHERE id = :id", nativeQuery = true)
    void eliminarUsuario(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Usuario SET nombre = :nombre, correo = :correo, telefono = :telefono, cedula = :cedula, promedio_calificacion = :promedio WHERE id = :id", nativeQuery = true)
    void actualizarUsuario(@Param("id") Long id,
                           @Param("nombre") String nombre,
                           @Param("correo") String correo,
                           @Param("telefono") String telefono,
                           @Param("cedula") String cedula,
                           @Param("promedio") Double promedio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Usuario (id, nombre, correo, telefono, cedula, promedio_calificacion) VALUES (:id, :nombre, :correo, :telefono, :cedula, :promedio)", nativeQuery = true)
    void insertarUsuario(@Param("id") Long id,
                         @Param("nombre") String nombre,
                         @Param("correo") String correo,
                         @Param("telefono") String telefono,
                         @Param("cedula") String cedula,
                         @Param("promedio") Double promedio);
}
