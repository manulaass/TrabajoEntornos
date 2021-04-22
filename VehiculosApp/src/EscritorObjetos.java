package ende.VehiculosApp.src;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Clase que permita escribir 
 * <strong>Objetos de la clase Vehiculo</strong> en un fichero.
 * 
 * @author josema
 */
public class EscritorObjetos {
    /**
     * Atributo: ruta/nombre fichero
     */
    private String filename;

    /**
     * Constructor
     * 
     * @param filename ruta/nombre fichero de objetos.
     */
    public EscritorObjetos (String filename){
            this.filename = filename;
    }

    /**
     * Escribe en el fichero un objeto Vehiculo.
     * 
     * @param obj objeto de la clase Vehiculo
     * @return nº de objetos escritos; -1 si sucedió un error.
     */
    public int write(Vehiculo obj){
        Vehiculo lista[] = new Vehiculo[1];
        lista[0] = obj;
        return write(lista);
    }
    
    /**
     * Escribe en el fichero una lista de objetos Vehiculo.
     * 
     * @param lista array con la lista de objetos
     * @return nº de objetos escritos; -1 si sucedió un error.
     */
    public int write(Vehiculo lista[]){
        int ret = 0;

        // Abro recurso: fichero de objetos
        try (ObjectOutputStream oos = 
                new ObjectOutputStream (
                        new FileOutputStream(filename))){

            for (Vehiculo v : lista) {
                oos.writeObject(v);
                ret++;
                // TRAZA
                System.out.printf(" > escribir: %s %n", v);				
            }
    
        } catch(IOException e){
            // Escribo información sobre la excepción
            System.out.printf(" > escribir: ERROR de E/S. Detalle: %s %n", e);
            ret = -1;
                
        } finally {
            // El return se realizará siempre.
            return ret;
            
        } // fin try-with-resources
    }
    
    /**
     * Añade al fichero un objeto de la clase Vehiculo.
     * 
     * @param obj objeto a agregar al fichero
     * @return nº de objetos escritos, en este caso 1; 
     * -1 si sucedió un error.
     */
    public int add(Vehiculo obj) {

        // Creo un array para un solo objeto y asi poder usar
        // la otra versi�n del m�todo agregar
        Vehiculo lista[] = new Vehiculo[1];
        lista[0] = obj;

        return add(lista);		
    }
	
    /**
     * Añade al fichero un conjunto de objetos de la clase Vehiculo,
     * almacenados en un array.
     * 
     * @param lista array de objetos a agregar al fichero
     * @return nº de objetos escritos; -1 si sucedió un error.
     */
    public int add(Vehiculo lista[]) {
        int ret = 0;

        // Abro recurso: fichero de objetos para AGREGAR
        try (MiObjectOutputStream myoos = 
                new MiObjectOutputStream (
                        new FileOutputStream(filename, true))){
			
            for (Vehiculo v : lista) {
                myoos.writeObject(v);
                ret++;
                // TRAZA
                System.out.printf(" > agregar: %s %n", v);
            }
									
        } catch(IOException e){
            // Escribo información sobre la excepción
            System.out.printf(" > agregar: ERROR de E/S. Detalle: %s %n", e);
            ret = -1;

        } finally {
            // Siempre se realizará
            return ret;
            
        } // fin try-with-resources
        
    }

}
