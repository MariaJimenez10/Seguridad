package com.tutorial.seguridad.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.tutorial.seguridad.Modelos.Permisos;
import com.tutorial.seguridad.Modelos.PermisoRoles;
import com.tutorial.seguridad.Modelos.Roles;
import com.tutorial.seguridad.Repositorios.RepositorioPermisos;
import com.tutorial.seguridad.Repositorios.RepositorioPermisoRoles;
import com.tutorial.seguridad.Repositorios.RepositorioRoles;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/permisos-roles")

public class ControladorPermisoRoles {
    @Autowired
    private  RepositorioPermisoRoles miRepositorioPermisosRoles;
    @Autowired
    private RepositorioPermisos miRepositorioPermisos;
    @Autowired
    private RepositorioRoles miRepositorioRoles;

    @GetMapping("")
    public  List<PermisoRoles> index(){
        return this.miRepositorioPermisosRoles.findAll();
    }

    /**
     * Asignacion rol y permiso
     * @param id_rol
     * @param id_permiso
     * @return
     */

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("rol/{id_rol}/permiso/{id_permiso}")

    public PermisoRoles create(@PathVariable String id_rol,@PathVariable String id_permiso){
        PermisoRoles nuevo=new PermisoRoles();
        Roles elRol=this.miRepositorioRoles.findById(id_rol).get();
        Permisos elPermiso=this.miRepositorioPermisos.findById(id_permiso).get();
        if (elRol!=null && elPermiso!=null){
            nuevo.setPermiso(elPermiso);
            nuevo.setRol(elRol);
            return this.miRepositorioPermisosRoles.save(nuevo);
        }else{
            return null;
        }
    }
    @GetMapping("{id}")
    public PermisoRoles show(@PathVariable String id){
        PermisoRoles permisosRolesActual=this.miRepositorioPermisosRoles.findById(id).orElse(null);
        return permisosRolesActual;
    }
    /**
     * Modificación Rol y Permiso
     * @param id
     * @param id_rol
     * @param id_permiso
     * @return
     */
    @PutMapping("{id}/rol/{id_rol}/permiso/{id_permiso}")
    public PermisoRoles update(@PathVariable String id,@PathVariable String id_rol,@PathVariable String id_permiso){
        PermisoRoles permisoRolesActual=this.miRepositorioPermisosRoles.findById(id).orElse(null);
        Roles elRol=this.miRepositorioRoles.findById(id_rol).get();
        Permisos elPermiso=this.miRepositorioPermisos.findById(id_permiso).get();
        if(permisoRolesActual !=null && elPermiso !=null && elRol !=null ){
            permisoRolesActual.setPermiso(elPermiso);
            permisoRolesActual.setRol(elRol);
            return this.miRepositorioPermisosRoles.save(permisoRolesActual);
        }else{
            return null;
        }
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        PermisoRoles permisoRolesActual = this.miRepositorioPermisosRoles.findById(id).orElse(null);
        if (permisoRolesActual !=null){
            this.miRepositorioPermisosRoles.delete(permisoRolesActual);
        }
    }
}
