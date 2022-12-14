public class OutputLayerNeuronBehaviour implements NeuronBehaviour{
    private static OutputLayerNeuronBehaviour myInstance;
    private OutputLayerNeuronBehaviour() {
    }
    public static OutputLayerNeuronBehaviour getInstance(){
        if(myInstance==null){
        myInstance = new OutputLayerNeuronBehaviour();
        }
        return myInstance;
    }

    @Override
    public double setDelta(Neuron i) {
        double expectedValue = LayerManager.ExpectedOutputArray[i.getNeuronNum()];
        double activation = i.getActivation();
        return activation * (1 - activation) * (expectedValue - activation);
    }

}