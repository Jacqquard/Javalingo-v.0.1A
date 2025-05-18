import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.ArrayList;

public class Main extends JFrame implements ActionListener {
    private JTextArea inputText;
    private JTextArea outputText;
    private JButton translateButton;
    private JButton clearHistoryButton;
    private DefaultListModel<String> historyModel;
    private JList<String> historyList;
    private HashMap<String, String> dictionary;

    public Main() {
        super("Javalingo");
        dictionary = new HashMap<>();
        fillDictionary();

        inputText = new JTextArea(4, 30);
        inputText.setLineWrap(true);
        inputText.setWrapStyleWord(true);
        inputText.setFont(new Font("Arial", Font.PLAIN, 16));

        outputText = new JTextArea(4, 30);
        outputText.setLineWrap(true);
        outputText.setWrapStyleWord(true);
        outputText.setFont(new Font("Arial", Font.PLAIN, 16));
        outputText.setEditable(false);
        outputText.setForeground(Color.BLUE);

        translateButton = new JButton("Translate");
        translateButton.setFont(new Font("Arial", Font.BOLD, 18));
        translateButton.addActionListener(this);

        clearHistoryButton = new JButton("Clear History");
        clearHistoryButton.setFont(new Font("Arial", Font.PLAIN, 16));
        clearHistoryButton.addActionListener(this);

        historyModel = new DefaultListModel<>();
        historyList = new JList<>(historyModel);
        historyList.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane historyScrollPane = new JScrollPane(historyList);
        historyScrollPane.setBorder(BorderFactory.createTitledBorder("Translation History"));

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter text in English..."));
        inputPanel.add(new JScrollPane(inputText), BorderLayout.CENTER);

        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.setBorder(BorderFactory.createTitledBorder("Translation to Russian..."));
        outputPanel.add(new JScrollPane(outputText), BorderLayout.CENTER);

        JPanel eastPanel = new JPanel(new BorderLayout());
        eastPanel.add(historyScrollPane, BorderLayout.CENTER);
        eastPanel.add(clearHistoryButton, BorderLayout.SOUTH);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(translateButton, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);
        add(eastPanel, BorderLayout.EAST);

        setSize(800, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void fillDictionary() {
        dictionary.put("hello", "привет");
        dictionary.put("world", "мир");
        dictionary.put("my", "мой");
        dictionary.put("name", "имя");
        dictionary.put("i", "я");
        dictionary.put("you", "ты");
        dictionary.put("today", "сегодня");
        dictionary.put("cat", "кот");
        dictionary.put("apple", "яблоко");
        dictionary.put("book", "книга");
        dictionary.put("dog", "собака");
        dictionary.put("friend", "друг");
        dictionary.put("family", "семья");
        dictionary.put("school", "школа");
        dictionary.put("good", "хороший");
        dictionary.put("time", "время");
        dictionary.put("work", "робота");
        dictionary.put("city", "город");
        dictionary.put("country", "страна");
        dictionary.put("love", "любовь");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == translateButton) {
            String inputTextContent = inputText.getText().toLowerCase().trim();
            if (inputTextContent.isEmpty()) {
                outputText.setText("Please enter text to translate");
                return;
            }

            String[] words = inputTextContent.split("\\s+");
            StringBuilder translation = new StringBuilder();
            for (String word : words) {
                String cleanedWord = word.replaceAll("[^a-z]", "");
                String translatedWord = dictionary.getOrDefault(cleanedWord, "[" + word + "]");
                translation.append(translatedWord).append(" ");
            }
            String result = translation.toString().trim();
            outputText.setText(result);
            if (!result.startsWith("[")) {
                 historyModel.addElement(inputTextContent + " -> " + result);
            } else if (words.length == 1 && result.equals("[" + words[0] + "]")) {

            } else {
                 historyModel.addElement(inputTextContent + " -> " + result);
            }


        } else if (source == clearHistoryButton) {
            historyModel.clear();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}