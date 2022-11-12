/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

import java.util.ArrayList;


       
/**
 *
 * @author Edwin Orlando Restrepo Mosquera y Andres Torres Ciceri
 */
public class ArbolBinario {
	/**
	 * Raiz del arbol binario
	 */
	public Nodo raiz;
	/**
	 * Constructor por defecto
	 */
	public ArbolBinario() {
		raiz = null;
	}

	/**
	 * Inserta un nodo en el arbol binario
	 * 
	 * @param valor a insertar
	 */
	public void inicializar() {
            //     A
            //  B      C
            //D   E  F   G
		Nodo nodoA = new Nodo("A");
		Nodo nodoB = new Nodo("B");
		Nodo nodoC = new Nodo("C");
		Nodo nodoD = new Nodo("D");
		Nodo nodoE = new Nodo("E");
		Nodo nodoF = new Nodo("F");
		Nodo nodoG = new Nodo("G");
		raiz = nodoA;
		raiz.setIzquierdo(nodoB);
		raiz.setDerecho(nodoC);

                nodoB.setIzquierdo(nodoD);
		nodoB.setDerecho(nodoE);

		nodoC.setIzquierdo(nodoF);
		nodoC.setDerecho(nodoG);

	}
	public void visitar(Nodo aux) {
		System.out.print(aux.getValor() + " ");
                
	}
        
        public void visitarPostOrden(Nodo aux,ArrayList lista) {
                lista.add(aux.getValor());
	}

	public Nodo getRaiz() {
		return raiz;
	}

}

