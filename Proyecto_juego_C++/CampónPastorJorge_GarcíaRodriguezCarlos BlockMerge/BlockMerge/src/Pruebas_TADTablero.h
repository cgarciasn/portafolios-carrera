/*
 * Pruebas_TADTablero.h
 *
 *  Created on: 20 ene. 2020
 *      Author: usuario
 */

#ifndef PRUEBAS_TADTABLERO_H_
#define PRUEBAS_TADTABLERO_H_

#include "TADTablero.h"
//Descripcion:{Llama a todas las pruebas del tablero}
void pruebas_Tablero();
//Descripcion:{Comprueba si coloca el valor correctamente en el tablero}
void prueba_ponerValorTab();
//Descripcion:{Comprueba si vacia la casilla del tablero correctamente}
void prueba_vaciarCasillaTab();
//Descripcion:{Comprueba si esta vacía una casilla correctamente}
void prueba_obtenerVacio();
//Descripcion:{Comprueba si obtiene el valor de una casilla correctamente}
void prueba_obtenerValorTab();
//Descripcion:{Comprueba si una casilla tiene bloques alrededor}
void prueba_casillaBloque();
//Descripcion:{Comprueba si hay algún bloque en el tablero}
void prueba_hayBloque();
//Descripcion:{Comprueba si obtiene el valor máximo del tablero}
//Complejidad: o(n²)
void prueba_valorMax();
//Descripcion:{Comprueba si se vacia el bloque}
void prueba_vaciarBloque();
//Descripcion:{Si despues de llamar al método desplazarAbajo,hay alguna casilla vacia,no funciona
// correctamente el método desplazarAbajo}
//Complejidad: O(n)
void prueba_desplazar();
//Descripcion:{Si despues de llamar al método desplazarTodasAbajo,hay alguna casilla vacia,no funciona
// correctamente el método desplazarTodasAbajo}
// Complejidad: O(n²)
void prueba_desplazarTodas();
//Descripcion:{Comprueba si rellena las casillas especificadas vacías correctamente}
//Complejidad: O(n)
void prueba_rellenar();
//Descripcion:{Comprueba si rellena todas las casillas vacias correctamente}
// Complejidad: 0(n²)
void prueba_rellenarTodas();



#endif /* PRUEBAS_TADTABLERO_H_ */
