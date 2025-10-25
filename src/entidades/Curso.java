package entidades;

public class Curso {
  private int id;
  private static int siguienteId = 1;
  private String titulo;
  private String nivel;
  private String idioma;
  private int duracionHoras;
  private double precio;
  private Boolean completado;


  // constructor
  public Curso(String titulo, String nivel, String idioma, int duracionHoras, double precio) {

    this.titulo = titulo;
    this.nivel = nivel;
    this.idioma = idioma;
    this.duracionHoras = duracionHoras;
    this.precio = precio;
    this.id = siguienteId;
    incrementarId ();
  }

  // Métodos

  public void incrementarId (){
    siguienteId++;
  }


  // Getters
  public int obtenerId(){
    return id;
  }

  public String obtenerTitulo(){
    return titulo;
  }

  public String obtenerNivel(){
    return nivel;
  }

  public String obtenerIdioma() {
    return idioma;}

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

  public void establecerTitulo(String titulo){

    if (titulo == null || titulo.isEmpty()){
      System.out.println("Ingreso un nombre invalido");
    }

    this.titulo = titulo;
  }

  public void establecerNivel (String nivel){
    this.nivel = nivel;
  }

  public void establecerIdioma(String idioma){
    this.idioma = idioma;
  }

  public void establecerDuracionHoras(int duracionHoras){
    this.duracionHoras = duracionHoras;
  }

  public void establecerPrecio(double precio){
    this.precio = precio;
  }



}
