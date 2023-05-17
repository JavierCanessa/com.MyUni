/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author tocho
 */
public class Cliente {

    private int rmd = Math.abs(new Random().nextInt());
    private int id;

    private int cod;
    private String foto;
    private String nombres;
    private String apellidos;
    private String ciudad;
    private String fechaNacimiento;
    private long celular;
    private String email;
    private long pasaporte;
    private List<Procesos> procesos;

    public Cliente() {
    }
    
    
    /*Constructor con id*/
    public Cliente(int id, int cod, String foto, String nombres, String apellidos, String ciudad, String fechaNacimiento, long celular, String email, long pasaporte, List<Procesos> procesos) {
        this.id = id;
        this.cod = cod;
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
    
    
    
    
    /*Constructor sin  INT cod*/
    public Cliente(String foto, String nombres, String apellidos, String ciudad, String fechaNacimiento, long celular, String email, long pasaporte, List<Procesos> procesos) {
        this.cod = rmd;
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

    /*Constructor con INT cod*/
    public Cliente(int cod, String foto, String nombres, String apellidos, String ciudad, String fechaNacimiento, long celular, String email, long pasaporte, List<Procesos> procesos) {
        this.cod = cod;
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

    public int getRmd() {
        return rmd;
    }

    public void setRmd(int rmd) {
        this.rmd = rmd;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
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

    public List<Procesos> getProcesos() {
        return procesos;
    }

    public void setProcesos(List<Procesos> procesos) {
        this.procesos = procesos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "rmd=" + rmd + ", id=" + id + ", cod=" + cod + ", foto=" + foto + ", nombres=" + nombres + ", apellidos=" + apellidos + ", ciudad=" + ciudad + ", fechaNacimiento=" + fechaNacimiento + ", celular=" + celular + ", email=" + email + ", pasaporte=" + pasaporte + ", procesos=" + procesos + '}';
    }

   
}
