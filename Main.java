import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel firstLabel;
  JLabel secondLabel;

  JTextField firstInput;
  JTextField secondInput;

  JButton firstButton;
  JButton secondButton;
  


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    // initialize the main JPanel
    mainPanel = new JPanel();
    // disable any layout helpers
    mainPanel.setLayout(null);

    // initialize the labels
    firstLabel = new JLabel("Degrees Fahrenheit");
    secondLabel = new JLabel("Degrees Celsius"); 

    // set the size and location of the labels
    firstLabel.setBounds(10, 10, 250, 30);
    secondLabel.setBounds(10, 40, 250, 30);

    // initialize the text fields
    firstInput = new JTextField();
    secondInput = new JTextField();

    // set the location and size of text fields
    firstInput.setBounds(260, 10, 100, 20);
    secondInput.setBounds(260, 40, 100, 20);

    // initialize the buttons
    firstButton = new JButton("F -> C");
    secondButton = new JButton("C -> F");

    // set the location and size of the buttons
    firstButton.setBounds(400, 10, 150, 30);
    secondButton.setBounds(400, 40, 150, 30);

    // add an action listener to the buttons
    firstButton.addActionListener(this);
    secondButton.addActionListener(this);

    // add an action command to the buttons
    firstButton.setActionCommand("F -> C");
    secondButton.setActionCommand("C -> F");

    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);

    mainPanel.add(firstInput);
    mainPanel.add(secondInput);

    mainPanel.add(firstButton);
    mainPanel.add(secondButton);

    frame.add(mainPanel);
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    // do something depending on what button is pressed
    if(command.equals("F -> C")){
      // get the text from each text box
      String firstText = firstInput.getText();
      String secondText = secondInput.getText();

      // change the string into an integer
      int firstNum = Integer.parseInt(firstText);
      

      // convert Fahrenheit to Celsius
      int fToC = (firstNum - 32) * 5/9;
      // show the answer
      secondInput.setText("" + fToC);
    }else if(command.equals("C -> F")){
      // get the text from each text box
      String firstText = firstInput.getText();
      String secondText = secondInput.getText();

      // change the string into an integer
      
      int secondNum = Integer.parseInt(secondText);

      // convert Celsius to Fahrenheit
      int cToF = (secondNum*9/5) + 32;
      // show the answer
      firstInput.setText("" + cToF); 
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
