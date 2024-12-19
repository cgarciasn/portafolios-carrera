/*
 * TADCasilla.cpp
 *
 *  Created on: 27 nov. 2019
 *      Author: usuario
 */

#include "TADCasilla.h"

void iniciarCasilla(Casilla& c) {
	c.valor = 0;
}

void ponerValorCasilla(Casilla& c, int num) {
	c.valor = num;
	c.estado = false;
}

int obtenerValorCasilla(Casilla& c) {
	return c.valor;
}

void vaciarCasilla(Casilla& c) {
	if(c.estado == false){
		c.estado = true;
	}
}

bool casillaVacia(Casilla& c) {
	return c.estado;
}
