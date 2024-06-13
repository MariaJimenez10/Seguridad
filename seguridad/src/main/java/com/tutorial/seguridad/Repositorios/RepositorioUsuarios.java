package com.tutorial.seguridad.Repositorios;
import com.tutorial.seguridad.Modelos.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioUsuarios extends MongoRepository<Usuario,String> {
}

