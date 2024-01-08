import java.rmi.*;
import java.rmi.server.*;

/*
 * In questo codice viene fornita l'implementazione dei prototipi dei metodi remoti (in questo caso solo il metodo print).
 * Questo metodo stampa sullo standard output del server la stringa (msg) ricevuta dal client tramite invocazione remota.
 */

// Estende la classe UnicastRemoteObject e se ne recupera il costruttore di questa classe per dar vita al thread che gestirà questo oggetto che implemneta l'interfaccia definita
public class PrintServiceImpl extends UnicastRemoteObject implements PrintService {

	// Numero seriale della classe
	private static final long serialVersionUID = 1L;

	// Costruttore senza argomenti
	public PrintServiceImpl() throws RemoteException {}
	
	public void print(String msg) throws RemoteException {
		// Stampa localmente al server il messaggio ricevuto
		System.out.println(msg);
	}
}