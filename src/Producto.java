/**
 * Esta clase que representa un producto del carrito de compra
 *
 * @author Carlos Cobos
 * @version 1.1
 * @since 03/12/2025
 */


public class Producto {

    /**
     * Nombre del producto
     */
    private String nombre;

    /**
     * Precio del producto
     */
    private double precio;
    /**
     * Categoría del producto
     */
    private String categoria;

    /**
     * El constructor de de la clase Produtco
     * @param nombre
     * @param precio
     * @param categoria
     */

    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    /**
     * Gets el nombre del producto
     * @return el nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Gets el precio del producto
     * @return el precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Gets la categoria del prodcuto
     * @return la categoria del producto
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Imprime la representacion del producto en texto
     * @return el nombre, precio y categoria
     */

    @Override
    public String toString() {
        return nombre + " - " + precio + " € (" + categoria + ")";
    }
}