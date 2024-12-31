import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CourierServiceApp {
    private ArrayList<Courier> couriers;
    private JFrame frame;

    public CourierServiceApp() {
        couriers = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Courier Service Management System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel senderLabel = new JLabel("Sender Name:");
        JTextField senderField = new JTextField();
        
        JLabel receiverLabel = new JLabel("Receiver Name:");
        JTextField receiverField = new JTextField();

        JLabel addressLabel = new JLabel("Delivery Address:");
        JTextField addressField = new JTextField();

        JButton bookButton = new JButton("Book Courier");
        JButton trackButton = new JButton("Track Courier");

        panel.add(senderLabel);
        panel.add(senderField);
        panel.add(receiverLabel);
        panel.add(receiverField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(bookButton);
        
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sender = senderField.getText();
                String receiver = receiverField.getText();
                String address = addressField.getText();
                if (!sender.isEmpty() && !receiver.isEmpty() && !address.isEmpty()) {
                    couriers.add(new Courier(sender, receiver, address));
                    JOptionPane.showMessageDialog(frame, "Courier booked successfully!");
                    senderField.setText("");
                    receiverField.setText("");
                    addressField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields.");
                }
            }
        });

        trackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder trackingInfo = new StringBuilder("Current Couriers:\n");
                for (Courier courier : couriers) {
                    trackingInfo.append(courier.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, trackingInfo.toString());
            }
        });

        panel.add(trackButton);

        frame.add(panel, BorderLayout.CENTER); 
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CourierServiceApp());
    }
}