package co.edu.utp.isc.gia.pruebas.web.controller;

import co.edu.utp.isc.gia.pruebas.servicio.ServicioUsuario;
import co.edu.utp.isc.gia.pruebas.web.dto.UsuarioDto;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("usuarios")
public class ControladorUsuario {
    private ServicioUsuario servicioUsuario;
    
    @PostMapping()
    public UsuarioDto guardar(@RequestBody UsuarioDto usuarioDto){
        return servicioUsuario.guardar(usuarioDto); 
    }
    
    @GetMapping()
    public List<UsuarioDto> listarTodos(){
        return servicioUsuario.listarTodos();
    }
    
    @GetMapping("/{id}")
    public UsuarioDto findOne(@PathVariable("id") Long id){
        return servicioUsuario.findOne(id);
    }
    
    @PutMapping("/{id}")
    public UsuarioDto updateOne(@PathVariable Long id,@PathVariable int tipo_usuario, @RequestBody UsuarioDto usuario){
        return servicioUsuario.updateOne(id, tipo_usuario, usuario);
    }
    
    @DeleteMapping("/{id}")
    public UsuarioDto removeOne(@PathVariable Long id){
        return servicioUsuario.removeOne(id);
    }

}
