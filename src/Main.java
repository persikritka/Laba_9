import exponential.Exponential;
import liner.Liner;

public class Main {
    public static void main (String args[]) {
        Liner liner = new Liner();
        Exponential exponential = new Exponential();
        exponential.setFirstElement(1);
        exponential.setNumberOfElement(5);
        exponential.setDifferenceOfExponentialProgression(2);
        System.out.println(exponential);
        System.out.println(exponential.sum());
       System.out.println(exponential.calculatingJElement(5));
       exponential.savingToFile(exponential);
    }
}
