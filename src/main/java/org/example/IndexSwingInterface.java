package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class IndexSwingInterface {

    public IndexSwingInterface() {
        // главное окно
        JFrame frame = new JFrame("Индексация");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // поле для ввода строк
        JTextField inputField = new JTextField(20);
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        JButton parseButton = new JButton("Парсить");

        // Обработка нажатия кнопки
        parseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();

                String[] sequences = inputText.split("\\s*,\\s*(?=\")");

                // Убираем лишние кавычки
                for (int i = 0; i < sequences.length; i++) {
                    sequences[i] = sequences[i].replaceAll("\"", "").trim();
                }

                // Парсинг строк в списки
                List<List<Integer>> parsedIndexes = IndexParser.parseIndexes(sequences);
                List<List<Integer>> combinations = CombinationGenerator.generateCombinations(parsedIndexes);

                // Формирование результата для вывода
                StringBuilder resultText = new StringBuilder();
                resultText.append("Результат:\n");
                for (List<Integer> combination : combinations) {
                    resultText.append(combination.toString()).append("\n");
                }
                resultArea.setText(resultText.toString());
            }
        });


        JPanel panel = new JPanel();
        panel.add(new JLabel("Ввод:"));
        panel.add(inputField);
        panel.add(parseButton);


        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, new JScrollPane(resultArea));


        frame.setVisible(true);
    }
}

