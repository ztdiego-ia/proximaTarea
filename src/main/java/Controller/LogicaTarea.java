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
        todoTarea.anadirTareaRep("pasear al perro", false);
        todoTarea.anadirTareaRep("barrer la sala", false);
        todoTarea.anadirTareaRep("tomar desayuno", true);
        todoTarea.anadirTareaRep("comprar 5kg de carne", true);
        todoTarea.anadirTareaRep("pedir una cita para el dentista", false);
        
    }
    
    //crear repositorio segun el modelo
    private static RepositorioTarea todoTarea=new RepositorioTarea();
    
    public void anadirTarea(String tarea, boolean stt){
        TareaFormato nTarea=new TareaFormato(tarea, stt);
        //todoTarea.anadirTareaRep(nTarea);
        //actualizarVista();
    }
    public void borrarTarea(int i){
        todoTarea.eliminarTareaRep(i);
        //actualizarVista();
    }
    public static ArrayList<String> actualizarVista(){
        ArrayList<String> texto=new ArrayList<>();
        for (int i = 0; i < todoTarea.listarTareaRep().size(); i++) {
            String tarea=todoTarea.listarTareaRep().get(i).getTarea();
            boolean status=todoTarea.listarTareaRep().get(i).isStatus();
            texto.add(status?tarea+" - completada":tarea+" - pendiente");
        }
        return texto;
    }
}
