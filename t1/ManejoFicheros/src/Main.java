import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Concesionario concesionario = new Concesionario();
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1.- Añadir nuevo coche");
            System.out.println("2.- Borrar coche por id");
            System.out.println("3.- Consulta coche por id");
            System.out.println("4.- Listado de coches");
            System.out.println("5. Exportar coches a archivo CSV");
            System.out.println("6.- Terminar el programa");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // Añadir coche
                    System.out.print("Introduce el ID del coche: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Limpiar buffer
                    System.out.print("Introduce la matrícula: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Introduce la marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Introduce el modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Introduce el color: ");
                    String color = scanner.nextLine();

                    Coche coche = new Coche(id, matricula, marca, modelo, color);
                    concesionario.añadirCoche(coche);
                    break;
                case 2:
                    // Borrar coche
                    System.out.print("Introduce el ID del coche a borrar: ");
                    int idBorrar = scanner.nextInt();
                    concesionario.borrarCoche(idBorrar);
                    break;
                case 3:
                    // Consultar coche
                    System.out.print("Introduce el ID del coche a consultar: ");
                    int idConsultar = scanner.nextInt();
                    concesionario.consultarCoche(idConsultar);
                    break;
                case 4:
                    // Listar coches
                    concesionario.listarCoches();
                    break;
                case 5:
                    // Exportar coches a CSV
                    concesionario.exportarCochesCSV();
                    break;

                case 6:
                    // Terminar y guardar
                    concesionario.guardarDatos();
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción del menú.");
                    break;
            }
        } while (opcion != 6);
        scanner.close();
    }
}



