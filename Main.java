
public class Main {
	public static void main(String[] args) {
		System.out.println("Hello World");
		parameter.setLayerArray(784,16,16,6);
		parameter.setTrainingFileReader("mnist_train.csv", "mnist"); 
		parameter.setTestingFileReader("mnist_test.csv", "mnist"); 
		parameter.setLearningRate(1);
		parameter.setBiasLearningRate(1);
		parameter.setEpsillion(0);
		parameter.setBatchsize(5);
		parameter.setRectificationFunction("sigmoid");
		Trainer myTrainer = new Trainer();
		myTrainer.train(50000);
		myTrainer.test(2);

			// System.out.println(LayerManager.ConnectionHeap);

		

	}
}
