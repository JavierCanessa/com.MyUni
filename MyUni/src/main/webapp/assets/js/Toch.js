/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

// Función para validar el campo de celular
function validarCelular() {
    const celularInput = document.getElementById('celular');
    const celularValue = celularInput.value;
    const celularRegex = /^[0-9]+$/;

    if (!celularRegex.test(celularValue)) {
        celularInput.setCustomValidity('Ingrese solo números');
    } else {
        celularInput.setCustomValidity('');
    }
}

function validarEmail() {
    const emailInput = document.getElementById('email');
    const emailValue = emailInput.value;
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!emailRegex.test(emailValue)) {
        emailInput.setCustomValidity('Ingrese un formato de correo válido');
    } else {
        emailInput.setCustomValidity('');
    }
}

// Función para validar el campo de pasaporte
function validarPasaporte() {
    const pasaporteInput = document.getElementById('pasaporte');
    const pasaporteValue = pasaporteInput.value;
    const pasaporteRegex = /^[0-9]+$/;

    if (!pasaporteRegex.test(pasaporteValue)) {
        pasaporteInput.setCustomValidity('Ingrese solo números');
    } else {
        pasaporteInput.setCustomValidity('');
    }
}

// Event listeners para los campos de celular, email y pasaporte
document.getElementById('celular').addEventListener('input', validarCelular);
document.getElementById('email').addEventListener('input', validarEmail);
document.getElementById('pasaporte').addEventListener('input', validarPasaporte);



function limpiarFormulario() {
    // Obtener referencias a los elementos del formulario
    var fotoInput = document.getElementById('foto');
    var nombresInput = document.getElementById('nombres');
    var apellidosInput = document.getElementById('apellidos');
    var ciudadInput = document.getElementById('ciudad');
    var fechaNacimientoInput = document.getElementById('fechaNacimiento');
    var celularInput = document.getElementById('celular');
    var emailInput = document.getElementById('email');
    var pasaporteInput = document.getElementById('pasaporte');

    // Limpiar los valores de los campos del formulario
    fotoInput.value = '';
    nombresInput.value = '';
    apellidosInput.value = '';
    ciudadInput.value = '';
    fechaNacimientoInput.value = '';
    celularInput.value = '';
    emailInput.value = '';
    pasaporteInput.value = '';
}




