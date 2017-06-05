package Models;

import java.util.Date;

public class Coche {
private String Matricula;
private Date Entrada;

public Coche(String matricula, Date entrada) {
	super();
	Matricula = matricula;
	Entrada = entrada;
}
public String getMatricula() {
	return Matricula;
}
public void setMatricula(String matricula) {
	Matricula = matricula;
}
public Date getEntrada() {
	return Entrada;
}
public void setEntrada(Date entrada) {
	Entrada = entrada;
}
@Override
public String toString() {
	return "Coche [Matricula=" + Matricula + ", Entrada=" + Entrada + "]";
}


}
