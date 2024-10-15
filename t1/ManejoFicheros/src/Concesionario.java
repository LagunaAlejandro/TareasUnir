import java.io.*;
import java.util.ArrayList;

public class Concesionario {

    ArrayList<Coche> coches;

    public Concesionario() {
        coches = new ArrayList<>();
        cargarDatos();
    }
public void cargarDatos() {

        File fichero= new File("coches.dat");
        if(fichero.exists()) {
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
           coches= (ArrayList<Coche>) ois.readObject();
                System.out.println("Datos cargados correctamente");

            } catch (FileNotFoundException e) {
                System.out.println("Archivo no encontrado");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al leer el fichero");
            }
        }else {
            System.out.println("No existe el fichero, comenzando con lista vacia...");
        }
}

    public void añadirCoche(Coche coche) {
        for (Coche c : coches) {
            if (c.getId() == coche.getId() || c.getMatricula().equals(coche.getMatricula())) {
                System.out.println("Error: Ya existe un coche con el mismo ID o matrícula.");
                return;  // No añadir el coche si hay duplicados
            }
        }
        coches.add(coche);
        System.out.println("Coche agregado correctamente");
    }
    public boolean existeIdOMatricula(ArrayList<Coche> listaCoches, int id, String matricula) {
        for (Coche coche : listaCoches) {
            if (coche.getId() == id || coche.getMatricula().equals(matricula)) {
                return true;  // Hay un duplicado
            }
        }
        return false;  // No hay duplicado
    }

    public void borrarCoche(int id) {
        Coche cocheABorrar = null;
        for (Coche coche : coches) {
            if (coche.getId() == id) {
                cocheABorrar = coche;
                break;
            }
        }

        if (cocheABorrar != null) {
            coches.remove(cocheABorrar);
            System.out.println("Coche eliminado correctamente.");
        } else {
            System.out.println("No se encontró un coche con ese ID.");
        }
    }
    public void consultarCoche(int id) {
        for (Coche coche : coches) {
            if (coche.getId() == id) {
                System.out.println(coche);
                return;
            }
        }
        System.out.println("No se encontró un coche con ese ID.");
    }
    public void listarCoches() {
        if (coches.isEmpty()) {
            System.out.println("No hay coches en el almacén.");
        } else {
            for (Coche coche : coches) {
                System.out.println(coche);
            }
        }
    }
    public void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("coches.dat"))) {
            oos.writeObject(coches);
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el fichero: " + e.getMessage());
        }
    }
    public void exportarCochesCSV() {
        try (PrintWriter writer = new PrintWriter(new File("coches.csv"))) {
            StringBuilder sb = new StringBuilder();
            sb.append("ID;Matricula;Marca;Modelo;Color\n");  // Encabezado del CSV

            for (Coche coche : coches) {  // Acceder directamente a la lista coches
                sb.append(coche.getId());
                sb.append(";");
                sb.append(coche.getMatricula());
                sb.append(";");
                sb.append(coche.getMarca());
                sb.append(";");
                sb.append(coche.getModelo());
                sb.append(";");
                sb.append(coche.getColor());
                sb.append("\n");
            }

            writer.write(sb.toString());
            System.out.println("Coches exportados correctamente a coches.csv.");
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el archivo CSV: " + e.getMessage());
        }
    }


}

