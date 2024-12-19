//============================================================================
// Name        : BlockMerge.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

/*#include "entorno.h"*/

/*using namespace std;
void ejecutar() {
	//variables para almacenar la información del fichero de configuración
	int tam, objetivo, deDonde;
	int m[MAX_TAMANO][MAX_TAMANO];

	//se carga la información almacenada en el fich. de configuración
	if (entornoCargarConfiguracion(tam, objetivo, deDonde, m)) {
		entornoIniciar(tam); //se inicia el entorno gráfico

		//se visualizan en el entorno gráfico los valores extraídos del
		//fichero de conf. y almacenados en la matriz m
		int fila, col;
		for ( fila = 0; fila < tam; fila++) {
			for ( col = 0; col < tam; col++) {
				entornoPonerNumero(fila, col, m[fila][col]);
			}
		}

		bool salir = false; //bandera utilizada para finalizar el bucle
		TipoTecla tecla;    //almacena la tecla pulsada por el usuario

		fila = 0;
		col  = 0;
		entornoMarcarPosicion(fila,col);
		entornoMostrarMensaje("Pulsa ESC para salir",1.5);

		//el bucle permite al jugador desplazarse por el tablero de juego
		while (!salir) {
			tecla = entornoLeerTecla();
			switch (tecla) {
			case TEnter:
				break;
			case TDerecha:
				entornoDesmarcarPosicion(fila, col);
				if (col < tam - 1)
						col++;
				else
						col = 0;
				entornoMarcarPosicion(fila, col);
				break;
			case TIzquierda:
				entornoDesmarcarPosicion(fila, col);
				if (col > 0)
					col--;
				else
					col = tam - 1;
				entornoMarcarPosicion(fila, col);
				break;
			case TArriba:
				entornoDesmarcarPosicion(fila, col);
				if (fila > 0)
					fila--;
				else
					fila = tam - 1;
				entornoMarcarPosicion(fila, col);
				break;
			case TAbajo:
				entornoDesmarcarPosicion(fila, col);
				if (fila < tam - 1)
					fila++;
				else
					fila = 0;
				entornoMarcarPosicion(fila, col);
				break;

			case TSalir:
				salir = true;
				break;

			case TNada:
				break;
			} //Fin de switch
		}//Fin de while


	entornoMostrarMensajeFin("¡¡¡¡Adios!!!!");
	entornoTerminar();
	}//Fin de if

}*/

/*int main() {
	ejecutar();
	return 0;
}*/
