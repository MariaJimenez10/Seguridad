package com.tutorial.seguridad.Controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.tutorial.seguridad.Modelos.Permisos;
import com.tutorial.seguridad.Repositorios.RepositorioPermisos;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/permisos")

public class ControladorPermisos {
    @Autowired
    private RepositorioPermisos miRepositorioPermisos;

    @GetMapping("")
    public List<Permisos> index(){
        return this.miRepositorioPermisos.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Permisos create(@RequestBody Permisos infoPermisos){
        return this.miRepositorioPermisos.save(infoPermisos);
    }
    @GetMapping("{id}")
    public Permisos show(@PathVariable String id){
        Permisos PermisoActual=this.miRepositorioPermisos
                .findById(id)
                .orElse(null);
        return PermisoActual;
    }
    @PutMapping("{id}")
    public Permisos update(@PathVariable String id,@RequestBody  Permisos infoPermiso){
        Permisos PermisoActual=this.miRepositorioPermisos
                .findById(id)
                .orElse(null);
        if (PermisoActual!=null){
            PermisoActual.setUrl(infoPermiso.getUrl());
            return this.miRepositorioPermisos.save(PermisoActual);
        }else{
            return  null;
        }
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Permisos PermisoActual=this.miRepositorioPermisos
                .findById(id)
                .orElse(null);
        if (PermisoActual!=null){
            this.miRepositorioPermisos.delete(PermisoActual);
        }
    }

}