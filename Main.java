import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Aeronava implements java.io.Serializable{
    String cod_aeronava;
    String tip_aeronava;
    public void printeaza(){ 
        System.out.print("Codul aeronavei este: ");
        System.out.println(this.cod_aeronava);
        System.out.print("Tipul aeronavei este: ");
        System.out.println(this.tip_aeronava);
        System.out.print("\n");
    }

}
class Avion extends Aeronava{
    String tip_avion;
    Avion( String cod,String tip)
    {
        tip_aeronava = "avion";
        cod_aeronava = cod;
        tip_avion=tip;
    }
    public void printeaza(){ 
        System.out.print("Codul aeronavei este: ");
        System.out.print(this.cod_aeronava);
        System.out.print("\n");
    }
    public void printeaza_tipul(){ 
        System.out.print("Tipul aeronavei este: ");
        System.out.print(this.tip_aeronava);
        System.out.print("\n");
    }
    public void printeaza_tipul_avion(){ 
        System.out.print("Tipul avionului este: ");
        System.out.print(this.tip_avion);
        System.out.print("\n");
    }


 }
  class Elicopter extends Aeronava{
        String tip_elicopter;
    Elicopter( String cod,String tip)
    {
        tip_aeronava = "elicopter";
        cod_aeronava = cod;
        tip_elicopter = tip;
    }

    public Elicopter(Elicopter elicopter) {
        cod_aeronava = elicopter.cod_aeronava;
        tip_aeronava = elicopter.tip_aeronava;
        tip_elicopter = elicopter.tip_elicopter;
    }
    
     public void printeaza_codul(){ 
        System.out.print("Codul aeronavei este: ");
        System.out.print(this.cod_aeronava);
        System.out.print("\n");
    }
     public void printeaza_tipul(){ 
        System.out.print("Tipul aeronavei este: ");
        System.out.print(this.tip_aeronava);
        System.out.print("\n");
    }
     public void printeaza_tipul_elicopter(){ 
        System.out.print("Tipul elicopterului este: ");
        System.out.print(this.tip_elicopter);
        System.out.print("\n");
    }

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

public class Main {
    
      
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        ArrayList<Aeronava> l1 = new ArrayList<>();
        Avion AV;
        AV = new Avion("123", "asf");
        l1.add(AV);
        Elicopter EL = new Elicopter("134","smurd");
        l1.add(EL);
        EL.printeaza_codul();
        EL.printeaza_tipul_elicopter();
        EL.printeaza_tipul();
        AV.printeaza_tipul();
         try {
         FileOutputStream fileOut =
         new FileOutputStream("aeronava.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(EL);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in /tmp/employee.ser");
        }catch(IOException i) {
         i.printStackTrace();
        }
         
        try {
            Scanner sc = new Scanner(new FileInputStream("aeronava.in"));
            
        } catch (Exception e) {
        }
        
        
        //Trebuie sa adaug clasele mele
        Aeronava aer = new Aeronava();
        FileInputStream fi = new FileInputStream("aeronava.ser");
        ObjectInputStream Aobj = new ObjectInputStream(fi);
        aer = (Aeronava) Aobj.readObject();
        aer.printeaza();
        Elicopter serEL = new Elicopter((Elicopter)aer);
        serEL.printeaza_tipul_elicopter();
    }
    
}
