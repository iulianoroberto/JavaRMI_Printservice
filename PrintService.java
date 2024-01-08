// Il codice di libreria che si utilizza (Remote) è in java.rmi, si importa la libreria
// l'import si potrebbe evitare usando il nome completo di Remote, ossia java.rmi.Remote
import java.rmi.*;

/*
 * In questa classe si definisce l'interfaccia a cui può ricorrere il client per accedere agli oggetti remoti.
 * Nell'interfaccia viene definito il prototipo del metodo print() che non restituisce alcun valore, ma, quando invocato dal client
 * tramite invocazione remota, il client gli passa una stringa msg che raggiunge l'oggeto remoto locato sul server.
 * 
 * Si prevede il lancio dell'eccezione RemoteException (non presente in locale) perché avviene una interazione remota.
 */

// L'interfaccia estende l'interfaccia Remote
public interface PrintService extends Remote{
	public void print(String msg) throws RemoteException;
}
