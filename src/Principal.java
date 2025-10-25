import java.lang.reflect.Array;
import java.util.ArrayList;
import entidades.Curso;
import java.util.Scanner;


public class Principal {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    ArrayList<Curso> cursosDB = obtenerCursos();


    while (true) {
      System.out.println("=======================");
      System.out.println("--- Code To Code ---");
      System.out.println("=======================");
      System.out.println("1) Crear un Curso");
      System.out.println("2) Listar Cursos");
      System.out.println("3) Busca Curso por ID");
      System.out.println("4) Buscar Curso por Título");
      System.out.println("5) Eliminar un Curso");
      System.out.println("0) Salir");
      System.out.print("Elige una opción: ");

      String opcion = sc.nextLine();

      switch (opcion) {
        case "1" -> agregarCurso(cursosDB); //crear();
        case "2" -> listarCursos(cursosDB); // listar();
        case "3" -> System.out.println("Buscar"); //buscar();
        case "4" -> System.out.println("Eliminar"); //eliminar();
        case "0" -> {
          System.out.println("Hasta luego!");
          return;
        }
        default -> System.out.println("Opción inválida, por favor, intente de nuevo");

      }
    }
  }

  public static void pausa() {
    Scanner entrada = new Scanner(System.in);
    System.out.println("\nPulse ENTER para continuar...");
    entrada = new Scanner(System.in);
    entrada.nextLine();
    for (int i = 0; i < 20; ++i) {
      System.out.println();
    }
    // TODO: limpiar la pantalla de la consola
  }


  public static void agregarCurso(ArrayList<Curso> cursosDB){
    System.out.println("=================================================================================================================");
    System.out.println("------------------------------------------------ Creando Producto---- -------------------------------------------");
    System.out.println("=================================================================================================================");

    Scanner sc = new Scanner(System.in);
    System.out.print("Título: ");
    String titulo = sc.nextLine();
    System.out.print("Nivel: ");
    String nivel = sc.nextLine();
    System.out.print("Idioma: ");
    String idioma = sc.nextLine();
    System.out.print("Duración (en horas): ");
    int duracionHoras = sc.nextInt();
    System.out.print("Precio: $");
    double precio = sc.nextDouble();

    Curso nuevo = new Curso(titulo,nivel,idioma,duracionHoras,precio);
    cursosDB.add(nuevo);
    System.out.println("------------------------------------------------ Curso Creado ---------------------------------------------------");
    pausa();
  }

  public static void listarCursos(ArrayList<Curso> cursosDB){
    System.out.println("=================================================================================================================");
    System.out.println("------------------------------------------------ Listado de Productos -------------------------------------------");
    System.out.println("=================================================================================================================");

    if(cursosDB == null || cursosDB.isEmpty()){
      System.out.println("No hay cursos para mostrar");
    } else{
      System.out.printf("| %-3s | %-35s | %-15s | %-15s | %-15s | %-10s |%n",
          "ID", "TITULO", "NIVEL", "IDIOMA", "DURACION", "PRECIO");
    }

    for(Curso cursos : cursosDB){
      System.out.printf("| %-3s | %-35s | %-15s | %-15s | %-15s | %-10s |%n",
          cursos.obtenerId(), cursos.obtenerTitulo(), cursos.obtenerNivel(), cursos.obtenerIdioma(), cursos.obtenerDuracionHoras()+"Hs", "$"+cursos.obtenerPrecio());
    }
    pausa();
  }



  public static ArrayList<Curso> obtenerCursos(){
    ArrayList <Curso> cursos = new ArrayList<>();

    cursos.add(new Curso(
        "Java de cero a Experto",
        "Principiante",
        "Español",
        14,
        19999
    ));
    cursos.add(new Curso(
        "Python: IA + BigData",
        "Avanzado",
        "Español",
        20,
        29999
    ));

    cursos.add(new Curso(
        "Programacion Orientada a Objetos",
        "Intermedio",
        "Español",
        8,
        9999
    ));

    cursos.add(new Curso(
        "Mejora tu Ingles con 5 min al día",
        "Principiante",
        "Español",
        7,
        8000
    ));


    return cursos;
  }
}
