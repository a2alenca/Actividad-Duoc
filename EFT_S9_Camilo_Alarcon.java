/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eft_s9_camilo_alarcon;

/**
 *
 * @author Charchilla
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EFT_S9_Camilo_Alarcon {

    
    public static String [] idCliente = new String [50];
    public static String [] nombreCliente = new String [50];
    public static int [] edadBox = new int [50];
    public static int [] precioEntrada = new int [50];
    public static int[] idCompraBox = new int[50];
    public static double[] tasaDescuento = new double[50];
    public static double[] precioFinal = new double[50];
     
    public static boolean [] esNino = new boolean [50];
    public static boolean [] esMujer = new boolean [50];
    public static boolean [] esEstudiante = new boolean [50];
    public static boolean [] esAdultoMayor = new boolean [50];
    

    static boolean[] estaVendido = new boolean[50];    
    
    public static ArrayList<Double> descuentos = new ArrayList<>(Arrays.asList(0.0 , 0.10 , 0.20 , 0.15 , 0.25 ));
    // lista de facil modificacion de descuento 0=normal  / 1 = niños (10%) / 2 = mujeres (20%)
    //                                                    / 3 = Estudiantes (15%) / 4 = Adulto Mayor (25%)
    public static ArrayList<Integer> compraList = new ArrayList<>();                                                               
    static int contadorCompra = 1;
    
    
    public static void main(String[] args) {
     int opcion;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n===== SISTEMA TEATRO MORO =====");
            System.out.println("1. Comprar entrada");
            System.out.println("2. Ver asientos disponibles");
            System.out.println("3. Ver boleta");
            System.out.println("4. Modificar Compra");
            System.out.println("5. Eliminar Compra");
            System.out.println("6. Ver Descuentos");
            System.out.println("7. Salir"); // Nueva opción
            System.out.print("Ingrese una opcion: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    comprarEntrada(scanner);
                    break;
                case 2:
                    verAsientosDisponibles(scanner);
                    break;
                case 3:
                    verBoleta(scanner);
                    break;
                case 4:
                    modificarCompra(scanner);
                    break;
                case 5:
                    eliminarCompra(scanner);
                    break;
                case 6:
                    verDescuentos(scanner); 
                    break;
                case 7:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

            if (opcion != 7) {
                System.out.println("Desea volver al menu principal?");
                System.out.println("1. Si");
                System.out.println("2. No");
                System.out.print("Ingrese una opcion: ");
                int volver = scanner.nextInt();
                if (volver == 2) {
                    break;
                }
            }

        } while (opcion != 7);
    }

    // METODOS DEL MENU ///////////////////////////////////////////////////////////////

    public static void comprarEntrada(Scanner scanner) {
        System.out.println("  "); // Espacio
        System.out.println("[Ingrese sus datos]");
        
        //PEDIR NOMBRE
        System.out.println("Ingrese su primer nombre: ");
        String nombre = scanner.next();
                //obligamos a cliente a cumplir con el parametro del nombre
                if (nombre.matches(".*\\d.*")) {
                System.out.println("Nombre no Valido");
                return;
                }
                //fin obligacion
        //FIN PEDIR NOMBRE
         
        //PEDIR SEXO
        System.out.println("Cual es su sexo? (Hombre/Mujer)");
        String sexo = scanner.next();
        if (!sexo.equalsIgnoreCase("Hombre") && !sexo.equalsIgnoreCase("Mujer")) {
        System.out.println("Opcion Invalida");
        return;
        }
        //FIN PEDIR SEXO
        
        //PEDIR EDAD
        int edad = -1;
        while (edad < 1 || edad > 100) {
        System.out.println("Ingrese su edad (1 a 100): ");
        edad = scanner.nextInt();
            if (edad < 1 || edad > 100) {
            System.out.println("Edad Invalida");
            }
            } 
        //FIN PEDIR EDAD
      
      
        mostrarPlano(); //optimizamos codigo ahorrando codigo.

        System.out.println("Ingrese la zona preferida (Ejemplo = VIP)");
        scanner.nextLine();
        String zona = scanner.nextLine();
        
           int asiento= -1; // para poder usarlos fuera del switch
           int precioEntradaTemp = 0;
           switch (zona.toLowerCase()) {
            case "vip":
                System.out.println(" ");
                System.out.println("Ingrese asiento preferido (1-10): ");
                    asiento = scanner.nextInt();
                  
                   // verficicacion que sea de la zona y asinacion precio//
                   if(asiento < 1 || asiento > 10 ) {
                   System.out.println("Asiento no valido.");
                   return;
                   } else {
                   System.out.println("Has seleccionado el asiento " + asiento + " en zona VIP.");
                   precioEntradaTemp = 25000;
                   }
                   // fin verificacion
                break;

            case "palco":
                System.out.println(" ");
                System.out.println("Ingrese asiento preferido (11-20): ");
                   asiento = scanner.nextInt(); // ya no ponemos int porq lo creamos dentro del mismo switch

                   // verficicacion que sea de la zona y asinacion precio//
                   if(asiento < 11 || asiento > 20 ) {
                   System.out.println("Asiento no valido.");
                   return;
                   } else {
                   System.out.println("Has seleccionado el asiento " + asiento + " en zona PALCO.");
                   precioEntradaTemp = 20000;
                   }
                   // fin verificacion
                break;
            case "platea baja":
                System.out.println(" ");
                System.out.println("Ingrese asiento preferido (21-30): ");
                   asiento = scanner.nextInt(); // ya no ponemos int porq lo creamos dentro del mismo switch
                   // verficicacion que sea de la zona y asinacion precio//
                   if(asiento < 21 || asiento > 30) {
                   System.out.println("Asiento no valido.");
                   return;
                   } else {
                   System.out.println("Has seleccionado el asiento " + asiento + " en zona PLATEA BAJA");
                   precioEntradaTemp = 15000;
                   }
                   // fin verificacion

                break;
            case "platea alta":
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("Ingrese asiento preferido (31-40): ");
                   asiento = scanner.nextInt(); // ya no ponemos int porq lo creamos dentro del mismo switch
                   // verficicacion que sea de la zona y asinacion precio//
                   if(asiento <31 || asiento > 40) {
                   System.out.println("Asiento no valido.");
                   return;
                   } else {
                   System.out.println("Has seleccionado el asiento " + asiento + " en zona PLATEA ALTA");
                   precioEntradaTemp = 10000;
                   }
                   // fin verificacion
         
                break;
            case "galería":
                System.out.println(" ");
                System.out.println("Ingrese asiento preferido (41-50): ");
                   asiento = scanner.nextInt(); // ya no ponemos int porq lo creamos dentro del mismo switch
                   // verficicacion que sea de la zona y asinacion precio//
                   if(asiento < 41 || asiento > 50) {
                   System.out.println("Asiento no valido.");
                   return;
                   } else {
                   System.out.println("Has seleccionado el asiento " + asiento + " en zona GALERIA");
                   precioEntradaTemp = 15000;
                   }
                   // fin verificacion
       
                break;
            default:
                System.out.println("Zona invalida.");
                return;
        }
           
        // verficicacion dispnibilidad asiento //
        if (estaVendido[asiento - 1]) {
        System.out.println("Error: Asiento ya vendido");
        return;
        }
        // fin verificacion
        
        //////DESCUENTOS DESCUENTOS DESCUENTOS DESCUENTOS //////
        ///LOS DESCUENTOS ESTAN ORDENADOS DE MENOR A MAYOR
        ///PARA BENEFICIO DEL CLIENTE
        ///
       
         //inicio descuento nino
        boolean esNinoTemporal = false;
        double tasaDescuentoTemporal=0;
        if (edad < 15) {
        System.out.println("Descuento Joven: Activado");
        esNinoTemporal = true;
        esNino[asiento - 1] = esNinoTemporal; // guardar valor
        tasaDescuentoTemporal = descuentos.get(1); // 
        tasaDescuento[asiento - 1] = tasaDescuentoTemporal;
}
        //fin descuento nino 
        
        //inicio descuento mujer
        boolean esMujerTemporal = false;

         if (sexo.equalsIgnoreCase("Mujer")) {
         System.out.println("Descuento Mujer: Activado");
         esMujerTemporal = true;
         esMujer[asiento - 1] = esMujerTemporal; // guardar en el arreglo
         tasaDescuento[asiento - 1] = descuentos.get(2); // 20%
}
        //fin descuento mujer
        
        // inicio descuento estudiante y verificion
        boolean esEstudianteTemporal;
        System.out.println("Usted es estudiante? (1 / 2) ");
        System.out.println("1. Si");
        System.out.println("2. No");
        int respuesta = scanner.nextInt();
        
        if (respuesta == 1 ) {
            esEstudianteTemporal = true;
            System.out.println("Descuento Estudiante = Activado");
            esEstudiante[asiento - 1] = esEstudianteTemporal; // guardo valor
            tasaDescuentoTemporal = descuentos.get(3);
            tasaDescuento[asiento - 1]= tasaDescuentoTemporal; //guardo valor
        } 
        //fin.
            
        
         //inicio descuento adulto mayor
        boolean esAdultoMayorTemporal;
        
        if (edad >= 60) {
        System.out.println("Descuento Adulto Mayor: Activado");
        esAdultoMayorTemporal = true;
        esAdultoMayor[asiento - 1] = esAdultoMayorTemporal; // guardo valor
        tasaDescuentoTemporal = descuentos.get(4);
        tasaDescuento[asiento - 1]= tasaDescuentoTemporal; //guardo valor
        }
        //fin descuento adulto mayor 
        
        //////DESCUENTOS DESCUENTOS DESCUENTOS DESCUENTOS //////
        
        // Generar ID compra
         int idCompra = contadorCompra++;
         tasaDescuento[asiento - 1] = tasaDescuentoTemporal;
         //fin asignacion id compra
         
       
        precioEntrada[asiento - 1] = precioEntradaTemp; //guardo valor entrada en array
        edadBox[asiento - 1] = edad; //guardo valor
        idCompraBox[asiento - 1] = idCompra; //guardo valor
        nombreCliente[asiento - 1] = nombre; //guardo valor
        
         //resumen finalizacion compra
        
        //calculo monto final y guardado valor en array
        double precioFinalTemporal = precioEntrada[asiento - 1] * (1 - tasaDescuento[asiento - 1]);
        precioFinal[asiento -1 ] = precioFinalTemporal;
        // fin calculo monto final y guardado valor en array
        
        
        

        System.out.println("\n========= Resume de compra =========");
        System.out.println(" ");
        System.out.println("Id Compra= " + idCompraBox[asiento - 1]);
        System.out.println("Nombre=  "+nombreCliente[asiento - 1]);
        System.out.println("Edad= "+edadBox[asiento - 1]);
        System.out.println("Asiento= " +asiento);
        System.out.println("Precio Entrada= " + precioEntrada[asiento - 1]);
        System.out.println("Tasa Descuento= " + (int)(tasaDescuento[asiento - 1] * 100) + "%");
        System.out.println("Precio Final= " + (int) precioFinal[asiento - 1]);
        System.out.println(" ");
        System.out.println("==========================================\n");
        
        //cambiando estado de asiento a vendido 
        estaVendido[asiento - 1] = true;    
        // finalizando cambio 
        
    }


        

    public static void verAsientosDisponibles(Scanner scanner) {
    System.out.println("  ");
    System.out.println("========= Asientos Disponibles =========");
    for (int i = 0; i < estaVendido.length; i++) {
        if (estaVendido[i] == false ) {
            System.out.println("Asiento "+(i+1));
        }
    }
    System.out.println("========================================\n");
}

    public static void verBoleta(Scanner scanner) {
        System.out.println("  ");
        int asiento = 0;
        int idCompra =0;
        System.out.println("Cual es su numero de asiento?");
        asiento = scanner.nextInt();
        
         if (precioFinal[asiento - 1] != 0){
              System.out.println(" ");
              System.out.println("\n========= Boleta Electronica =========");
              System.out.println(" ");
              System.out.println("Id Compra= " + idCompraBox[asiento - 1]);
              System.out.println("Nombre=  "+nombreCliente[asiento - 1]);
              System.out.println("Edad= "+edadBox[asiento - 1]);
              System.out.println("Asiento= " +asiento);
              System.out.println("Precio Entrada= " + precioEntrada[asiento - 1]);
              System.out.println("Tasa Descuento= " + (int)(tasaDescuento[asiento - 1] * 100) + "%");
              System.out.println("Precio Final= " + (int) precioFinal[asiento - 1]);
              System.out.println(" ");
              System.out.println("==========================================\n");
        } else{
            System.out.println("compra no encontrada");
}
    }

    public static void verDescuentos(Scanner scanner) {
        System.out.println("\n========= Descuentos =========");
        System.out.println(" ");
        System.out.println("Ninos        : 10%  (Hasta 14 edad)");
        System.out.println("Mujeres      : 20%");
        System.out.println("Estudiantes  : 15%");
        System.out.println("Tercera edad : 25%  (Desde 60 edad)");
        System.out.println(" ");
        System.out.println("================================\n");
    }
    
     public static void eliminarCompra(Scanner scanner) {
        System.out.println("  ");
        int asiento = 0;
        System.out.println("Cual es su numero de asiento?");
        asiento = scanner.nextInt();
        
        if (estaVendido  [asiento -1] == true) {
           System.out.println(" ");
           System.out.println("\n========= Registro Encontrado =========");
           System.out.println(" ");
           System.out.println("Id Compra= " + idCompraBox[asiento - 1]);
              idCompraBox[asiento - 1]=0; //pongo valor por defecto
              estaVendido[asiento - 1] = false; //pongo valor por defecto
           System.out.println("Nombre=  "+nombreCliente[asiento - 1]);
              nombreCliente[asiento - 1] = null; //pongo valor por defecto
           System.out.println("Edad= "+edadBox[asiento - 1]);
              edadBox[asiento - 1] = 0; //pongo valor por defecto
           System.out.println("Asiento= " +asiento);
              // es mi referencia 
           System.out.println("Precio Entrada= " + precioEntrada[asiento - 1]);
              precioEntrada[asiento - 1] = 0; //pongo valor por defecto
           System.out.println("Tasa Descuento= " + (int)(tasaDescuento[asiento - 1] * 100) + "%");
              tasaDescuento[asiento - 1] = 0; //pongo valor por defecto
           System.out.println("Precio Final= " + (int) precioFinal[asiento - 1]);
              precioFinal[asiento - 1] = 0; //pongo valor por defecto
           System.out.println(" ");
           System.out.println("==========================================\n");
           
        } else {
            System.out.println("ERROR: Compra no encontrada");
        }
      
    }
     
    public static void modificarCompra(Scanner scanner) {
        System.out.println("  ");
        int asiento = 0;
        System.out.println("Cual es su numero de asiento?");
        asiento = scanner.nextInt();
         if (estaVendido  [asiento -1] == true) {
             //borramos registros
             System.out.println("\n========= Registro Encontrado =========");
             System.out.println(" ");
             System.out.println("Id Compra= " + idCompraBox[asiento - 1]);
             idCompraBox[asiento - 1]=0; //pongo valor por defecto
             estaVendido[asiento - 1] = false; //pongo valor por defecto
             System.out.println("Nombre=  "+nombreCliente[asiento - 1]);
             nombreCliente[asiento - 1] = null; //pongo valor por defecto
             System.out.println("Edad= "+edadBox[asiento - 1]);
             edadBox[asiento - 1] = 0; //pongo valor por defecto
             System.out.println("Asiento= " +asiento);
             // es mi referencia 
             System.out.println("Precio Entrada= " + precioEntrada[asiento - 1]);
             precioEntrada[asiento - 1] = 0; //pongo valor por defecto
             System.out.println("Tasa Descuento= " + (int)(tasaDescuento[asiento - 1] * 100) + "%");
             tasaDescuento[asiento - 1] = 0; //pongo valor por defecto
             System.out.println("Precio Final= " + (int) precioFinal[asiento - 1]);
             precioFinal[asiento - 1] = 0; //pongo valor por defecto
             System.out.println(" ");
             System.out.println("==========================================\n");
             
             //lo redirigimos a comprarlo nuevamente
             comprarEntrada(scanner);
         }  else {
            System.out.println("ERROR: Compra no encontrada");
        }
        

    
      
    }
    
   
    
 
     public static void mostrarPlano() {
        System.out.println("\n========= PLANO DEL TEATRO MORO =========");
        System.out.println(" ");
        System.out.println("          1-10  ($25.000) VIP");
        System.out.println("         11-20  ($20.000) Palco");
        System.out.println("         21-30  ($15.000) Platea Baja");
        System.out.println("         31-40  ($10.000) Platea Alta");
        System.out.println("         41-50  ($5.000 ) Galeria");
        System.out.println(" ");
        System.out.println("==========================================\n");
    }   
    
}



