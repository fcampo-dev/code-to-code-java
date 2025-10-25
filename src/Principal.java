import entidades.Curso;
import java.util.ArrayList;
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
      System.out.println("5) Modificar Titulo de Curso");
      System.out.println("6) Eliminar un Curso");
      System.out.println("0) Salir");
      System.out.print("Elige una opción: ");

      String opcion = sc.nextLine();

      switch (opcion) {
        case "1" -> agregarCurso(cursosDB); //crear();
        case "2" -> listarCursos(cursosDB); // listar();
        case "3" -> buscarCursosPorID(cursosDB); //buscarID();
        case "4" -> buscarCursosPorTitulo(cursosDB); //buscarTitulo();
        case "5" -> modificarCurso(cursosDB); //eliminar();
        case "6" -> borrarCurso(cursosDB); //eliminar();
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

  public static void agregarCurso(ArrayList<Curso> cursosDB) {
    System.out.println(
        "=================================================================================================================");
    System.out.println(
        "------------------------------------------------ Creando Producto---- -------------------------------------------");
    System.out.println(
        "=================================================================================================================");

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

    Curso nuevo = new Curso(titulo, nivel, idioma, duracionHoras, precio);
    cursosDB.add(nuevo);
    System.out.println(
        "------------------------------------------------ Curso Creado ---------------------------------------------------");
    pausa();
  }

  public static void listarCursos(ArrayList<Curso> cursosDB) {
    System.out.println(
        "=================================================================================================================");
    System.out.println(
        "------------------------------------------------ Listado de Productos -------------------------------------------");
    System.out.println(
        "=================================================================================================================");

    if (cursosDB == null || cursosDB.isEmpty()) {
      System.out.println("No hay cursos para mostrar");
    } else {
      System.out.printf("| %-3s | %-35s | %-15s | %-15s | %-15s | %-10s |%n", "ID", "TITULO",
          "NIVEL", "IDIOMA", "DURACION", "PRECIO");
    }

    if (cursosDB != null && !cursosDB.isEmpty()) {
      for (Curso cursos : cursosDB) {
        System.out.printf("| %-3s | %-35s | %-15s | %-15s | %-15s | %-10s |%n", cursos.obtenerId(),
            cursos.obtenerTitulo(), cursos.obtenerNivel(), cursos.obtenerIdioma(),
            cursos.obtenerDuracionHoras() + "Hs", "$" + cursos.obtenerPrecio());
      }
      pausa();
    }
  }

  public static void buscarCursosPorTitulo(ArrayList<Curso> cursosDB) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese el título de un Curso: ");
    String busqueda = scanner.nextLine();
    ArrayList<Curso> cursosEncontrados = new ArrayList<>();

    for (Curso curso : cursosDB) {
      if (estaIncluido(curso.obtenerTitulo(), busqueda)) {
        cursosEncontrados.add(curso);
      }
    }

    listarCursos(cursosEncontrados);
  }

  public static boolean estaIncluido(String tituloCompleto, String nombreParcial) {
    String tituloCompletoFormateado = formatoBusqueda(tituloCompleto);

    return tituloCompletoFormateado.contains(formatoBusqueda(nombreParcial));
  }

  public static String formatoBusqueda(String texto) {
    return texto.trim().toLowerCase();
  }

  public static void buscarCursosPorID(ArrayList<Curso> cursosDB) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese el ID de un Curso: ");
    int busqueda = scanner.nextInt();
    ArrayList<Curso> cursosEncontrados = new ArrayList<>();

    // TODO: Modificar el imprimir para un solo producto, no es necesario recorrer todo si busco por ID
    for (Curso curso : cursosDB) {
      if (curso.obtenerId() == busqueda) {
        cursosEncontrados.add(curso);
      }
    }

    listarCursos(cursosEncontrados);

  }

  public static void modificarCurso(ArrayList<Curso> cursosDB) {
    Curso cursoAModificar = obtenerCurso(cursosDB);
    // TODO: validar que encontramos el producto
    if (cursoAModificar == null) {
      System.out.println("No se puede editar el producto.");
      pausa();
      return; // cuando hacemos el return en una funcion void, estamos cortando la ejecucion de la funcion
    }

    String tituloOriginal = cursoAModificar.obtenerTitulo();
    System.out.print("Curso a editar el título: ");
    System.out.println("[ " + tituloOriginal + " ]");
    // TODO: validar que el usuario quiere editar el producto que se encontro
    System.out.print("Ingrese el nuevo nombre: ");
    Scanner sc = new Scanner(System.in);
    String nuevoTitulo = sc.nextLine();

    cursoAModificar.establecerTitulo(nuevoTitulo);

    System.out.printf("El título del Curso cambio de '%s' a '%s'\n", tituloOriginal, nuevoTitulo);
  }

  public static Curso obtenerCurso(ArrayList<Curso> cursosDB) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese el ID de un Curso: ");
    int busqueda = scanner.nextInt();
    ArrayList<Curso> cursosEncontrados = new ArrayList<>();

    // TODO: Modificar el imprimir para un solo producto, no es necesario recorrer todo si busco por ID
    for (Curso curso : cursosDB) {
      if (curso.obtenerId() == busqueda) {
        cursosEncontrados.add(curso);
      }
      return curso;
    }
    return null;
  }

  public static void borrarCurso(ArrayList<Curso> cursosDB) {
    Curso cursoABorrar = obtenerCurso(cursosDB);
    // TODO: validar que encontramos el producto
    if (cursoABorrar == null) {
      System.out.println("No pudimos borrar el producto");
      pausa();
      return; //
    }
    String nombreOriginal = cursoABorrar.obtenerTitulo();
    System.out.println("Curso a borrar:");
    System.out.println(nombreOriginal);
    // TODO: validar que el usuario quiere borrar el producto que se encontro

    cursosDB.remove(cursoABorrar);
    System.out.println("Borrado exitosamente!");
    pausa();
  }

  public static ArrayList<Curso> obtenerCursos() {
    ArrayList<Curso> cursos = new ArrayList<>();

    cursos.add(new Curso("Java de cero a Experto", "Principiante", "Español", 14, 19999));
    cursos.add(new Curso("Python: IA + BigData", "Avanzado", "Español", 20, 29999));

    cursos.add(new Curso("Programacion Orientada a Objetos", "Intermedio", "Español", 8, 9999));

    cursos.add(new Curso("Mejora tu Ingles con 5 min al día", "Principiante", "Español", 7, 8000));

    return cursos;
  }
}
