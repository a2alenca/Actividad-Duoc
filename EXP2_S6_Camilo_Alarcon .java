/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s6.pkg1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Charchilla
 */
public class S61 {

    public static boolean[] estaReservado = new boolean[20];
    public static boolean[] estaVendido = new boolean[20];
    public static boolean [] esSocio = new boolean [20]; 
    public static boolean [] tieneDescuento = new boolean [20]; 
    
    public static double [] precioEntrada = new double [20]; 
    public static double [] precioTotal = new double [20]; 
    public static Double [] tasaDescuento = new Double [20]; 
    
    
    public static double precioEntradaTemporal = 1000;
    public static double precioTotalTemporal =0;
    public static Double tasaDescuentoTemporalPublicoGeneral  =0.0;
    public static Double tasaDescuentoTemporalSocio  =0.10;
    
    
    //estadisticas globales
    public static double estadisticaTotalIngresos;
    public static double estadisticaCantidadEntradasVendidas;
    
    
   
    // Entrando al MAIN
    public static void main(String[] args) {
        // TODO code application logic here

        // variables estaticas
        // fin creacion entradas
        //creamos scanner
        int opcion;
        Scanner scanner = new Scanner(System.in);
        // fin creacion scanner

        //Estrutura menu interactivo
        do {
            System.out.println("          ");
            System.out.println(":_:_:Teatro Moro:_:_");
            System.out.println("1.Reserva entrada");
            System.out.println("2.Comprar Entrada");
            System.out.println("3.Modificar una venta existente");
            System.out.println("4.Imprimir boleta");
            System.out.println("5.Estadisticas globales");
            System.out.println("6.Salir");
            System.out.println(":_:_:_:_:_:_:_:_:_:_:");
            System.out.print("ingrese una opcion: ");
            System.out.println(" ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(" ");
                    reservaEntrada(scanner);

                    break;
                case 2:
                    System.out.println(" ");
                    compraEntrada(scanner);
                    break;
                case 3:
                    System.out.println(" ");
                    modificacionReserva(scanner);
                    break;
                case 4:
                    System.out.println(" ");
                    imprimirBoleta(scanner);
                    break; 
                case 5:
                    System.out.println(" ");
                    estadisticas(scanner);
                    break;
                case 6:
                    System.out.println("hasta pronto");
                    break;
                default:
                    System.out.println("selecciona opcion correcta");
                    break;
            }

            if (opcion != 6) {
                System.out.println(":_:_:__:_:_:_:_:_:_:_:_:_:_::");
                System.out.println("deseas volver al menu principal?");
                System.out.println("1.SI");
                System.out.println("2.NO");
                System.out.print("Ingrese una opcion: ");
                System.out.println(" ");
                int returnMenu = scanner.nextInt();
                if (returnMenu == 2) {
                    break;
                }
            }

        } while (opcion != 6);
    

    /// terminamos estructura menu interactivo
      
    }
    
    ///SALIENDO DEL MAIN
   
    //MODULO MAPA
    public static void mostrarPlano() {
        System.out.println("\n========= PLANO DEL TEATRO MORO =========");
        System.out.println(" ");
        System.out.println("         1 /2 /3 /4 /5   ($10.000)");
        System.out.println("         6 /7 /8 /9 /10  ($10.000)");
        System.out.println("         11/12/13/14/15  ($10.000)");
        System.out.println("         16/17/18/19/20  ($10.000)");
        System.out.println(" ");
        System.out.println("==========================================\n");
    }
    //FIN MODULO MAPA
    
   
            
