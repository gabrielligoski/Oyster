package test.java;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;

import main.Publicacao;
import main.Singleton;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SingletonTests {

    @Test
    public void addingMultipleEqualElements() throws NoSuchAlgorithmException {
        Singleton sg = Singleton.getInstance();

        String texto = "Ut sit amet nisl id leo eleifend dignissim. Curabitur eu pellentesque sem. Mauris quis"
                + "condimentum tortor. Curabitur augue arcu, fermentum vel luctus et, consectetur laoreet nibh."
                + "Fusce volutpat diam at risus ultrices, sit amet aliquet lorem viverra. Morbi id ex sem. Donec"
                + "varius scelerisque sem a aliquet. Nam tristique accumsan diam, tempor tristique magna"
                + "sodales vel. Aliquam quis feugiat mi, nec tempus est. Duis metus nibh, pretium ac ullamcorper"
                + "et, imperdiet ut mi. Nullam nunc purus, congue quis velit eget, scelerisque congue nisl. Mauris"
                + "id mattis odio. Curabitur eu leo eu velit elementum mattis eget in mauris.";
        String processo = "0000002-31.2010.5.01.001";
        String evento = "DESPACHO";


        Publicacao pub1 = new Publicacao(new Date(), evento, processo, texto);
        Publicacao pub2 = new Publicacao(evento, processo, texto);
        Publicacao pub3 = new Publicacao(new Date(), evento, processo, texto);

        String hash1 = sg.generateUID(pub1);
        String hash2 = sg.generateUID(pub2);
        String hash3 = sg.generateUID(pub3);


        assertEquals(pub1, pub2);
        assertEquals(pub2, pub3);
        assertEquals(hash1, hash2);
        assertEquals(hash2, hash3);
    }

    @Test
    public void addingMultipleDifferentElements() throws NoSuchAlgorithmException {
        Singleton sg = Singleton.getInstance();

        String texto = "Ut sit amet nisl id leo eleifend dignissim. Curabitur eu pellentesque sem. Mauris quis"
                + "condimentum tortor. Curabitur augue arcu, fermentum vel luctus et, consectetur laoreet nibh."
                + "Fusce volutpat diam at risus ultrices, sit amet aliquet lorem viverra. Morbi id ex sem. Donec"
                + "varius scelerisque sem a aliquet. Nam tristique accumsan diam, tempor tristique magna"
                + "sodales vel. Aliquam quis feugiat mi, nec tempus est. Duis metus nibh, pretium ac ullamcorper"
                + "et, imperdiet ut mi. Nullam nunc purus, congue quis velit eget, scelerisque congue nisl. Mauris"
                + "id mattis odio. Curabitur eu leo eu velit elementum mattis eget in mauris.";
        String texto2 = "Ut sit amet nisl id leo eleifend dignissim. Curabitur eu pellentesque sem. Mauris quis"
                + "condimentum tortor. Curabitur augue arcu, fermentum vel luctus et, consectetur laoreet nibh."
                + "Fusce volutpat diam at risus ultrices, sit amet aliquet lorem viverra. Morbi id ex sem. Donec"
                + "varius scelerisque sem a aliquet. Nam tristique accumsan diam, tempor tristique magna"
                + "sodales vel. Aliquam quis feugiat mi, nec tempus est. Duis metus nibh, pretium ac ullamcorper"
                + "et, imperdiet ut mi. Nullam nunc purus, congue quis velit eget, scelerisque congue nisl. Mauris"
                + "id mattis odio. Curabitur eu leo eu velit elementum mattis eget in mauris,";
        String processo = "0000002-31.2010.5.01.001";
        String processo2 = "0000002-31.2010.5.01.002";
        String evento = "DESPACHO";


        Publicacao pub1 = new Publicacao(new Date(), evento, processo, texto);
        Publicacao pub2 = new Publicacao(evento, processo, texto2);
        Publicacao pub3 = new Publicacao(new Date(), evento, processo2, texto2);

        String hash1 = sg.generateUID(pub1);
        String hash2 = sg.generateUID(pub2);
        String hash3 = sg.generateUID(pub3);


        assertNotEquals(pub1, pub2);
        assertNotEquals(pub2, pub3);
        assertNotEquals(hash1, hash2);
        assertNotEquals(hash2, hash3);
    }

}
