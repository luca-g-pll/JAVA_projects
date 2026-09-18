/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.persistence;

import java.util.Objects;

/**
 *
 * @author MULTI01
 */
public class Seat {
    private String number; //nome --> lettere+num
    private boolean free; //stato

    public Seat(String number, boolean free) {
        this.number = number;
        this.free = free;
    }

    //metodi get-set
    Seat(String number){
        this.number=number;
    }
    public String getNumber() {
        return number;
    }
    public boolean isFree() {
        return free;
    }
    public void setFree(boolean free) {
        this.free = free;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.number);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Seat other = (Seat) obj;
        return Objects.equals(this.number, other.number);
    }
    
    
}
