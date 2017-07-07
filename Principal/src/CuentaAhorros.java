/**
 * Clase que declara una Cuenta de Ahorros, que hereda de Cuenta
 * Ricardo Castillo Lara
 * 04/07/2017
 */
public class CuentaAhorros extends Cuenta{
  public CuentaAhorros(double bal) {
		super(bal);
		// TODO Auto-generated constructor stub
	}

public void retiro(double dinero, int pos) {
	  if(balance>5000){
      balance = balance -dinero;
    }
  }
}
