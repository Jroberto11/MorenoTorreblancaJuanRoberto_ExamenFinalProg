package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaCoches<T>extends ArrayList<T> {
Comparator<T>comparator;

public ListaCoches(Comparator<T> comparator) {
	super();
	this.comparator = comparator;
}
public ListaCoches() {
		
	}



	public boolean aniadir(T elemento) throws Exception {
		if (elemento == null) {
			
				throw new Exception("Elemento no válido");
				} else {
			if (super.add(elemento)) {
				reverse();
				return true;
			}
		}
		return false;
	}

	
	
	public boolean borrar(T elemento) throws Exception {
		if(elemento == null){
			throw new Exception("Elemento no válido");
		}
		else{
			if(super.remove(elemento)){
				reverse();
				return true;
			}
		}
		return false;
	}
	

	public void reverse() {
		Collections.sort(this, comparator);
	}

}

