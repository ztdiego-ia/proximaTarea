package Controller;

import View.Home;
import Model.*;
import java.util.ArrayList;
import java.util.List;

public class LogicaTarea {
    
    public static void main(String[] args) {
        //añadir tareas predefinidas
        new LogicaTarea().anadirTarea("pasear al perro", false);
        new LogicaTarea().anadirTarea("barrer la sala", false);
        new LogicaTarea().anadirTarea("tomar desayuno", true);
        new LogicaTarea().anadirTarea("comprar 5kg de carne", true);
        new LogicaTarea().anadirTarea("pedir una cita para el dentista", false);
        
        //iniciar app Home
        iniciarPantalla();
    }
    
    //crear repositorio segun el modelo
    private static final RepositorioTarea todoTareas=new RepositorioTarea();
    
    //configurar JFrame
    private static void iniciarPantalla(){
        Home ventana=new Home();
        ventana.setVisible(true);
        
    }
    
    //añade una tarea al repositorio
    public void anadirTarea(String tarea, boolean status){
        todoTareas.anadirTareaRep(tarea, status);
    }
    
    //envia el encabezado de la tabla
    public static List<String> envEncabezado(){
        return List.of("Tarea","Status"," ");
    }
    
    //lectura de datos usando inicializacion anonima
    public static List<List<String>> verTarea(){
        List<List<String>> lista=new ArrayList<>();
        for (TareaFormato tr : todoTareas.listarTareaRep()) {
            if(tr.isStatus()){
                lista.add(new ArrayList<>(List.of(tr.getTarea(), "Listo")));
            }else{
                lista.add(new ArrayList<>(List.of(tr.getTarea(), "Ya casi")));
            }
        }
        return lista;
    }
    
}
