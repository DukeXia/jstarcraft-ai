/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsat.classifiers.bayesian;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jsat.classifiers.ClassificationDataSet;
import jsat.classifiers.Classifier;
import jsat.distributions.Normal;
import jsat.utils.GridDataGenerator;

/**
 *
 * @author Edward Raff
 */
public class NaiveBayesTest {
    static private ClassificationDataSet easyTrain;
    static private ClassificationDataSet easyTest;
    static private NaiveBayes nb;

    public NaiveBayesTest() {
        GridDataGenerator gdg = new GridDataGenerator(new Normal(0, 0.05), new Random(12), 2);
        easyTrain = new ClassificationDataSet(gdg.generateData(40).getList(), 0);
        easyTest = new ClassificationDataSet(gdg.generateData(40).getList(), 0);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        nb = new NaiveBayes();
    }

    /**
     * Test of train method, of class NaiveBayes.
     */
    @Test
    public void testTrainC_ClassificationDataSet() {
        System.out.println("trainC");
        nb.train(easyTrain);
        for (int i = 0; i < easyTest.size(); i++)
            assertEquals(easyTest.getDataPointCategory(i), nb.classify(easyTest.getDataPoint(i)).mostLikely());
    }

    /**
     * Test of clone method, of class NaiveBayes.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        nb.train(easyTrain);
        Classifier clone = nb.clone();
        for (int i = 0; i < easyTest.size(); i++)
            assertEquals(easyTest.getDataPointCategory(i), clone.classify(easyTest.getDataPoint(i)).mostLikely());
    }

    /**
     * Test of train method, of class NaiveBayes.
     */
    @Test
    public void testTrainC_ClassificationDataSet_ExecutorService() {
        System.out.println("trainC");
        nb.train(easyTrain, true);
        for (int i = 0; i < easyTest.size(); i++)
            assertEquals(easyTest.getDataPointCategory(i), nb.classify(easyTest.getDataPoint(i)).mostLikely());
    }
}