/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test.no.especifico;

import java.util.Scanner;

/**
 *
 * @author Charchilla
 */
public class TestNoEspecifico {
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // DECLARACION DE VARIABLES
        int opcion;
        int asiento=0;
        int zona = 0;
        int edad;
        int tipoCliente;
        int precio = 0;
        boolean esEstudiante = false;
        boolean esAdultoMayor = false;
        int cantidad = 0;
        double precioTotal = 0;
        double descuento = 0;
        boolean continuar = true;
        
        // FIN DECLARACION VARIABLES
        
        // CREACION DE SCANNER
        Scanner scanner = new Scanner(System.in);
        // FIN CREACION SCANNER
        
     do {
            System.out.println("\n--- Bienvenido al Teatro Moro ---");
            System.out.println("1. Comprar entrada");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            // CREAMOS SCANNER... (ESTA ARRIBA)
            opcion = scanner.nextInt();
            if (opcion == 2){
                break;
            }
            
            // MUESTRA PLANO TEATRO (CON PRECIOS)
            System.out.println("\n========= PLANO DEL TEATRO =========");
            System.out.println(" ");
            System.out.println("  [01] [02] [03] [04] [05]   ← Zona A ($10.000)");
            System.out.println("  [06] [07] [08] [09] [10]   ← Zona b ($15.000)");
            System.out.println("  [11] [12] [13] [14] [15]   ← Zona c ($20.000)");
            System.out.println(" ");
            System.out.println("\n====================================");
            // CREAMOS ENTRADA USUARIO Y OPCION DE ASIENTO
            System.out.println("Seleciona la zona (1/2/3)");
            System.out.println("1. Zona A");
            System.out.println("2. Zona b");
            System.out.println("3. Zona c");
            System.out.println("Ingrese una opcion: ");
            zona = scanner.nextInt(); //declaramos la variable arriba como int
            
            // creamos switch para seleccion de asientos
            switch (zona) {
                // zona a
                case 1:
                    
                    System.out.println("Seleccione asiento: (1/2/3/4/5)");
                    asiento = scanner.nextInt(); //declaramos la variable arriba como int       
                    //verificacion de asiento correcto
                    if (asiento >= 1 &&  asiento <= 5) {         
                    System.out.println("Has seleccionado el asiento = "+asiento);
                    precio = 10000;
                    } else {
                    System.out.println("Ingrese un asiento correcto");
                    continue;
                    }
                    //fin verificacion
                    break;
                
                //zona b
                case 2:
                    System.out.println("Seleccione asiento: (6/7/8/9/10)");
                    asiento = scanner.nextInt(); //declaramos la variable arriba como int  
                    System.out.println("Has seleccionado el asiento = "+asiento);
                    
                    //verificacion de asiento correcto
                    if (asiento >= 6 &&  asiento <= 10) {         
                    System.out.println("Has seleccionado el asiento = "+asiento);
                    precio = 15000;
                    } else {
                    System.out.println("Ingrese un asiento correcto");
                    continue;
                    }
                    //fin verificacion
                    
                    break;
                
                //zona c
                case 3:
                    System.out.println("Seleccione asiento: (11/12/13/14/15)");
                    asiento = scanner.nextInt(); //declaramos la variable arriba como int 
                    System.out.println("Has seleccionado el asiento = "+asiento);
                    
                     //verificacion de asiento correcto
                    if (asiento >= 11 &&  asiento <= 15) {         
                    System.out.println("Has seleccionado el asiento = "+asiento);
                    precio = 20000;
                    } else {
                    System.out.println("Ingrese un asiento correcto");
                    continue;
                    }
                    //fin verificacion
                    
                    break;
                
                // numero erroneo
                default:
                    System.out.println("no has selecciona ninguna de las 3 opciones");
                    asiento = scanner.nextInt();
                    break;
            }
            
           
            
           System.out.println(":_:_:_:_:_:_:_:_:_:");
           System.out.println("ingrese su edad");
           System.out.println("  ");
           edad = scanner.nextInt(); //declaramos la variable arriba como int
           System.out.println("Ha escrito =  " +edad);
           
           
           System.out.println("Clasificacion de adulto mayor =  " +esAdultoMayor);
           
           System.out.println(":_:_:_:_:_:_:_:_:_:");
           System.out.println("Que tipo de cliente es usted? (1/2)");
           System.out.println("1. Estudiante");
           System.out.println("2. Publico General");
           System.out.println("  ");
           tipoCliente = scanner.nextInt(); //declaramos la variable arriba como int
      
           if (tipoCliente < 1 ||  tipoCliente > 2) {
                    System.out.println("Ingrese una opcion valida");
                    } 
           
           if (tipoCliente == 1){
               esEstudiante = true;}
           System.out.println("Clasificacion de estudiante =  " +esEstudiante);
           
           
           // creacion definicion de adulto mayor a mayores 60
           
           if (edad>=60){
               esAdultoMayor = true;
           }
           
           // creamos descuentos
           
         if (esAdultoMayor && esEstudiante){
               descuento = 0.15;
           } else if (esAdultoMayor){
               descuento = 0.15;
           } else if (esEstudiante) {
               descuento = 0.1;
           } else {
               descuento = 0.0;
           }

            // Calcular total
            precioTotal = precio - (precio * descuento);

            // Mostrar resumen
            System.out.println("\n========= RESUMEN DE COMPRA =========");
            System.out.println("Zona: " + zona);
            System.out.println("Asiento: " + asiento);
            System.out.println("Precio base: $" + precio);
            System.out.println("¿Estudiante?: " + esEstudiante);
            System.out.println("¿Adulto mayor?: " + esAdultoMayor);
            System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
            System.out.println("Total a pagar: $" + precioTotal);
            System.out.println("======================================");

            // Preguntar si desea continuar
            System.out.print("\n¿Desea comprar otra entrada? (1 = Sí / 2 = No): ");
            int respuesta = scanner.nextInt();
            if (respuesta != 1) {
                continuar = false;
                System.out.println("Gracias por comprar en Teatro Moro");
            }

        } while (continuar);
    }
}
            
          