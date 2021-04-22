package ende.VehiculosApp.src;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class MiObjectOutputStream extends ObjectOutputStream{
	
    public MiObjectOutputStream() throws IOException{
            super();

    }

    public MiObjectOutputStream(OutputStream out) throws IOException{
            super(out);

    }

    @Override
    protected void writeStreamHeader() throws IOException{

            // Sobreescrito sin implementación, 
            // para que NO incluya cabecera al añadir objetos.
    }

}

