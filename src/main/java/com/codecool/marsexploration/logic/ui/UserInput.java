package com.codecool.marsexploration.logic.ui;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.SimulationInput;

import javax.swing.*;

public class UserInput {
    public SimulationInput getConfiguration() {
        SimulationInput configuration = null;
        boolean isValid = false;

        while (!isValid){
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JTextField mapPathField = new JTextField(10);
            mapPathField.setText("src/main/resources/exploration-1.map");
            JTextField roverIdField = new JTextField(10);
            roverIdField.setText("1");
            JTextField timeoutField = new JTextField(10);
            timeoutField.setText("200");
            JTextField roverSightField = new JTextField(10);
            roverSightField.setText("10");
            JTextField mineralCountField = new JTextField(10);
            mineralCountField.setText("2");
            JTextField waterCountField = new JTextField(10);
            waterCountField.setText("2");
            JTextField roverPositionXField = new JTextField(10);
            roverPositionXField.setText("12");
            JTextField roverPositionYField = new JTextField(10);
            roverPositionYField.setText("12");
            JTextField logPathField = new JTextField(10);
            logPathField.setText("src/main/resources/exploration-11.log");

            panel.add(new JLabel("Map path:"));
            panel.add(mapPathField);
            panel.add(new JLabel("Rover id:"));
            panel.add(roverIdField);
            panel.add(new JLabel("Timeout:"));
            panel.add(timeoutField);
            panel.add(new JLabel("Rover's sight range:"));
            panel.add(roverSightField);
            panel.add(new JLabel("Number of minerals to collect:"));
            panel.add(mineralCountField);
            panel.add(new JLabel("Number of bodies of water to collect:"));
            panel.add(waterCountField);
            panel.add(new JLabel("Rover's position coordinate X:"));
            panel.add(roverPositionXField);
            panel.add(new JLabel("Rover's position coordinate Y:"));
            panel.add(roverPositionYField);
            panel.add(new JLabel("Log path:"));
            panel.add(logPathField);

            int result = JOptionPane.showConfirmDialog(null, panel, "Enter Map Configuration",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {

                if (timeoutField.getText().matches("^-?\\d+(\\.\\d+)?$") &&
                        roverSightField.getText().matches("^-?\\d+(\\.\\d+)?$") &&
                        mineralCountField.getText().matches("^-?\\d+$") &&
                        waterCountField.getText().matches("^-?\\d+$") &&
                        roverPositionXField.getText().matches("^-?\\d+$") &&
                        roverPositionYField.getText().matches("^-?\\d+$")
                ) {
                    String mapPath = mapPathField.getText();
                    String roverId = roverIdField.getText();
                    int timeout = Integer.parseInt(timeoutField.getText());
                    int roverSight = Integer.parseInt(roverSightField.getText());
                    int mineralCount = Integer.parseInt(mineralCountField.getText());
                    int waterCount = Integer.parseInt(waterCountField.getText());
                    int xCoord = Integer.parseInt(roverPositionXField.getText());
                    int yCoord = Integer.parseInt(roverPositionYField.getText());
                    String logPath = logPathField.getText();

                    configuration = new SimulationInput(mapPath, roverId, roverSight, new Coordinate(xCoord, yCoord), mineralCount, waterCount, timeout, logPath);
                    isValid = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                }
            } else {
                break;
            }
        }
        return configuration;
    }
}
