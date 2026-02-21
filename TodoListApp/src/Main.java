import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {

        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        do{
            System.out.println("\n" + "Gestion de tareas");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3.Marcar tarea como completada");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Salir" + "\n");

            System.out.println("¿Qué opción eliges? ");
            opcion = entrada.nextInt();
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
                
                case 4:
                    if (Tarea.tareas.size() == 0) {
                        System.out.println("No hay tareas por ahora");
                    } else {
                        System.out.println("ID de la tarea a eliminar");
                        int idTarea = entrada.nextInt();
                        Tarea.eliminarTarea(idTarea);
                    }

                    break;
                    
            }

        }
        while(opcion != 5);
        entrada.close();
    }
}
