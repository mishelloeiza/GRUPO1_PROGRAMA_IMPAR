 /*Capa controlador (Domain)
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author visitante
 */
public class Partido {
     private int id;
    private String equipo;
    private String partidos_jugados;
    private String ganados;
    private String empatados;
    private String perdidos;
    private String goles_favor;
    private String goles_contra;
    private String puntos;
    public Partido() {
    }

    public Partido(int id, String equipo, String partidos_jugados, String ganados, String empatados, String perdidos, String goles_favor, String goles_contra, String puntos) {
        this.id = id;
        this.equipo = equipo;
        this.partidos_jugados = partidos_jugados;
        this.ganados = ganados;
        this.empatados = empatados;
        this.perdidos = perdidos;
        this.goles_favor = goles_favor;
        this.goles_contra = goles_contra;
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", equipo=" + equipo + ", partidos_jugados=" + partidos_jugados + ", ganados=" + ganados + ", empatados=" + empatados + ", perdidos=" + perdidos + ", goles_favor=" + goles_favor + ", goles_contra=" + goles_contra + ", puntos=" + puntos + '}';
    }
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getPartidos_jugados() {
        return partidos_jugados;
    }

    public void setPartidos_jugados(String partidos_jugados) {
        this.partidos_jugados = partidos_jugados;
    }

    public String getGanados() {
        return ganados;
    }

    public void setGanados(String ganados) {
        this.ganados = ganados;
    }

    public String getEmpatados() {
        return empatados;
    }

    public void setEmpatados(String empatados) {
        this.empatados = empatados;
    }

    public String getPerdidos() {
        return perdidos;
    }

    public void setPerdidos(String perdidos) {
        this.perdidos = perdidos;
    }

    public String getGoles_favor() {
        return goles_favor;
    }

    public void setGoles_favor(String goles_favor) {
        this.goles_favor = goles_favor;
    }

    public String getGoles_contra() {
        return goles_contra;
    }

    public void setGoles_contra(String goles_contra) {
        this.goles_contra = goles_contra;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }
    
}

  

  
    
