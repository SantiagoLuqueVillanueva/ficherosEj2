package gestion;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class CodiceEncantado {
    private String rutaArchivo = "codice.txt";

    public void crearCodice(){
        File archivo = new File(rutaArchivo);

        try {
            if (archivo.createNewFile()) {
                System.out.println("Se ha forjado un nuevo códice: " + archivo.getName());
            } else {
                System.out.println("El códice ya reposa en la biblioteca.");
            }
        } catch (IOException e) {
            System.out.println();
        }
    }

    public void escribirRelato(String relato){
        try (
            FileWriter tuberia = new FileWriter(rutaArchivo, true);
            BufferedWriter camion = new BufferedWriter(tuberia);
        ){
            camion.write(relato);
            camion.newLine();
        } catch (IOException e) {
            System.out.println("Error al inscribir el relato: " + e.getMessage());
        }
    }

    public void leerCodice(){
        try (
            FileReader tuberia = new FileReader(rutaArchivo);
            BufferedReader camion = new BufferedReader(tuberia);
        ){
            String linea;
            int contadorLineas = 0;

            System.out.println("\n--- Abriendo el Códice Encantado ---");
            while ((linea = camion.readLine()) != null) {
                System.out.println(linea);
                contadorLineas++;
            }
            System.out.println("------------------------------------");

            System.out.println("Oh, viajero, este códice contiene " + contadorLineas + " relatos de antaño.");
        } catch (IOException e) {
            System.out.println("El códice está sellado o no existe.");
        }
    }

    public void borrarCodice(){
        File archivo = new File(rutaArchivo);
        if (archivo.delete()) {
            System.out.println("El códice ha sido reducido a cenizas.");
        } else {
            System.out.println("El códice se resiste a ser destruido.");
        }
    }
}
