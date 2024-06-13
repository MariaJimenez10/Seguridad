package com.tutorial.seguridad.Controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.tutorial.seguridad.Modelos.Roles;
import com.tutorial.seguridad.Repositorios.RepositorioRoles;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/roles")
public class ControladorRoles {
    @Autowired
    private RepositorioRoles miRepositorioRoles;


    @GetMapping("")
    public List<Roles> index(){
        return this.miRepositorioRoles.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Roles create(@RequestBody  Roles infoRol){
        return this.miRepositorioRoles.save(infoRol);
    }
    @GetMapping("{id}")
    public Roles show(@PathVariable String id){
        Roles rolActual=this.miRepositorioRoles
                .findById(id)
                .orElse(null);
        return rolActual;
    }
    @PutMapping("{id}")
    public Roles update(@PathVariable String id,@RequestBody  Roles infoRol){
        Roles rolActual=this.miRepositorioRoles
                .findById(id)
                .orElse(null);
        if (rolActual!=null){
            rolActual.setNombre(infoRol.getNombre());
            return this.miRepositorioRoles.save(rolActual);
        }else{
            return  null;
        }
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Roles rolActual=this.miRepositorioRoles
                .findById(id)
                .orElse(null);
        if (rolActual!=null){
            this.miRepositorioRoles.delete(rolActual);
        }
    }

}