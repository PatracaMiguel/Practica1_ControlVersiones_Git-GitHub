import java.util.ArrayList;

public class Tarea {
    static int contadorId = 0;
    static ArrayList<Tarea> tareas = new ArrayList<Tarea>();

    int id = 0;
    String nombreTarea;
    boolean completada = false;


    public Tarea(String nombreTarea) {
        this.id = ++contadorId;
        this.nombreTarea = nombreTarea;
        this.completada = false;
        tareas.add(this);
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
}
