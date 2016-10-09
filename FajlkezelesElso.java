/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fajlkezeleselso;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author bodnart
 */
public class FajlkezelesElso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
//beolvassuk a txt fájlból az első sort
            FileReader fr = new FileReader("c:/prog/megrendelok.txt");
            br = new BufferedReader(fr);
            String sor = br.readLine();
            String nev = "";
//megkeressük a nevet, éscsinálunk belőle egy sztringet
            if (sor.substring(0, 4).equals("Név: ")) {
                nev = sor.substring(5);
            }
//Átalakítjuk a nevet nagy kezdőbetűssé, a többi betű kicsi lesz
            while (sor != null) {
                if (sor.startsWith("N")) {
                    nev = sor.substring(5);
                    String szunet = " ";
                    nev = nev.substring(0, 1).toUpperCase() + nev.substring(1, nev.indexOf(szunet)).toLowerCase()
                            + " " + nev.substring(nev.indexOf(szunet) + 1, nev.indexOf(szunet) + 2).toUpperCase() + nev.substring(nev.indexOf(szunet) + 2).toLowerCase();

                    System.out.println(nev);
                }
//megkeressük a telefonszám sorokat
                if (sor.startsWith("T")) {
//csinálunk egy sztringbuildert a telefonszámból
                    StringBuilder telSzam = new StringBuilder(sor.substring(13));
//kitöröljük a szóközöket
                    for (int i = 0; i < telSzam.length(); i++) {
                        if (telSzam.charAt(i) == ' ') {
                            telSzam = telSzam.deleteCharAt(i);
                        }
                    }
//hozzáadjuk a + az első indexre
                    if (telSzam.charAt(0) != '+') {
                        telSzam.insert(0, "+");
                    }
//hozzáadjuk a kötőjelet a megfelelő indexekre
                    telSzam.insert(3, "-");
                    telSzam.insert(6, "-");
                    System.out.println(telSzam);

                }
//beolvassuk a következő sort
                sor = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("nem találom: " + ex);

        } catch (IOException ex) {
            System.out.println(ex);

        } finally {

            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

    }

}

