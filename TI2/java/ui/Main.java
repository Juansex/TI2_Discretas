package ui;

import model.Airport;

import java.util.Scanner;

public class Main {
    public static Airport airport;
    public static Scanner input=new Scanner(System.in);
    public static void main(String[] args) {
        airport = Airport.getInstance();
        menu();





        // Generar un grafo guardado
        //airport.generateRandomGraph(50);


        // Reiniciar el grafo
        // airport.resetGraph();
    }
    public static void menu(){
        System.out.println();
        System.out.println("Menu: Ingrese el numero de la opcion que desea realizar");
        System.out.println("1. Ingresar mapa(grafo) de rutas de la aerolinea");
        System.out.println("2. Ver si es la aeroline tiene cierta ruta");
        System.out.println("3. Ver si la aerolinea llega a todas las ciudades en el mapa ingresado");
        System.out.println("4. Buscar la mejor ruta (mas corta) de una ciudad a otra");
        System.out.println("5. Ingresar nuevas rutas (conexiones) de la aerolinea");
        System.out.println("6. Cerrar programa");
        String choice= input.nextLine();
        switch (choice) {
            case "1":
                generateGraph();
                break;
            case "2":
                city2city();
                break;
            case "3":
                conected();
                break;
            case "4":
               calcBestRoute();
                break;
            case "5":
                addRoutes();
                break;
            case "6":
                System.out.println("Gracias");
                break;
            default:
                System.out.println("Ingrese una opcion valida");
        }
        if(!choice.equalsIgnoreCase("6")) menu();
    }

    private static void addRoutes() {
        String choice="1";
        String conexions="";
        while (choice.equalsIgnoreCase("1")){
            System.out.println("Ingrese las conexiones entre ciudades, escribiendo los nombres de las ciudades y su distancia, separando cada una por un guion:\n De esta forma: (ciudad1-ciudad2-12): ");
            conexions+= input.nextLine()+"/";

            System.out.println("Desea ingresar mas conexiones? \n1.Si\n2.No");
            choice=input.nextLine();
        }
        airport.addRoutes(conexions);

    }

    private static void generateGraph() {
        System.out.println("Ingrese el numero de ciudades: ");
        String nString= input.nextLine();
        int n= Integer.parseInt(nString);
        System.out.println("Ingrese los nombres de las "+n+" ciudades ingresadas (separados unicamente por un espacio): ");
        String names= input.nextLine();
        System.out.println("Desea ingresar conexiones? \n1.Si\n2.No");
        String choice=input.nextLine();
        String conexions="";
        while (choice.equalsIgnoreCase("1")){
            System.out.println("Ingrese las conexiones entre ciudades, escribiendo los nombres de las ciudades y su distancia, separando cada una por un guion:\n De esta forma: (ciudad1-ciudad2-12): ");
            conexions+= input.nextLine()+"/";

            System.out.println("Desea ingresar mas conexiones? \n1.Si\n2.No");
            choice=input.nextLine();
        }
        airport.genGraph(n,names,conexions);


    }

    public static void calcBestRoute(){
        //calcula la distancia mas corta entre dos ciudades
        System.out.println("Ingrese el nombre de la ciudad de origen:");
        String origin= input.nextLine();

        System.out.println("Ingrese el nombre de la ciudad de destino");
        String destiny= input.nextLine();

        System.out.println( airport.calculateDijkstra(origin,destiny));
    }

    public static void city2city(){
        //Ver si es posible la ruta de una ciudad a otra
        String msg="";
        System.out.println("Ingrese el nombre de la ciudad de origen:");
        String origin= input.nextLine();

        System.out.println("Ingrese el nombre de la ciudad de destino");
        String destiny= input.nextLine();

        if (airport.calculateDFS(origin, destiny)) msg= "Si es posible llegar a este destino";
        else msg="No es posible llegar a este destino con nuestra aerolinea";
        System.out.println(msg);
    }
    public static void conected(){
        //si todas las ciudades son alcanzables por alguna ruta

        String msg="";
        if (airport.calculateDFSRelated()) msg= "Todas las ciudades registradas estan conectadas por nuestra aerolinea";
        else msg="No todas las ciudades registradas estan conectadas a nuestra aerolinea";
        System.out.println(msg);
    }
}
