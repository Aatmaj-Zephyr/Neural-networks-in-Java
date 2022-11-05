public class LossCalculator {
    

    public static double calculateLossFunction(OutputLayer outputLayer, double[] expectedLayer) {


        // Overloaded for arrays as input

        if (outputLayer.getListOfNeurons().size() != expectedLayer.length) {
            throw new RuntimeException("Length mismatch between lists of neurons and expected lists of neurons");
        }

        // Mean squared error
        double[] sum = new double[outputLayer.getListOfNeurons().size()];
        for (int i = 0; i < outputLayer.getListOfNeurons().size(); i++) {
            sum[i] = Math.pow((outputLayer.getListOfNeurons().get(i).getActivation() - expectedLayer[i]), 2);
            
        }
        
        return NN.average(sum);
    }

   



}
