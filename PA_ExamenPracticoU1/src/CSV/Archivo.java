package CSV;

import Modelo.Producto;
import java.io.*;
import java.util.ArrayList;

public class Archivo {

    private final String archivo = "productos.csv";

    public void exportarCSV(ArrayList<Producto> lista) {

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {

            for (Producto p : lista) {
                pw.println(p.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Producto> importarCSV() {

        ArrayList<Producto> lista = new ArrayList<>();

        File f = new File(archivo);

        if (!f.exists()) {

            lista.add(new Producto(1,"Arroz","Grano",10,35,"Disponible"));
            lista.add(new Producto(2,"Frijol","Grano",8,40,"Disponible"));
            lista.add(new Producto(3,"Azucar","Grano",12,30,"Disponible"));
            lista.add(new Producto(4,"Aceite","Liquido",6,55,"Disponible"));
            lista.add(new Producto(5,"Leche","Lacteo",10,28,"Disponible"));

            exportarCSV(lista);

            return lista;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                Producto p = new Producto(
                        Integer.parseInt(datos[0]),
                        datos[1],
                        datos[2],
                        Integer.parseInt(datos[3]),
                        Double.parseDouble(datos[4]),
                        datos[5]
                );

                lista.add(p);
            }

        } catch (Exception e) { }

        return lista;
    }
}