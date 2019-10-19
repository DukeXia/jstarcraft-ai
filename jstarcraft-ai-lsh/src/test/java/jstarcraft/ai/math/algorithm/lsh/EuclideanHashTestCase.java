package jstarcraft.ai.math.algorithm.lsh;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import be.tarsos.lsh.KeyVector;

public class EuclideanHashTestCase {

    @Test
    public void testHash() {
        KeyVector vector = new KeyVector("hash", 3);
        vector.setValue(0, 1);
        vector.setValue(1, 2);
        vector.setValue(2, 3);

        Random random = new Random(0);
        EuclideanHash hash = new EuclideanHash(random, 3, 4);
        int hashValue = hash.hash(vector);
        assertEquals("Expected about 1", 1, hashValue);
    }

}