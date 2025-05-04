/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp3_s8_camilo_alarcon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Charchilla
 */
public class EXP3_S8_Camilo_Alarcon {

    /**
     * @param args the command line arguments
     */
     // Contador iD
    private static int contadorCompra = 1;
    private static final int contadorReserva = 1;
   

    // Lista id
    private static final ArrayList<Integer> reservaList = new ArrayList<>();
    private static final ArrayList<Integer> compraList = new ArrayList<>();
    
    // 
    public static String [] idCliente = new String [30];
    public static String [] nombreCliente = new String [30];
    public static int [] edadBox = new int [30];
    public static int [] precioEntrada = new int [30];
    public static int[] idCompraBox = new int[30];
    public static double[] tasaDescuento = new double[30];
    public static double[] precioFinal = new double[30];
     
    
    public static boolean [] esEstudiante = new boolean [30];
    public static boolean [] esAdultoMayor = new boolean [30];

    public static ArrayList<Double> descuentos = new ArrayList<>(Arrays.asList(0.0 , 0.10, 0.15 , 0.0 , 0.0 ));
    // lista de facil modificacion de descuento                       0=normal  / 2 = estudiante 
                                                                    //3=Adult.Mayor / 4= modificable
    static boolean[] estaReservado = new boolean[30];
    static boolean[] estaVendido = new boolean[30];    
    //
    
    public static void main(String[] args) {
       int opcion;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n===== SISTEMA TEATRO MORO =====");
            System.out.println("1. Reservar Asiento");
            System.out.println("2. Comprar Entrada");
            System.out.println("3. Modificar Compra");
            System.out.println("4. Eliminar Compra");
            System.out.println("5. Generar Boleta");
            System.out.println("6. Ver Descuentos");
            System.out.println("7. Salir");
            System.out.print("Ingrese una opcion: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    reservarAsiento(scanner);
                    break;
                case 2:
                    comprarEntrada(scanner);
                    break;
                case 3:
                    modificarReservaCompra(scanner);
                    break;
                case 4:
                    eliminarCompra(scanner);
                    break;
                case 5:
                    generarBoleta(scanner);
                    break;
                case 6:
                    verDescuentos(scanner);
                    break;
                case 7:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opcion inválida");
                    break;
            }

            if (opcion != 7) {
                System.out.println("Desea volver al menu principal?");
                System.out.println("1. si");
                System.out.println("2. No");
                System.out.print("Ingrese una opcion: ");
                int volver = scanner.nextInt();
                if (volver == 2) {
                    break;
                }
            }

        } while (opcion != 7);
    }
    
    // entrada

// entrada

