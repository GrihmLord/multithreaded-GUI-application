import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.concurrent.*;

public class EnhancedNoteApp {
    private JFrame frame;
    private JTextArea noteTextArea;
    private JTextField fileNameField;
    private JLabel wordCountLabel, timerLabel;
    private JButton saveButton, darkModeButton;
    private volatile boolean isTyping = false;
    private ScheduledExecutorService scheduler;
    private boolean darkMode = false;
    private int inactivityTime = 60; // Default 1-minute inactivity timer

    public EnhancedNoteApp() {
        frame = new JFrame("Enhanced Note App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setLayout(new BorderLayout());

        // UI Components
        noteTextArea = new JTextArea();
        noteTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        noteTextArea.setBackground(Color.WHITE);
        noteTextArea.setForeground(Color.BLACK);

        fileNameField = new JTextField("Enter filename here...");
        saveButton = new JButton("Save Note");
        darkModeButton = new JButton("Dark Mode");

        wordCountLabel = new JLabel("Word Count: 0");
        timerLabel = new JLabel("Inactivity Time: " + inactivityTime + "s");

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(fileNameField, BorderLayout.CENTER);
        topPanel.add(saveButton, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.add(wordCountLabel);
        bottomPanel.add(timerLabel);
        bottomPanel.add(darkModeButton);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(noteTextArea), BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Event Listeners
        noteTextArea.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                isTyping = true;
                updateWordCount();
            }
        });

        saveButton.addActionListener(e -> saveNote());
        darkModeButton.addActionListener(e -> toggleDarkMode());

        // Start Thread Executor
        scheduler = Executors.newScheduledThreadPool(2);
        scheduler.scheduleAtFixedRate(this::checkInactivity, 0, 10, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(this::autoSave, 30, 30, TimeUnit.SECONDS);

        frame.setVisible(true);
    }

    private void checkInactivity() {
        if (!isTyping) {
            SwingUtilities.invokeLater(this::showBreakDialog);
        }
        isTyping = false;
    }

    private void showBreakDialog() {
        int choice = JOptionPane.showOptionDialog(
                frame,
                "Do you need a break?",
                "Inactivity Alert",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Yes, break!", "No, continue."},
                "No, continue."
        );

        if (choice == JOptionPane.YES_OPTION) {
            if (fileNameField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please provide a filename before saving!");
            } else {
                saveNote();
            }
        }
    }

    private void saveNote() {
        String fileName = fileNameField.getText().trim();
        if (fileName.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Filename cannot be empty!");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(noteTextArea.getText());
            JOptionPane.showMessageDialog(frame, "Note saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving file: " + e.getMessage());
        }
    }

    private void autoSave() {
        String fileName = fileNameField.getText().trim();
        if (!fileName.isEmpty()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(noteTextArea.getText());
                System.out.println("Auto-saved at: " + System.currentTimeMillis());
            } catch (IOException e) {
                System.err.println("Auto-save failed: " + e.getMessage());
            }
        }
    }

    private void updateWordCount() {
        SwingUtilities.invokeLater(() -> {
            String text = noteTextArea.getText().trim();
            int wordCount = text.isEmpty() ? 0 : text.split("\\s+").length;
            wordCountLabel.setText("Word Count: " + wordCount);
        });
    }

    private void toggleDarkMode() {
        darkMode = !darkMode;
        if (darkMode) {
            noteTextArea.setBackground(Color.DARK_GRAY);
            noteTextArea.setForeground(Color.WHITE);
            fileNameField.setBackground(Color.BLACK);
            fileNameField.setForeground(Color.WHITE);
            frame.getContentPane().setBackground(Color.BLACK);
            darkModeButton.setText("Light Mode");
        } else {
            noteTextArea.setBackground(Color.WHITE);
            noteTextArea.setForeground(Color.BLACK);
            fileNameField.setBackground(Color.WHITE);
            fileNameField.setForeground(Color.BLACK);
            frame.getContentPane().setBackground(Color.WHITE);
            darkModeButton.setText("Dark Mode");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EnhancedNoteApp::new);
    }
}
