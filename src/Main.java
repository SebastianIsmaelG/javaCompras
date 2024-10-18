import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el limite de cupo de la tarjeta: ");
        double limite = leer.nextDouble();
        TarjetaDeCredito tarjeta = new TarjetaDeCredito(limite);

        int salir= 1;
        while (salir != 0){
            //tomamos datos
            System.out.println("Ingrese la nombre del articulo: ");
            String descripcion = leer.next();
            System.out.println("Ingrese el valor del articulo");
            double valor = Double.valueOf(leer.next());

            //ingresamos nuevo objeto
            Compra compra = new Compra(valor,descripcion);
            //comprobamos el valor de los datos en TarjdetaDeCredito
            boolean compraRealizada = tarjeta.lanzarCompra(compra);

            System.out.println(compraRealizada);

            //if true
            if (compraRealizada){
                System.out.println("Compra ingresada");
                System.out.println("Ingrese 0 para salir o 1 para continuar");
                salir = leer.nextInt();
            }else {
                System.out.println("Saldo insuficiente");
                salir = 0;
            }

        }

        System.out.println("******************************");
        System.out.println("Resumen de compra: \n");
        Collections.sort(tarjeta.getListaDeCompras());

        for (Compra compra: tarjeta.getListaDeCompras()){
            System.out.println(compra.getDescripcion()+ " - " +compra.getValor());
        }
        System.out.println("\n******************************");
        System.out.println("\nCupo restante de la tarjeta: "+tarjeta.getSaldo());


    }
}