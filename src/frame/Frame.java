package frame;

import exponential.Exponential;
import liner.Liner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private static int numberOfElement;
    private static int itemElement;
    private static int firstElement;
    private static int differenceOfSeries;
    private static String nameOfFile;
    private JLabel elementsLabel;
    private JLabel elements;
    private JLabel itemOfElements;
    private JLabel elementsLabelEx;
    private JLabel elementsEx;
    private JLabel itemOfElementsEx;
    JComboBox box;
    String[] series = {"Linear", "Exponential"};

    public Frame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 500);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        GridLayout gridLayout = new GridLayout(0, 2, 10, 12);
        panel.setLayout(gridLayout);
        JLabel numberOfElementLabel = new JLabel("Enter the number of elements of the progression");
        panel.add(numberOfElementLabel);
        JTextField numberOfElementField = new JTextField(5);
        panel.add(numberOfElementField);

        JLabel firstElementLabel = new JLabel("Enter first element");
        panel.add(firstElementLabel);
        JTextField firstElementField = new JTextField(5);
        panel.add(firstElementField);

        JLabel differenceOfSeriesLabel = new JLabel("Enter difference of progression");
        panel.add(differenceOfSeriesLabel);
        JTextField differenceOfSeriesField = new JTextField(5);
        panel.add(differenceOfSeriesField);

        JLabel itemElementLabel = new JLabel("Enter the number of the progression element");
        panel.add(itemElementLabel);
        JTextField itemElementField = new JTextField(5);
        panel.add(itemElementField);

        JLabel nameOfFileLabel = new JLabel("Enter the name of file");
        panel.add(nameOfFileLabel);
        JTextField nameOfFileField = new JTextField(5);
        panel.add(nameOfFileField);

        JButton okElement = new JButton("OK");
        panel.add(okElement);


        okElement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    firstElement = Integer.parseInt(firstElementField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Please, enter the correct first element");
                }
                try {
                    numberOfElement = Integer.parseInt(numberOfElementField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Please, enter the correct number of elements of the progression");
                }
                try {
                    differenceOfSeries = Integer.parseInt(differenceOfSeriesField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Please, enter the correct, difference of Series");
                }
                try {
                    itemElement = Integer.parseInt(itemElementField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Please, enter the correct number of progression element");
                }
                nameOfFile = nameOfFileField.getText();
            }
        });

        box = new JComboBox<>(series);
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(box.getSelectedIndex() == 0) {
                    if(elementsLabelEx != null && elementsEx != null && itemOfElementsEx != null) {
                        panel.remove(elementsLabelEx);
                        panel.remove(elementsEx);
                        panel.remove(itemOfElementsEx);
                    }
                    if(elementsLabel != null && elements != null && itemOfElements != null) {
                        panel.remove(elementsLabel);
                        panel.remove(elements);
                        panel.remove(itemOfElements);
                    }
                    Liner liner = new Liner(firstElement, numberOfElement, differenceOfSeries);
                    liner.savingToFile(liner, nameOfFile);
                    liner.setItemOfElement(itemElement);
                    elementsLabel = new JLabel("Elements of series: ");
                    panel.add(elementsLabel);
                    elements = new JLabel(liner.toString() + " ");
                    panel.add(elements);
                    itemOfElements = new JLabel("Element of progression: " + liner.calculatingJElement(itemElement));
                    panel.add(itemOfElements);

                }
                if(box.getSelectedIndex() == 1) {
                    if(elementsLabel != null && elements != null && itemOfElements != null) {
                        panel.remove(elementsLabel);
                        panel.remove(elements);
                        panel.remove(itemOfElements);
                    }
                    if(elementsLabelEx != null && elementsEx != null && itemOfElementsEx != null) {
                        panel.remove(elementsLabelEx);
                        panel.remove(elementsEx);
                        panel.remove(itemOfElementsEx);
                    }
                    Exponential exponential = new Exponential(firstElement, numberOfElement, differenceOfSeries);
                    exponential.savingToFile(exponential, nameOfFile);
                    elementsLabelEx = new JLabel("Elements of series: ");
                    panel.add(elementsLabelEx);
                    elementsEx = new JLabel(exponential.toString() + " ");
                    panel.add(elementsEx);
                    itemOfElementsEx = new JLabel("Element of progression: " + exponential.calculatingJElement(itemElement));
                    panel.add(itemOfElementsEx);
                }
                panel.revalidate();
            }
        });

        panel.add(box);
        add(panel);
        pack();
        setVisible(true);
    }
}
