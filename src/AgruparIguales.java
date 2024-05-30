import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Pila que implementa una pila genérica utilizando un ArrayList.
 *
 * @param <T> el tipo de elementos en la pila
 */
class Pila<T> {
    private ArrayList<T> elementos;

    /**
     * Constructor de la clase Pila.
     * Inicializa la pila como un ArrayList vacío.
     */
    public Pila() {
        elementos = new ArrayList<>();
    }

    /**
     * Empila un elemento en la pila.
     *
     * @param valor el elemento a empilar
     */
    public void empilar(T valor) {
        elementos.add(valor);
    }

    /**
     * Desempila un elemento de la pila.
     *
     * @return el elemento desempilado, o null si la pila está vacía
     */
    public T desempilar() {
        if (!elementos.isEmpty()) {
            return elementos.remove(elementos.size() - 1);
        }
        return null;
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false en caso contrario
     */
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    /**
     * Obtiene el número de elementos en la pila.
     *
     * @return el número de elementos en la pila
     */
    public int numElem() {
        return elementos.size();
    }
}

/**
 * Clase Cola que implementa una cola genérica utilizando un ArrayList.
 *
 * @param <T> el tipo de elementos en la cola
 */
class Cola<T> {
    private ArrayList<T> elementos;

    /**
     * Constructor de la clase Cola.
     * Inicializa la cola como un ArrayList vacío.
     */
    public Cola() {
        elementos = new ArrayList<>();
    }

    /**
     * Encola un elemento en la cola.
     *
     * @param valor el elemento a encolar
     */
    public void encolar(T valor) {
        elementos.add(valor);
    }

    /**
     * Desencola un elemento de la cola.
     *
     * @return el elemento desencolado, o null si la cola está vacía
     */
    public T desencolar() {
        if (!elementos.isEmpty()) {
            return elementos.remove(0);
        }
        return null;
    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return true si la cola está vacía, false en caso contrario
     */
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    /**
     * Obtiene el número de elementos en la cola.
     *
     * @return el número de elementos en la cola
     */
    public int numElem() {
        return elementos.size();
    }

    /**
     * Imprime los elementos de la cola en formato de lista.
     */
    public void imprimir() {
        System.out.print("[ ");
        for (T elemento : elementos) {
            System.out.print(elemento + " ");
        }
        System.out.println("]");
    }
}

/**
 * Clase principal que agrupa los elementos iguales en una cola utilizando una pila auxiliar.
 */
public class AgruparIguales {
    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>();
        Pila<Integer> pila = new Pila<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una lista de enteros separados por espacios:");
        String[] elementos = scanner.nextLine().split(" ");

        // Llenar la cola con los elementos ingresados
        for (String elemento : elementos) {
            cola.encolar(Integer.parseInt(elemento));
        }

        // Imprimir la cola original
        System.out.println("Cola original:");
        cola.imprimir();

        // Agrupar elementos iguales
        int numElementosOriginales = cola.numElem();
        while (numElementosOriginales > 0) {
            int actual = cola.desencolar();
            cola.encolar(actual); // Reencolar el primer elemento

            // Mover los elementos diferentes a la pila y reencolar los iguales al final
            for (int i = 1; i < numElementosOriginales; i++) {
                int siguiente = cola.desencolar();
                if (siguiente != actual) {
                    pila.empilar(siguiente);
                } else {
                    cola.encolar(siguiente);
                }
            }

            // Reencolar el primer elemento al final
            cola.encolar(cola.desencolar());

            // Reencolar los elementos diferentes desde la pila a la cola original
            while (!pila.estaVacia()) {
                cola.encolar(pila.desempilar());
            }

            numElementosOriginales--;
        }

        // Imprimir la cola agrupada
        System.out.println("Cola agrupada:");
        cola.imprimir();
    }
}
