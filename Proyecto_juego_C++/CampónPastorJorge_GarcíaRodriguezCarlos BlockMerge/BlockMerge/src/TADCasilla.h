/*
 * TADCasilla.h
 *
 *  Created on: 27 nov. 2019
 *      Author: usuario
 */

#ifndef TADCASILLA_H_
#define TADCASILLA_H_

#include "entorno.h"

struct Casilla{
	int valor;
	bool estado; // si esta vacia true, si no esta vacia false

};

/*
 * PRE:
 * POST:{inicializa la casilla}
 * COMPLEJIDAD:0(1)
 */
void iniciarCasilla(Casilla &c);
/*
 * PRE{la casilla debe estar inicializada y num > 0}
 * POST:{pone el valor pasado por parámetros en una casilla}
 * COMPLEJIDAD:0(1)
 */
void ponerValorCasilla(Casilla &c,int num);
/*
 * PRE:{la casilla debe estar inicializada}
 * POST:{devuelve el valor de una casilla}
 * COMPLEJIDAD:O(1)
 */
int obtenerValorCasilla(Casilla &c);
/*
 * PRE:{la casilla debe estar inicializada}
 * POST:{cambia el estado de una casilla (vacia la casilla)}
 * COMPLEJIDAD:O(1)
 */
void vaciarCasilla(Casilla &c);
/*
 * PRE:{la casilla debe estar inicializada}
 * POST:{devuelve el estado de una casilla}
 * COMPLEJIDAD:O(1)
 */
bool casillaVacia(Casilla &c);


#endif /* TADCASILLA_H_ */
