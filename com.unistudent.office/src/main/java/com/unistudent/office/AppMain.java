/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unistudent.office;

import RepositorioInterfaz.ClienteDAO;
import Entidades.Cliente;
import Entidades.Procesos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author tocho
 */
public class AppMain {

    public static void main(String[] args) {

        

        Cliente c1;
        c1 = new Cliente("Foto1", "Javier Freddy", "Canessa Mautong", "Machala", "02/10/1993", 1122538411, "asdasdasd@asddfasd.com", 0705005700,
                Arrays.asList(Procesos.enumProcesos.Grupo_de_Whatsapp,
                        Procesos.enumProcesos.Cita_DNI));

        System.out.print("----------Este es el comienzo de la App Unistudent---------- \n");
        System.out.println(c1.toString());

    }
}
