package Model;

public class TareaFormato {
    private String tarea;
    private boolean status;

    public TareaFormato(String tarea, boolean status) {
        this.tarea = tarea;
        this.status = status;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}