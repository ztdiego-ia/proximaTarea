package Controller;

import View.Home;
import Model.*;
import java.util.ArrayList;

public class LogicaTarea {
    
    public static void main(String[] args) {
        //iniciar app Home
        Home ventana=new Home();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        
        //añadir tareas predefinidas
        todoTareas.anadirTareaRep(new TareaFormato("pasear al perro", false));
        todoTareas.anadirTareaRep(new TareaFormato("barrer la sala", false));
        todoTareas.anadirTareaRep(new TareaFormato("tomar desayuno", true));
        todoTareas.anadirTareaRep(new TareaFormato("comprar 5kg de carne", true));
        todoTareas.anadirTareaRep(new TareaFormato("pedir una cita para el dentista", false));
        
    }
    
    //crear repositorio segun el modelo
    private static final RepositorioTarea todoTareas=new RepositorioTarea();
    
    //añade un objeto TareaFormato, a partir de un String y un boolean, a todoTarea
    public static void anadirTarea(String tarea, boolean stt){
        TareaFormato nTarea=new TareaFormato(tarea, stt);
        todoTareas.anadirTareaRep(nTarea);
    }
    
    public static ArrayList<String> actualizarVista(){
        ArrayList<String> texto=new ArrayList<>();
        for (int i = 0; i < todoTareas.listarTareaRep().size(); i++) {
            String tarea=todoTareas.listarTareaRep().get(i).getTarea();
            boolean status=todoTareas.listarTareaRep().get(i).isStatus();
            texto.add(status?tarea+" - completada":tarea+" - pendiente");
        }
        return texto;
    }
}
