/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectSerialization;

/**
 *
 * @author ASUS
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Modul3_Serialization {
    public void Serialize(ArrayList<Modul3_Participant> pList, String fileName){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(pList);
        }catch(IOException ex){
            System.out.println("a problem assured during serialization\n"+ex.getMessage());
        }
    }
    public void save(ArrayList<Modul3_Participant> pList, String fileBaru){
        try(FileOutputStream fou = new FileOutputStream(fileBaru)){
            String v = String.valueOf(pList);
            for(int i=0; i<v.length(); i++){
                fou.write(v.charAt(i));
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public ArrayList<Modul3_Participant> print(String fileName){
        List<Modul3_Participant> pList = null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
            pList = (List<Modul3_Participant>) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.printf("a problem accured deserializing %s%n", fileName);
            System.out.println(ex.getMessage());
        }
        return (ArrayList<Modul3_Participant>) pList;
    }

   }