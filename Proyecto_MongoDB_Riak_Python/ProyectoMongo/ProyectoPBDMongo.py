import pymongo
import csv
import pandas as pd
import re
from datetime import datetime




client = pymongo.MongoClient("mongodb://localhost:27017")
db = client["Movies_MongoDB"]
collection = db["ratedMovies"]
collection_name = "ratedMovies"


def collection_exists(db,collection_name):
    return collection_name in db.list_collection_names()


def collection_data(collection):
    return collection.count_documents({}) > 0


if collection_exists(db,collection_name) and collection_data:
    print(f"La colección '{collection_name} ya existe y tiene datos, por lo que no se insertará")
else:
    datos_movie = pd.read_csv("Top_rated_movies1.csv", dtype={"title" : str,"overview": str, "popularity":float, "release_date": str,"vote_average":float,"vote_count": int})
    collection.insert_many(datos_movie.to_dict("records"))




def pelicula_por_titulo(title):
    regex_pattern = re.compile(f'.*{re.escape(title)}.*', re.IGNORECASE)
    resultados = collection.find({'title': {'$regex': regex_pattern}})
    return resultados


def pelicula_por_fecha(year):
    resultados = collection.find({"release_date": {"$regex": f"^{year}"}}, {"_id": 0})
    return resultados  


def pelicula_por_votos(votes):
    resultados = collection.find({'vote_average': {'$gte': float(votes)}})
    return resultados


def pelicula_por_popularidad(popularity):
    resultados = collection.find({'popularity': {'$gte': float(popularity)}})
    return resultados


def mostrar_resultados(resultados):
    for resultado in resultados:
        print(resultado)




while True:
    print("Menú de consultas")
    print("1. Consulta por titulo")
    print("2. Consulta por fecha")
    print("3. Consulta por votos")
    print("4. Consulta por popularidad")
    print("5. Salir")


    opcion = input("Seleccione el tipo de consulta que le gustaría hacer (1-5): ")


    if opcion == "1":
        title = input("Inserte el titulo: ")
        resultados = pelicula_por_titulo(title)
        mostrar_resultados(resultados)
    elif opcion == "2":
        year = input("Inserte el año: ")
        resultados = pelicula_por_fecha(year)
        mostrar_resultados(resultados)
    elif opcion == "3":
        votes = input("Inserte el número mínimo de la media de votos: ")
        resultados = pelicula_por_votos(votes)
        mostrar_resultados(resultados)
    elif opcion == "4":
        popularity = input("Inserte el número mínimo de popularidad: ")
        resultados = pelicula_por_popularidad(popularity)
        mostrar_resultados(resultados)
    elif opcion == "5":
        print("Saliendo del programa")
        break
    else:
        print("La opción que ha seleccionado no es válida")


client.close()

