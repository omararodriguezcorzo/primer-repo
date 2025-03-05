import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte bebidaEscogida = 0;
        do {
            System.out.println("MAQUINA EXPENDEDORA");
            System.out.println("Bebidas disponibles:\n1. Agua (1 euro).\n2. Refresco (2 euros).\n3. Jugo (2 euros).");
            try{
                bebidaEscogida = scanner.nextByte();
            } catch (InputMismatchException ex) {
                System.out.println("Digite un número válido entre 1 y 3. Vuelve a intentarlo.\n");
                scanner.next();
            }
        } while (bebidaEscogida < 1 || bebidaEscogida > 3);

        byte precio = switch (bebidaEscogida) {
            case 1 -> 1;
            case 2, 3 -> 2;
            default -> 0;
        };

        byte totalIngresado = 0;
        while (totalIngresado < precio){
            System.out.println("Ingrese una moneda: ");
            byte monedaIngresada = 0;
            try {
                monedaIngresada = scanner.nextByte();
            }catch (InputMismatchException ex){
                System.out.println("Valor inválido, por favor ingrese un nuevo valor.");
            }

            byte moneda = validar_moneda(monedaIngresada, scanner);

            totalIngresado += moneda;
            if (totalIngresado < precio){
                System.out.println("No alcanza ingrese otra moneda.");
            }else {
                if (totalIngresado > precio){
                    byte vueltos = (byte) (totalIngresado - precio);
                    System.out.println("Sus vueltos son: " + vueltos + "euro(s).");
                    break;
                }
            }
        }
        System.out.println("Gracias por su compra");
    }

    //Valida la moneda sea de 1 - 2 euros
    static byte validar_moneda(byte monedaIngresada, Scanner scanner){
        while (monedaIngresada < 1 || monedaIngresada > 2){
            System.out.println("El valor de la moneda debe ser 1 uero o 2 euros.\nIngrese otra: ");
            try {
                monedaIngresada = scanner.nextByte();
            } catch (InputMismatchException ex){
                System.out.println("Entrada invalida. Digite un número válido.");
            }
        }
        return monedaIngresada;
    };
}