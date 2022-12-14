import java.util.*;

abstract class Layer {
    public ArrayList<Neuron> listOfNeurons = new ArrayList<Neuron>();
    public int layerNum;
    public NeuronBehaviour myBehaviour;

    Layer(int numOfNeurons) {
        this.setBehaviour();

        // aggregation
        // Creating a new neuron and adding it to the list of neurons.
        for (int i = 0; i < numOfNeurons; i++) {
            Neuron newNeuron = new Neuron();
            newNeuron.setNeuronNum(i);
            newNeuron.setBehaviour(myBehaviour);
            addNeuron(newNeuron);
        }
    }

    public abstract void setBehaviour();
    /*
         * The delta of each neuron will be different accouding to it's type, that is if
         * it belongs to hidden layer or the output layer.
         * Hence we make a abstract method to calculate the delta of each neuron.
         * It will be implemented by the behaviours of concrete implementations of Neuron behaviour
         * For calculating the delta of each neuron, the activation value will be
         * required. Also the actual expected value will be required. 
         * Each implementation of the method will differ according to the formula.
         * This will be implemented to Strategy pattern.
         */

    public ArrayList<Neuron> getListOfNeurons() {
        return listOfNeurons;
    }

    public void setLayerNum(int layerNum) {
        // Setting the layer number for each neuron in the layer.
        this.layerNum = layerNum;
        for (Neuron i : listOfNeurons) {
            i.setLayerNum(layerNum);
        }
    }

    public void addNeuron(Neuron toBeAdded) {
        listOfNeurons.add(toBeAdded);
    }

    public void forwardPropagate() {
        // Iterating through the list of neurons and calling the forwardPropagate method
        // on each neuron.
        for (Neuron i : listOfNeurons) {
            i.forwardPropagate();
        }
    }

    public String toString() {
        String str = "Layer #" + layerNum + " has Length: " + listOfNeurons.size() + "\n";
        for (Neuron i : listOfNeurons) {
            str += i.toString();

        }
        return str + "\n";
    }

    public String printWeights() {
        String s = "";
        for (Neuron i : listOfNeurons) {
            s += i.leftConnections.toString();
        }
        return s;
    }

    public void backwardPropagate() {
        // Iterating through the list of neurons and calling the backwardPropagate
        // method
        // on each neuron.
        for (Neuron i : listOfNeurons) {
            i.backwardPropagate();
        }
       
    }

     

}
