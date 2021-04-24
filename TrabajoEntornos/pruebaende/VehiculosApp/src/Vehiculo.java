package ende.VehiculosApp.src;


public class Vehiculo implements java.io.Serializable {

    //<editor-fold defaultstate="collapsed" desc="Atributos NO Serializables">

    /**
     * Serial UID: generado con el programa serialver (ver JDK)
     */
    private static final long serialVersionUID = 5155091404716818946L;
    
    /**
     * Color del vehiculo. 
     * Todos los vehículos de la flota, tienen el mismo color.
     * Actualmente son AMARILLOS.
     */
    private final static String color = "AMARILLO";
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Atributos Serializables">

    /**
     * Número de Matricula  
     */
    private String matricula;

    /**
     * Marca  
     */
    private String marca;

    /**
     * Modelo  
     */
    private String modelo;

    /**
     * Disponible (NO alquilado)  
     */
    private boolean disponible;
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    
    /**
     * Constructor
     * 
     * @param mat matricula
     * @param mar marca vehiculo
     * @param mod modelo vehiculo
     */
    public Vehiculo(String mat, String mar, String mod){
        this.matricula  = mat;
        this.marca      = mar;
        this.modelo     = mod;
        this.disponible = true;
    }

    /**
     * Devuelve el serial version ID
     * @return serial version ID
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * Devuelve la matrícula
     * 
     * @return la matrícula del vehículo.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Devuelve la marca del vehículo.
     * 
     * @return la marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Devuelve el modelo del vehículo.
     * 
     * @return el modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Comprueba si está disponible.
     * 
     * @return true si está disponible; false en otro caso.
     */
    public boolean isDisponible() {
        return disponible;
    }
	
    /**
     * Alquila el vehiculo, marcando el vehiculo como 
     * NO disponible 
     */
    public void alquilar() {
        if (this.disponible){
          this.disponible = false;
        }
    }
	
    /**
     * Devuelve el vehículo, marca el vehículo como disponible.
     */
    public void devolver() {
        if (this.disponible == false){
          this.disponible = true;
        }
    }

    @Override
    public String toString() {
        return "Vehiculo [matricula=" + matricula + ", marca=" + 
                marca + ", modelo=" + modelo + ", disponible=" + 
                disponible + "]";
    }
    //</editor-fold>
}
