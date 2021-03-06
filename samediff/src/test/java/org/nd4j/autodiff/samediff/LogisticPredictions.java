package org.nd4j.autodiff.samediff;

import org.nd4j.autodiff.samediff.impl.SDVariable;
import org.nd4j.linalg.api.ndarray.INDArray;

import java.util.Map;

public class LogisticPredictions implements SameDiff.SameDiffFunctionDefinition {
    /**
     * @param sameDiff
     * @param inputs
     * @return
     */
    @Override
    public SDVariable define(SameDiff sameDiff, Map<String, INDArray> inputs) {
        SDVariable input = sameDiff.var("x",inputs.get("x"));
        SDVariable w = sameDiff.var("w",inputs.get("w"));
        SDVariable y = sameDiff.var("y",inputs.get("y"));
        SDVariable preOutput = sameDiff.mmul(0,input,w);
        SDVariable sigmoid = sameDiff.sigmoid(preOutput);

        return sigmoid;
    }
}
