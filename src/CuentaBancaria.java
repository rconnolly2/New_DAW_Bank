import java.util.ArrayList;
public class CuentaBancaria {
    private final String iban;
    private final String titular;
    private Double saldo = 0.0;
    private ArrayList<String> movimientos = new ArrayList<String>();
    private boolean notif_hacienda = false;

    public CuentaBancaria(String iban_arg, String titular_arg) {
        if (!iban_arg.matches("[A-Z]{2}\\d{22}")) {
            throw new IllegalArgumentException("¡IBAN no válido!");
        }

        if (titular_arg.length() < 1) {
            throw new IllegalArgumentException("¡Titular no valido!");
        }

        this.iban = iban_arg;
        this.titular = titular_arg;

    }

    public void ingresar(Double cantidad) {
        if (cantidad < 0) {
            System.err.println("¡Cantidad no valida!");
        } else {
            if (cantidad >= 3000) {
                System.err.println("AVISO: Notificar a hacienda");
                this.notif_hacienda = true;
            }
            this.saldo += cantidad;

            // Registro movimiento:
            movimientos.add("Deposito de: "+cantidad+" Eur");
        }
    }

    public void retirada(Double cantidad) {
        if (cantidad < 0) {
            System.err.println("¡Cantidad no valida!");
        } else {
            if (cantidad >= 3000) {
                System.err.println("AVISO: Notificar a hacienda");
                this.notif_hacienda = true;
            } else if (this.saldo<-50) {
                System.err.println("AVISO: Saldo negativo");
            }
            this.saldo -= cantidad;

            // Registrar movimiento:
            movimientos.add("Retirada de: "+cantidad+" Eur");
        }
    }

    public void mostrarMovimientos() {
        for (String mov : movimientos) {
            System.out.println(mov);
        }
    }

    public String mostrarIBAN() {
        return this.iban;
    }

    public String mostrarTitular() {
        return this.titular;
    }

    public Double mostrarSaldo() {
        return this.saldo;
    }

    public boolean isNotif_hacienda() {
        return notif_hacienda;
    }

}
