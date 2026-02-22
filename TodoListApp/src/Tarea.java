import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Tarea {
    static int contadorId = 0;
    static ArrayList<Tarea> tareas = new ArrayList<Tarea>();

    static String archivo = "Tareas.txt";

    int id = 0;
    String nombreTarea;
    boolean completada = false;


    public Tarea(String nombreTarea) {
        this.id = ++contadorId;
        this.nombreTarea = nombreTarea;
        this.completada = false;
        tareas.add(this);
        guardarArchivo();
    }

    public static void listarTareas(){

        if (tareas.size() == 0) {
             System.out.println("No hay tareas en este momento");
        }

        for (Tarea tarea : tareas) {
            String tareaCompleta = "No";

            if (tarea.completada == true) {
                tareaCompleta = "Sí";
            }

            System.out.println( "Tarea No." + tarea.id + " | " + " Nombre:" + tarea.nombreTarea + " | " + " Completada: " + tareaCompleta);
        }
    }

    public static void eliminarTarea(int idTarea) {
        boolean tareaExiste = false;

        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).id == idTarea) {
                tareas.remove(i);
                System.out.println("Tarea eliminada");
                tareaExiste = true;
                guardarArchivo();
                break;
            }
        }

        if (tareaExiste == false) {
            System.out.println("Tarea no encontrada");
        }
    }

    public static void marcarComoCompletada(int idTarea) {

    boolean tareaExiste = false;

    for (Tarea tarea : tareas) {

        if (tarea.id == idTarea) {

            tarea.completada = true;

            System.out.println("Tarea marcada como completada");

            tareaExiste = true;

            guardarArchivo(); // importante para persistencia

            break;
        }

    }

        if (tareaExiste == false) {

            System.out.println("Tarea no encontrada");
        }
    }

    public static void guardarArchivo() {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));

            for (Tarea tarea : tareas) {

                writer.write(tarea.nombreTarea);
                writer.newLine();

            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error al guardar");

        }

    }
    public static void cargarArchivo() {

        try {

            BufferedReader reader = new BufferedReader(new FileReader(archivo));

            String linea;

            while ((linea = reader.readLine()) != null) {

                new Tarea(linea);

            }

            reader.close();

        } catch (IOException e) {

        }

    }
}