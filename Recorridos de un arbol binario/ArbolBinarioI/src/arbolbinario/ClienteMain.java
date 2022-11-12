package arbolbinario;

import java.util.ArrayDeque; //Utilizado para recorrer la cola
import java.util.Queue; //Utilizado como cola
import java.util.Scanner; //Utilizado para leer los valores digitados por el usuario
import java.util.Stack; //Utilizado como pila

/**
 *
 * @author Edwin Orlando Restrepo Mosquera y Andres Torres Ciceri
 */
public class ClienteMain {

    public static void main(String[] args) throws InterruptedException {
        ArbolBinario ab = new ArbolBinario(); //Se instancia una variable de la clase Arbol Binario
        ab.inicializar(); //Crea el árbol para poder trabajarlo
        boolean salir = false; //Booleano para poder terminar el proceso do-while
        do {
            switch (menu()) { //Método para mostrar las opciones a elegir y devolver la opción elegida.
                case 1:
                    System.out.println("\nPreorden Iterativo:");
                    preordenIterativo(ab); //Método para mostrar el recorrido en PreOrden del árbol de forma iterativa.
                    pressEnter(); //Método para pausar el sistema y generar mayor facilidad de lectura.
                    break;
                case 2:
                    System.out.println("\nInorden Iterativo:");
                    inordenIterativo(ab);//Método para mostrar el recorrido en InOrden del árbol de forma iterativa.
                    pressEnter();
                    break;
                case 3:
                    System.out.println("\nPostorden Iterativo:");
                    postOrdenIterativo(ab);//Método para mostrar el recorrido en PosOrden del árbol de forma iterativa.
                    pressEnter();
                    break;
                case 4:
                    System.out.println("\nAnchura / Amplitud:");
                    recorridoAnchura(ab);//Método para mostrar el recorrido en Anchura del árbol de forma iterativa. 
                    pressEnter();
                    break;
                case 5:
                    System.out.println("\nPreOrden Recursivo:");
                    preordenRecursivo(ab);//Método para mostrar el recorrido en PreOrden del árbol de forma recursiva.
                    pressEnter();
                    break;
                case 6:
                    System.out.println("\nInOrden Recursivo:");
                    inordenRecursivo(ab);//Método para mostrar el recorrido en InOrden del árbol de forma recursiva.
                    pressEnter();
                    break;
                case 7:
                    System.out.println("\nPosOrden Recursivo:");
                    posordenRecursivo(ab);//Método para mostrar el recorrido en PosOrden del árbol de forma recursiva.
                    pressEnter();
                    break;
                case 8:
                    salir = true; //Sale del while
                    break;

            }
        } while (salir != true);
    }

    public static void preordenIterativo(ArbolBinario arbin) { //Recorrido PreOrden Iterativo
        Stack<Nodo> pila = new Stack<>(); //Se crea una pila de tipo Nodo para guardar el Árbol creado
        pila.push(arbin.raiz); // inserta a la pila la raiz del árbol
        while (!pila.empty()) { //Condición para saber si la pila no está vacía
            Nodo aux = pila.pop(); // recupera y elimina el ultimo nodo ingresado
            arbin.visitar(aux); //Muestra el valor contenido en el nodo
            if (aux.getDerecho() != null) {
                pila.push(aux.getDerecho()); // ingresa el derecho de la raiz
            }
            if (aux.getIzquierdo() != null) {
                pila.push(aux.getIzquierdo()); // ingresa el izquierdo de la raiz
            }
        }
    }

    public static void inordenIterativo(ArbolBinario arbin) { //Recorrido InOrden Iterativo
        Stack<Nodo> pila = new Stack<>(); //Crea la pila de tipo Nodo vacía
        Nodo aux = arbin.raiz; //Se guarda en el nodo la raíz
        while (!pila.empty() || aux != null) { //Condición hasta llegar a nulo
            if (aux != null) { 
                pila.push(aux);//ingresa a la pila el izquierdo de la raíz
                aux = aux.getIzquierdo(); //Se iguala el nodo al izquierdo de la raíz hasta llegar a nulo
            } else {
                aux = pila.pop();//Recupera el último nodo ingresado y lo elimina de la pila
                arbin.visitar(aux); //Muestra el último nodo ingresado
                aux = aux.getDerecho(); //Se iguala el nodo al derecho del nodo antes recuperado.
            }
        }
    }

    public static void postOrdenIterativo(ArbolBinario arbin) { //Recorrido PosOrden Iterativo
        Stack<Nodo> pila = new Stack<>(); //Crea la pila vacía
        Stack<Nodo> mostrar = new Stack<>(); //Crea otra pila para guardar los nodos y luego mostrarlos
        Nodo aux; //Crea el nodo
        pila.push(arbin.raiz); //Inserta a la pila la raiz del árbol
        while (!pila.empty()) {
            aux = pila.pop(); //Recupera el último nodo ingresado a la pila y lo elimina
            mostrar.push(aux); //Se guarda el nodo recuperado
            if (aux.getIzquierdo() != null) {
                pila.push(aux.getIzquierdo()); //Ingresa a la pila el izquierdo de la raíz
            }
            if (aux.getDerecho() != null) {
                pila.push(aux.getDerecho()); //Ingresa a la pila el derecho de la raíz.
            }
        }
        while (!mostrar.empty()) { //Muestra la pila con los nodos guardados
            aux = mostrar.pop(); //Recupera el último nodo y lo elimina de la pila.
            arbin.visitar(aux); //Muestra el valor que tiene el nodo.
        }
    }

