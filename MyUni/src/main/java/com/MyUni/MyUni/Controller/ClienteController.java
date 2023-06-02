/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MyUni.MyUni.Controller;

import com.MyUni.MyUni.Dao.ClienteDAO;
import com.MyUni.MyUni.Entidades.Cliente;
import com.MyUni.MyUni.Entidades.Proceso;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tocho
 */
@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteDAO cdao;

    @GetMapping("/all")
    public List<Cliente> all() {
        return cdao.findAll();
    }

    @GetMapping("buscar/{id}")
    public Optional<Cliente> busquedaId(@PathVariable int id) {
        return cdao.findById(id);
    }

    @GetMapping("eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        Optional<Cliente> oc = cdao.findById(id);
        Cliente c = oc.orElse(null);
        c.eliminarTodosLosProcesos();
        cdao.delete(c);
        return "id : " + id + " " + "eliminado";
    }

    @PostMapping("/agregar")
    public ResponseEntity<String> agregarCliente(@RequestParam("procesos") List<String> procesosTextos, @ModelAttribute Cliente cliente) {
        try {
            String foto = cliente.getFoto();
            String nombres = cliente.getNombres();
            String apellidos = cliente.getApellidos();
            String ciudad = cliente.getCiudad();
            String fechaNacimiento = cliente.getFechaNacimiento();
            long celular = cliente.getCelular();
            String email = cliente.getEmail();
            long pasaporte = cliente.getPasaporte();

            List<Proceso> listaProcesos = new ArrayList<>();

            for (String procesoTexto : procesosTextos) {
                Proceso proceso = Proceso.valueOf(procesoTexto); // Obtener el proceso correspondiente al texto
                listaProcesos.add(proceso); // Agregar el proceso a la lista
            }

            cliente.setProcesos(listaProcesos);

            cdao.save(cliente);

            return ResponseEntity.ok("Cliente agregado: " + cliente.getId() + " " + nombres + " " + apellidos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar el cliente");
        }
    }

}
