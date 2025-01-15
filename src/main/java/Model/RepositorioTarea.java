package Model;

import java.util.ArrayList;

public class RepositorioTarea {
    private final ArrayList<TareaFormato> tareaRep;

    public RepositorioTarea() {
        tareaRep=new ArrayList<>();
    }
    public void anadirTareaRep(String tarea, boolean status){
        tareaRep.add(new TareaFormato(tarea, status));
    }
    public ArrayList<TareaFormato> listarTareaRep(){
        return tareaRep;
    }
    public void edtTarea(String texto, int i){
        tareaRep.get(i).setTarea(texto);
    }
    public void edtStt(boolean stt, int i){
        tareaRep.get(i).setStatus(stt);
    }
    public void brrTarea(int i){
        tareaRep.remove(i);
    }
}
