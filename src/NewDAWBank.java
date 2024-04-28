import java.util.Scanner;

public class NewDAWBank {
    public static void main(String[] args) {
        // Aquí ejecuto las funciones de la instancia cuenta bancaria
        boolean prog_ejec = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el IBAN:");
        String iban = sc.nextLine();

        System.out.println("Introduce el nombre del titular:");
        String nombre = sc.nextLine();

        CuentaBancaria cuenta = new CuentaBancaria(iban, nombre);

        while (prog_ejec) {
            System.out.println("1. Datos de la cuenta. Mostrará el IBAN, el titular y el saldo.");
            System.out.println("2. IBAN. Mostrará el IBAN.");
            System.out.println("3. Titular. Mostrará el titular.");
            System.out.println("4. Saldo. Mostrará el saldo disponible.");
            System.out.println("5. Ingreso. Pedirá la cantidad a ingresar y realizará el ingreso si es posible.");
            System.out.println("6. Retirada. Pedirá la cantidad a retirar y realizará la retirada si es posible.");
            System.out.println("7. Movimientos. Mostrará una lista con el historial de movimientos.");
            System.out.println("8. Salir. Termina el programa.");
            String cant;
            Integer opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("IBAN: "+cuenta.mostrarIBAN());
                    System.out.println("Titular: "+cuenta.mostrarTitular());
                    System.out.println("Saldo: "+cuenta.mostrarSaldo());
                    break;
                case 2:
                    System.out.println("IBAN: "+cuenta.mostrarIBAN());
                    break;
                case 3:
                    System.out.println("Titular: "+cuenta.mostrarTitular());
                    break;
                case 4:
                    System.out.println("Saldo: "+cuenta.mostrarSaldo());
                    break;
                case 5:
                    System.out.println("Introduce la cantidad a ingresar:");
                    cant = sc.next();
                    cuenta.ingresar(Double.valueOf(cant));
                    break;
                case 6:
                    System.out.println("Introduce la cantidad a retirar:");
                    cant = sc.next();
                    cuenta.retirada(Double.valueOf(cant));
                    break;
                case 7:
                    System.out.println("Movimientos: ");
                    cuenta.mostrarMovimientos();
                    break;
                case 8:
                    prog_ejec = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        }
    }
}
