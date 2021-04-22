package ende.VehiculosApp.src;

import java.util.LinkedList;

public class VehiculosApp {

	
		
		/**
	     * MAIN method
	     * @param args the command line arguments (not used)
	     */
	    public static void main(String[] args) {
	        final String FICH_1 = "v1.obt";
	        final String FICH_2 = "vehiculos.obt";

	        // Creo objetos Vehiculo
	        Vehiculo v1 = new Vehiculo("CFC 6666", "BMW", "X3");
	        System.out.printf("Creado %s %n", v1);
	        
	        Vehiculo v2 = new Vehiculo("HCG 5555", "SEAT", "Leon");
	        System.out.printf("Creado %s %n", v2);
	        
	        // Guardo el primer vehiculo
	        EscritorObjetos escritor = new EscritorObjetos(FICH_1);
	        System.out.printf("Escribiendo \"%s\"... %n", FICH_1);
	        escritor.write(v1);
	        
	        // Examino el contenido del fichero 
	        LectorObjetos lector = new LectorObjetos(FICH_1);
	        System.out.printf("Leyendo \"%s\"... %n", FICH_1);
	        lector.show();
	        
	        // Guardo los dos vehiculos
	        EscritorObjetos escritor2 = new EscritorObjetos(FICH_2);
	        System.out.printf("Escribiendo \"%s\"... %n", FICH_2);
	        Vehiculo lista[] = new Vehiculo[2];
	        lista[0] = v1;
	        lista[1] = v2;
	        escritor2.write(lista);
	        
	        // Recupero el segundo vehiculo
	        LectorObjetos lector2 = new LectorObjetos(FICH_2);
	        System.out.printf("Buscando vehiculo \"%s\"... ", "HCG 5555");
	        Vehiculo vBuscado = lector2.search("HCG 5555");
	        if (vBuscado != null){
	            System.out.printf("Encontrado, es un %s %s %n", 
	                    vBuscado.getMarca(), vBuscado.getModelo());
	            // Lo alquilo
	            vBuscado.alquilar();
	            System.out.println(vBuscado);
	        }
	        else {
	            System.out.printf("NO Encontrado %n");
	        }
	        
	        // Guardo los dos vehiculos otra vez
	        System.out.printf("Escribiendo \"%s\"... %n", FICH_2);
	        lista[0] = v1;
	        lista[1] = vBuscado;
	        escritor2.write(lista);
	        
	        // Recupero TODOS los objetos en una estructura dinámica
	        System.out.printf("Recuperando vehiculos de \"%s\"...%n", FICH_2);
	        LinkedList<Vehiculo> todos = lector2.read();
	        int conta=0;
	        for (Vehiculo v: todos){
	            System.out.printf("lista[%d]: %s %n", conta, v);
	            conta++;
	        }
	       
	        // Busco un vehículo que no existe
	        System.out.printf("Buscando vehiculo \"%s\"... ", "ZZZ 9999");
	        vBuscado = lector2.search("ZZZ 9999");
	        if (vBuscado != null){
	            System.out.printf("Encontrado, es un %s %s %n", 
	                    vBuscado.getMarca(), vBuscado.getModelo());
	        }
	        else {
	            System.out.printf("NO Encontrado %n");
	        }
	        
	        // Agrego dos objetos más
	        System.out.printf("Agregando dos vehiculos...%n");
	        escritor2.add(new Vehiculo("HGG 1111", "Citroen", "C6"));
	        escritor2.add(new Vehiculo("III 9999", "Kia", "Venga"));
	        
	        // Muestro el contenido del fichero
	        System.out.printf("Leyendo \"%s\"... %n", FICH_2);
	        lector2.show();
	        
	    }
	    System.out.println("hola soy esteban este cambio se ha producido el 21/04 ");
	    System.out.println("Hola, primer cambio de Manuel")
	    System.out.println("este cambio esta hecho el 21/04/21 19:45");
	    System.out.println("Hola soy Assma y este es mi primer cambio 22/04");
		   
//	

	}


