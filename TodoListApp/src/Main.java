import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {

        Scanner entrada = new Scanner(System.in);
        Tarea.cargarArchivo();
        int opcion = 0;
        
        do{
            System.out.println("\n" + "Gestion de tareas");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Salir" + "\n");

            try {

            System.out.println("¿Qué opción eliges? ");
            opcion = entrada.nextInt();

            if (opcion < 1 || opcion > 5) {
                System.out.println("Solo se aceptan números del 1 al 5.");
                continue;
            }

            entrada.nextLine();
            System.out.println("\n" );

            switch (opcion) {
                case 1:
                    System.out.println("¿Cuál es el nombre de tu tarea? ");
                    String nombreTarea = entrada.nextLine();
                    Tarea tarea = new Tarea(nombreTarea);
                    System.out.println("Tarea guardada");
                    break;

                case 2:
                    Tarea.listarTareas();
                    break;

                case 3:
                    Tarea.listarTareas();
                    if (Tarea.tareas.size() == 0) {
                        System.out.println("No hay tareas por ahora");
                    } else {
                        System.out.println("ID de la tarea:");
                        int id = entrada.nextInt();
                        Tarea.marcarComoCompletada(id);
                    }
                    break;
                
                case 4:
                    Tarea.listarTareas();
                    if (Tarea.tareas.size() == 0) {
                        System.out.println("No hay tareas por ahora");
                    } else {
                        System.out.println("ID de la tarea a eliminar");
                        try {
                        int idTarea = entrada.nextInt();
                        Tarea.eliminarTarea(idTarea);
                        
                        } catch (Exception e) {
                            System.out.println("No se aceptan letras. Solo números.");
                            entrada.nextLine();
                        }
                    }
                    break;
                    
            }
            } catch (Exception e) {
                System.out.println("No se aceptan letras. Solo números del 1 al 5.");
                entrada.nextLine();
            }

        }
        while(opcion != 5);
        entrada.close();
    }
}
