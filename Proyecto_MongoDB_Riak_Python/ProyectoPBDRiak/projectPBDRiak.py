import riak
import datetime
import csv

# Starting Client
myClient = riak.RiakClient(pb_port=8087)

def checkConnection(RiakClient):
    try:
        server_info = RiakClient.ping()

        if server_info:
            print("CONNECTED WITH RIAK", server_info)
            return True
        else:
            print("ERROR, NOT CONNECTED RIAK", server_info)
            return False

    except Exception as e:
        print("Error al intentar conectar con RIAK:", e)

def read_csv():
    with open('Top_rated_movies1.csv', 'r') as file:
        # Read CSV
        csv_reader = csv.reader(file)
        next(csv_reader)

        # Fetch rows
        for row in csv_reader:
            title = str(row[1])
            overview = str(row[2])
            popularity = float(row[3])
            release_date = datetime.datetime.strptime(row[4], "%Y-%m-%d").date().isoformat()
            vote_average = float(row[5])
            vote_count = int(row[6])

            obj = myBucket.new(title, data={'title': title, 'overview': overview, 'popularity': popularity,
                                            'release_date': release_date, 'vote_average': vote_average,
                                            'vote_count': vote_count})
            obj.store()
            # Use date.fromisoformat(date) to show date in good format when getting an object from DB.
            # print('Objeto insertado en RIAK:', obj.key)


def search_by_year(target_year):
    result_list = []
    my_bucket = myClient.bucket('Top_rated_movies1')

    for key in my_bucket.get_keys():
        obj = my_bucket.get(key)
        release_date_str = obj.data.get('release_date')

        release_date = datetime.datetime.strptime(release_date_str, "%Y-%m-%d").date()

        release_year = release_date.year

        if release_year == target_year:
            title = obj.data.get('title')
            popularity = obj.data.get('popularity')
            vote_average = obj.data.get('vote_average')
            vote_count = obj.data.get('vote_count')
            result_list.append((title,popularity, release_date, vote_average, vote_count))

    print("--> Numero de titulos encontrados:", len(result_list))
    for item in result_list:
        print(item)

    return result_list

def search_by_title(title_query):
    result_list = []
    my_bucket = myClient.bucket('Top_rated_movies1')

    for key in my_bucket.get_keys():
        obj = my_bucket.get(key)
        title = obj.data.get('title').lower()

        if title_query.lower() in title:
            popularity = obj.data.get('popularity')
            release_date = obj.data.get('release_date')
            vote_average = obj.data.get('vote_average')
            vote_count = obj.data.get('vote_count')
            result_list.append((title,popularity, release_date, vote_average, vote_count))

    print("--> Numero de titulos encontrados:", len(result_list))
    for item in result_list:
        print(item)

    return result_list

def search_by_vote_average(min_vote_average):
    result_list = []
    my_bucket = myClient.bucket('Top_rated_movies1')

    for key in my_bucket.get_keys():
        obj = my_bucket.get(key)
        vote_average = obj.data.get('vote_average')

        if vote_average is not None and vote_average >= min_vote_average:
            title = obj.data.get('title')
            popularity = obj.data.get('popularity')
            release_date = obj.data.get('release_date')
            vote_count = obj.data.get('vote_count')
            result_list.append((title,popularity, release_date, vote_average, vote_count))

    print("--> Numero de titulos encontrados:", len(result_list))
    for item in result_list:
        print(item)

    return result_list

def search_by_vote_count(min_vote_count):
    result_list = []
    my_bucket = myClient.bucket('Top_rated_movies1')

    for key in my_bucket.get_keys():
        obj = my_bucket.get(key)
        vote_count = obj.data.get('vote_count')

        if vote_count is not None and vote_count >= min_vote_count:
            title = obj.data.get('title')
            popularity = obj.data.get('popularity')
            release_date = obj.data.get('release_date')
            vote_average = obj.data.get('vote_average')
            result_list.append((title,popularity, release_date, vote_average, vote_count))

    print("--> Numero de titulos encontrados:", len(result_list))
    for item in result_list:
        print(item)

    return result_list



if checkConnection(myClient):
    if myClient.bucket_type('default').bucket('Top_rated_movies1'):
        print("\n")
        print("-------------------------------------")
        print("--> The bucket already exist")
        print("--> Deleting all rows in the bucket")
        myBucket = myClient.bucket('Top_rated_movies1')
        cont = 0
        for key in myClient.get_keys(myBucket):
            myBucket.delete(key)
            cont = cont + 1
            #print("Deleted key:", key)
        print("--> Deleted: " + str(cont) + " rows correctly")
        print("-------------------------------------")
        print("--> Adding new rows to the bucket")
        read_csv()
        print("--> Added correctly")
        print("-------------------------------------")
        print("\n")
        while True:
            print("\nMenú de consultas")
            print("1. Consulta por título")
            print("2. Consulta por fecha")                        
            print("3. Consulta por votos")
            print("4. Consulta por popularidad")
            print("5. Salir")
            opcion = input("Seleccione el tipo de consulta que le gustaría hacer (1-5): ")
            if opcion == "1":      
                tit = str(input("Inserte el titulo: "))
                print("--> Titulo seleccionado: " + str(tit))
                search_by_title(tit)
            elif opcion == "2":
                year = int(input("Inserte el año: "))
                print("--> Año seleccionado: " + str(year))
                search_by_year(year)
            elif opcion == "3":
                avg = float(input("Inserte el número mínimo de la media de votos: "))
                print("--> Numero seleccionado: " + str(avg))
                search_by_vote_average(avg)
            elif opcion == "4":
                count = int(input("Inserte el número mínimo de popularidad: "))
                print("--> Numero seleccionado: " + str(count))
                search_by_vote_count(count)
            elif opcion == "5":
                print("Saliendo del progrma")
                break
            else:
                print("La opción que ha seleccionado no es válida")

    else:
        print("--> Creating new bucket")
        # Creating Buckets
        myBucket = myClient.bucket('Top_rated_movies1')
        print("--> Adding new rows to the bucket")
        read_csv()
        print("--> Added correctly")
