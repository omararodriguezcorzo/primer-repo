import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("MAQUINA EXPENDEDORA");
        System.out.println("Bebidas disponibles:\n1. Agua (1 euro).\n2. Refresco (2 euros).\n3. Jugo (2 euros).\n");
        byte bebidaEscogida = scanner.nextByte();

        byte precio = 0;
        switch (bebidaEscogida){
            case 1:
                precio = 1;
                break;
            case 2, 3:
                precio = 2;
                break;
            default:
                System.out.println("Bebida no válida");
        }
        System.out.println("El precio es: " + precio + "euro(s).");

        byte totalIngresado = 0;
        while (totalIngresado < precio){
            System.out.println("Ingrese otra moneda: ");
            byte monedaIngresada = scanner.nextByte();
            byte moneda = validar_moneda(monedaIngresada, scanner);

            totalIngresado += moneda;
            if (totalIngresado < precio){
                System.out.println("No alcanza ingrese otra moneda.");
                continue;
            }
            if (totalIngresado > precio){
                byte vueltos = (byte) (totalIngresado - precio);
                System.out.println("Sus vueltos son: " + vueltos + "euro(s).");
                break;
            }
        }
        System.out.println("Gracias por su compra");
    }

    //Valida la moneda sea de 1 - 2 euros
    static byte validar_moneda(byte monedaIngresada, Scanner scanner){
        byte intentos = 0;
        while (monedaIngresada < 1 || monedaIngresada > 2){
            System.out.println("El valor de la moneda debe ser 1 uero o 2 euros.\nIngrese otra: ");
            monedaIngresada = scanner.nextByte();

            intentos++;
            if (intentos == 3){
                System.out.println("Quiere cancelar la compra: \nPresione s (sí)/n (no)");
                char salirDelPrograma = scanner.next().charAt(0);

                if (salirDelPrograma == 's'){
                    System.out.println("Gracias por usar el programa. Hasta luego.");
                    break;
                }else {
                    intentos = 0;
                    continue;
                }
            }
        }
        return monedaIngresada;
    };
}