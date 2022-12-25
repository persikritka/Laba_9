package exponential;

import series.Series;

public class Exponential extends Series {
    private int differenceOfExponentialProgression;

    public Exponential(){};

    public Exponential(int firstElement, int numberOfElement, int differenceOfExponentialProgression) {
        this.firstElement = firstElement;
        this.numberOfElement = numberOfElement;
        this.differenceOfExponentialProgression = differenceOfExponentialProgression;
    }


    public void setDifferenceOfExponentialProgression(int differenceOfExponentialProgression) {
        this.differenceOfExponentialProgression = differenceOfExponentialProgression;
    }

    public void setItemElement(int itemElement) {
        this.itemElement = itemElement;
    }

    public void setFirstElement(int firstElement) {
        this.firstElement = firstElement;
    }

    public void setNumberOfElement(int numberOfElement) {
        this.numberOfElement = numberOfElement;
    }

    public int getFirstElement() {
        return super.firstElement;
    }

    public int getNumberOfElement() {
        return super.numberOfElement;
    }

    public int getDifferenceOfExponentialProgression() {
        return differenceOfExponentialProgression;
    }

    public int getItemElement() {
        return super.itemElement;
    }

    @Override
    public int calculatingJElement(int itemElement) {
        int element = firstElement;
        if(itemElement == 1) {
            return firstElement;
        } else {
            for(int i = 1; i < itemElement; i++) {
                element = element * differenceOfExponentialProgression;
            }
        }
        return element;
    }

    public int calculatingElement(int numberOfElement) {
        int element = firstElement;
        for(int i = 0; i < numberOfElement; i++) {
            element = element * differenceOfExponentialProgression;
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
        String result = "";
        for(int i = 0; i < numberOfElement; i++) {
            result += (i+1) + " element: " + calculatingElement(i) + "; ";
        }
        return result;
    }
}
