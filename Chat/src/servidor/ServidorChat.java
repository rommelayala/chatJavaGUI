package servidor;

import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.DefaultListModel;

/**
 * Servidor de chat.
 * Acepta conexiones de clientes, crea un hilo para atenderlos 
 * y espera la siguiente conexion.
 *
 */
public class ServidorChat
{
    /** Lista en la que se guardara toda la conversacion */
    private DefaultListModel charla = new DefaultListModel();

    /**
     * Instancia esta clase.
     * @param args
     */
    public static void main(String[] args)
    {
        new ServidorChat();
    }

    /**
     * Se mete en un bucle infinito para atender clientes, 
     * lanzando un hilo para cada uno de ellos.
     */
    public ServidorChat()
    {
        try
        {
            ServerSocket socketServidor = new ServerSocket(5557);
            System.out.println("Servidor de chat en ejecucion!");
            while (true)
            {
                Socket cliente = socketServidor.accept();
                Runnable nuevoCliente = new HiloDeCliente(charla, cliente);
                Thread hilo = new Thread(nuevoCliente);
                hilo.start();                
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
