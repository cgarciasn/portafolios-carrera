/*
 * TADJuego.h
 *
 *  Created on: 27 nov. 2019
 *      Author: usuario
 */

#ifndef TADJUEGO_H_
#define TADJUEGO_H_

#include "TADTablero.h"

struct Juego{
	Tablero tab;
	int objetivo;
};

/*
 * POST:{inicia la estructura}
 * COMPLEJIDAD:0(1)
 */
void iniciarEstructura(Juego &J);
/*
 * POST:{gestiona las teclas,actualiza el tablero,actualiza la pantalla}
 * COMPLEJIDAD:O(n)
 */
void movimiento(Juego &J);
/*
 * POST:{termina el juego y el entorno y muestra mensaje de despedida}
 * COMPLEJIDAD:O(1)
 */
void finDelJuego(Juego &J);


#endif /* TADJUEGO_H_ */
