package Controller;

import View.Home;
import Model.*;
import View.*;
import java.io.File;
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class LogicaTarea {
    
    public static void main(String[] args) {
        //añadir tareas predefinidas
        LogicaTarea.anadirTarea("pasear al perro", false);
        LogicaTarea.anadirTarea("barrer la sala", false);
        LogicaTarea.anadirTarea("tomar desayuno", true);
        LogicaTarea.anadirTarea("comprar 5kg de carne", true);
        LogicaTarea.anadirTarea("pedir una cita para el dentista", false);
        
        PnlArchivo.envDatos(ruta, nmbrArchivo);

        //iniciar app Home
        iniciarPantalla();
        
        String rutaInicial=System.getProperty("user.dir");
        Path rutaAbsoluta = Paths.get(rutaInicial, "\\src\\main\\java\\Save\\", "registroDeTareas.csv");
        File carpeta = rutaAbsoluta.getParent().toFile();
        System.out.println(carpeta.exists());
        System.out.println(rutaInicial);
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
        guardarRegistro();
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
    
    //borrar una entrada del repositorio
    public static void brrTarea(int i){
        registroTarea.brrTarea(i);
    }
    
    //ruta de guardado
    private static String rutaBase=System.getProperty("user.dir");
    private static String ruta="..\\Save\\";
    public static String getRuta() {
        return ruta;
    }
    public static void setRuta(String ruta) {
        LogicaTarea.ruta = ruta;
    }
    //nombre de archivo
    private static String nmbrArchivo="registroDeTareas";
    public static String getNmbrArchivo() {
        return nmbrArchivo;
    }
    public static void setNmbrArchivo(String nmbrArchivo) {
        LogicaTarea.nmbrArchivo = nmbrArchivo;
    }

    //guardar registros en un json
    private static void guardarRegistro(){
        JSONArray arrayJson=new JSONArray();
        for (TareaFormato tr : registroTarea.listarTareaRep()) {
            JSONObject rgsJson=new JSONObject(); //crear el jsonobject dentro del for para que iteracion de un objeto independiente
            rgsJson.put("tarea", tr.getTarea());
            rgsJson.put("status", tr.isStatus());
            arrayJson.add(rgsJson);
        }
        try(FileWriter escribir=new FileWriter(rutaBase+"\\src\\main\\java\\Save\\"+"texto.json");){
            escribir.write(arrayJson.toJSONString()+"\n");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    //exportar en un .txt, .pdf o .csv
    public static void exportarArchivo(int opc){
        switch(opc){
            case 1->expTxt();
            case 2->expPdf();
            case 3->expCsv();
            default->System.out.println("opcion invalida");
        }
    }
    
    private static void expTxt(){
        
    }
    private static void expPdf(){
        
    }
    private static void expCsv(){
        try(FileWriter escribir=new FileWriter(ruta+nmbrArchivo+".csv");
            CSVPrinter escrCsv=new CSVPrinter(escribir, CSVFormat.DEFAULT.withHeader("Tarea","Status"))){
            
            for (TareaFormato tr : registroTarea.listarTareaRep()) {
                escrCsv.printRecord(tr.getTarea(), tr.isStatus());
            }
            JOptionPane.showMessageDialog(null, "Archivo guardado con exito", "Informe", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
