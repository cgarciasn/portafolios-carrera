/*
 * TADTablero.cpp
 *
 *  Created on: 27 nov. 2019
 *      Author: usuario
 */

#include "TADTablero.h"
#include "TADCasilla.h"

int obtenerTamanioTablero(Tablero T) {
	return T.tamanio;
}

void iniciarTablero(Tablero& T) {
	for (int i = 0; i < T.tamanio; i++) {
		for (int j = 0; j < T.tamanio; j++) {
			iniciarCasilla(T.matrizTablero[i][j]);
		}
	}
}

void iniciarDesdeFichero(Tablero& T,int m[MAX][MAX],int tamanio) {
	T.tamanio = tamanio;
	for(int i = 0; i < T.tamanio;i++){
		for(int j = 0; j < T.tamanio;j++){
			ponerValorCasilla(T.matrizTablero[i][j],m[i][j]);
			if(m[i][j] == 0){
				vaciarCasilla(T.matrizTablero[i][j]);

			}

		}
	}
}

void iniciarAleatoriamente(Tablero& T,int tamanio,int num) {
	int aleatorio;
	T.tamanio = tamanio;
	for(int i = 0; i < T.tamanio; i++){
		for(int j = 0; j < T.tamanio; j++){
			aleatorio = 1 + rand () % (num-1);
			ponerValorCasilla(T.matrizTablero[i][j],aleatorio);
		}
	}
	int i = rand() % T.tamanio;
	int j = rand() % T.tamanio;
	ponerValorCasilla(T.matrizTablero[i][j],num);
}

void ponerValorEnTablero(Tablero& T, int fila, int colum, int num) {

	ponerValorCasilla(T.matrizTablero[fila][colum],num);

}

void vaciarCasillaTablero(Tablero& T, int fila, int colum) {

	vaciarCasilla(T.matrizTablero[fila][colum]);
}

bool obtenerVacio(Tablero T, int fila, int colum) {

	return casillaVacia(T.matrizTablero[fila][colum]);
}

int obtenerValorTablero(Tablero T, int fila, int colum) {

	return obtenerValorCasilla(T.matrizTablero[fila][colum]);
}

bool CasillaEnBloque(Tablero T, int fila, int colum) {
	bool enc = false;
	int num = obtenerValorTablero(T, fila, colum);
	if ((fila - 1) >= 0 && (fila + 1) < T.tamanio && (colum - 1) >= 0
			&& (colum + 1) < T.tamanio) {
		if (obtenerValorCasilla(T.matrizTablero[fila - 1][colum]) == num
				|| obtenerValorCasilla(T.matrizTablero[fila][colum - 1]) == num
				|| obtenerValorCasilla(T.matrizTablero[fila + 1][colum]) == num
				|| obtenerValorCasilla(T.matrizTablero[fila][colum + 1])
						== num) {
			enc = true;
		}
	}
	if((fila - 1) < 0){ // Primer if
		if((fila - 1) < 0 && (colum + 1) >= T.tamanio){
			if(obtenerValorCasilla(T.matrizTablero[fila + 1][colum]) == num ||
					obtenerValorCasilla(T.matrizTablero[fila][colum - 1]) == num){
				enc = true;
			}
		}
		else
			if (obtenerValorCasilla(T.matrizTablero[fila + 1][colum]) == num
						|| obtenerValorCasilla(T.matrizTablero[fila][colum - 1]) == num
						|| obtenerValorCasilla(T.matrizTablero[fila][colum + 1])
								== num) {
					enc = true;
		}
		}
		if((colum + 1) >= T.tamanio){ // Segundo if
		if((fila + 1) >= T.tamanio && (colum + 1) >= T.tamanio){
			if(obtenerValorCasilla(T.matrizTablero[fila - 1][colum]) == num ||
					obtenerValorCasilla(T.matrizTablero[fila][colum - 1]) == num){
						enc = true;
					}
		}
		else
			if (obtenerValorCasilla(T.matrizTablero[fila - 1][colum]) == num
						|| obtenerValorCasilla(T.matrizTablero[fila + 1][colum]) == num
						|| obtenerValorCasilla(T.matrizTablero[fila][colum - 1])
								== num) {
					enc = true;
			}
		}
		if((fila + 1) >= T.tamanio){ // Tercer if
		if((fila + 1) >= T.tamanio && (colum - 1) < 0){
			if(obtenerValorCasilla(T.matrizTablero[fila - 1][colum]) == num ||
					obtenerValorCasilla(T.matrizTablero[fila][colum + 1]) == num){
				enc = true;
			}
		}
		else
			if (obtenerValorCasilla(T.matrizTablero[fila - 1][colum]) == num
						|| obtenerValorCasilla(T.matrizTablero[fila][colum - 1]) == num
						|| obtenerValorCasilla(T.matrizTablero[fila][colum + 1])
								== num) {
					enc = true;
			}
		}
		if((colum - 1) < 0){ // Cuarto if
		if((fila - 1) < 0 && (colum - 1) < 0){
			if(obtenerValorCasilla(T.matrizTablero[fila + 1][colum]) == num ||
					obtenerValorCasilla(T.matrizTablero[fila][colum + 1]) == num){
				enc = true;
			}
		}
		else
			if (obtenerValorCasilla(T.matrizTablero[fila - 1][colum]) == num
						|| obtenerValorCasilla(T.matrizTablero[fila + 1][colum]) == num
						|| obtenerValorCasilla(T.matrizTablero[fila][colum + 1])
								== num) {
					enc = true;
			}
		}

	return enc;
}
bool siHayBloque(Tablero T) {
	bool enc = false;
	for (int i = 0; i < T.tamanio; i++) {
		for (int j = 0; j < T.tamanio; j++) {
			if (CasillaEnBloque(T, i, j) == true) {
				enc = true;

			}
		}

	}
	return enc;
}

