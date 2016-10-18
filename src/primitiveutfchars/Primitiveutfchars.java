
package primitiveutfchars;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author julián
 */
public class Primitiveutfchars {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File text3 = new File("/home/oracle/Documents/text3.txt");

        FileOutputStream salida = new FileOutputStream(text3);
        BufferedOutputStream bsalida = new BufferedOutputStream(salida);
        DataOutputStream dsalida = new DataOutputStream(bsalida);

        FileInputStream entrada = new FileInputStream(text3);
        BufferedInputStream bentrada = new BufferedInputStream(entrada);
        DataInputStream dentrada = new DataInputStream(bentrada);

        String cadea2 = "Esto é unha cadea \n";

        dsalida.writeUTF(cadea2);
        System.out.print("writeUtf escribiu: " + cadea2);
        int lcadea1 = dsalida.size();
        System.out.println("WriteUtf escribiu: " + lcadea1 + "bytes");

        dsalida.writeChars(cadea2);
        System.out.print("writeChars escribiu " + cadea2);
        System.out.println("writeChars escribiu: " + (dsalida.size() - lcadea1) + "bytes");
        
        //dsalida.close();
        int totaisporler = dentrada.available();
        System.out.println("bytes totais por ler" + totaisporler);

        dsalida.writeUTF(cadea2);

        System.out.print("writeUtf escribiu: " + cadea2);
        int lcadea3 = dsalida.size();
        System.out.println("WriteUtf escribiu: " + (lcadea3 - lcadea1) + "bytes");
        dsalida.close();

       
        
        
        String leerutf1 = dentrada.readUTF();
        System.out.println("Lemos a primeira cadea UTF : " + leerutf1);

        int bytesprimeira = totaisporler - dentrada.available();
        System.out.println("O numero bytes lidos e " + bytesprimeira);
        System.out.println("bytes restantes por ler" + dentrada.available());

       
        
        String lercadea2 = "";
        for (int i = 0; i < cadea2.length(); i++) {
            lercadea2 += dentrada.readChar();

        }
        System.out.println("Lemos a cadea chars: " + lercadea2);
        System.out.println("O numero bytes lidos e " + (lcadea3 - lcadea1));
        System.out.println("bytes restantes por ler" + (dentrada.available()));

        String lercadeaUTF2 = dentrada.readUTF();

        System.out.println("Lemos a segunda cadea UTF : " + lercadeaUTF2);
        dentrada.close();

// writeUTF escribiu: Esta e unha cadea\n
//writeUTF escribiu: 20 bytes
//writeChars escribiu: Esta e unha cadea\n
//writeChars escribiu:  36bytes
//writeUTF escribiu: Esta e unha cadea\n
//writeUTF escribiu: 20 bytes
//bytes totais escritos = 76
//lemos a primeira cadea en UTF: Esta e unha cadea
//numero de bytes lidos: 20 bytes.
//bytes restantes por ler = 56
//lemos a segunda cadea Chars:  Esta e unha cadea
//
//o numero de bytes lidos e :36
//bytes restantes por ler : 20
//lemos a terceira cadea  mediante readUTF:  Esta e unha cadea
    }

}
