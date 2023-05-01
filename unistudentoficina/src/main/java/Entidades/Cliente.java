/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;



import java.util.List;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author tocho
 */
@Entity
public class Cliente {
    
    int rmd = new Random().nextInt();

    //private static int genrarId = rmd;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    private int cod;
    private String foto;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String fechaNacimiento;
    private int celular;
    private String email;
    private int pasaporte;
    private List<Procesos.enumProcesos> procesos;
    
    public Cliente() {
      //  this.id = genrarId * 50 /30;
    }
    
    public int getCod() {
        return cod;
    }

    public Cliente(String foto, String nombre, String apellido, String ciudad, String fechaNacimiento, int celular, String email, int pasaporte, List<Procesos.enumProcesos> procesos) {
        //this.id = genrarId++ * 506515 /3087;
        this.cod = rmd;
        this.foto = foto;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(int pasaporte) {
        this.pasaporte = pasaporte;
    }

    public List<Procesos.enumProcesos> getProcesos() {
        return procesos;
    }

    public void setProcesos(List<Procesos.enumProcesos> procesos) {
        this.procesos = procesos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", cod=" + cod + ", foto=" + foto + ", nombre=" + nombre + ", apellido=" + apellido + ", ciudad=" + ciudad + ", fechaNacimiento=" + fechaNacimiento + ", celular=" + celular + ", email=" + email + ", pasaporte=" + pasaporte + ", procesos=" + procesos + '}';
    }
    
    

  


    
    

    
    
    
    

}
