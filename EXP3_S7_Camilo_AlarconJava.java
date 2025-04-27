/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp3_s7_camilo_alarcon.java;

/**
 *
 * @author Charchilla
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EXP3_S7_Camilo_AlarconJava {

       // scanner y zonas globales para usar metodos
        static Scanner scanner = new Scanner(System.in);
        static String zona = null;
        
        static boolean esEstudiante =false;
        static boolean esAdultoMayor =false;
        static String cliente = "Publico General";
        
        static float precioEntrada;
        static float valorDescuento;
        static float precioTotal;
        
        static int contadorEntradas = 1;
        static float estadisticaTotalIngreso;
        
        static List<Integer> numeroEntradaLista = new ArrayList<>();
        static List<String> zonaLista = new ArrayList<>();
        static List<Float> precioEntradaLista = new ArrayList<>();
        static List<Float> ValorDescuentoLista = new ArrayList<>();
        static List<Float> precioTotalLista = new ArrayList<>();
        static List <Float> listaUnida = new ArrayList<>();

     

  
        
        
        
        // Entrando al MAIN
        public static void main(String[] args) {
        // TODO code application logic here

      
  
        int opcion;
 
        // fin creacion scanner

        //Estrutura menu interactivo
        do {
            System.out.println("          ");
            System.out.println(":_:_:Teatro Moro:_:_");
            System.out.println("1.Venta de entrada");
            System.out.println("2.visualizar resumen venta");
            System.out.println("3.generar boleta");
            System.out.println("4.Calcular ingresos totales");
            System.out.println("5.Salir");
            System.out.println(":_:_:_:_:_:_:_:_:_:_:");
            System.out.print("ingrese una opcion: ");
            System.out.println(" ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(" ");
                    compraEntrada(scanner);
                    break;
                case 2:
                    System.out.println(" ");
                    verResumenVenta(scanner);
             
                    break;
                case 3:
                    System.out.println(" ");
                    generarBoleta(scanner);
           
                    break;
                case 4:
                    System.out.println(" ");
                    calcularIngresosTotales(scanner);
            
                    break; 
                case 5:
                    System.out.println("hasta pronto");
                    break;
                default:
                    System.out.println("selecciona opcion correcta");
                    break;
            }

            if (opcion != 5) {
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

        } while (opcion != 5);
    

    /// terminamos estructura menu interactivo
      
    }
    
    ///SALIENDO DEL MAIN
 
    //CREAMO MODULOS //////////////////////////////////////// FUNCIONES ////////////
        
    ///Entrando MODULO MAPA
     public static void mostrarPlano() {
        System.out.println("\n========= PLANO DEL TEATRO MORO =========");
        System.out.println(" ");
        System.out.println("                  VIP   ($20.000)");
        System.out.println("              PALEA ALTA  ($10.000)");
        System.out.println("                BALCON  ($5.000)");
        System.out.println(" ");
        System.out.println("==========================================\n");
    }
    //FIN MODULO MAPA 
     
   
     
    //ESTABLECIENDO TIPO DE CLIENTE 
     static void tipoCliente(){ 
         System.out.println("Que tipo de cliente es usted? ");
         System.out.println("1. Publico General");
         System.out.println("2. Estudiante");
         int tipoCliente = scanner.nextInt();

            if (tipoCliente == 2) {
             esEstudiante = true;
             cliente = "Estudiante";
             System.out.println("Descuento Estudiante: Activado");  
             valorDescuento = (float) (0.10);
             }
        
         System.out.println("Que edad tiene?");
         int nEdad= scanner.nextInt();
         if (nEdad >=60){
            esAdultoMayor = true;
            cliente ="Adulto Mayor";
            valorDescuento = (float) (0.15);
            System.out.println("Descuento Adulto Mayor = Activado. ");
         }
         
           
     }
     //FIN TIPO DE CLIENTE
     
     //ENTRADA ELECCION ZONA 
     public static void tipoZona(){ 
         System.out.println("Que tipo de zona deseas? ");
         System.out.println("1.VIP");
         System.out.println("2.PALEA ALTA");
         System.out.println("3.BALCON");
         int tipoZona = scanner.nextInt();
            if (tipoZona == 1) {
             zona = "Vip";
             precioEntrada = 20000;}
            if (tipoZona == 2) {
             zona = "PALEA ALTA";
             precioEntrada = 10000;}
            if (tipoZona == 3) {
             zona = "BALCON";
             precioEntrada = 5000;}
            System.out.println("Has seleccionado la Zona = "+ zona); 
        //agrego a lista de zona
        zonaLista.add(zona);
        precioEntradaLista.add(precioEntrada);
            
            
     
     
     //FIN ENTRADA ELECCION ZONA    
     }
     
     //asignar numero entrada 
     public static void nEntrada(){ 
     numeroEntradaLista.add(contadorEntradas);
     contadorEntradas++;    
     
     
     }
  
     //FIN adquirir index
     
     //calculo precio final
     
     //FIN
     
     // modulo resumen compra
      public static void resumenCompra(){ 
          System.out.println("   "); 
          System.out.println(":_:_:_:Resumen Compa:_:_:_:"); 
          System.out.println("   "); 
          System.out.println("Cliente :"+ cliente);
          System.out.println("ZONA: "+ zona);
          System.out.println("Numero de Entrada: " +numeroEntradaLista.get(numeroEntradaLista.size() - 1));
          System.out.println("Precio Entrada "+precioEntrada);
          System.out.println("Descuento "+valorDescuento*100) ;
          ValorDescuentoLista.add(valorDescuento * 100);
          precioTotal =  ((precioEntrada * 1) - (precioEntrada*valorDescuento));
          System.out.println("Precio final "+precioTotal);
          precioTotalLista.add(precioTotal);
        
          
      }
      
     // fin modulo resumen compra 
     //MODULO RESUMEN venta
      public static void resumenVenta(){
          System.out.println("listaDeListas");
 
   
          System.out.println("xd");
          for (int i = 0; i < numeroEntradaLista.size(); i++) {  
         System.out.print("(Entrada: " + numeroEntradaLista.get(i) + ", Ubicacion: " + zonaLista.get(i)+", Precio Entrada: " + precioEntradaLista.get(i)+ ", Descuento: " + ValorDescuentoLista.get(i)+ ", Costo Final: " + precioTotalLista.get(i)+ ")");
          }
          }

      
     //FIN RESUMEN venta    
      
     
       //ENTRANDO MODULO GENERAR BOLETA
        public static void generarBoleta() {
        System.out.println("Cual es su numero de entrada?");
        int numeroConsultado = scanner.nextInt();
        int indice = numeroEntradaLista.indexOf(numeroConsultado);
         System.out.println("-----------------------");
         System.out.println("     Teatro Moro ");
         System.out.println("-----------------------");
         System.out.println("Ubicacion: "+zonaLista.get(indice));
         System.out.println("Costo Base: "+precioEntradaLista.get(indice));
         System.out.println("Descuento Aplicado: "+ValorDescuentoLista.get(indice));
         System.out.println("Costo Final: "+precioTotalLista.get(indice));
         System.out.println("---------------------------------------");
         System.out.println("Gracias por su visita al Teatro Moro");
         System.out.println("---------------------------------------");
           
    //FIN MODULO GENERAR BOLETA
     }
     // FIN CREACION MODULOS //////////////////////////////////////// FUNCIONES ////////////
     
    //////// CASES 1 - 2 - 3 - 4;
     
    // Entrando CASE 1
    static void compraEntrada(Scanner scanner) {
    System.out.println("Venta de entradas:_:_:"); 
    tipoCliente(); 
    mostrarPlano();
    tipoZona(); 
    nEntrada();
    resumenCompra();
    }
    //FIN CASE 1    
    
    //Entrando CASE 2
    static void verResumenVenta(Scanner scanner) {
    System.out.println("Resumen de entrada"); 
    resumenVenta();
    }
    //FIN CASE 2
    
    //Entrando CASE 3
    static void generarBoleta(Scanner scanner) {
    System.out.println("Generacion Boleta"); 
    generarBoleta(); // muestro boleta
    }
    //FIN CASE 3
    
    //Entrando CASE 4
    static void calcularIngresosTotales(Scanner scanner) {
    System.out.println("Calculo ingresos totales"); 
    estadisticaTotalIngreso=0;
    
     for (int i = 0; i < precioTotalLista.size(); i++) {                                                     
        estadisticaTotalIngreso += precioTotalLista.get(i);
    }
        System.out.println("la cantidad ingresos son: "+estadisticaTotalIngreso);
    }  
    
    

    }
    //FIN CASE 4
    
      
      
      
    //saliendo codigo 




