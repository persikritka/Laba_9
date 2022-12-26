package liner;

import series.Series;

public class Liner extends Series {

    private int differenceOfArithmeticProgression;

    public Liner(){};

    public Liner(int firstElement, int numberOfElement, int differenceOfArithmeticProgression) {
        this.firstElement = firstElement;
        this.numberOfElement = numberOfElement;
        this.differenceOfArithmeticProgression = differenceOfArithmeticProgression;
    }

    public void setDifferenceOfArithmeticProgression(int differenceOfArithmeticProgression) {
        this.differenceOfArithmeticProgression = differenceOfArithmeticProgression;
    }

    public void setFirstElement(int firstElement) {
        this.firstElement = firstElement;
    }

    public void setNumberOfElement(int numberOfElement) {
        this.numberOfElement = numberOfElement;
    }

    public void setItemOfElement(int itemElement) {
        this.itemElement = itemElement;
    }

    public int getFirstElement() {
        return super.firstElement;
    }

    public int getItemOfElement() {
        return super.itemElement;
    }

    public int getDifferenceOfArithmeticProgression() {
        return differenceOfArithmeticProgression;
    }

    public int getNumberOfElement() {
        return super.numberOfElement;
    }

    public int calculatingJElement(int itemElement) {
        int element = firstElement;
        if(itemElement == 1)
            return firstElement;
        else {
            for (int i = 1; i < itemElement; i++) {
                element = element +  differenceOfArithmeticProgression;
            }
        }

        return element;
    }

    public int calculatingElement(int numberOfElement) {
        int element = firstElement;
        for(int i = 0; i < numberOfElement; i++) {
            element = element +  differenceOfArithmeticProgression;
        }
        return element;
    }

    public int sum() {
        int sum = 0;
        for(int i = 0; i < numberOfElement; i++) {
            sum += calculatingElement(i);
        }
        return sum;
    }

    @Override
    public String toString() {
        String result = "(";
        for(int i = 0; i < numberOfElement; i++) {
            if(i == (numberOfElement - 1) )
                result += calculatingElement(i);
            if(i < (numberOfElement - 1))
                result += (calculatingElement(i) + ", ");
        }
        result += ")";
        return result;
    }
}
