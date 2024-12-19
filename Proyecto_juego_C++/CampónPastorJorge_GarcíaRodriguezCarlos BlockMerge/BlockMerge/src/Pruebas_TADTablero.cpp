/*
 * Pruebas_TADTablero.cpp
 *
 *  Created on: 20 ene. 2020
 *      Author: usuario
 */

#include "Pruebas_TADTablero.h"

void pruebas_Tablero() {
	prueba_ponerValorTab();
	prueba_vaciarCasillaTab();
	prueba_obtenerVacio();
	prueba_obtenerValorTab();
	prueba_valorMax();
	prueba_desplazar();
	prueba_desplazarTodas();
	prueba_rellenar();
	prueba_rellenarTodas();
}

void prueba_ponerValorTab() {
	Tablero T;
	int i = 1;
	int j = 2;
	ponerValorEnTablero(T, i, j, 4);
	if (T.matrizTablero[i][j].valor != 4) {
		cout << "Error al poner valor en el tablero" << endl;
	}

}

void prueba_vaciarCasillaTab() {
	Tablero T;
	int i = 1;
	int j = 2;
	vaciarCasillaTablero(T,i,j);
	if(T.matrizTablero[i][j].estado != true){
		cout << "Error al vaciar una casilla del tablero" << endl;
	}
}

void prueba_obtenerVacio() {
	Tablero T;
	int i = 1;
	int j = 2;
	vaciarCasillaTablero(T,i,j);
	if(obtenerVacio(T,i,j) != true){
		cout << "Error al obtener el estado de una casilla del tablero" << endl;
	}
}

void prueba_obtenerValorTab() {
	Tablero T;
	int i = 1;
	int j = 2;
	ponerValorEnTablero(T,i,j,4);
	if(obtenerValorTablero(T,i,j) != 4){
		cout << "Error al obtener el valor de una casilla del tablero" << endl;
	}
}

void prueba_casillaBloque() {
}

void prueba_hayBloque() {
}


void prueba_valorMax() {
	Tablero T;
	T.tamanio = 8;
	int max = 7;
	bool b = false;
	for(int i = 0;i < T.tamanio && b == false;i++){
		for(int j = 0;j < T.tamanio && b == false;j++){
			if(obtenerValorTablero(T,i,j) == max){
				b = true;
			}
		}
	}
	if(!b){
		cout << "Error en obtener el maximo valor del tablero" << endl;
	}
}

void prueba_vaciarBloque() {
}
void prueba_desplazar() {
	    Tablero T;
		T.tamanio = 8;
		int col = 2;
		bool b = true;
		for(int i = 0;i < T.tamanio && b == true;i++){
				if(obtenerVacio(T,i,col) != false){
					b = false;
			}
		}
		if(b == false){
			cout << "Error al desplazar la columna del tablero" << endl;
		}
	}

void prueba_desplazarTodas() {
	Tablero T;
	T.tamanio = 8;
	bool b = true;
	for(int i = 0;i < T.tamanio && b == true;i++){
		for(int j = 0;j < T.tamanio && b == true;j++){
			if(obtenerVacio(T,i,j) != false){
				b = false;
			}
		}
	}
	if(b == false){
		cout << "Error al desplazar todas las columnas del tablero" << endl;
	}
}

void prueba_rellenar() {
	Tablero T;
	T.tamanio = 8;
	int col = 2;
	bool b = true;
	for(int i = 0;i < T.tamanio && b == true;i++){
			if(obtenerVacio(T,i,col) != false){
				b = false;
		}
	}
	if(b == false){
		cout << "Error al rellenar la columna del tablero" << endl;
	}
}

void prueba_rellenarTodas() {
	Tablero T;
	T.tamanio = 8;
	bool b = true;
	for(int i = 0;i < T.tamanio && b == true;i++){
		for(int j = 0;j < T.tamanio && b == true;j++){
			if(obtenerVacio(T,i,j) != false){
				b = false;
			}
		}
	}
	if(b == false){
		cout << "Error al rellenar todas las columnas del tablero" << endl;
	}
}
