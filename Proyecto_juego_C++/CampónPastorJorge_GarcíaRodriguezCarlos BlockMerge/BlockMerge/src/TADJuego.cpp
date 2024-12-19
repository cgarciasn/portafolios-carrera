/*
 * TADJuego.cpp
 *
 *  Created on: 27 nov. 2019
 *      Author: usuario
 */

#include "TADJuego.h"

void pintarJuego(Juego &J){
	int tam = obtenerTamanioTablero(J.tab);
	//se visualizan en el entorno gráfico los valores extraídos del
	//fichero de conf. y almacenados en la matriz m
	int fila, col;
	for ( fila = 0; fila < tam; fila++) {
		for ( col = 0; col < tam; col++) {
			entornoPonerNumero(fila, col,obtenerValorTablero(J.tab,fila,col));
		}
	}

}

void iniciarEstructura(Juego& J) {
	//variables para almacenar la información del fichero de configuración
	int tam,deDonde;
	int m[MAX_TAMANO][MAX_TAMANO];

	//se carga la información almacenada en el fich. de configuración
	if (entornoCargarConfiguracion(tam, J.objetivo, deDonde, m)) {
		entornoIniciar(tam); //se inicia el entorno gráfico
        if(deDonde == 0){
        	iniciarDesdeFichero(J.tab,m,tam);

        }
        else{
        	iniciarAleatoriamente(J.tab,tam,deDonde);
        }

        pintarJuego(J);
        entornoPonerObjetivo(J.objetivo);
	}//Fin del if
}

void movimiento(Juego &J) {
	int tam = J.tab.tamanio;
	int fila;
	int col;
	int num;
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
			if(CasillaEnBloque(J.tab,fila,col) == true){
			num = obtenerValorTablero(J.tab,fila,col);
			//mostrar(J.tab);
			//cout << "--------" << endl;
			vaciarCasillasEnBloque(J.tab,fila,col,num);
			ponerValorEnTablero(J.tab,fila,col,num+1);
			desplazarTodasAbajo(J.tab);
			//mostrar(J.tab);
			rellenarTodasColumnas(J.tab);
			pintarJuego(J);
			if(J.objetivo == obtenerValorMaximo(J.tab)){
				entornoPausa(0.5);
				entornoMostrarMensajeFin("¡Has ganado la partida! :)");
				entornoTerminar();
			}
			if(siHayBloque(J.tab) == false){
				entornoPausa(0.5);
				entornoMostrarMensajeFin("!Has perdido la partida! :(");
				entornoTerminar();
			}

		}
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
			finDelJuego(J);
			break;

		case TNada:
			break;
		} //Fin de switch
	}//Fin de while

}


void finDelJuego(Juego& J) {
	entornoPausa(1);
	entornoMostrarMensajeFin("¡Hasta otra!");
	entornoTerminar();
}


int main(){
	srand(time(NULL));
	Juego Ju;
	iniciarEstructura(Ju);
	movimiento(Ju);
}



