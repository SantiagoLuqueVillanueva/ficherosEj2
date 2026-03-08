import java.util.Scanner;
import gestion.CodiceEncantado;
import gestion.EscribaReal;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. Instanciamos las clases
        CodiceEncantado miCodice = new CodiceEncantado();
        EscribaReal miEscriba = new EscribaReal();

        // 2. Verificamos y creamos el códice
        miCodice.crearCodice();

        // 3. Añadimos relatos
        miEscriba.añadirRelato("El dragón de fuego despertó en la montaña oscura.");
        miEscriba.añadirRelato("El caballero sin nombre encontró la espada de cristal.");
        miEscriba.añadirRelato("Los elfos abandonaron el bosque de los lamentos.");

        miEscriba.listarRelatos();

        // 4. Guardamos los relatos en el fichero (pasando el códice por parámetro)
        miEscriba.guardarRelatosEnCodice(miCodice);

        // 5. Leemos el códice (aquí saldrá el recuento de líneas)
        miCodice.leerCodice();

        // 6. Confirmación para borrar
        System.out.println("\n¿Deseas destruir el códice para siempre? (S/N): ");
        String respuesta = scanner.nextLine();

        // Si la respuesta es "S" o "s", lo borramos
        if (respuesta.equalsIgnoreCase("S")) {
            miCodice.borrarCodice();
        } else {
            System.out.println("Sabia elección. El conocimiento ha sido preservado.");
        }

        scanner.close(); // Siempre cerramos el scanner al terminar
    }
}
