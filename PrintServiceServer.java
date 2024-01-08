import java.rmi.*;
import java.net.*;
import java.rmi.registry.*;

/*
 * Questo è il codice del server. Essenzialmente il codice è contenuto nel try.
 * Questo codice una volta avviato darà vita al processo server che crea un oggetto di tipo PrintService (ps) ospitato dal
 * processo server.
 * L'oggetto viene poi memorizzato sul registro tramite un'operazione di bind.
 */

public class PrintServiceServer {

	public static void main(String[] args) {
		try {
			// Creo istanza oggetto remoto di tipo PrintService ospitato dal processo server il cui refernce locale è contenuto nella variabile ps.
			PrintService ps = new PrintServiceImpl();

			/*
			 * Con questa riga si può fare a meno dell'utilizzo esplicito del registro. Il registro viene creato dal processo
			 * server, non serve avviarlo. Il registro sarà in ascolto sulla porta 1099.
			 */
			LocateRegistry.createRegistry(1099);

			// Si memorizza l'istanza dell' oggetto sul registro, il suo nome è printservice e il reference locale al server è ps.
			Naming.bind("rmi://127.0.0.1/printservice", ps);

			/*
			 * Si prevedono diversi catch per catturare le evntuali eccezioni generate.
			 * L'operazione di bind può dar vita a diverse eccezioni.
			 */

		} catch(AccessException e) {
			// Accesso non possibile al registro
			System.err.println("Bind operation not permitted");
		} catch(RemoteException e) {
			// Eccezzione per l'invocazione remota (siamo in un sistema distribuito)
			System.err.println("Registry could not be contacted");
		} catch(MalformedURLException e) {
			// Eccezzione dovuta ad un URL errato
			System.err.println("Wrong URL for binding");
		} catch(AlreadyBoundException e) {
			// Eccezzione dovuta ad una registrazione già effettuata (evitabile con rebind)
			System.err.println("Object already bound to the registry");
		}

	}

}