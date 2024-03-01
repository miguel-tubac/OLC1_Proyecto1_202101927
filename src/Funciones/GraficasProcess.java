
package Funciones;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


public class GraficasProcess { 
    public static void linea(
            String Titulo, 
            String TituloX,
            String TituloY,
            double valores[],
            String ejex []
    )
    {
        //Ingreso de datos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
        
        for(int i = 0; i < 5; i++){
            dataset.addValue(valores[i], "Valor", ejex[i]);
        }
        
        // Creación de gráfica
        JFreeChart grafica = 
            ChartFactory.createLineChart(
                    Titulo, 
                    TituloX,
                    TituloY, 
                    dataset);
        
        
        // Mostrar
        ChartFrame frame = new ChartFrame("Ejemplo", grafica);
        frame.pack();
        frame.setVisible(true);
    }
    
    
    public static void Pie(
            String Titulo, 
            String TituloX,
            String TituloY,
            double valores[],
            String ejex []
    )
    {
        //Ingreso de datos
        DefaultPieDataset dataset = new DefaultPieDataset( );
      
        for(int i = 0; i < 5; i++){
            dataset.setValue(ejex[i], valores[i]);
        }
        // Creación de gráfica
        JFreeChart grafica = 
            ChartFactory.createPieChart(Titulo, dataset);
        
        
        // Mostrar
        ChartFrame frame = new ChartFrame("Ejemplo", grafica);
        frame.pack();
        frame.setVisible(true);
    }
    
}