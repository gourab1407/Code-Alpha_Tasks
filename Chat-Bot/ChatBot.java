import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ChatBot extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private HashMap<String, String> responses;

    public ChatBot() {
        setTitle("AI ChatBot");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        sendButton = new JButton("Send");
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);

        responses = new HashMap<>();
        loadResponses();

        sendButton.addActionListener(e -> respond());
        inputField.addActionListener(e -> respond());
    }

    private void loadResponses() {
        responses.put("hi", "Hello! How can I help you?");
        responses.put("hello", "Hi there! What can I do for you?");
        responses.put("how are you", "I'm just a bot, but I'm doing fine!");
        responses.put("your name", "I am a Java-based AI chatbot.");
        responses.put("bye", "Goodbye! Have a nice day.");
        responses.put("help", "I can answer simple questions like 'hi', 'bye', or 'your name'.");
    }

    private void respond() {
        String userInput = inputField.getText().toLowerCase().trim();
        chatArea.append("You: " + userInput + "\n");
        inputField.setText("");

        String response = "Sorry, I didn't understand that.";

        for (String key : responses.keySet()) {
            if (userInput.contains(key)) {
                response = responses.get(key);
                break;
            }
        }

        chatArea.append("Bot: " + response + "\n\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ChatBot().setVisible(true);
        });
    }
}
