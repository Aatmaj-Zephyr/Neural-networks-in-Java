public class Trainer {
    public LayerManager myLayerManager;
    public double[] expectedLayer;
    public InputFileReader myMnistDataBaseFileReader;
    double[] inputLayer;
		double label;

    Trainer(LayerManager myLayerManager,  InputFileReader myMnistDataBaseFileReader){
        this.myLayerManager= myLayerManager;
        this.myMnistDataBaseFileReader= myMnistDataBaseFileReader;
    }
    public void train(int epochs){
        for (int i = 0; i <= epochs; i++) {

            myMnistDataBaseFileReader.next();
            expectedLayer = myMnistDataBaseFileReader.getExpectedOutputArray();
            inputLayer = myMnistDataBaseFileReader.getInputArray();
            label = myMnistDataBaseFileReader.getLabel();
            

            train();

        }
    
    }
    public void train() {

        myLayerManager.setInputLayer(inputLayer);

        myLayerManager.setExpectedOutputArray(expectedLayer);
        // System.out.println(myLayerManager.listOfLayers.get(1));

        myLayerManager.forwardPropagate();
        // System.out.println(myLayerManager.listOfLayers.get(1));
//        System.out.println(myLayerManager.OutputLayer);

        myLayerManager.backwardPropagate();

        
       // System.out.println("value " + myLayerManager.OutputLayer.listOfNeurons.get(prediction));
      //  for(int i=0;i<=10;i++)
    System.out.println(myLayerManager.OutputLayer);
  // System.out.println(myLayerManager.OutputLayer.printWeights());
    }

    public static int getMostSignificantNeuronAsPrediction(LayerManager myLayerManager) {
        double temp = 0;
        int no = 0;
        for (int i = 0; i < myLayerManager.OutputLayer.listOfNeurons.size(); i++) {
            double val = myLayerManager.OutputLayer.listOfNeurons.get(i).activation;
            if (val > temp) {
                no = i;
                temp = val;
            }
        }
        return no;
    }

}
