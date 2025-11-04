package org.example.ejercicio07;

public class Alumno implements Comparable<Alumno> {

    private String id;
    private String nombre;
    private String apellidos;
    private float nota;
    private String curso;

    public Alumno() {
    }

    public Alumno(String id, String nombre, String apellidos, float nota, String curso) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nota = nota;
        this.curso = curso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nota='" + nota + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }

    @Override
    public int compareTo(Alumno o) {
        return Double.compare(o.nota, this.nota);
    }
}
