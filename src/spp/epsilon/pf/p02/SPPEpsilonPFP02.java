//Proyecto Final 
//Problema 2
//Equipo Epsilon
//Nombres, matrículas y carreras de integrantes de equipo:
//Roberto Alain Rivera Bravo | A01411516 | IMT11
//Fabricio Arturo Balboa Cavazos | A01411541 | IMT11
//Andrés de Jesús Martínez Castillo | A01411447 | IMT11
//Jessica Delgado González | A01411536 | IMT11
//Alfredo Alejandro Lárraga Sosa | A01410278 | LMC
/*
Problema:
Desarrolla un programa en Java que acumule cantidades de gasto capturadas, estas
pueden tener punto decimal, las debe guardar en un arreglo y las muestre al final
con el total de gastos. La captura debe detenerse al introducir cualquier número negativo.
 */
package spp.epsilon.pf.p02;
import javax.swing.JOptionPane; 
/**
 *
 * @author andres
 */
public class SPPEpsilonPFP02 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          menu();//Método menú
    }
    public static void menu(){//Metodo menú en el cual se desarrollará el programa
        double[] V=new double[100];
        int i=0; double x=0,suma=0;
            while(x>=0){
               x=solicitardouble("Introduce un gasto, si deseas parar introduce un numero negativo");//Método que me devuelve una variable tipo double validada
                V[i]=x;  
                i++;  
            }
            for (int j = 0; j < i-1; j++) {
            suma=suma+V[j];
            }
        String y=Gastos(V,i-1);//Método que me devuelve una variable String concatenada 
        JOptionPane.showMessageDialog(null,"Gastos: "+y+"\nTotal de gastos:  $"+suma);
        salida();
    }
    public static double solicitardouble(String mensaje){//Método que me devuelve una variable double verificada introducida por JOptionPane
        boolean flag;
        double x=0;
            do{
                try{
                    String dato=JOptionPane.showInputDialog(null,  mensaje);
                    x=Double.parseDouble(dato) ;
                    flag=true;
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Dato no válido, vuelva a intentarlo","ERROR", JOptionPane.OK_CANCEL_OPTION);
                    flag=false;
                }
            }while(flag==false);
        return x;  
    }
    public static String Gastos(double[] V, int n){//Método que me devuelve una variable string concatenada con otras para devolver todos los gastos por separado
        String x="";
        for (int i = 0; i < n; i++) { 
        x=x+"  $"+Double.toString(V[i])+"  ";  
        }
        return x; 
    }
    public static void salida(){//Método que pregunta al usuario si desea volver a correr el programa o salir mediante cuadro de dialogo
       int opcion=JOptionPane.showOptionDialog(null, "¿Qué desea hacer? ", "Menu de salida",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object []{"Volver a correr el programa", "Salir"}, "Volver a correr el programa");
            if(opcion==0){
               menu();
               System.exit(0);
            }else {
                JOptionPane.showMessageDialog(null,"Vuelva pronto!");
                System.exit(0);
            }
    }
}