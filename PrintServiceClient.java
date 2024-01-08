import java.rmi.*;
import java.net.*;
import java.util.*;

/*
 * Questo è il codice del client, una volta avviato da vita al processo client.
 * Il codice principale è contenuto nel try. In particolare, il client recupera dal registro (tramite una operazione di lookup)
 * il refernce globale dell'oggetto remoto che espone quel metodo (ossia il metodo print).
 * Una volta recuperato il reference globale invoca (trasparenza agli accessi) il metodo print come se fosse scritto in locale e quindi
 * la stringa viene scritta sullo standard output del processo server. * 
 */

public class PrintServiceClient {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			String s = null;
			// Recupero reference globale all'oggetto printservice, il cast è necessario perché la lookup ritorna un oggetto di tipo Remote
			// Si recupera il proxy dell'oggetto remoto con l'operazione di lookup
			PrintService ps = (PrintService)Naming.lookup("rmi://127.0.0.1/printservice");
			do {
				// Lettura linea dallo standard input finché non trova il carattere punto
				s = sc.nextLine();
				// Viene invocato il metodo remoto e la stringa s viene passata come parametro, quindi scritta sullo stdout del processo server
				ps.print(s);
			} while (!s.equals(".")); // Condizione di uscita dal ciclo basata sull'individuazione del caratterre punto nello stdin
		} catch(RemoteException e) {
			System.err.println("Registry could not be contacted");
		} catch(MalformedURLException e) {
			System.err.println("Wrong URL for binding");
		} catch(NotBoundException e) {
			System.err.println("Object not bound");
		}

	}

}
