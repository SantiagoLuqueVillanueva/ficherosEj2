package gestion;

import java.util.ArrayList;
import java.util.HashMap;

public class EscribaReal {
    private ArrayList<String> lista;
    private HashMap<Integer, String> mapa;
    private int idActual;

    public EscribaReal(){
        this.lista = new ArrayList<>();
        this.mapa = new HashMap<>();
        this.idActual = idActual;
    }

    public void añadirRelato(String relato){
        lista.add(relato);

        mapa.put(idActual, relato);

        System.out.println("El escriba ha tomado nota del relato con ID: " + idActual);

        idActual++;
    }

    public void listarRelatos(){
        System.out.println("\n--- Registro del Escriba (HashMap) ---");
        for (Integer id : mapa.keySet()) {
            System.out.println("Pergamino " + id + ": " + mapa.get(id));
        }
    }

    public void guardarRelatosEnCodice(CodiceEncantado archivo){
        System.out.println("\nEl escriba se dirige a transcribir los relatos al códice...");

        for (String relato : lista) {
            archivo.escribirRelato(relato);
        }

        lista.clear();
        System.out.println("Los relatos han sido sellados en el fichero con éxito.");
    }
}
