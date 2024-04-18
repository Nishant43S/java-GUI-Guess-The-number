import java.awt.*;
import  java.awt.event.*;

public class Main extends Frame implements ActionListener{
    private Label Info_text;
    private TextField Number_input;
    private Button Guess_Btn;
    private Button Reset_Btn;
    private Label Output_text;
    private int randomNumber;
    

    public Main(){
        // Basic frame settings
        final Color bg_Color = new Color(26,27,37);

        this.setSize(500,340);
        this.setVisible(true);
        this.setTitle("Guess The Number ~ Nishant Maity");
        this.setResizable(false);
        this.setBackground(bg_Color);
        this.setLayout(null);

        // window closing event

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we){
                dispose();
            }
        });

        // title heading 

        final Label app_title = new Label("Guess The Number");
        app_title.setBounds(70, 49, 400, 45);
        app_title.setBackground(new Color(26,27,37));
        app_title.setForeground(new Color(207, 226, 228));
        app_title.setFont(new Font(
            "ds-digital",Font.BOLD,36
        ));
        add(app_title);

        //  Infolabel

        Info_text = new Label("Guess the Number between 1 - 100");
        Info_text.setBackground(new Color(26,27,37));
        Info_text.setBounds(60, 298, 400, 32);
        Info_text.setForeground(new Color(0xfdb44b));
        Info_text.setFont(new Font(
            "ds-digital",Font.BOLD,17
        ));
        add(Info_text);

        // text fields

        final Label Number_label = new Label("Enter Guess");
        Number_label.setBounds(85, 128, 130, 33);
        Number_label.setBackground(bg_Color);
        Number_label.setForeground(new Color(0xfdb44b));
        Number_label.setFont(new Font(
            "ds-digital",Font.PLAIN,22
        ));
        add(Number_label);

        Number_input = new TextField(25);
        Number_input.setBounds(225, 128, 150, 33);
        Number_input.setFont(new Font(
            "ds-digital",Font.PLAIN,22
        ));
        Number_input.setBackground(new Color(0xfdb44b));
        Number_input.setForeground(new Color(0x272343));
        add(Number_input);

        // buttons

        Guess_Btn = new Button("Guess");
        Guess_Btn.setBounds(255, 189, 100, 35);
        Guess_Btn.setFont(new Font(
            "ds-digital",Font.BOLD,19
        ));
        Guess_Btn.setBackground(new Color(0x385170));
        Guess_Btn.setForeground(new Color(0xfdb44b));
        add(Guess_Btn);

        Reset_Btn = new Button("Reset");
        Reset_Btn.setBounds(115, 189, 100, 35);
        Reset_Btn.setFont(new Font(
            "ds-digital",Font.BOLD,19
        ));
        Reset_Btn.setBackground(new Color(0x385170));
        Reset_Btn.setForeground(new Color(0xfdb44b));
        add(Reset_Btn);

        //  output

        Output_text = new Label();
        Output_text.setBounds(125, 249, 300, 45);
        Output_text.setForeground(new Color(0xfda403));
        Output_text.setFont(new Font(
            "ds-digital",Font.BOLD,22
        ));
        add(Output_text);

        // action listner

        Guess_Btn.addActionListener(this);
        Reset_Btn.addActionListener(this);
        GenerateRandomNumber();

    }

    // main logic
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Guess_Btn){
            GameStart();
        }else if(ae.getSource() == Reset_Btn){
            ResetGame();
        }
    }

    private void GenerateRandomNumber(){
        randomNumber= (int) (Math.random() * 100) + 1;
    }

    public void GameStart(){
        Info_text.setText("");
        try{
            if(Number_input.getText().strip() == ""){
                Output_text.setText("Please Enter Number");
            }else{
                // convert into integer
                int Guess_numb = Integer.parseInt(Number_input.getText());

                if(Guess_numb < 0 || Guess_numb > 100){
                    Output_text.setText("Invalid Number");
                }else{
                    // game logic
                    if(Guess_numb > randomNumber){
                        Output_text.setText("Number is too High");
                    }else if(Guess_numb < randomNumber){
                        Output_text.setText("Number is too Low");   
                    }else{
                        Output_text.setText("You got the Number"); 
                        Guess_Btn.setEnabled(false);
                    }
                }
            }
        }
        catch (Exception e){
            Output_text.setText("Invalid Input");
        }
    }

    public void ResetGame(){
        Info_text.setText("Guess the Number between 1 - 100");
        Output_text.setText(""); 
        GenerateRandomNumber();
        Guess_Btn.setEnabled(true);
    }
    public static void main(String[] args) {
        new Main();
    }
}