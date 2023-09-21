package Tarea10;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FormatoTabla {
   private DefaultTableModel modelo = new DefaultTableModel();// aqui agrego los datos
    private JTable tabla = new JTable();// aqui se agregan a la tabla
    private JScrollPane scrollPane = new JScrollPane();// en cso de que sea muy grande y necesite parras de desplasamiento

    //en este Array meteremos los nombres de las columnas
    /*el usar Object...es mas facil ya que si uso Object[] tengria que crear ese array 
     * y ahi agregar los datos y luego ya pasarlos, mientras que con Object.. se evita el
     * crear ese array y los puedo agregar directo */

    public Object[] Columnas(Object... nombresColumnas) {
        return nombresColumnas;
    }//aqui se agregan los nombres de las columnas

    public void AgregarColumnas(Object[] nombresColumnas) {
        modelo = new DefaultTableModel();

        for (Object nombre : nombresColumnas) {
            modelo.addColumn((String) nombre);
        }//va a recorrer toso lo que este en en Object[]
    }// aqui se agregan las columnas a la tabla

    public Object[] Datos(Object... datos) {
        return datos;
    }//aqui se agregan los datos
    
    public void AgregarDatos(Object[] Datos) { 
            modelo.addRow(Datos);
    }// end agregar los datos a la tabla
    
    public void ImprimirTabla() {
        tabla = new JTable(modelo);
        scrollPane = new JScrollPane(tabla);
        JOptionPane.showMessageDialog(null, scrollPane);
        
    }// end imprimirTabla 
    public static void main(String[] args) {
        FormatoTabla ar = new FormatoTabla();
        ar.AgregarColumnas(ar.Columnas("c1", "c2", "c3", "c4"));
        ar.AgregarDatos(ar.Datos("d1", "d2", "d3", "d4" ));
        ar.AgregarDatos(ar.Datos("d11", "d21", "d31", "d41" ));
        ar.AgregarDatos(ar.Datos(" ", null, "", "12312312" ));
     
        ar.ImprimirTabla();
    }
}//end Formato Tabla
