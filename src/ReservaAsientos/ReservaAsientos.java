package ReservaAsientos;

import java.util.Scanner;

public class ReservaAsientos {

    public static void main(String[] args) {

        //declaración de variables
        char asientos[][] = new char[10][10];
        boolean bandera = false;
        Scanner teclado = new Scanner(System.in);
        int fila = 0, asiento = 0;
        String respuesta;
        String verMapa;

        //cargar la matriz de asientos
        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {
                asientos[f][c] = 'L';
            }
        }

        //bienvenido al sistema
        System.out.println("---------BIENVENID2@S AL SISTEMA DE RESERVAS---------");

        //empieza la reserva de asientos
        while (bandera != true)  {
            //visualización de mapa
            System.out.println("¿Desea ver los asientos disponibles? (S/N)");
            verMapa = teclado.next();

            if (verMapa.equalsIgnoreCase("S")) {
                dibujarMapa(asientos);
            }

            //reserva
            boolean valoresCorrectos = false;
            while (valoresCorrectos != true) {
                System.out.println("Ingresa fila y columna del asiento que desea reservar");
                System.out.print("Fila (0 y 9): ");
                fila = teclado.nextInt();

                System.out.print("Asiento (0 y 9): ");
                asiento = teclado.nextInt();

                if (fila <= 9 && fila >= 0) {
                    if (asiento <= 9 && asiento >= 0) {
                        valoresCorrectos = true;
                    } else {
                        System.out.println("El número de asiento no es válido");
                    }
                } else {
                    System.out.println("El número de fila no es válido");
                }
            }

            if (asientos[fila][asiento] == 'L') {
                asientos[fila][asiento] ='X';
                System.out.println("Asiento reservado correctamente");
            } else {
                System.out.println("El asiento ya está ocupado. Por favor elija otro");
            }

            //preguntar por otro asiento
            System.out.println("¿Quieres reservar otro asiento? (S/N)");
            respuesta = teclado.next();

            if (respuesta.equalsIgnoreCase("N")) {
                bandera = true;
                System.out.println("---------SALIENDO DEL SISTEMA DE RESERVAS---------");
            }
        }
    }

    //método para pintar la matriz
    static void dibujarMapa(char asientos[][]) {
        for (int f = 0; f < 10; f++) {
            System.out.print(f + " ");
            for (int c = 0; c < 10; c++) {
                System.out.print("[" + asientos[f][c] + "] ");
            }
            System.out.println("");
        }
    }
}
