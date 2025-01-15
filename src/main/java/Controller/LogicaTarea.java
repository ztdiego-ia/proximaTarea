package Controller;

import View.Home;
import Model.*;
import View.PnlPrincipal;
import java.util.ArrayList;

public class LogicaTarea {
    
    public static void main(String[] args) {
        //añadir tareas predefinidas
        LogicaTarea.anadirTarea("pasear al perro", false);
        LogicaTarea.anadirTarea("barrer la sala", false);
        LogicaTarea.anadirTarea("tomar desayuno", true);
        LogicaTarea.anadirTarea("comprar 5kg de carne", true);
        LogicaTarea.anadirTarea("pedir una cita para el dentista", false);
        
        //iniciar app Home
        iniciarPantalla();
    }
    
    //crear repositorio segun el modelo
    private static final RepositorioTarea registroTarea=new RepositorioTarea();
    
    //configurar JFrame
    private static void iniciarPantalla(){
        Home ventana=new Home();
        ventana.setVisible(true);
        
        //pasarle el objeto de la ventana Home
        PnlPrincipal.padre(ventana);
    }
    
    //añade una tarea al repositorio
    public static void anadirTarea(String tarea, boolean status){
        registroTarea.anadirTareaRep(tarea, status);
    }
    
    //envia el encabezado de la tabla
    public static ArrayList<String> envEncabezado(){
        return new ArrayList<>(){{
            add("Tarea");
            add("Status");
            add(" ");
        }};
    }
    
    //envio de datos
    public static ArrayList<ArrayList<String>> verTarea(){
        ArrayList<ArrayList<String>> lista=new ArrayList<>();
        for (TareaFormato tr : registroTarea.listarTareaRep()) {
            lista.add(new ArrayList<>(){{
                add(tr.getTarea());
                add(String.valueOf(tr.isStatus()));
            }});
        }
        return lista;
    }
    
    //actualizar una entrada del repositorio
    public static void edtTarea(String texto, boolean stt, int i){
        if(texto==null){
            registroTarea.edtStt(!stt, i);
        }else{
            registroTarea.edtTarea(texto, i);
        }
    }
    
}
