/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.busqueda;

import ec.edu.espol.entidades.Migracion;
import ec.edu.espol.entidades.Migrante;
import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author CORE I7
 */
public class MigracionProperty {
    private Migracion migration;
    private IntegerProperty cod;
    private ObjectProperty<LocalDate> fechaM;
    private StringProperty idMigrante;
    private StringProperty name;
    private StringProperty cityO;
    private StringProperty provinciaO;
    private StringProperty country;
    private StringProperty lugarDestino;
    
    

   public MigracionProperty(Migracion m){
       migration = m;
       this.cod = new SimpleIntegerProperty(m.getCodigo());
       this.fechaM = new SimpleObjectProperty<>(m.getFechaMigra());
       this.idMigrante = new SimpleStringProperty(m.getMigrante().getIdentificacion());
       this.name = new SimpleStringProperty(m.getMigrante().getNombre()+" "+m.getMigrante().getApellido());
       this.cityO =  new SimpleStringProperty(m.getMigrante().getCantonOrigen());
       this.provinciaO =  new SimpleStringProperty(m.getMigrante().getProvinciaOrigen());
       this.country =  new SimpleStringProperty(m.getMigrante().getPais());
       this.lugarDestino = new SimpleStringProperty(m.getLugarDestino());
   }

    public Migracion getMigration() {
        return migration;
    }

    public void setMigration(Migracion migration) {
        this.migration = migration;
    }
   
   public int getCod() {
        return cod.getValue();
    }

    public void setCod(IntegerProperty age) {
        this.cod = age;
    }

    public ObjectProperty<LocalDate> getDate() {
        return fechaM;
    }

    public void setDate(ObjectProperty<LocalDate> fechaM) {
        this.fechaM = fechaM;
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(StringProperty name) {
        this.name = name;
    }
    
    public String getLugarDestino() {
        return lugarDestino.getValue();
    }

    public void setLugarDestino(StringProperty lugarDestino) {
        this.lugarDestino = lugarDestino;
    }

    public String getCountry() {
        return country.getValue();
    }

    public void setCountry(StringProperty country) {
        this.country = country;
    }

    public String getProvinciaO() {
        return provinciaO.getValue();
    }

    public void setProvinciaO(StringProperty provinciaO) {
        this.provinciaO = provinciaO;
    }

    public String getCityO() {
        return cityO.getValue();
    }

    public void setCityO(StringProperty cityO) {
        this.cityO = cityO;
    }

    public String getIdMigrante() {
        return idMigrante.getValue();
    }

    public void setIdMigrante(StringProperty idMigrante) {
        this.idMigrante = idMigrante;
    }
    
    
    
    
}
