package com.tutorial.seguridad.Repositorios;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.tutorial.seguridad.Modelos.Permisos;
import org.springframework.data.mongodb.repository.Query;

public interface RepositorioPermisos extends MongoRepository<Permisos,String> {

    @Query("{'url':?0,'metodo':?1}")
    Permisos getPermiso(String url, String metodo);
}