package entidades;

public class Curso {
  private static int id;
  private String nombre;
  private String plataforma;
  private int duracionHoras;
  private double precio;
  private Boolean completado;


  // constructor
  public Curso(String nombre, String plataforma, int duracionHoras, double precio) {

    this.nombre = nombre;
    this.plataforma = plataforma;
    this.duracionHoras = duracionHoras;
    this.precio = precio;
    id = 1;
    incrementarId();
  }

  // Métodos

  public void incrementarId (){
    id++;
  }


  // Getters
  public int obtenerId(){
    return id;
  }

  public String obtenerNombre(){
    return nombre;
  }

  public String obtenerPlataforma(){
    return plataforma;
  }

  public int obtenerDuracionHoras(){
    return duracionHoras;
  }

  public Boolean obtenerCompletado(){
    return completado;
  }

  public double obtenerPrecio(){
    return precio;
  }

  // Setters

  public void establecerNombre(String nombre){

    if (nombre == "" || nombre == null){
      System.out.println("Ingreso un nombre invalido");
    }

    this.nombre = nombre;
  }

  public void establecerPlataforma (String plataforma){
    this.plataforma = plataforma;
  }

  public void establecerDuracionHoras(int duracionHoras){
    this.duracionHoras = duracionHoras;
  }



}
