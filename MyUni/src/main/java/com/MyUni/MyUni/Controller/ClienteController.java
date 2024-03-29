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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<?> busquedaId(@PathVariable String id) {
        try {
            int clienteId = Integer.parseInt(id);
            Optional<Cliente> cliente = cdao.findById(clienteId);
            if (cliente.isPresent()) {
                return ResponseEntity.ok(cliente.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("El código del cliente debe ser un número válido o no existe el codigo");
        }
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
    public Map<String, Object> agregarCliente(@RequestParam("procesos") List<String> procesosTextos, @ModelAttribute Cliente cliente) {
        Map<String, Object> response = new HashMap<>();
        try {
            String foto = cliente.getFoto();
            String nombres = cliente.getNombres();
            String apellidos = cliente.getApellidos();
            String ciudad = cliente.getCiudad();
            String fechaNacimiento = cliente.getFechaNacimiento();
            long celular = cliente.getCelular();
            String email = cliente.getEmail();
            String pasaporte = cliente.getPasaporte();

            List<Proceso> listaProcesos = new ArrayList<>();

            for (String procesoTexto : procesosTextos) {
                Proceso proceso = Proceso.valueOf(procesoTexto); // Obtener el proceso correspondiente al texto
                listaProcesos.add(proceso); // Agregar el proceso a la lista
            }

            cliente.setProcesos(listaProcesos);

            cdao.save(cliente);

            response.put("agregado", true);
            response.put("mensaje", "Cliente agregado: " + cliente.getId() + " " + nombres + " " + apellidos);
            response.put("mensaje1", "Cliente modificado: " + cliente.getId() + " " + nombres + " " + apellidos);

            return response;
        } catch (Exception e) {
            response.put("agregado", false);
            response.put("mensaje", "Error al agregar el cliente");

            return response;
        }
    }

    @PutMapping("modificar/{id}")
    public ResponseEntity<?> modificarCliente(
            @PathVariable int id,
            @RequestParam("procesos") List<String> procesosTextos,
            @ModelAttribute Cliente clienteModificado
    ) {
        try {
            Optional<Cliente> clienteOptional = cdao.findById(id);
            if (clienteOptional.isPresent()) {
                Cliente clienteExistente = clienteOptional.get();

                // Actualizar la lista de procesos del cliente existente con los nuevos procesos
                List<Proceso> listaProcesos = new ArrayList<>();
                for (String procesoTexto : procesosTextos) {
                    Proceso proceso = Proceso.valueOf(procesoTexto);
                    listaProcesos.add(proceso);
                }
                clienteExistente.setProcesos(listaProcesos);

                // Actualizar el cliente existente con los datos del cliente modificado
                BeanUtils.copyProperties(clienteModificado, clienteExistente, "id");

                // Guardar los cambios en la base de datos
                cdao.save(clienteExistente);

                return ResponseEntity.ok("true");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al modificar el cliente");
        }
    }

}
