import java.util.Scanner;
import java.util.Stack;

class ListaEnlazada<AnyType> {
    private Nodo<AnyType> primero; // Puntero que apunta al inicio de la lista
    private Nodo<AnyType> ultimo; // Puntero que apunta al final de la lista
    private int tam = 0;

    // Constructor Lista Enlazada
    public ListaEnlazada() {
        this.primero = null;
        this.ultimo = null;
        this.tam = 0;
    }

    // Método para saber si la lista está vacía
    public boolean isEmpty() {
        return primero == null;
    }

    // Método para saber tamaño de la lista
    public int getTamano() {
        return tam;
    }

    // Método para insertar un elemento al inicio de la lista
    public void insertarInicio(AnyType valor) {
        // Crear el nuevo nodo a añadir
        Nodo<AnyType> nuevo = new Nodo<AnyType>(valor);
        // Comprobar si la lista está vacía
        if (isEmpty()) {
            // primero y último apuntan al nuevo nodo
            primero = ultimo = nuevo;
        } else { // ya hay elementos en la lista. Cambia el puntero primero, pero no el puntero último
            // El nuevo nodo tiene que apuntar a lo que apunta primero
            nuevo.setSiguiente(primero);
            // primero ahora apunta a nuevo, que es el primer nodo de la lista
            primero = nuevo;
        }
        tam++;
    }

    // Método para invertir la lista
    public void invertir() {
        Nodo<AnyType> prev = null;
        Nodo<AnyType> current = primero;
        Nodo<AnyType> next = null;
        ultimo = primero; // El antiguo primero será el último

        while (current != null) {
            next = current.getSiguiente(); // Guardar el siguiente nodo
            current.setSiguiente(prev); // Invertir el enlace
            prev = current; // Mover prev y current un paso adelante
            current = next;
        }
        primero = prev; // El último nodo procesado será el nuevo primero
    }

    // Método para imprimir la lista
    public void imprimir() {
        if (isEmpty()) {
            System.out.println("La lista está vacía");
        } else {
            Nodo<AnyType> aux = primero;
            System.out.print("[ ");
            while (aux != null) {
                System.out.print(aux.getValor() + " ");
                aux = aux.getSiguiente();
            }
            System.out.print("]");
        }
    }

    // Clase interna Nodo
    private class Nodo<T> {
        private T valor;
        private Nodo<T> siguiente;

        // Constructor
        public Nodo(T valor) {
            this.valor = valor;
            this.siguiente = null;
        }

        public void setSiguiente(Nodo<T> sig) {
            this.siguiente = sig;
        }

        public void setValor(T valor) {
            this.valor = valor;
        }

        public T getValor() {
            return this.valor;
        }

        public Nodo<T> getSiguiente() {
            return this.siguiente;
        }
    }
}

public class PruebaListaInvertida {
    public static void main(String[] args) {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        // Leer una lista de enteros por pantalla
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una lista de enteros separados por espacios:");
        String[] elementos = scanner.nextLine().split(" ");

        // Usar una pila para invertir los elementos antes de insertarlos
        Stack<Integer> pila = new Stack<>();
        for (String elemento : elementos) {
            pila.push(Integer.parseInt(elemento));
        }

        // Insertar elementos en la lista utilizando insertarInicio
        while (!pila.isEmpty()) {
            lista.insertarInicio(pila.pop());
        }

        // Imprimir la lista original
        System.out.println("Lista original:");
        lista.imprimir();
        System.out.println();

        // Invertir la lista
        lista.invertir();

        // Imprimir la lista invertida
        System.out.println("Lista invertida:");
        lista.imprimir();
    }
}
