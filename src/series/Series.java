package series;

import exponential.Exponential;
import liner.Liner;

import java.io.FileWriter;
import java.io.IOException;

public abstract class Series {
    protected int jElement;
    protected int sum;
    protected int firstElement;
    protected int itemElement;
    protected int numberOfElement;

    public abstract int calculatingJElement(int numberOfElement);
    public int sum(){return sum;};

    public String toString() {

        return null;
    }

    public void savingToFile(Object obj, String nameOfFile) {
        if(obj.getClass() == Liner.class) {
            Liner liner = (Liner)obj;
            try(FileWriter filewriter = new FileWriter(nameOfFile, false)) {
                String linerString = liner.toString();
                filewriter.write(linerString);
                String sumOfLinearSeries = "Sum of linear series: " + Integer.toString(liner.sum());
                filewriter.write(sumOfLinearSeries);
                filewriter.flush();

            } catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (obj.getClass() == Exponential.class) {
            Exponential exponential = (Exponential)obj;
            try(FileWriter filewriter = new FileWriter(nameOfFile, false)) {
                String exponentialString = exponential.toString();
                filewriter.write(exponentialString);
                filewriter.write(System.lineSeparator());
                String sumOfExponentialSeries = "Sum of exponential series: " + Integer.toString(exponential.sum());
                filewriter.write(sumOfExponentialSeries);
                filewriter.flush();
            } catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}
