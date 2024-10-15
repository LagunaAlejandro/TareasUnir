import java.util.Scanner;


public class Main {




    public static void main(String[] args) {


            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\nMenú:");
                System.out.println("1.- Añadir nuevo coche");
                System.out.println("2.- Borrar coche por id");
                System.out.println("3.- Consulta coche por id");
                System.out.println("4.- Listado de coches");
                System.out.println("5.- Terminar el programa");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        scanner.close();
                        break;

                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción del menú.");
                        break;
                }
            } while (opcion != 5);
        }
    }

