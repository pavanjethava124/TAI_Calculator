import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numButtons=new JButton[10];
    JButton[] funButtons=new JButton[9];
    JButton add,sub,mul,div;
    JButton dec,equ,del,clr,neg;
    JPanel panel;
    //Font font=new Font("Ink Free",font.BOLD,30);
    double num1=0,num2=0,result=0;
    char operator;
    calculator(){
        frame=new JFrame("calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textfield=new JTextField();
        textfield.setBounds(50,25,300,50);
       // textfield.setText(font);
        textfield.setEditable(false);
       
        add=new JButton("+");
        sub=new JButton("-");
        mul=new JButton("*");
        div=new JButton("/");
        dec=new JButton(".");
        equ=new JButton("=");
        del=new JButton("Del");
        clr=new JButton("Clr");
        neg=new JButton("(-)");
        funButtons[0]=add;
        funButtons[1]=sub;
        funButtons[2]=mul;
        funButtons[3]=div;
        funButtons[4]=dec;
        funButtons[5]=equ;
        funButtons[6]=del;
        funButtons[7]=clr;
        funButtons[8]=neg;

        for(int i=0;i<8;i++)
        {
            funButtons[i].addActionListener(this);
           // funButtons[i].setFont(font);
            funButtons[i].setFocusable(false);

        }

        for(int i=0;i<10;i++)
        {
            numButtons[i]=new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
           // numButtons[i].setFont(font);
            numButtons[i].setFocusable(false);
        }
        neg.setBounds(50,430,100,50);
        del.setBounds(150,430,100,50);
        clr.setBounds(250,430,100,50);

        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(add);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(sub);
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(mul);
        panel.add(dec);
        panel.add(numButtons[0]);
        panel.add(equ);
        panel.add(div);
        frame.add(panel);
        frame.add(del);
        frame.add(clr);
        frame.add(neg);
        frame.add(textfield);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        calculator calc=new calculator();
    }

     @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<10;i++)
        {
            
            if(e.getSource()==numButtons[i])
            {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
            if(e.getSource()==dec)
            {
                textfield.setText(textfield.getText().concat("."));
            }
            
            if(e.getSource()==add)
            {
                num1=Double.parseDouble(textfield.getText());
                operator='+';
                textfield.setText("");
            }
            
            if(e.getSource()==sub)
            {
                num1=Double.parseDouble(textfield.getText());
                operator='-';
                textfield.setText("");
            }
            
            if(e.getSource()==mul)
            {
                num1=Double.parseDouble(textfield.getText());
                operator='*';
                textfield.setText("");
            }
            
            if(e.getSource()==div)
            {
                num1=Double.parseDouble(textfield.getText());
                operator='+';
                textfield.setText("");
            }
            
            if(e.getSource()==equ)
            {
                num2=Double.parseDouble(textfield.getText());
                
                switch (operator) {
                    case '+':
                    result=num1+num2;
                    break;
                    
                    case '-':
                    result=num1-num2;
                    break;

                    case '*':
                    result=num1*num2;
                    break;

                    case '/':
                    result=num1/num2;
                    break;
                }
                textfield.setText(String.valueOf(result));
                num1=result;
            
            }

            if(e.getSource()==clr)
            {
                textfield.setText("");
            }

            if(e.getSource()==del)
            {
                String string= textfield.getText();
                textfield.setText("");
                for(int i=0;i<string.length()-1;i++)
                {
                    textfield.setText(textfield.getText()+string.charAt(i));
                }
            }
            if(e.getSource()==neg)
            {
                double temp= Double.parseDouble(textfield.getText());
                temp*=-1;
                textfield.setText(String.valueOf(temp));
            }
        }
    }
