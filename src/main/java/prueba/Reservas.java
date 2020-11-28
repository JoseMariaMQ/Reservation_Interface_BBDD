package prueba;

import javax.persistence.*;

@Entity
@Table(name = "reservas")
public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido1")
    private String apellido1;
    @Column(name = "apellido2")
    private String apellido2;
    @Column(name = "empresa")
    private String empresa;
    @Column(name = "email")
    private String email;
    @Column(name = "num_acomp")
    private int numAcomp;
    @Column(name = "observaciones")
    private String observaciones;

    public Reservas(String nombre, String apellido1, String apellido2, String empresa, String email, int numAcomp, String observaciones) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.empresa = empresa;
        this.email = email;
        this.numAcomp = numAcomp;
        this.observaciones = observaciones;
    }

    public Reservas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumAcomp() {
        return numAcomp;
    }

    public void setNumAcomp(int numAcomp) {
        this.numAcomp = numAcomp;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

   /* @Override
    public String toString() {
        return "Reservas{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", empresa='" + empresa + '\'' +
                ", email='" + email + '\'' +
                ", numAcomp=" + numAcomp +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }*/
}