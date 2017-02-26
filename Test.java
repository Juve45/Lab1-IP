package test;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;


class Aeronava
{

}

class Locatie
{
    protected ArrayList <Aeronava> listaAeronave;

    Locatie() {
        listaAeronave = new ArrayList<Aeronava>();
    }

    public void addAeronava(Aeronava a)
    {
        listaAeronave.add(a);
    }



}

class Hangar extends Locatie
{
    int capacitate;

    @Override
    public void addAeronava(Aeronava a)
    {
        if(this.listaAeronave.size() == capacitate)
        {
            System.err.println("Nu mai e loc in hangar!");
        }
    }



}

class Pista extends Locatie
{
    int lungime;

}

class Aeroport{
    private List<Locatie> listaLocatii;
}


public class Test {

    
    public static void main(String[] args) {
        
        
        
    }
    
}
