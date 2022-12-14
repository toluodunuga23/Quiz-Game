import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class Quiz implements ActionListener{
    
    String[] questions = {
        "What does www stand for?",
        "What is cynophobia",
        "What is the biggest tech company in South Korea",
        "What animal is seen on the Porsche logo"



    };

    String[][] options = {
            {"whowherewhy", "World Wide Web", "World Wide Work"},
            {"fear of cats", "fear of colors", "fear of dogs"},
            {"Samsung", "Amazon", "Apple"},
            {"Dog", "Cat", "Horse"},

                         };


char[] answers=         {
    'B',
    'C',
    'A',   
    'C'

};
// Quiz questions: https://www.quizbreaker.com/trivia-questions#general-trivia-questions

char guess;
char answer;
int index;
int correct_guess;
int correct_guesses=0;
int total_questions= questions.length;
int result;
int seconds=30;


// GUI Components
JFrame frame = new JFrame();
JTextField textfield= new JTextField();
JTextArea textarea= new JTextArea();
JButton  buttonA = new JButton();
JButton  buttonB = new JButton();
JButton  buttonC = new JButton();
JLabel answer_labelA= new JLabel();
JLabel answer_labelB= new JLabel();
JLabel answer_labelC= new JLabel();
JLabel time_label= new JLabel();
JLabel seconds_left = new JLabel();
JTextField number_right= new JTextField();
JTextField percentage = new JTextField();
// global variables
Timer timer = new Timer(1000, new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
        seconds--;
        seconds_left.setText(String.valueOf(seconds));
        
        if(seconds==10){
            seconds_left.setForeground(Color.BLUE);
        }

        if(seconds<=0){
            displayAnswer();
        }
    }
});





  public Quiz(){
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(680,700);
frame.getContentPane().setBackground(new Color(50,50,50));
frame.setLayout(null);
frame.setResizable(false);

textfield.setBounds(0,0,650,50);
textfield.setBackground(new Color(25,25,25));
textfield.setForeground(new Color(25,255,0));
textfield.setFont(new Font("Ink Free",Font.BOLD,30));
textfield.setBorder(BorderFactory.createBevelBorder(1));
textfield.setHorizontalAlignment(JTextField.CENTER);
textfield.setEditable(false);
textfield.setText("testing text");

textarea.setBounds(0,50,650,50);
textarea.setLineWrap(true);
textarea.setWrapStyleWord(true);
textarea.setBackground(new Color(25,25,25));
textarea.setForeground(new Color(25,255,0));
textarea.setFont(new Font("MV Boli",Font.BOLD,25));
textarea.setBorder(BorderFactory.createBevelBorder(1));
textarea.setEditable(false);



buttonA.setBounds(0,100,100,100);
buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
buttonA.setFocusable(false);
buttonA.addActionListener(this);
buttonA.setText("A");

buttonB.setBounds(0,200,100,100);
buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
buttonB.setFocusable(false);
buttonB.addActionListener(this);
buttonB.setText("B");

buttonC.setBounds(0,300,100,100);
buttonC.setFont(new Font("MV Boli",Font.BOLD,35));
buttonC.setFocusable(false);
buttonC.addActionListener(this);
buttonC.setText("C");


answer_labelA.setBounds(125,100,500,100);
answer_labelA.setBackground(new Color(50,50,50));
answer_labelA.setForeground(new Color(25,255,0));
answer_labelA.setFont(new Font("MV Boli",Font.PLAIN,35));



answer_labelB.setBounds(125,200,500,100);
answer_labelB.setBackground(new Color(50,50,50));
answer_labelB.setForeground(new Color(25,255,0));
answer_labelB.setFont(new Font("MV Boli",Font.PLAIN,35));


answer_labelC.setBounds(125,300,500,100);
answer_labelC.setBackground(new Color(50,50,50));
answer_labelC.setForeground(new Color(25,255,0));
answer_labelC.setFont(new Font("MV Boli",Font.PLAIN,35));


seconds_left.setBounds(535,510,100,100);
seconds_left.setBackground(new Color(25,25,25));
seconds_left.setForeground(new Color(255,0,0));
seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
seconds_left.setBorder(BorderFactory.createBevelBorder(1));
seconds_left.setOpaque(true);
seconds_left.setHorizontalAlignment(JTextField.CENTER);
seconds_left.setText(String.valueOf(seconds));


time_label.setBounds(535,475,100,25);
time_label.setBackground(new Color(50,50,50));
time_label.setForeground(new Color(255,0,0));
time_label.setFont(new Font("MV Boli",Font.BOLD,21));
time_label.setBorder(BorderFactory.createBevelBorder(1));
time_label.setHorizontalAlignment(JTextField.CENTER);
time_label.setText("Timer");


number_right.setBounds(225,225,200,100);
number_right.setBackground(new Color(25,25,25));
number_right.setForeground(new Color(25,255,0));
number_right.setFont(new Font("Ink Free",Font.BOLD,50));
number_right.setBorder(BorderFactory.createBevelBorder(1));
number_right.setHorizontalAlignment(JTextField.CENTER);
number_right.setEditable(false);


percentage.setBounds(225,335,200,100);
percentage.setBackground(new Color(25,25,25));
percentage.setForeground(new Color(25,255,0));
percentage.setFont(new Font("Ink Free",Font.BOLD,50));
percentage.setBorder(BorderFactory.createBevelBorder(1));
percentage.setHorizontalAlignment(JTextField.CENTER);
percentage.setEditable(false);


frame.add(time_label);
frame.add(seconds_left);
frame.add(answer_labelA);
frame.add(answer_labelB);
frame.add(answer_labelC);
frame.add(buttonA);
frame.add(buttonB);
frame.add(buttonC);
frame.add(textarea);
frame.add(textfield);
frame.setVisible(true);

nextQuesiton();



    }
    public void nextQuesiton(){
        if(index>=total_questions){
            results();
            //Play again button
            JButton  playAgain= new JButton();
            playAgain.setBounds(225,425,200,100);
            playAgain.setFont(new Font("MV Boli",Font.BOLD,35));
            playAgain.setForeground(Color.BLUE);
            playAgain.setText("Play Again");
            frame.add(playAgain);
            frame.setVisible(true);
            playAgain.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Quiz quiz = new Quiz();
                    frame.dispose();
                   
                }
            });



        
             



    }
    else{
        textfield.setText("Question "+(index+1));
        textarea.setText(questions[index]);
        answer_labelA.setText(options[index][0]);
        answer_labelB.setText(options[index][1]);
        answer_labelC.setText(options[index][2]);
        timer.start();
        
    }
}

    public void actionPerformed(ActionEvent e){
    buttonA.setEnabled(false);
    buttonB.setEnabled(false);
    buttonC.setEnabled(false);

    if(e.getSource()==buttonA){
        answer= 'A';
        if(answer==answers[index]){
            correct_guesses++;
        }
    }

    if(e.getSource()==buttonB){
        answer= 'B';
        if(answer==answers[index]){
            correct_guesses++;
        }
    }

    if(e.getSource()==buttonC){
        answer= 'C';
        if(answer==answers[index]){
            correct_guesses++;
        }
    }
    displayAnswer();

    }

    public void displayAnswer(){
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);

        if(answers[index]!='A')
            answer_labelA.setForeground(new Color(255,0,0));

        if(answers[index]!='B')
            answer_labelB.setForeground(new Color(255,0,0));

        if(answers[index]!='C')
            answer_labelC.setForeground(new Color(255,0,0));

        Timer pause = new Timer(2000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                answer_labelA.setForeground(new Color(25,255,0));
                answer_labelB.setForeground(new Color(25,255,0));
                answer_labelC.setForeground(new Color(25,255,0));

                answer=' ';
                seconds=30;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                index++;
                nextQuesiton();
            }
        });
        pause.setRepeats(false);
        //Q: What does .setRepeats(false) do?
        //A: It makes the timer only run once
        pause.start();
        //Q: What does .start() do?
        //A: It starts the timer


    }

    public void results(){
buttonA.setEnabled(false);
buttonB.setEnabled(false);
buttonC.setEnabled(false);

result=(int)((correct_guesses/(double)total_questions)*100);
textfield.setText("RESULTS!");
textarea.setText("");
answer_labelA.setText("");
answer_labelB.setText("");
answer_labelC.setText("");

number_right.setText("("+correct_guesses+"/"+total_questions+")");
percentage.setText(result+"%");
frame.add(number_right);
frame.add(percentage);



    }






}