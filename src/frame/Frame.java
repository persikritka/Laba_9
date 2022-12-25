package frame;

import exponential.Exponential;
import liner.Liner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Frame extends JFrame {
    private static int numberOfElement;
    private static String chooseSeries;
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
        setBounds(100, 100, 500, 300);

        JPanel panel = new JPanel(new FlowLayout());
        JLabel numberOfElementLabel = new JLabel("Enter the number of elements of the progression");
        panel.add(numberOfElementLabel);
        JTextField numberOfElementField = new JTextField(10);
        panel.add(numberOfElementField);
        JButton okNumber = new JButton("OK");
        panel.add(okNumber);
        okNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberOfElement = Integer.parseInt(numberOfElementField.getText());
            }
        });

        JLabel firstElementLabel = new JLabel("Enter first element");
        panel.add(firstElementLabel);
        JTextField firstElementField = new JTextField(30);
        panel.add(firstElementField);
        JButton okElement = new JButton("OK");
        panel.add(okElement);
        okElement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstElement = Integer.parseInt(firstElementField.getText());
            }
        });

        JLabel differenceOfSeriesLabel = new JLabel("Enter difference of progression");
        panel.add(differenceOfSeriesLabel);
        JTextField differenceOfSeriesField = new JTextField(20);
        panel.add(differenceOfSeriesField);
        JButton differenceOfSeriesButton = new JButton("OK");
        panel.add(differenceOfSeriesButton);
        differenceOfSeriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                differenceOfSeries = Integer.parseInt(differenceOfSeriesField.getText());
            }
        });

        JLabel itemElementLabel = new JLabel("Enter the number of the progression element");
        panel.add(itemElementLabel);
        JTextField itemElementField = new JTextField(10);
        panel.add(itemElementField);
        JButton itemElementButton = new JButton("OK");
        panel.add(itemElementButton);
        itemElementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemElement = Integer.parseInt(itemElementField.getText());
            }
        });

        JLabel nameOfFileLabel = new JLabel("Enter the name of file");
        panel.add(nameOfFileLabel);
        JTextField nameOfFileField = new JTextField(10);
        panel.add(nameOfFileField);
        JButton nameOfFileButton = new JButton("OK");
        panel.add(nameOfFileButton);
        nameOfFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameOfFile = nameOfFileField.getText();
            }
        });

        box = new JComboBox<>(series);
        //panel.add(box);
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(box.getSelectedIndex() == 0) {
                    if(elementsLabelEx != null && elementsEx != null && itemOfElementsEx != null) {
                        panel.remove(elementsLabelEx);
                        panel.remove(elementsEx);
                        panel.remove(itemOfElementsEx);
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
        setVisible(true);
    }
}