    public static void recorridoAnchura(ArbolBinario arbin) { //Recorrido Anchura/Amplitud Iterativa
        Stack<Nodo> pila = new Stack<>(); //Se crea la pila vacía
        Queue<Nodo> cola = new ArrayDeque<>(); //Se crea la cola para guardar nodos
        pila.push(arbin.raiz); // inserta a la pila la raiz
        Nodo aux = pila.pop(); //Recupera el último nodo ingresado a la pila y lo elimina
        cola.add(aux); //Inserta a la cola el nodo raíz.
        while (!cola.isEmpty()) {
            aux = cola.poll(); // Recupera el nodo ubicado en la primera posición de la cola y lo elimina.
            arbin.visitar(aux); // Muestra el nodo en primera posición.
            if (aux.getIzquierdo() != null) {
                cola.add(aux.getIzquierdo()); //Inserta a la cola el izquierdo del nodo raíz.
            }
            if (aux.getDerecho() != null) {
                cola.add(aux.getDerecho()); //Inserta a la cola el derecho del nodo raiz.
            }
        }
    }

    public static void preordenRecursivo(ArbolBinario arbin) { //Recorrido PreOrden recursivo
        Nodo aux = arbin.raiz; //Se guarda en el nodo la raíz del árbol.
        preordenRecursivo(aux); //Método para PreOrden Recursivo sobrecargado (diferente parámetro)
    }

    public static void preordenRecursivo(Nodo aux) { //PreOrden Recursivo
        ArbolBinario arbin = new ArbolBinario(); //Crea la variable de la clase ArbolBinario para utilizar su impresión.
        arbin.visitar(aux); //Muestra el valor que tiene el nodo actual
        if (aux.getIzquierdo() != null) {
            preordenRecursivo(aux.getIzquierdo()); //Se llama de nuevo con el izquierdo del nodo raíz.
        }
        if (aux.getDerecho() != null) {
            preordenRecursivo(aux.getDerecho()); //Se llama de nuevo con el derecho del nodo raíz.
        }
    }

    public static void inordenRecursivo(ArbolBinario arbin) { //Recorrido InOrden recursivo
        Nodo aux = arbin.raiz; 
        inordenRecursivo(aux);//Método para InOrden Recursivo sobrecargado (diferente parámetro)
    }

    public static void inordenRecursivo(Nodo aux) {
        ArbolBinario arbin = new ArbolBinario();
        if (aux.getIzquierdo() != null) {
            preordenRecursivo(aux.getIzquierdo());//Se llama de nuevo con el izquierdo del nodo raíz.
        }
        arbin.visitar(aux);//Muestra el valor que tiene el nodo actual
        if (aux.getDerecho() != null) {
            preordenRecursivo(aux.getDerecho());//Se llama de nuevo con el derecho del nodo raíz.
        }
    }

    public static void posordenRecursivo(ArbolBinario arbin) { //Recorrido PosOrden recursivo
        Nodo aux = arbin.raiz;
        posordenRecursivo(aux);//Método para PosOrden Recursivo sobrecargado (diferente parámetro)
    }

    public static void posordenRecursivo(Nodo aux) {
        ArbolBinario arbin = new ArbolBinario();
        if (aux.getIzquierdo() != null) {
            preordenRecursivo(aux.getIzquierdo());//Se llama de nuevo con el izquierdo del nodo raíz.
        }
        if (aux.getDerecho() != null) {
            preordenRecursivo(aux.getDerecho());//Se llama de nuevo con el derecho del nodo raíz.
        }
        arbin.visitar(aux);//Muestra el valor que tiene el nodo actual
    }

    public static void pressEnter() { //Metodo para pausar la consola.
        String key;
        Scanner leer = new Scanner(System.in); //Instancia para leer
        System.out.println("\n\nPress Enter key to continue...");
        key = leer.nextLine(); //Pausa el sistema hasta presionar el Enter
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static int menu() { //Método para mostrar las opciones.
        Scanner leer = new Scanner(System.in);
        int option;
        System.out.println( //Opciones
                "\n\n\n\nRecorridos del arbol:\n"
                +"1. PreOrden iterativo\n"
                + "2. InOrden iterativo\n"
                + "3. PosOrden iterativo\n"
                + "4. Anchura / Amplitud\n"
                + "5. PreOrden recursivo\n"
                + "6. InOrden recursivo\n"
                + "7. PosOrden recursivo\n"
                + "8. Salir\n"
                + "\nSeleccione una opcion:");
        return option = leer.nextInt(); //Lee la opción y la devuelve.
    }

}
