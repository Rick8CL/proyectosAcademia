/**
 * Programa que simula el funcionamiento de un Banco
 * Ricardo Castillo Lara
 * 03/07/2017
 */
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner lector;
        int opc = 0, x = 0;
        double dinero = 0;
        String nom = "", ape = "";
        //Cuenta cue=null;

        //Cliente c = new Cliente(nom, ape, cue);
        //Cuenta cu = new Cuenta(dinero);
        Banco b = new Banco();

        try {
            System.out.println("Bienvenido! Selecciona una opcion del siguiente menu:");
            do {
                lector = new Scanner(System.in);
                System.out.println("1. Agregar Cliente\n2. Buscar Cliente\n3. Cantidad de Clientes\n4. Ver Clientes\n5. Consultar Balance\n6. Deposito\n7. Retiro\n0. Salir");
                opc = lector.nextInt();
                switch (opc) {
                    case 1:
                        lector = new Scanner(System.in);
                        System.out.println("Cliente a Agregar");
                        System.out.println("Nombre");
                        nom = lector.nextLine();
                        System.out.println("Apellido");
                        ape = lector.nextLine();
                        lector = new Scanner(System.in);
                        System.out.println("Deposito Inicial:");
                        dinero = lector.nextDouble();
                        Cuenta cue = new Cuenta(dinero);
                        b.addCliente(nom, ape, cue);
                        System.out.println("Cliente Agregado Correctamente!");
                        break;
                    case 2:
                        lector = new Scanner(System.in);
                        System.out.println("No Cliente a Buscar");
                        x = lector.nextInt();
                        if (b.getCliente(x).nombre != "") {
                            System.out.println("Cliente encontrado: " + b.getCliente(x).nombre);
                        } else {
                            System.out.println("Cliente no Encontrado");
                        }
                        break;
                    case 3:
                        System.out.println("Actualmente hay " + b.getClientes() + " clientes en el banco");
                        break;
                    case 4:
                        for (int i = 0; i < b.getClientes(); i++) {
                            System.out.println(b.getCliente(i).nombre+" $"+b.getCliente(i).cuenta.balance);
                        }
                        break;
                    case 5:
                    	lector = new Scanner(System.in);
                    	System.out.println("Numero de Cliente:");
                        x = lector.nextInt();
                        if (b.getCliente(x).nombre != "") {
                            System.out.println("Cliente: " + b.getCliente(x).nombre + " con un balance de: " + b.getCliente(x).cuenta.balance);
                        } else {
                            System.out.println("Cliente no registrado");
                        }
                        break;
                    case 6:
                        lector = new Scanner(System.in);
                        System.out.println("Numero de Cliente:");
                        x = lector.nextInt();
                        if (b.getCliente(x).nombre != "") {
                        	lector = new Scanner(System.in);
                        	System.out.println("Monto del Deposito:");
                            dinero = lector.nextDouble();
                            b.getCliente(x).getCuenta().deposito(dinero);
                            System.out.println("Transaccion Exitosa!");
                        } else {
                            System.out.println("Cliente no registrado");
                        }
                        break;
                    case 7:
                    	lector = new Scanner(System.in);
                        System.out.println("Numero de Cliente:");
                        x = lector.nextInt();
                        if (b.getCliente(x).nombre != "") {
                            System.out.println("Monto del Retiro:");
                            lector = new Scanner(System.in);
                            dinero = lector.nextDouble();
                            b.getCliente(x).getCuenta().retiro(dinero);
                            System.out.println("Transaccion Exitosa!");
                        } else {
                            System.out.println("Cliente no registrado");
                        }
                        break;
                    case 0:
                        System.out.println("Hasta Luego!");
                        break;
                    default:
                        System.out.println("Opcion no valida...");
                        break;
                }
            } while (opc != 0);
        } catch (Exception e) {
            System.err.println("Error " + e);
        }
    }
}
