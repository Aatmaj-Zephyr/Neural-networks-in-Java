import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MNISTDataBaseFileReader extends InputFileReader {
    // This class is custom made for the MNIST database Dataset
    public double[] expectedOutputArray;
    public double[] inputArray;
    public double label;
    public BufferedReader singleFileReader;
    public int outputLayerLength;

    MNISTDataBaseFileReader(String filename,int outputLayerLength) throws FileNotFoundException {
        super(filename);
        this.outputLayerLength= outputLayerLength;
        this.singleFileReader = new BufferedReader(new FileReader(filename));
    }

    public double getLabel() {
        return label;
    }

    public void next() {
        double[] array;
        try {
            array = readLineToDoubleArray();
            label = array[0];
            expectedOutputArray = generateExpectedOutputArrayFromLabel();
            inputArray = generateInputFromBigArray(array);

        } catch (IOException ex) {
        }
    }

    public double[] readLineToDoubleArray() throws IOException {
        String line = singleFileReader.readLine();
        String[] arrayOfStrings = line.split(","); // CSV files are seperate dby Commas
        return convertStringArrayToDoubleArray(arrayOfStrings);
    }

    private double[] convertStringArrayToDoubleArray(String[] arrayOfStrings) {
        double[] arrayOfDouble = new double[arrayOfStrings.length];
        for (int i = 0; i < arrayOfStrings.length; i++) {
            arrayOfDouble[i] = Double.parseDouble(arrayOfStrings[i]);
        }
        return arrayOfDouble;
    }

    public double[] getExpectedOutputArray() {
        return expectedOutputArray;

    }

    public double[] getInputArray() {
        return inputArray;
    }

    public double[] generateExpectedOutputArrayFromLabel() {
        double[] expectedOutputArray = new double[outputLayerLength];
        for (int i = 0; i < 10; i++) {
            if(i==0){
                expectedOutputArray[0]=1; //Top circle
                expectedOutputArray[1]=1; //Bottom circle
                expectedOutputArray[2]=0; //Straight Line
                expectedOutputArray[3]=0; //Top horizontal line 
                expectedOutputArray[4]=0; //Bottom horizontal line 
                expectedOutputArray[5]=0; //mid horizontal line 

            }
            else if(i==1){
                expectedOutputArray[0]=0; //Top circle
                expectedOutputArray[1]=0; //Bottom circle
                expectedOutputArray[2]=1; //Straight Line
                expectedOutputArray[3]=0; //Top horizontal line 
                expectedOutputArray[4]=0; //Bottom horizontal line 
                expectedOutputArray[5]=0; //mid horizontal line 
                
            }
            else if(i==2){
                expectedOutputArray[0]=0; //Top circle
                expectedOutputArray[1]=0; //Bottom circle
                expectedOutputArray[2]=1; //Straight Line
                expectedOutputArray[3]=1; //Top horizontal line 
                expectedOutputArray[4]=1; //Bottom horizontal line 
                expectedOutputArray[5]=0; //mid horizontal line 

            }
            else if(i==3){
                expectedOutputArray[0]=0; //Top circle
                expectedOutputArray[1]=0; //Bottom circle
                expectedOutputArray[2]=0; //Straight Line
                expectedOutputArray[3]=1; //Top horizontal line 
                expectedOutputArray[4]=1; //Bottom horizontal line 
                expectedOutputArray[5]=1; //mid horizontal line 

            }
            else if(i==4){
                expectedOutputArray[0]=1; //Top circle
                expectedOutputArray[1]=0; //Bottom circle
                expectedOutputArray[2]=1; //Straight Line
                expectedOutputArray[3]=0; //Top horizontal line 
                expectedOutputArray[4]=0; //Bottom horizontal line 
                expectedOutputArray[5]=1; //mid horizontal line 

            }

            else if(i==5){
                expectedOutputArray[0]=0; //Top circle
                expectedOutputArray[1]=1; //Bottom circle
                expectedOutputArray[2]=0; //Straight Line
                expectedOutputArray[3]=1; //Top horizontal line 
                expectedOutputArray[4]=0; //Bottom horizontal line 
                expectedOutputArray[5]=1; //mid horizontal line 

            }
            else if(i==6){
                expectedOutputArray[0]=0; //Top circle
                expectedOutputArray[1]=1; //Bottom circle
                expectedOutputArray[2]=1; //Straight Line
                expectedOutputArray[3]=0; //Top horizontal line 
                expectedOutputArray[4]=0; //Bottom horizontal line 
                expectedOutputArray[5]=0; //mid horizontal line 

            }
            else if(i==7){
                expectedOutputArray[0]=0; //Top circle
                expectedOutputArray[1]=0; //Bottom circle
                expectedOutputArray[2]=1; //Straight Line
                expectedOutputArray[3]=1; //Top horizontal line 
                expectedOutputArray[4]=0; //Bottom horizontal line 
                expectedOutputArray[5]=0; //mid horizontal line 

            }

            else if(i==8){
                expectedOutputArray[0]=1; //Top circle
                expectedOutputArray[1]=1; //Bottom circle
                expectedOutputArray[2]=0; //Straight Line
                expectedOutputArray[3]=0; //Top horizontal line 
                expectedOutputArray[4]=0; //Bottom horizontal line 
                expectedOutputArray[5]=0; //mid horizontal line 

            }
            else if(i==9){
                expectedOutputArray[0]=1; //Top circle
                expectedOutputArray[1]=0; //Bottom circle
                expectedOutputArray[2]=1; //Straight Line
                expectedOutputArray[3]=0; //Top horizontal line 
                expectedOutputArray[4]=0; //Bottom horizontal line 
                expectedOutputArray[5]=0; //mid horizontal line 

            }
        }
        // go to next line
        return expectedOutputArray;
    }

    public double[] generateInputFromBigArray(double[] array) {
        // generates the input array from the total array , that is it excludes the
        // first element of the array
        double[] inputArray = new double[array.length-1];
        for (int i = 0; i < array.length-1; i++) {
            inputArray[i] = array[i + 1] / 256;
        }
        return inputArray;
    }

}
