import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;


public class LoginPage implements ActionListener {
//Q: What does ActionListener do?
//A: ActionListener is an interface that is used to perform an action when an event occurs.

JFrame frame = new JFrame();
JButton loginButton = new JButton("Login");
JButton resetButton = new JButton("Reset");
JTextField userIDField = new JTextField();
JPasswordField passwordField = new JPasswordField();
JLabel userIDLabel = new JLabel("userID: ");
JLabel userPasswordLabel = new JLabel("Password ");
JLabel messageLabel = new JLabel();



HashMap<String,String> logininfo=new HashMap<String,String>();
//Q: What is a HashMap?
//A: A HashMap is a data structure that stores data in key-value pairs. It is a part of the Java Collections Framework.

    LoginPage(HashMap<String,String> loginInfoOriginal){
        logininfo= loginInfoOriginal;
        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);
        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIDField.setBounds(125,100,200,25);
        passwordField.setBounds(125,150,200,25);


        loginButton.setBounds(125,200,100,25);
        loginButton.addActionListener(this);


     resetButton.setBounds(225,200,100,25);
        resetButton.addActionListener(this);


        frame.add(resetButton);
        frame.add(loginButton);
        frame.add(passwordField);
        frame.add(userIDField);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==resetButton){
            userIDField.setText("");
            passwordField.setText("");
            messageLabel.setText("");

        }
//Q. What is e.getSource()?
//A. e.getSource() is a method that returns the source of the event that occurred.

if(e.getSource()==loginButton){
    String userID=userIDField.getText();
    String password=String.valueOf(passwordField.getPassword());
    //Q. What is String.valueOf()?
    //A. String.valueOf() is a method that returns the string representation of the argument passed to it.
     
if(logininfo.containsKey(userID)){
    //Q. What is logininfo.containsKey()?
    //A. logininfo.containsKey() is a method that returns true if the map contains a mapping for the specified key.

    if(logininfo.get(userID).equals(password)){
        messageLabel.setForeground(Color.green);
        messageLabel.setText("Login Successful");
       // frame.dispose();
        //Q. What is frame.dispose()?
        //A. frame.dispose() is a method that closes the frame.
        WelcomeScreen welcomeScreen = new WelcomeScreen();
    }
}

    else{
        //Setting the messageLabel to red and displaying the message "Wrong Password"
        messageLabel.setForeground(Color.red);
        messageLabel.setText("Wrong Password");
       // stop at 23:47
       //https://www.youtube.com/watch?v=Hiv3gwJC5kw

      
    }

       
 
      

        
    
    
    
    
}
}
    }

