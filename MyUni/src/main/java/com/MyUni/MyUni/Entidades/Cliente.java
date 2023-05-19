/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MyUni.MyUni.Entidades;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Random;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author tocho
 */
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @Column(name = "id")
    private final int id = Math.abs(new Random().nextInt());
    ;

    private String foto;
    private String nombres;
    private String apellidos;
    private String ciudad;
    private String fechaNacimiento;
    private long celular;
    private String email;
    private long pasaporte;

    @ElementCollection(targetClass = Proceso.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "cliente_procesos", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "procesos")
    private List<Proceso> procesos;

    // Método para eliminar todos los procesos
    public void eliminarTodosLosProcesos() {
        if (procesos != null) {
            procesos.clear();
        }
    }

    public Cliente() {
    }

    public Cliente(String foto, String nombres, String apellidos, String ciudad, String fechaNacimiento, long celular, String email, long pasaporte, List<Proceso> procesos) {
        this.foto = foto;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.email = email;
        this.pasaporte = pasaporte;
        this.procesos = procesos;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(long pasaporte) {
        this.pasaporte = pasaporte;
    }

    public List<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(List<Proceso> procesos) {
        this.procesos = procesos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", foto=" + foto + ", nombres=" + nombres + ", apellidos=" + apellidos + ", ciudad=" + ciudad + ", fechaNacimiento=" + fechaNacimiento + ", celular=" + celular + ", email=" + email + ", pasaporte=" + pasaporte + ", procesos=" + procesos + '}';
    }

    public int getId() {
        return id;
    }

}
