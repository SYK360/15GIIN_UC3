class ListaEnlazada<AnyType>{

    private Nodo <AnyType> primero; //Puntero que apunta al inicio de la lista
    private Nodo <AnyType> ultimo; //Puntero que apunta al final de la lista
    private int tam=0;

    //Constructor Lista Enlazada

    public ListaEnlazada() {
        this.primero=null;
        this.ultimo=null;
        this.tam=0;
    }


    // Metodo saber si lista estÃ¡ vacÃ­a

    public boolean isEmpty() {

        if (primero==null)
            return true;
        return false;
    }

    // Metodo para saber tamaÃ±o de la lista

    public int getTamano() {

        return tam;
    }

    //metodo para aÃ±adir un elemento a la cabeza de la lista

    public void insertarInicio(AnyType valor) {
        // Creo el nuevo nodo a aÃ±adir

        Nodo<AnyType> nuevo= new Nodo<AnyType>(valor);

        //comprobar si la lista estÃ¡ vacÃ­a

        if (isEmpty()) {

            //primero y Ãºltimo apuntan al nuevo nodo
            primero=ultimo= nuevo;
        }
        else { // ya hay elementos en la lista. Cambia el puntero primero, pero no el puntero Ãºltimo


            //El nuevo nodo tiene que apuntar a lo que apunta primero
            nuevo.setSiguiente(primero);
            //primero ahora apunta a nuevo, que es el primer nodo de la lista
            primero=nuevo;
        }
        tam++;
    }

    public void invertir(){


    }

    public void imprimir() {

        if (isEmpty()) {

            System.out.println("La lista esta vacia");
        }else {
            Nodo<AnyType> aux=primero;
            System.out.print( "[ ");
            while(aux!=null) {
                System.out.print(aux.getValor() + " ");
                aux= aux.siguiente;
            }
            System.out.print( "]");
        }
    }

    //Clase interna Nodo
    private class Nodo <T>{

        private T valor;
        private Nodo<T> siguiente;


        // Constructor
        public Nodo (T valor) {

            this.valor=valor;
            this.siguiente=null;
        }

        public void setSiguiente(Nodo<T> sig) {

            this.siguiente=sig;
        }

        public void setValor( T valor) {

            this.valor=valor;
        }

        public T getValor() {
            return this.valor;
        }

        public Nodo<T> getSiguiente(){

            return this.siguiente;
        }
    }
}