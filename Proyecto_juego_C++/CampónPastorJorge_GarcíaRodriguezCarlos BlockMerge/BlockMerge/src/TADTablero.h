/*
 * TADTablero.h
 *
 *  Created on: 27 nov. 2019
 *      Author: usuario
 */

#ifndef TADTABLERO_H_
#define TADTABLERO_H_

#include "TADCasilla.h"

const int MAX = 8;
typedef Casilla _MatrizTablero[MAX][MAX];
struct Tablero{
	_MatrizTablero matrizTablero;
	int tamanio;
};

/*
 * PRE:{el tablero debe estar inicializado}
 * POST:{devuelve el tamaño del tablero}
 * COMPLEJIDAD:O(1)
 */
int obtenerTamanioTablero(Tablero T);
/*
 * POST:{inicializa el tablero}
 * COMPLEJIDAD:O(n^2)
 */
void iniciarTablero(Tablero &T);
/*
 * POST:{inicializada el tablero con los valores del fichero}
 * COMPLEJIDAD:O(n^2)
 */
void iniciarDesdeFichero(Tablero &T,int m[MAX][MAX],int tamanio);
/*
 * PRE:{num > 0}
 * POST:{inicializa el tablero de manera aleatoria}
 * COMPLEJIDAD:o(n^2)
 */
void iniciarAleatoriamente(Tablero &T,int tamanio,int num);
/*
 * PRE:{el tablero debe estar inicializado,fila >= 0,colum >=0,num > 0}
 * POST:{pone el valor en una casilla concreta del tablero}
 * COMPLEJIDAD:O(1)
 */
void ponerValorEnTablero(Tablero &T,int fila,int colum,int num);
/*
 * PRE:{el tablero debe estar inicializado,fila >= 0,colum >= 0}
 * POST:{vacia una casilla concreta del tablero}
 * COMPLEJIDAD:O(1)
 */
void vaciarCasillaTablero(Tablero &T,int fila,int colum);
/*
 * PRE:{el tablero debe estar inicializado,fila >= 0,colum >= 0}
 * POST:{devuelve el estado de una casilla concreta del tablero}
 * COMPLEJIDAD:O(1)
 */
bool obtenerVacio(Tablero T,int fila,int colum);
/*
 * PRE:{el tablero debe estar inicializado,fila >= 0,colum >= 0}
 * POST:{devuelve el valor de una casilla concreta del tablero}
 * COMPLEJIDAD:
 */
int obtenerValorTablero(Tablero T,int fila,int colum);
/*
 * PRE:
 * POST:
 * COMPLEJIDAD:
 */
bool CasillaEnBloque(Tablero T,int fila,int colum);
/*
 * PRE:{el tablero debe estar inicializado}
 * POST:{devuelve true si hay algun bloque en el tablero y false si no}
 * COMPLEJIDAD:O(n^2)
 */
bool siHayBloque(Tablero T);
/*
 * PRE:{el tablero debe estar inicializado}
 * POST:{devuelve el valor más alto del tablero}
 * COMPLEJIDAD:O(n^2)
 */
int obtenerValorMaximo(Tablero T);
/*
 * PRE:{el tablero debe estar inicializado,fila >= 0,colum >= 0,num >0}
 * POST:{vacia las casillas que se encuentren en bloque}
 * COMPLEJIDAD:O(1)
 */
void vaciarCasillasEnBloque(Tablero &T,int fila,int colum,int num);
/*
 * PRE:{el tablero debe estar inicializado,colum >= 0}
 * POST:{desplaza todas las casillas que tengan una casilla vacia debajo de
 * una determinada columna}
 * COMPLEJIDAD:O(n)
 */
void desplazarAbajo(Tablero &T,int colum);
/*
 * PRE:{el tablero debe estar inicializado}
 * POST:{desplaza todas las casillas que tengan una casilla vacia debajo en
 * todo el tablero}
 * COMPLEJIDAD:O(n)
 */
void desplazarTodasAbajo(Tablero &T);
/*
 * PRE:{el tablero debe estar inicializado,colum >=0}
 * POST:{rellena las casillas vacias de la parte superior de manera aleatoria de
 * una determinada columna}
 * COMPLEJIDAD:O(n)
 */
void rellenarColumna(Tablero &T,int colum);
/*
 * PRE:{el tableto debe estar inicializado}
 * POST:{rellena las casillas vacias de la parte superior de manera aleatoria
 * de todo el tablero}
 * COMPLEJIDAD:O(n)
 */
void rellenarTodasColumnas(Tablero &T);
/*
 * POST:{muestra por pantalla los valores de la matriz}
 * COMPLEJIDAD:O(n^2)
 */
//void mostrar(Tablero T);

#endif /* TADTABLERO_H_ */
