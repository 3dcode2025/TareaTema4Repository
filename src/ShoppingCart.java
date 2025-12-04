import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 *  Esta clase que representa el carrito de compra ya con el codigo refactorizado
 *  utilizando una lista de objetos de la clase Prodcuto. Incluyendo metodos para añadir, eliminar y
 *  consultar el contenido del carrito.
 *  --------------------------------------
 *  Implemento mejoras de eliminacion de listas, uso de streams, mejor cohesion y estructura interna
 *  *  del codigo
 *
 *   @author Carlos Cobos
 *   @version 1.1
 *   @since 03/12/2025
 */

public class ShoppingCart {

    /**
     * Lista que contiene todos los productos del carrito
     */
    private List<Producto> productos = new ArrayList<>();

    /**
     * Agrega un prodcuto al carrito
     *
     * @param nombre
     * @param precio
     * @param categoria
     */
    public void agregarProducto(String nombre, double precio, String categoria) {
        if (nombre != null && categoria != null) {
            productos.add(new Producto(nombre, precio, categoria));
        }
    }

    /**
     *Elimina todos los productos que coincidan por nombre.
     * Ignora mayusculas y minusculas
     *
     * @param nombre
     */
    public void eliminarProductoPorNombre(String nombre) {
        if (nombre == null) return;
        productos.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    /**
     * Calcula el precio total de los productos
     *
     * @return el precio total
     */
    public double calcularTotal() {
        return productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
    }

    /**
     * Calcula el total en una categoria
     *
     * @param categoria
     * @return el total de los productos de essa categoria
     */
    public double calcularTotalPorCategoria(String categoria) {
        if (categoria == null) return 0;

        return productos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .mapToDouble(Producto::getPrecio)
                .sum();
    }
    /**
     * Busca el producto mas caro del carrito
     *
     * @return el producto mas caro que haya
     */
    public Optional<Producto> buscarProductoMasCaro() {
        return productos.stream()
                .max(Comparator.comparingDouble(Producto::getPrecio));
    }

    /**
     * Imprime el ticket con todos los productos
     */
    public void mostrarTicket() {
        System.out.println("===== CARRITO DE LA COMPRA =====");

        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i));
        }

        System.out.println("--------------------------------");
        System.out.println("TOTAL: " + calcularTotal() + " €");
        System.out.println("================================");
    }

    /**
     * metodo de prueba para imprimir el funcionamiento de la clase
     *
     * @param args argumentos de ejecucion
     */

    public static void main(String[] args) {

        ShoppingCart carrito = new ShoppingCart();

        carrito.agregarProducto("Teclado", 25.99, "Informática");
        carrito.agregarProducto("Monitor", 199.99, "Informática");
        carrito.agregarProducto("Libro Java", 35.50, "Libros");
        carrito.agregarProducto("Ratón", 15.00, "Informática");

        carrito.mostrarTicket();

        System.out.println("Total en libros: " +
                carrito.calcularTotalPorCategoria("Libros") + " €");

        carrito.buscarProductoMasCaro().ifPresent(p ->
                System.out.println("Producto más caro: " + p));

        System.out.println("\nEliminando 'Ratón' del carrito...");
        carrito.eliminarProductoPorNombre("Ratón");

        carrito.mostrarTicket();
    }
}
