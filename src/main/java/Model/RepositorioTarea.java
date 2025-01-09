package Model;

import java.util.ArrayList;

public class RepositorioTarea {
    private ArrayList<TareaFormato> tareaRep;
    private ArrayList<TareaFormato> tareaHistorial;

    public RepositorioTarea() {
        tareaRep=new ArrayList<>();
        tareaHistorial=new ArrayList<>();
    }
    public void anadirTareaRep(String tarea, boolean stt){
        TareaFormato nEntrada=new TareaFormato(tarea, stt);
        tareaRep.add(nEntrada);
    }
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
    public ArrayList<TareaFormato> listarTareaRep(){
        return tareaRep;
    }
    public ArrayList<TareaFormato> listarTareaHistorial(){
        return tareaHistorial;
    }
}