public static void reservarAsiento(Scanner scanner) {
    System.out.println("  ");
    System.out.println("[Reservar Asiento]");
    System.out.println("  ");
    mostrarPlano();  //optimizamos codigo ahorrando codigo.
    System.out.print("Que asiento desea reservar? (1/30): ");
    int asiento = scanner.nextInt();
    

    if (asiento < 1 || asiento > 30) {
        System.out.println("El teatro solo posee asientos del 1 al 30");
        return;
    }

    if (estaVendido[asiento - 1]) {
        System.out.println("Asiento ya vendido");
        return;
    }

    if (estaReservado[asiento - 1]) {
        System.out.println("Asiento ya reservado");
        return;
    }

    ///// CREAMOS UN TEMPORIZADOR /////
                //temporizador 1 minuto
                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                @Override
                public void run() {
                System.out.println("Tiempo de reserva finalizado");
                System.out.println("Tu asiento se encuentra liberado");
                System.out.println("Hasta Pronto");
                estaVendido[asiento-1]=false;
                estaReservado[asiento-1]=false;                                      
                System.exit(0); 
                }
                };
                timer.schedule(task, 60000); // 1 minuto
                ///// DAMOS FIN AL CODIGO DEL TEMPORIZADOR /////
         
                ///// CREAMOS OPCION PARA SALIR DEL TEMPORIZADOR  /////
                int eleccionTeporizador =2;
                System.out.println("Tienes 1 minuto para comprar tu entrada,antes que se libere");
                System.out.println("   "); // dar espacio
                System.out.println("si quieres comprar ahora selecciona escriba = 1");
                System.out.println("   "); // dar espacio
                int eleccionTemporizador = scanner.nextInt();
                if (eleccionTemporizador == 1) {
                        timer.cancel();
                     System.out.println("Muchas gracias por su reserva");
                     System.out.println("A continuacion confirme sus datos");
                     System.out.println("Para confirmar la compra");
                     estaVendido[asiento-1]=false;
                     estaReservado[asiento-1]=false;  
                     comprarEntrada(scanner); //optimizamos codigo ahorrando codigo.

                     } else {
                     System.out.println("Ingrese un numero valido");
                       }
}


    public static void comprarEntrada(Scanner scanner) {
        System.out.println("  "); // Espacio
        System.out.println("[Ingrese sus datos]");

        System.out.println("Ingrese rut del cliente (sin codigo verificador): ");
        System.out.println("Ejemplo = 12345678");
        String rut = scanner.next();
        //obligamos a cliente a cumplir con el parametro del rut
        if (!rut.matches("\\d{8}")) {
                System.out.println("RUT incorecto " + rut);
                return;
        }
        //fin obligacion
        
        System.out.println("Ingrese su primer nombre: ");
        String nombre = scanner.next();
        
        //obligamos a cliente a cumplir con el parametro del nombre
         if (nombre.matches(".*\\d.*")) {
                System.out.println("Nombre no Valido");
                return;
            }
         //fin obligacion
        
        
        //bucle edad
        int edad = -1;
        while (edad < 1 || edad > 100) {
        System.out.println("Ingrese su edad (1 a 100): ");
        edad = scanner.nextInt();
        if (edad < 1 || edad > 100) {
        System.out.println("Edad Invalida");
        }
         //fin bucle
 
   
    }  
       
        mostrarPlano(); //optimizamos codigo ahorrando codigo.

        System.out.println("Ingrese la zona preferida");
        System.out.println("1. VIP (asientos: 1-10)");
        System.out.println("2. Platea Alta (asientos: 11-20)");
        System.out.println("3. Platea Baja (asientos: 21-30)");
        System.out.print("Ingrese zona (1-2-3): ");
        int zona = scanner.nextInt();
        
        int asiento = -1;
        int precioEntradaTemp = 0;

        // Validación de zona y selección de asiento
        if (zona == 1) {
            System.out.println("Has seleccionado zona VIP.");
            System.out.println("Ingrese asiento preferido (1-10): ");
            asiento = scanner.nextInt();
                  // verficicacion disposicion asiento //
                   if (estaVendido[asiento - 1]) {
                   System.out.println("Error: Asiento ya vendido");
                   return;
                   } else if (estaReservado[asiento - 1]) {
                   System.out.println("Error: Asiento ya reservado");
                   return;
                   }
                  // fin verificacion
                  if(asiento < 1 || asiento > 10 ) {
                  System.out.println("Asiento no valido.");
                  return;
                  } else {
                  System.out.println("Has seleccionado el asiento " + asiento + " en zona VIP.");
                  precioEntradaTemp = 20000;
                  }
        } else if (zona == 2) {
            System.out.println("Has seleccionado zona Platea Alta.");
            System.out.println("Ingrese asiento preferido (11-20): ");
            asiento = scanner.nextInt();
                  // verficicacion disposicion asiento //
                   if (estaVendido[asiento - 1]) {
                   System.out.println("Error: Asiento ya vendido");
                   return;
                   } else if (estaReservado[asiento - 1]) {
                   System.out.println("Error: Asiento ya reservado");
                   return;
                   }
                  // fin verificacion
                 if (asiento < 11 || asiento > 20) {
                System.out.println("Asiento no valido.");
                return;
                 } else {
                System.out.println("Has seleccionado el asiento " + asiento + " en zona Platea Alta.");
                precioEntradaTemp = 15000;
                }
        } else if (zona == 3) {
            System.out.println("Has seleccionado zona Platea Baja.");
            System.out.println("Ingrese asiento preferido (21-30): ");
            asiento = scanner.nextInt();
                 // verficicacion disposicion asiento //
                   if (estaVendido[asiento - 1]) {
                   System.out.println("Error: Asiento ya vendido");
                   return;
                   } else if (estaReservado[asiento - 1]) {
                   System.out.println("Error: Asiento ya reservado");
                   return;
                   }
                  // fin verificacion
                if (asiento < 21 || asiento > 30) {
                System.out.println("Asiento no valido.");
                return;
                } else {
                System.out.println("Has seleccionado el asiento " + asiento + " en zona Platea Baja.");
                precioEntradaTemp = 10000;
                }
        } else {
            System.out.println("Zona no valida.");
            return;
        }
        
        
        //fin verificacion estudios
        System.out.println("Usted es estudiante? (1 / 2) ");
        System.out.println("1. Si");
        System.out.println("2. No");
        boolean esEstudianteTemporal = false;
        double tasaDescuentoTemporal = descuentos.get(0);
        int respuesta = scanner.nextInt();
        if (respuesta == 1 ) {
            esEstudianteTemporal = true;
            System.out.println("Descuento Estudiante = Activado");
            esEstudiante[asiento - 1] = esEstudianteTemporal; // guardo valor
            tasaDescuentoTemporal = descuentos.get(1);
            tasaDescuento[asiento - 1]= tasaDescuentoTemporal; //guardo valor
        } 
            
      
        // asignacion id compra
        int idCompra = contadorCompra++;
        compraList.add(idCompra);
        System.out.println("Id Compra= " + idCompra);
        
         //descuento adulto mayor
        boolean esAdultoMayorTemporal;
        
        if (edad >= 60) {
        System.out.println("Descuento Adulto Mayor: Activado");
        esAdultoMayorTemporal = true;
        esAdultoMayor[asiento - 1] = esAdultoMayorTemporal; // guardo valor
        tasaDescuentoTemporal = descuentos.get(2);
        tasaDescuento[asiento - 1]= tasaDescuentoTemporal; //guardo valor
        }
        //fin descuento adulto mayor 
        
        
         //fin asignacion id compra
         
        idCliente[asiento - 1] = rut; //guardo valor entrada en array
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
        System.out.println("id cliente(rut)= "+idCliente[asiento - 1]);
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
        estaReservado[asiento - 1]=false;
        // finalizando cambio 
        
        
     
    }
    

   

    public static void eliminarCompra(Scanner scanner) {
        System.out.println("  ");
        int asiento = 0;
        System.out.println("Cual es su numero de asiento?");
        asiento = scanner.nextInt();
        if (estaVendido [asiento -1] == true) {
           System.out.println(" ");
           System.out.println("\n========= Registro Eliminado =========");
           System.out.println(" ");
           System.out.println("Id Compra= " + idCompraBox[asiento - 1]);
                idCompraBox[asiento - 1] = 0;
                estaVendido[asiento - 1] = false;
           System.out.println("id cliente(rut)= "+idCliente[asiento - 1]);
                idCliente[asiento - 1] = null;
           System.out.println("Nombre=  "+nombreCliente[asiento - 1]);
                nombreCliente[asiento - 1] = null;
           System.out.println("Edad= "+edadBox[asiento - 1]);
                edadBox[asiento - 1] = 0;
           System.out.println("Asiento= " +asiento);
                // el asiento se ocupa como referencia 
           System.out.println("Precio Entrada= " + precioEntrada[asiento - 1]);
                precioEntrada[asiento - 1] = 0;
           System.out.println("Tasa Descuento= " + (int)(tasaDescuento[asiento - 1] * 100) + "%");
                tasaDescuento[asiento - 1] = 0;
           System.out.println("Precio Final= " + (int) precioFinal[asiento - 1]);
                precioFinal[asiento - 1] = 0;
           System.out.println(" ");
           System.out.println("==========================================\n");
        
        } else {
          System.out.println("ERROR: Asiento NO encontrado");
        }   
   
    }
    
     public static void modificarReservaCompra(Scanner scanner) {
        System.out.println("  ");
        System.out.println("[Modificar Compra]");
        eliminarCompra(scanner);
        System.out.println("Modifiquemos la Compra");
        comprarEntrada(scanner); //optimizamos codigo ahorrando codigo.
    }

    public static void generarBoleta(Scanner scanner) {
        System.out.println("  ");
        
        int asiento = 0;
        int idCompra =0;
        System.out.println("Cual es su numero de asiento?");
        asiento = scanner.nextInt();
        System.out.println("\n========= Boleta Electronica =========");
        System.out.println(" ");
        System.out.println("Id Compra= " + idCompraBox[asiento - 1]);
        System.out.println("id cliente(rut)= "+idCliente[asiento - 1]);
        System.out.println("Nombre=  "+nombreCliente[asiento - 1]);
        System.out.println("Edad= "+edadBox[asiento - 1]);
        System.out.println("Asiento= " +asiento);
        System.out.println("Precio Entrada= " + precioEntrada[asiento - 1]);
        System.out.println("Tasa Descuento= " + (int)(tasaDescuento[asiento - 1] * 100) + "%");
        System.out.println("Precio Final= " + (int) precioFinal[asiento - 1]);
        System.out.println(" ");
        System.out.println("==========================================\n");
    }

    public static void verDescuentos(Scanner scanner) {
        System.out.println("[Descuentos disponibles]");
        System.out.println("Estudiantes = 10%");
        System.out.println("Adulto Mayor = 15%");
    }


    // Módulo de mapa del cine
    public static void mostrarPlano() {
        System.out.println("\n========= PLANO DEL TEATRO MORO =========");
        System.out.println(" ");
        System.out.println("          1-10  ($20.000) VIP");
        System.out.println("         11-20  ($15.000) PLATEA ALTA");
        System.out.println("         21-30  ($10.000) PLATEA BAJA");
        System.out.println(" ");
        System.out.println("==========================================\n");
    }
    
    // Módulo de resumen
   
    // Fin de módulo de mapa

    
    
  
    
}

