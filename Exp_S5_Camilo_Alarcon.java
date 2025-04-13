/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package teatromoro;

import java.util.Scanner;

/**
 *
 * @author Charchilla
 */
 

public class TeatroMoro {
    /**
     * @param args the command line arguments
     */
    

    static String zona = "0";
    static int cliente;
    static int edad;
    static boolean esAdultoMayor = false;
    static boolean esEstudiante = false;
    static boolean esMultiCompra = false;
    static double tasadescuento = 0;
    static int precioEntrada;
    static int precioTotal;
    static int cantidadCompra;
    static int numeroCompra;
    static int eliminar;
    static int descuento;

    public static void main(String[] args) {

        int opcion;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("          ");
            System.out.println(":_:_:Teatro:_:_");
            System.out.println("1.Venta Entrada");
            System.out.println("2.ver promociones");
            System.out.println("3.buscar entrada");
            System.out.println("4.Eliminar entrada");
            System.out.println("5.Salir");
            System.out.println(":_:_:_:_:_:_:_:_:_:_:");
            System.out.print("ingrese una opcion: ");
            System.out.println(" ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ventaEntrada(scanner);
                    break;
                case 2:
                    verPromociones(scanner);
                    break;
                case 3:
                    buscarEntrada(scanner);
                    break;
                case 4:
                    eliminarEntrada(scanner);
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
    }

    static void ventaEntrada(Scanner scanner) {
        int zonaOpcion = 0;

        System.out.println("Venta de entrada");
        System.out.println("   ");

        System.out.println("\n========= PLANO DEL TEATRO =========");
        System.out.println(" ");
        System.out.println("         Zona VIP ($10.000)");
        System.out.println("         Zona PLATEA ($15.000)");
        System.out.println("         Zona GENERAL ($20.000)");
        System.out.println(" ");
        System.out.println("\n====================================");

        System.out.println("  ");
        System.out.println("1.zona VIP");
        System.out.println("2.zona PLATEA");
        System.out.println("3.zona GENERAL");
        System.out.print("ingresa la zona: ");
        zonaOpcion = scanner.nextInt();

        switch (zonaOpcion) {
            case 1:
                zona = "VIP";
                precioEntrada = 10000;
                numeroCompra++;
                break;
            case 2:
                zona = "PLATEA";
                precioEntrada = 15000;
                numeroCompra++;
                break;
            case 3:
                zona = "GENERAL";
                precioEntrada = 20000;
                numeroCompra++;
                break;
            default:
                System.out.println("selecciona opción valida");
                return;
        }

        System.out.println("Has seleccionado zona: " + zona);

        System.out.print("Ingrese su edad: ");
        edad = scanner.nextInt();

        System.out.print("Ingrese cuantas entradas desea comprar: ");
        cantidadCompra = scanner.nextInt();

        esMultiCompra = cantidadCompra >= 3;

        if (esMultiCompra) {
            System.out.println("Tienes un descuento de un 15% (1 entrada)");
            System.out.println("Ya que adquieres desde 3 entradas");
        }

        if (edad >= 65) {
            esAdultoMayor = true;
            System.out.println("usted tiene derecho a descuento adulto mayor");
        }
        
        

        System.out.println("Seleccione tipo de cliente");
        System.out.println("1.Publico General");
        System.out.println("2.Estudiante");
        System.out.println("3.Adulto Mayor");
        System.out.print("Ingrese una opcion: ");
        cliente = scanner.nextInt();
        
        if (cliente < 1 || cliente > 3) {
        System.out.println("Error: Opción no valida");
        return;
        }
        
       

        // Aplicar descuento según tipo
        tasadescuento = 0;

        if (cliente == 2) {
            esEstudiante = true;
            tasadescuento = 0.10;
        }

        if (esAdultoMayor) {
            tasadescuento = 0.15;
        }

        if (esMultiCompra) {
            tasadescuento = 0.15;
        }
        
        //EL DESCUETO LO MULTIPLICO POR 1 PARA QUE SOLO EL DESCUENTO SEA PARA
        // 1 ENTRADA...
        descuento = (int) ((precioEntrada * 1) * tasadescuento);
        precioTotal = ((precioEntrada * cantidadCompra) - descuento);

        System.out.println(":_:_:_:Resumen de compra:_:_:_:_:::");
        System.out.println("");
        System.out.println("Tipo de cliente: " + cliente);
        System.out.println("Su edad es: " + edad);
        System.out.println("Zona tipo:  " + zona);
        System.out.println("Numero de orden: " + numeroCompra);
        System.out.println("Precio Unitario: " + precioEntrada);
        System.out.println("Cantidad Entradas: " + cantidadCompra);
        System.out.println("Descuento (solo 1 X entrada): " + descuento);
        System.out.println("Precio total: " + precioTotal);
        System.out.println(":_:_:_::_:_:_:");
    }

    static void verPromociones(Scanner scanner) {
        System.out.println(":_:_Promociones:_:_:");
        System.out.println("1. Estudiantes 10% descuento");
        System.out.println("2. Tercera edad 15% descuento");
        System.out.println("3. Por comprar desde 3 entradas obtienes un 15% descuento");
        System.out.println("  ");
        System.out.println("ADVERTENCIA: SOLO 1 DESCUENTO POR USUARIO(EL MAYOR)");
        System.out.println("  ");
    }

    static void buscarEntrada(Scanner scanner) {
        System.out.print("Ingrese el numero de compra: ");
        int busqueda = scanner.nextInt();
        if (busqueda == numeroCompra) {
            System.out.println(":_:_:_:Resumen de compra:_:_:_:_:::");
            System.out.println("");
            System.out.println("Tipo de cliente: " + cliente);
            System.out.println("Su edad es: " + edad);
            System.out.println("Zona tipo:  " + zona);
            System.out.println("Numero de orden: " + numeroCompra);
            System.out.println("Precio Unitario: " + precioEntrada);
            System.out.println("Cantidad Entradas: " + cantidadCompra);
            System.out.println("Descuento (solo 1 X entrada): " + descuento);
            System.out.println("Precio total: " + precioTotal);
            System.out.println(":_:_:_::_:_:_:");
        } else {
            System.out.println("Numero de compra es erroneo");
        }
    }

    static void eliminarEntrada(Scanner scanner) {
        System.out.print("Ingrese el numero de compra: ");
        eliminar = scanner.nextInt();
        if (eliminar == numeroCompra) {
            System.out.println("Anulación de Pedido");
            System.out.println("    ");
            System.out.println(":_:_:_:Resumen de Anulación :_:_:_:_:::");
            System.out.println("");
            System.out.println("Tipo de cliente: " + cliente);
            cliente=0;
            System.out.println("Su edad es: " + edad);
            edad=0;
            System.out.println("Zona tipo:  " + zona);
            zona=null;
            System.out.println("Numero de orden: " + numeroCompra);
            numeroCompra = 0; 
            System.out.println("Precio Unitario: " + precioEntrada);
            precioEntrada = 0;
            System.out.println("Cantidad Entradas: " + cantidadCompra);
            precioEntrada = 0;
            System.out.println("Descuento (solo 1 X entrada): " + descuento);
            descuento = 0;
            System.out.println("Precio total: " + precioTotal);
            precioTotal=0;
            System.out.println(":_:_:_::_:_:_:");
            System.out.println("      ");
            System.out.println("Pedido Anulado :) ");
            
            
        } else {
            System.out.println("Numero de compra es erroneo");
        }
    }
}
