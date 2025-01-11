package Model;

import java.util.ArrayList;

public class RepositorioTarea {
    private final ArrayList<TareaFormato> tareaRep;
    private final ArrayList<TareaFormato> tareaHistorial;

    public RepositorioTarea() {
        tareaRep=new ArrayList<>();
        tareaHistorial=new ArrayList<>();
    }
    public void anadirTareaRep(String tarea, boolean status){
        tareaRep.add(new TareaFormato(tarea, status));
    }
    public ArrayList<TareaFormato> listarTareaRep(){
        return tareaRep;
    }
    //--------------------------------------------------------
    public void anadirTareaHistorial(TareaFormato tarea){
        tareaHistorial.add(tarea);
    }
    public void eliminarTareaRep(int i){
        tareaHistorial.add(tareaRep.get(i));
        tareaRep.remove(i);
    }
    public void eliminarTareaHistorial(int i){
        tareaRep.clear();
    }
    
    public ArrayList<TareaFormato> listarTareaHistorial(){
        return tareaHistorial;
    }
}
