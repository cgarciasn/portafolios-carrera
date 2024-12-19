/*
 * Pruebas_TADCasilla.cpp
 *
 *  Created on: 20 ene. 2020
 *      Author: usuario
 */

#include "Pruebas_TADCasilla.h"

void pruebas_Casilla() {
	prueba_iniciar();
	prueba_ponerValor();
	prueba_obtenerValor();
	prueba_vaciar();
	prueba_vacio();
}
void prueba_iniciar() {
	Casilla c;
	iniciarCasilla(c);
	if(c.valor != 0){
		cout << "Error al iniciar la casilla" << endl;
	}
}
void prueba_ponerValor() {
	Casilla c;
	ponerValorCasilla(c,3);
	c.estado = false;
	if(c.valor != 3 || c.estado != false){
		cout << "Error al poner valor en la casilla" << endl;
	}
}
void prueba_obtenerValor() {
	Casilla c;
	ponerValorCasilla(c,3);
	if(obtenerValorCasilla(c) != 3){
		cout << "Error al obtener el valor de la casilla" << endl;
	}
}
void prueba_vaciar() {
	Casilla c;
	vaciarCasilla(c);
	if(c.estado != true){
		cout << "Error al vaciar la casilla" << endl;
	}
}
void prueba_vacio() {
	Casilla c;
	c.estado = true;
	if(casillaVacia(c) != true){
		cout << "Error al obtener el estado de la casilla" << endl;
	}
	c.estado =false;
	if(casillaVacia(c) != false){
		cout << "Error al obtener el estado de la casilla" << endl;
	}
}

