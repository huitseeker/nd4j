package org.nd4j.shade.serde.jackson.ndarray;

import org.nd4j.shade.jackson.core.JsonParser;
import org.nd4j.shade.jackson.databind.DeserializationContext;
import org.nd4j.shade.jackson.databind.JsonDeserializer;
import org.nd4j.shade.jackson.databind.JsonNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.serde.base64.Nd4jBase64;


import java.io.IOException;

/**
 * @author Adam Gibson
 */

public class NDArrayDeSerializer extends JsonDeserializer<INDArray> {
    @Override
    public INDArray deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        String field = node.get("array").asText();
        INDArray ret = Nd4jBase64.fromBase64(field);
        return ret;
    }
}
