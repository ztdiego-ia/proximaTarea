import java.util.Scanner;
import java.util.ArrayList;

public class ProximaTarea {

    public static void main(String[] args) {
        tareadb.add("tomar el desayuno");
        tareadb.add("pasear a Boby");
        tareadb.add("barrer la sala");
        tareadb.add("preparar la presentacion");
        System.out.println("Proxima Tarea - alpha");
        System.out.println("--------------------");
        Integer menu=0;
        do{
            System.out.println("1 - nueva tarea.");
            System.out.println("2 - lista de tareas.");
            System.out.println("3 - editar tarea.");
            System.out.println("4 - borrar tarea.");
            System.out.println("5 - borrar todo.");
            System.out.println("6 - salir.");
            System.out.print("opcion: ");
            menu=entrada.nextInt();
            entrada.nextLine();
            switch(menu){
                case 1 -> añadir();
                case 2 -> listar();
                case 3 -> editar();
                case 4 -> borrar();
                case 5 -> borrartodo();
                case 6 -> {
                    menu=6;
                    System.out.println("saliendo...");
                }
                default -> System.out.println("opcion incorrecta...\n");
            }
        }while(!menu.equals(6));
    }
    
    static Scanner entrada=new Scanner(System.in);
    static ArrayList<String> tareadb=new ArrayList<>();
    
    private static void añadir(){
        System.out.print("nueva tarea: ");
        tareadb.add(entrada.nextLine());
        Character validarpunto=tareadb.getLast().charAt(tareadb.getLast().length()-1);
        if(!validarpunto.equals('.')){
            tareadb.set(tareadb.size()-1, tareadb.getLast()+".");
        }
        System.out.println("tarea añadida\n");
    }
    private static void listar(){
        System.out.println("lista de pendiantes\n");
        for (int i = 0; i < tareadb.size(); i++) {
            System.out.println((i+1)+": "+tareadb.get(i));
        }
        System.out.print("\n");
    }
    private static void editar(){
        System.out.println("\nescribe '0' para cancelar");
        System.out.print("numero de tarea: ");
        Integer n=entrada.nextInt()-1;
        entrada.nextLine();
        if(!n.equals(-1)){
            if(n>=0 && n<tareadb.size()){
                System.out.println("\nescribe '<off>' para cancelar");
                System.out.println("actual: "+tareadb.get(n));
                System.out.print("nuevo: ");
                String texto=entrada.nextLine();
                if(!texto.equals("<off>")){
                    if(!texto.isEmpty()){
                     tareadb.set(n, texto);
                        System.out.println("tarea actualizada\n");
                    }else{
                        System.out.println("entrada vacia\n");
                    }
                }else{
                    System.out.println("cancelado...\n");
                }
            }else{
                System.out.println("no existe tal tarea\n");
            }
        }
    }
        
    private static void borrar(){
        System.out.print("numero de tarea: ");
        tareadb.remove(entrada.nextInt());
        entrada.nextLine();
        System.out.println("tarea eliminada\n");
    }
    private static void borrartodo(){
        tareadb.clear();
        System.out.println("sin tareas pendientes...\n");
    }
    
}
