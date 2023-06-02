/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.MyUni.MyUni.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author tocho
 */

public enum Proceso {

    Grupo_de_Whatsapp(0),
    Material_Estudio_CBC_Area_de_Salud(1),
    Convalidación_Titulo_Secundario(2),
    Compra_Pasajes_Aereos(3),
    Reserva_Alojamiento(4),
    Recepción_Aeropuerto(5),
    Entrega_Kit_Supervivencia(6),
    Pago_Boletas(7),
    Certificado_De_Domicilio(8),
    Cita_DNI(9),
    Precaria(10),
    DNI_Resuelto(11),
    Pre_inscripción(12),
    Busqueda_Laboral(13);
    
    
    
    private final int id;

    Proceso(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public static Proceso getValor(int id) {
        for (Proceso proceso : values()) {
            if (proceso.getId() == id) {
                return proceso;
            }
        }
        throw new IllegalArgumentException("ID de proceso inválido: " + id);
    }
    
}
