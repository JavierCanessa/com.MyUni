<%@page import="com.MyUni.MyUni.Tabla.TablaHtml"%>
<%@page import="com.MyUni.MyUni.Dao.ClienteDAO"%>
<%@page import="com.MyUni.MyUni.Entidades.Cliente" %>
<%@page import="com.MyUni.MyUni.Entidades.Proceso" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.HttpURLConnection, java.net.URL, java.io.BufferedReader, java.io.InputStreamReader" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <head>
        <title>ModificarCliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        <!-- Modal 3 -->
        <div class="modal fade" id="modal3" tabindex="-1" role="dialog" aria-labelledby="modal2Label" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-xl" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="modal3Label">Modificar/Eliminar</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" class="form-control" id="codigoClienteBuscar" placeholder="Ingrese el código del cliente">
                        </div>
                    </div>
                    <div class="col-auto">
                        <button class="btn btn-primary" id="btnBuscarCliente">Buscar</button>
                    </div>
                    <div class="modal-body">
                        <form id="formularioModificar">
                            <div class="form-group">
                                <label for="codigoCliente">ID:</label>
                                <input type="text" class="form-control" id="codigoClienteModificar" name="codigoCliente" readonly>
                            </div>
                            <div class="form-group">
                                <label for="foto">Foto:</label>
                                <input type="text" class="form-control" id="foto" name="foto" >
                            </div>
                            <div class="form-group">
                                <label for="nombres">Nombres:</label>
                                <input type="text" class="form-control" id="nombres" name="nombres" required>
                            </div>
                            <div class="form-group">
                                <label for="apellidos">Apellidos:</label>
                                <input type="text" class="form-control" id="apellidos" name="apellidos" required>
                            </div>
                            <div class="form-group">
                                <label for="ciudad">Ciudad:</label>
                                <input type="text" class="form-control" id="ciudad" name="ciudad" required>
                            </div>
                            <div class="form-group">
                                <label for="fechaNacimiento">Fecha de Nacimiento:</label>
                                <input type="text" class="form-control" id="fechaNacimiento" name="fechaNacimiento" required>
                            </div>
                            <div class="form-group">
                                <label for="celular">Celular:</label>
                                <input type="text" class="form-control" id="celular" name="celular" required pattern="[0-9]+">
                                <small class="form-text text-muted">Ingrese solo números.</small>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                                <small class="form-text text-muted">Ingrese un formato de correo válido.</small>
                            </div>
                            <div class="form-group">
                                <label for="pasaporte">Pasaporte:</label>
                                <input type="text" class="form-control" id="pasaporte" name="pasaporte" required pattern="[0-9]+">
                                <small class="form-text text-muted">Ingrese solo números.</small>
                            </div>

                            <!-- Lista de procesos -->
                            <div class="form-group">
                                <label for="procesos">Procesos:</label>
                                <% for (Proceso proceso : Proceso.values()) {%>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" id="proceso_<%= proceso.getId()%>" name="procesos" value="<%= proceso.name()%>">

                                    <label class="form-check-label" for="proceso_<%= proceso.getId()%>"><%= proceso%></label>

                                </div>
                                <% }%>
                            </div>
                            <!-- Fin Lista de procesos -->

                            <button id="btnModificar" class="btn btn-primary">Modificar</button>
                        </form>
                    </div>

                    <script>
                        document.getElementById('btnBuscarCliente').addEventListener('click', function () {
                            const clienteId = document.getElementById('codigoClienteBuscar').value;
                            console.log("Primer paso" + clienteId);
                            fetch(`http://localhost:8084/myuni/clientes/buscar/` + clienteId)
                                    .then(response => response.json())
                                    .then(data => {
                                        const formularioModificar = document.getElementById('formularioModificar');
                                        console.log("Data segundo paso : ");
                                        console.log(data);
                                        if (data) {
                                            // Mostrar los datos del cliente en el formulario
                                            document.getElementById('codigoClienteModificar').value = data.id;
                                            document.getElementById('foto').value = data.foto;
                                            document.getElementById('nombres').value = data.nombres;
                                            document.getElementById('apellidos').value = data.apellidos;
                                            document.getElementById('ciudad').value = data.ciudad;
                                            document.getElementById('fechaNacimiento').value = data.fechaNacimiento;
                                            document.getElementById('celular').value = data.celular;
                                            document.getElementById('email').value = data.email;
                                            document.getElementById('pasaporte').value = data.pasaporte;
                                            // Marcar los checkboxes de los procesos del cliente
                                            const procesosCliente = data.procesos;
                                            const checkboxes = document.querySelectorAll('input[name="procesos"]');
                                            checkboxes.forEach(checkbox => {
                                                const proceso = checkbox.value;
                                                if (procesosCliente.includes(proceso)) {
                                                    checkbox.checked = true;
                                                }
                                            });
                                        } else {
                                            console.error('No se encontró el cliente.');
                                        }
                                    })
                                    .catch(error => {
                                        console.error('Tocho Error en la solicitud:', error);
                                    });
                        });
                        document.getElementById('btnModificar').addEventListener('click', function () {
                            event.preventDefault();
                            // Obtener los valores del formulario
                            const codigoCliente = document.getElementById('codigoClienteModificar').value;
                            const foto = document.getElementById('foto').value;
                            const nombres = document.getElementById('nombres').value;
                            const apellidos = document.getElementById('apellidos').value;
                            const ciudad = document.getElementById('ciudad').value;
                            const fechaNacimiento = document.getElementById('fechaNacimiento').value;
                            const celular = document.getElementById('celular').value;
                            const email = document.getElementById('email').value;
                            const pasaporte = document.getElementById('pasaporte').value;
                            // Construir el objeto cliente con los datos actualizados
                            const clienteModificado = {
                                id: codigoCliente,
                                foto: foto,
                                nombres: nombres,
                                apellidos: apellidos,
                                ciudad: ciudad,
                                fechaNacimiento: fechaNacimiento,
                                celular: celular,
                                email: email,
                                pasaporte: pasaporte
                            };
                            // Obtener los valores de los checkboxes de procesos seleccionados
                            const procesosSeleccionados = Array.from(document.querySelectorAll('input[name="procesosCliente"]:checked')).map(checkbox => checkbox.value);
                            const clienteId = document.getElementById('codigoClienteBuscar').value;
                            console.log("Primer paso de modificar" + clienteId);
                            // Enviar la solicitud PUT al enlace de modificación
                            fetch(`http://localhost:8084/myuni/clientes/modificar/${clienteId}?procesos=${procesosSeleccionados.join(',')}`, {
                                method: 'PUT',
                                headers: {
                                    'Content-Type': 'application/json'
                                },
                                body: JSON.stringify(clienteModificado)
                            })
                                    .then(response => {
                                        if (response.ok) {
                                            console.log('Cliente modificado correctamente');
                                            // Realizar acciones adicionales o recargar la página
                                        } else {
                                            console.error('Error al modificar el cliente');
                                        }
                                    })
                                    .catch(error => {
                                        console.error('Error en la solicitud:', error);
                                    });

                            
                        });



                    </script>
                </div>
            </div>
        </div>

    </body>
</html>