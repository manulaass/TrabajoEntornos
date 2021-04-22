package ende.VehiculosApp.src;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.LinkedList;



public class LectorObjetos {
	    /**
	     * Atributo: ruta/nombre fichero
	     */
	    private String filename;

	    /**
	     * Constructor
	     * 
	     * @param filename ruta/nombre fichero de objetos.
	     */
	    public LectorObjetos (String filename){
	        this.filename = filename;
	    }
	    
	    /**
	     * Lee del fichero todos los objetos Vehiculo, y devuelve 
	     * un objeto LinkedList NUEVO con todos ellos.
	     * 
	     * @return un objeto LinkedList con todos los objetos leídos.
	     */
	    public LinkedList<Vehiculo> read(){
	        LinkedList<Vehiculo>lista = new LinkedList<>();
	        Vehiculo obj;
	        int conta=0;

	        // Abro recurso: fichero de objetos (cierre automático)
	        try (ObjectInputStream ois = 
	                new ObjectInputStream (new FileInputStream(filename))){
	            
	            // Leo todos los objetos del fichero.
	            while(true){
	                obj = (Vehiculo) ois.readObject();
	                // TRAZA
	                System.out.printf(" > leer: %s %n", obj); 
	                lista.add(obj);
	                conta++;
	            }
	            
	        }catch(EOFException e){
	            // Se alcanzó el final del fichero
	            System.out.printf(" > leer: EOF. %d objetos leidos. %n", conta); 

	        }catch(ClassNotFoundException e){
	            System.out.println("> leer: ERROR en readObject: "+e); 
	            
	        }catch(FileNotFoundException e){
	            System.out.println("> leer: ERROR al abrir: "+e); 
	            
	        }catch(IOException e){
	            System.out.println("> leer: ERROR E/S: "+e);             
	        
	        }finally{
	            // Aunque se produzca una excepción no controlada,
	            // se ejecuta el return.
	            return lista;
	            
	        } // fin try-with-resources    
	    
	    }
	        
	    /**
	     * Lee del fichero todos los objetos serializados de la 
	     * clase Vehiculo y muestra su información en consola.
	     */
	    public void show(){
	        LinkedList<Vehiculo> lista;
	        
	        lista = read();
	        // Recorro la lista y escribo en consola cada objeto
	        lista.forEach((v) -> {
	            // Muestro información en consola
	            System.out.printf("Objeto: %s %n", v);
	        System.out.println("hola mundo");
		});        
	    }    
	    
	    /**
	     * Busca en un fichero el vehículo con la matrícula indicada
	     * por parámetro.
	     * 
	     * @param matricula matricula del vehículo buscado.
	     * @return el objeto buscado; null si no se encuentra.
	     */
	    public Vehiculo search(String matricula){
	        Vehiculo obj = null;

	        // Abro recurso: fichero de objetos (cierre automático)
	        try (ObjectInputStream ois = 
	                new ObjectInputStream (new FileInputStream(filename))){
	            
	            // Leo todos los objetos hasta encontrarlo.
	            boolean encontrado = false;
	            while(!encontrado){
	                obj = (Vehiculo) ois.readObject();
	                if (obj.getMatricula().equals(matricula)){
	                    encontrado=true;
	                }
	            }
	            
	        }catch(EOFException e){
	            // Se alcanzó el final del fichero
	            obj = null;

	        }catch(ClassNotFoundException e){
	            System.out.println("buscar > ERROR en readObject: "+e); 
	            
	        }catch(FileNotFoundException e){
	            System.out.println("buscar > ERROR al abrir: "+e); 
	            
	        }catch(IOException e){
	            System.out.println("buscar > ERROR E/S: "+e);             
	                
	        }finally{
	            // Aunque se produzca una excepción no controlada,
	            // se ejecuta el return.
	            return obj;
	            
	        } // fin try-with-resources    
	    }
	}