    //interaccion reserva entrada
    static void reservaEntrada(Scanner scanner) {
        mostrarPlano();
        System.out.println("Que asiento desea reservar ? (1/20)");
        int seleccionUsuario = scanner.nextInt();  //capturamos valor usuario

        //volvemos el numero index como la seleccion de usuario para todas las
        //opciones asi podemos accede a todo.
        int index = seleccionUsuario - 1;
        //fin transformacion
 
        System.out.println("has seleccionado el asiento "+seleccionUsuario); //PUNTO 1 DEPURACION RESERVA :)*********************************************
        
        //verificacion reserva y compra
        if (estaReservado[index] ==true){                                   //PUNTO 2 DEPURACION RESERVA :)*********************************************
            System.out.println("El asiento se encuentra reservado");

        } else if (estaVendido[index] ==true) {
            System.out.println("Asiento se encuentra vendido");
        } else  {
            estaVendido[index]=false;
                estaVendido[index]=true;
                estaReservado[index]=true;
                System.out.println("Asiento Reservado exitosamente"); 
                ///// CREAMOS UN TEMPORIZADOR /////
                //temporizador 1 minuto
                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                @Override
                public void run() {
                System.out.println("Tiempo de reserva finalizado");
                System.out.println("Tu asiento se encuentra liberado");
                System.out.println("Hasta Pronto");
                estaVendido[index]=false;
                estaReservado[index]=false;                                      //PUNTO 3 DEPURACION RESERVA :)*********************************************
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
        
        
                 if (eleccionTemporizador== 1) {
                        timer.cancel();
                        System.out.println("   "); // dar espacio
                        System.out.println("Que tipo de cliente eres?");
                        System.out.println("1.Publico General");
                        System.out.println("2.Socio Teatro Moro");
                        System.out.println("    ");
                        System.out.println("Ingrese una opcion: ");
                        int tipoCliente = scanner.nextInt();
                        if (tipoCliente ==1){
                          estaVendido[index]=true;
                          estaReservado[index]=false;
                          System.out.println("    "); // solo para dar espacio
                          System.out.println("Bienvenido Cliente");
                          System.out.println("Has Seleccionado opcion: Publico General");
                          System.out.println("    "); // solo para dar espacio
                          System.out.println("Asiento Comprado exitosamente"); 
                          System.out.println("    "); // solo para dar espacio
                          System.out.println(":_:_:_:_Resumen de compra:_:_:_:_:_:_:_:");
                          // creamos una variable de precio entrada temporal solo para 
                          // que esta se dedique a enviar precio al index correspondiente
                          precioEntrada[index] = (precioEntradaTemporal) ; //
                          System.out.println("Entrada = "+precioEntrada[index]);
                          System.out.println("Cantidad = 1");
                          // creamos una variable de precio entrada temporal solo para 
                          // que esta se dedique a enviar precio al index correspondiente
                          tasaDescuento[index] = tasaDescuentoTemporalPublicoGeneral;
                          System.out.println("Descuento = "+tasaDescuento[index]*100);
                          //sacamos la operacion en otra entrada temporal
                          precioTotalTemporal = (precioEntradaTemporal*1)-(precioEntradaTemporal*tasaDescuentoTemporalPublicoGeneral);
                          precioTotal[index]= precioTotalTemporal;
                          System.out.println("Precio Final = "+precioTotal[index]);
                          // fin calculos
                          System.out.println("   ");// solo para dar espacio
                    
                   
                         } else {
                         System.out.println("    "); // solo para dar espacio
                         System.out.println("Bienvenido Socio Teatro Moro");
                         System.out.println("Has Seleccionado opcion: Socio Teatro");
                         System.out.println("    "); // solo para dar espacio
                         System.out.println("Asiento Comprado exitosamente"); 
                         System.out.println("    "); // solo para dar espacio
                        System.out.println(":_:_:_:_Resumen de compra:_:_:_:_:_:_:_:");
                         // creamos una variable de precio entrada temporal solo para 
                         // que esta se dedique a enviar precio al index correspondiente
                         precioEntrada[index] = (precioEntradaTemporal);
                         System.out.println("Entrada = "+precioEntrada[index]);
                         // creamos una variable de precio entrada temporal solo para 
                         // que esta se dedique a enviar precio al index correspondiente
                         tasaDescuento[index] = (tasaDescuentoTemporalSocio);
                         System.out.println("Descuento = "+tasaDescuento[index]*100);
                         //sacamos la operacion en otra entrada temporal
                         precioTotalTemporal = (precioEntradaTemporal*1)-(precioEntradaTemporal*tasaDescuentoTemporalSocio);
                         precioTotal[index]= precioTotalTemporal;
                         System.out.println("Precio Final = "+precioTotal[index]);
                         // fin calculos
                        System.out.println("   ");// solo para dar espacio                 
                    }
                 
                  } else {
                System.out.println("Ingrese un numero valido");
                 }
                 ///// FIN OPCION PARA SALIR DEL TEMPORIZADOR  ///// 
        }
        //fin verificacion
        
    }
    //fin interaccion reserva entrada

    //interaccion compra entrada
    static void compraEntrada(Scanner scanner) {
        mostrarPlano();
        System.out.println("Que asiento desea adquirir? (1/20)");
        int seleccionUsuario = scanner.nextInt(); //capturamos valor usuario

        //volvemos el numero index como la seleccion de usuario para todas las
        //opciones asi podemos accede a todo.
        int index = seleccionUsuario -1;
        //fin transformacion
 
        System.out.println("has seleccionado el asiento "+seleccionUsuario);     //PUNTO 1 DEPURACION LOGICA Y VALIDACION ASIENTO :)*********************************************
        
        //verificacion reserva y proceso de compra
        if (estaReservado[index] ==true){                                         //PUNTO 2 DEPURACION LOGICA Y VALIDACION ASIENTO :)*********************************************
            System.out.println("El asiento se encuentra reservado");
        } else if (estaVendido[index] ==true) {
            System.out.println("Asiento se encuentra vendido");
        } else  {
            estaReservado[index] =false;
                 if (estaVendido[index] ==true){
                 System.out.println("El asiento se encuentra comprado");           //PUNTO 3 DEPURACION LOGICA Y VALIDACION ASIENTO :)*********************************************
                 }  else  {
                 estaVendido[index] =true;
            
                System.out.println("Que tipo de cliente eres?");
                System.out.println("1.Publico General");
                System.out.println("2.Socio Teatro Moro");
                System.out.println("    ");
                System.out.println("Ingrese una opcion: ");
                int tipoCliente = scanner.nextInt();
                   if (tipoCliente ==1){
                   System.out.println("    "); // solo para dar espacio
                   System.out.println("Bienvenido Cliente");
                   System.out.println("Has Seleccionado opcion: Publico General");
                   System.out.println("    "); // solo para dar espacio
                   System.out.println("Asiento Comprado exitosamente"); 
                   System.out.println("    "); // solo para dar espacio
                   System.out.println(":_:_:_:_Resumen de compra:_:_:_:_:_:_:_:");
                   // creamos una variable de precio entrada temporal solo para 
                   // que esta se dedique a enviar precio al index correspondiente
                   precioEntrada[index] = (precioEntradaTemporal) ; //
                   System.out.println("Entrada = "+precioEntrada[index]);
                   System.out.println("Cantidad = 1");
                   // creamos una variable de precio entrada temporal solo para 
                   // que esta se dedique a enviar precio al index correspondiente
                   tasaDescuento[index] = tasaDescuentoTemporalPublicoGeneral;
                   System.out.println("Descuento = "+tasaDescuento[index]*100);
                   //sacamos la operacion en otra entrada temporal
                   precioTotalTemporal = (precioEntradaTemporal*1)-(precioEntradaTemporal*tasaDescuentoTemporalPublicoGeneral);
                   precioTotal[index]= precioTotalTemporal;
                   System.out.println("Precio Final = "+precioTotal[index]);
                   // fin calculos
                   System.out.println("   ");// solo para dar espacio
                    
                   
                   } else {
                   System.out.println("    "); // solo para dar espacio
                   System.out.println("Bienvenido Socio Teatro Moro");
                   System.out.println("Has Seleccionado opcion: Socio Teatro");
                   System.out.println("    "); // solo para dar espacio
                   System.out.println("Asiento Comprado exitosamente"); 
                   System.out.println("    "); // solo para dar espacio
                   System.out.println(":_:_:_:_Resumen de compra:_:_:_:_:_:_:_:");
                   // creamos una variable de precio entrada temporal solo para 
                   // que esta se dedique a enviar precio al index correspondiente
                   precioEntrada[index] = (precioEntradaTemporal);
                   System.out.println("Entrada = "+precioEntrada[index]);
                   // creamos una variable de precio entrada temporal solo para 
                   // que esta se dedique a enviar precio al index correspondiente
                   tasaDescuento[index] = (tasaDescuentoTemporalSocio);
                   System.out.println("Descuento = "+tasaDescuento[index]*100);
                   //sacamos la operacion en otra entrada temporal
                   precioTotalTemporal = (precioEntradaTemporal*1)-(precioEntradaTemporal*tasaDescuentoTemporalSocio);
                   precioTotal[index]= precioTotalTemporal;
                   System.out.println("Precio Final = "+precioTotal[index]);
                   // fin calculos
                   System.out.println("   ");// solo para dar espacio                 
                }
                }                
        }
        //fin verificacion
        //code

    }

    //fin interaccion compra entrada   
    
    
    //Entrada interaccion modificacion compra
    static void modificacionReserva(Scanner scanner) {
        //code
        mostrarPlano();
        System.out.println("Escriba su numero de asiento");
        int seleccionUsuario = scanner.nextInt(); //capturamos valor usuario
        int index = seleccionUsuario -1;
       
        if (estaVendido[index]==true){
            System.out.println("Compra Encontrada existosamente");
            System.out.println("   ");  //espacio
            System.out.println("Anulando..Procedimiento anterior");
            System.out.println("   ");  //espacio
            System.out.println("Anulando......  ");
            estaReservado[index]=false;
            estaVendido[index]=false;
            esSocio[index]= false;
            tieneDescuento[index] = false;
            
            precioEntrada[index]= 0.0;
            precioTotal[index] =0.0;
            tasaDescuento[index]=0.0;
            
            System.out.println("Su numero de entrada ha sido liberada");
            System.out.println("   ");  //espacio
            System.out.println("Montos descontados de nuestro sistema");
            System.out.println("   ");  //espacio
            System.out.println("Redirigiendo a modificar su entrada");
            System.out.println("   ");  //espacio
            System.out.println("Redirigiendo...");
            System.out.println("    "); //espacio
            compraEntrada(scanner);
            
            
            
        } else
            System.out.println("Compra no encontrada");

                

    }
    //fin interaccion modificacion compra

    //intereaccion imprimir boleta
    static void imprimirBoleta(Scanner scanner) {
        //code
        System.out.println("Ingrese su numero de asiento: ");               
        int seleccionUsuario = scanner.nextInt(); //capturamos valor usuario
        System.out.println("   ");
        //volvemos el numero index como la seleccion de usuario para todas las
        //opciones asi podemos accede a todo.
        int index = seleccionUsuario -1;
        
        
        if (estaVendido[index] == true){                                          //PUNTO 1 DEPURACION BOLETA :)*********************************************
        System.out.println("=====================");
        System.out.println("BOLETA ELECTRONICA");
        System.out.println("=====================");
        System.out.println("Servicios Teatro Moro LTDA");
        System.out.println("Entrada = "+precioEntrada[index]);
        System.out.println("Cantidad = 1");
        System.out.println("Descuento = "+tasaDescuento[index]*100);
        System.out.println("Precio Final = "+precioTotal[index]);
        System.out.println("   ");// solo para dar espacio  
        System.out.println("=====================");
        System.out.println("=====================");
            
        } else {
            System.out.println("El asiento no se encuentra vendido");               
        }
        //fin transformacion
        
        
    }
    // fin interaccion imprimir boleta
    
    
    //comiento interaccion estadisticas
    static void estadisticas(Scanner scanner) {
    System.out.println(":_:_Estadisticas Globales:_:;_:");
    
    estadisticaTotalIngresos=0;
    estadisticaCantidadEntradasVendidas=0;
    // Sumar la cantidad del total de ingresos
    
    for (int i= 0; i <20; i++){                                                     //PUNTO 2 DEPURACION BOLETA :)*********************************************
        if (estaVendido[i]){
            estadisticaTotalIngresos = estadisticaTotalIngresos+precioTotal[i];
        }
    }
    
      System.out.println("Total de ingresos= " + estadisticaTotalIngresos);
    
   // Sumar la cantidad entradas vendidas                                                 //PUNTO 3 DEPURACION BOLETA :)*********************************************
   for (int i= 0; i <20; i++){
        if (estaVendido[i]){
            estadisticaCantidadEntradasVendidas = estadisticaCantidadEntradasVendidas + 1;
        }
    }
    
     
      System.out.println("Cantidad Entradas= " +  estadisticaCantidadEntradasVendidas);
    
}
}
    //fin interaccion total ingreso