int obtenerValorMaximo(Tablero T) {
	int pmayor = obtenerValorCasilla(T.matrizTablero[0][0]);
	for(int i = 0; i < T.tamanio;i++){
		for(int j = 0; j < T.tamanio;j++){
			if(obtenerValorCasilla(T.matrizTablero[i][j]) > pmayor){
				pmayor = obtenerValorCasilla(T.matrizTablero[i][j]);
			}
		}
	}
	return pmayor;
}
void vaciarCasillasEnBloque(Tablero& T,int fila,int colum,int num) {
	if(fila < T.tamanio && fila >= 0 && colum < T.tamanio && colum >= 0){
		if(casillaVacia(T.matrizTablero[fila][colum]) == false){
			if(obtenerValorCasilla(T.matrizTablero[fila][colum]) == num){
				vaciarCasilla(T.matrizTablero[fila][colum]);
				vaciarCasillasEnBloque(T,fila+1,colum,num);
				vaciarCasillasEnBloque(T,fila-1,colum,num);
				vaciarCasillasEnBloque(T,fila,colum+1,num);
				vaciarCasillasEnBloque(T,fila,colum-1,num);
			}
		}
	}
}

void desplazarAbajo(Tablero& T, int colum) {
	int num;
	for (int i = T.tamanio - 1; i > 0 ; i--) {
		if(casillaVacia(T.matrizTablero[i][colum]) == true){
			num = obtenerValorCasilla(T.matrizTablero[i-1][colum]);
			ponerValorCasilla(T.matrizTablero[i][colum],num);
			vaciarCasilla(T.matrizTablero[i-1][colum]);
		}
	}
}

void desplazarTodasAbajo(Tablero& T) {
	for (int j = 0; j < T.tamanio; j++) {
		desplazarAbajo(T, j);
	}
}

void rellenarColumna(Tablero& T, int colum) {
	int aleatorio;
	int mayor;
	for (int i = 0; i < T.tamanio; i++) {
			mayor = obtenerValorMaximo(T);
			aleatorio = 1 + rand() % mayor;
			if(casillaVacia(T.matrizTablero[i][colum]) == true){
			ponerValorCasilla(T.matrizTablero[i][colum],aleatorio);
			}
		}
	}

void rellenarTodasColumnas(Tablero& T) {
	for(int j = 0; j < T.tamanio; j++){
		rellenarColumna(T,j);
	}
}

/*void mostrar(Tablero T){
	for(int i= 0;i < T.tamanio; i++){
		for(int j = 0;j < T.tamanio;j++){
			if(casillaVacia(T.matrizTablero[i][j]) == false){
			cout << "[" << obtenerValorCasilla(T.matrizTablero[i][j]) << "]" ;
			}
			else
				cout << "[" << "0" << "]" ;
		}
		cout << endl;
	}
}*/
