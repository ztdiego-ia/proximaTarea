package Controller;

import View.Home;
import Model.*;
import View.*;
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class LogicaTarea {
    
    public static void main(String[] args) {
        //leer ruta en json
        leerRuta();

        //datos para PnlArchivo
        PnlArchivo.envDatos(ruta, nmbrArchivo);
        
        //leer los datos guardados
        leerJson();

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
    private static final String rutaBase=System.getProperty("user.dir");
    private static String ruta="\\src\\main\\java\\Save\\";
    public static String getRuta() {
        return ruta;
    }
    public static void setRuta(String ruta) {
        LogicaTarea.ruta = ruta;
        guardarRuta();
    }
    //nombre de archivo
    private static String nmbrArchivo="";
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
        try(FileWriter escribir=new FileWriter(rutaBase+"\\src\\main\\java\\Save\\"+"regiData.json");){
            escribir.write(arrayJson.toJSONString());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    //leer json
    private static void leerJson(){
        JSONParser parser=new JSONParser();
        try(FileReader leer=new FileReader(rutaBase+"\\src\\main\\java\\Save\\"+"regiData.json")){
            JSONArray arrayJson=(JSONArray)parser.parse(leer);
            for (Object obj:arrayJson) {//la clase object es la madre de todas las clases
                JSONObject objJson=(JSONObject)obj;
                registroTarea.anadirTareaRep((String)objJson.get("tarea"), (boolean)objJson.get("status"));
            }
        }catch(IOException | ParseException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    //guargar json de ruta
    private static void guardarRuta(){
        JSONObject objtJson=new JSONObject();
        objtJson.put("ruta", ruta);
        try(FileWriter escribir=new FileWriter(rutaBase+"\\src\\main\\java\\Save\\"+"regiRuta.json")){
            escribir.write(objtJson.toJSONString());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    //leer json de ruta
    private static void leerRuta(){
        JSONParser parser=new JSONParser();
        try(FileReader leer=new FileReader(rutaBase+"\\src\\main\\java\\Save\\"+"regiRuta.json")){
            JSONObject objJson=(JSONObject)parser.parse(leer);
            ruta=(String)objJson.get("ruta");
        }catch(IOException | ParseException ex){
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
