package org.nd4j.linalg.api.blas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.nd4j.linalg.BaseNd4jTest;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.factory.Nd4jBackend;

import static org.junit.Assert.assertEquals;

/**
 * @author Audrey Loeffel
 */
@RunWith(Parameterized.class)
public class SparseLevel1Test extends BaseNd4jTest{

    private double[] data = {1,2,4} ;
    private int[] col = {0,1,3};
    private int[] pointerB = {0};
    private int[] pointerE = {4};
    private int[] shape = {1, 4};

    public SparseLevel1Test(Nd4jBackend backend) {
        super(backend);
    }

    @Test
    public void shouldComputeDot() {
        INDArray sparseVec = Nd4j.createSparseCSR(data, col, pointerB, pointerE, shape);
        INDArray vec = Nd4j.create( new double[] {1 ,2, 3, 4});
        assertEquals(21, Nd4j.getBlasWrapper().dot(sparseVec, vec), 1e-1);
    }

    @Test
    public void shouldComputeNrm2() {
        INDArray sparseVec = Nd4j.createSparseCSR(data, col, pointerB, pointerE, shape);
        assertEquals(Math.sqrt(21), Nd4j.getBlasWrapper().nrm2(sparseVec), 1e-1);
    }

    @Test
    public void shouldComputeAsum() {
        INDArray sparseVec = Nd4j.createSparseCSR(data, col, pointerB, pointerE, shape);
        assertEquals(7, Nd4j.getBlasWrapper().asum(sparseVec), 1e-1);
    }

    @Test
    public void shouldComputeIamax() {
        INDArray sparseVec = Nd4j.createSparseCSR(data, col, pointerB, pointerE, shape);
        assertEquals(4, Nd4j.getBlasWrapper().iamax(sparseVec), 1e-1);
    }

    @Test
    public void shouldComputeIamin() {
        INDArray sparseVec = Nd4j.createSparseCSR(data, col, pointerB, pointerE, shape);
        assertEquals(1, Nd4j.getBlasWrapper().level1().iamin(sparseVec), 1e-1);
    }

    @Test
    public void shouldComputeAxpy() {
        INDArray sparseVec = Nd4j.createSparseCSR(data, col, pointerB, pointerE, shape);
        INDArray vec = Nd4j.create( new double[] {1 ,2, 3, 4});
        INDArray expected = Nd4j.create(new double[]{3, 6, 3, 12});
        Nd4j.getBlasWrapper().level1().axpy(vec.length(), 1, sparseVec, vec);
        assertEquals(getFailureMessage(), expected, vec);
    }

    @Test
    public void shouldComputeRot(){
        INDArray sparseVec = Nd4j.createSparseCSR(data, col, pointerB, pointerE, shape);
        INDArray vec = Nd4j.create( new double[] {1 ,2, 3, 4});
        // TODO
    }
}