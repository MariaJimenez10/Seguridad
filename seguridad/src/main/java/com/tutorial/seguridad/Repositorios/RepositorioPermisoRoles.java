package com.tutorial.seguridad.Repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.tutorial.seguridad.Modelos.PermisoRoles;
public interface RepositorioPermisoRoles extends MongoRepository<PermisoRoles,String> {
}
