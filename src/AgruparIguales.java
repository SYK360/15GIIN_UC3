import java.util.ArrayList;
import java.util.Scanner;

class Pila<T> {
    private ArrayList<T> elementos;

    public Pila() {
        elementos = new ArrayList<>();
    }

    public void empilar(T valor) {
        elementos.add(valor);
    }

    public T desempilar() {
        if (!elementos.isEmpty()) {
            return elementos.remove(elementos.size() - 1);
        }
        return null;
    }

    public T tope() {
        if (!elementos.isEmpty()) {
            return elementos.get(elementos.size() - 1);
        }
        return null;
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    public int numElem() {
        return elementos.size();
    }
}

class Cola<T> {
    private ArrayList<T> elementos;

    public Cola() {
        elementos = new ArrayList<>();
    }

    public void encolar(T valor) {
        elementos.add(valor);
    }

    public T desencolar() {
        if (!elementos.isEmpty()) {
            return elementos.remove(0);
        }
        return null;
    }

    public T frente() {
        if (!elementos.isEmpty()) {
            return elementos.get(0);
        }
        return null;
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    public int numElem() {
        return elementos.size();
    }

    public void imprimir() {
        System.out.print("[ ");
        for (T elemento : elementos) {
            System.out.print(elemento + " ");
        }
        System.out.println("]");
    }
}

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
        Cola<Integer> agrupados = new Cola<>();

        while (!cola.estaVacia()) {
            int actual = cola.desencolar();
            agrupados.encolar(actual);
            while (!cola.estaVacia()) {
                int siguiente = cola.desencolar();
                if (siguiente != actual) {
                    pila.empilar(siguiente);
                } else {
                    agrupados.encolar(siguiente);
                }
            }
            while (!pila.estaVacia()) {
                cola.encolar(pila.desempilar());
            }
        }

        // Imprimir la cola agrupada
        System.out.println("Cola agrupada:");
        agrupados.imprimir();
    }
}