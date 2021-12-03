import javax.lang.model.type.NullType;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EmptyStackException;


public class LeftPanel extends JPanel implements ActionListener, MouseListener {
    JTextArea window = new JTextArea(2,20);

    private String answer;
    private boolean isDec = true;
    private boolean isOct = false;
    private boolean isHex = false;
    private boolean isBin = false;
    private JButton number0;
    private JButton number1;
    private JButton number2;
    private JButton number3;
    private JButton number4;
    private JButton number5;
    private JButton number6;
    private JButton number7;
    private JButton number8;
    private JButton number9;
    private JButton numberA;
    private JButton numberB;
    private JButton numberC;
    private JButton numberD;
    private JButton numberE;
    private JButton numberF;

    GridBagConstraints c = new GridBagConstraints();

    public LeftPanel()
    {
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        window.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 5, 10)));

        c.fill=GridBagConstraints.HORIZONTAL;
        JPanel LeftPanel = new JPanel();
        window.setLineWrap(true);
        window.setEditable(false);
        LeftPanel.setLayout(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth=5;
        c.gridheight=2;
        //Display window
        LeftPanel.add(window,c);
        c.gridwidth = 1;
        c.gridheight = 1;
        c.ipadx = 2;


        ButtonGroup group = new ButtonGroup();
        //Hex Settings

        JRadioButton HEX = new JRadioButton();
        HEX.addActionListener(e -> {
            if(((JRadioButton) e.getSource()).isSelected())
            {
                isDec = false;
                isBin = false;
                isHex = true;
                isOct = false;
                number0.setBackground(Color.GREEN);
                number1.setBackground(Color.GREEN);
                number2.setBackground(Color.GREEN);
                number2.setEnabled(true);
                number3.setBackground(Color.GREEN);
                number3.setEnabled(true);
                number4.setBackground(Color.GREEN);
                number4.setEnabled(true);
                number5.setBackground(Color.GREEN);
                number5.setEnabled(true);
                number6.setBackground(Color.GREEN);
                number6.setEnabled(true);
                number7.setBackground(Color.GREEN);
                number7.setEnabled(true);
                number8.setBackground(Color.GREEN);
                number8.setEnabled(true);
                number9.setBackground(Color.GREEN);
                number9.setEnabled(true);
                numberA.setBackground(Color.GREEN);
                numberA.setEnabled(true);
                numberB.setBackground(Color.GREEN);
                numberB.setEnabled(true);
                numberC.setBackground(Color.GREEN);
                numberC.setEnabled(true);
                numberD.setBackground(Color.GREEN);
                numberD.setEnabled(true);
                numberE.setBackground(Color.GREEN);
                numberE.setEnabled(true);
                numberF.setBackground(Color.GREEN);
                numberF.setEnabled(true);
                window.setText("");
            }
        });
        JLabel Hex = new JLabel("HEX");
        c.gridx = 0;
        c.gridy = 2;
        LeftPanel.add(HEX,c);
        c.gridx+=1;
        LeftPanel.add(Hex,c);

        //Dec Settings
        JRadioButton DEC = new JRadioButton("",true);
        DEC.addActionListener(e -> {
            if(((JRadioButton) e.getSource()).isSelected())
            {
                isDec = true;
                isBin = false;
                isHex = false;
                isOct = false;
                number0.setBackground(Color.GREEN);
                number1.setBackground(Color.GREEN);
                number2.setBackground(Color.GREEN);
                number2.setEnabled(true);
                number3.setBackground(Color.GREEN);
                number3.setEnabled(true);
                number4.setBackground(Color.GREEN);
                number4.setEnabled(true);
                number5.setBackground(Color.GREEN);
                number5.setEnabled(true);
                number6.setBackground(Color.GREEN);
                number6.setEnabled(true);
                number7.setBackground(Color.GREEN);
                number7.setEnabled(true);
                number8.setBackground(Color.GREEN);
                number8.setEnabled(true);
                number9.setBackground(Color.GREEN);
                number9.setEnabled(true);
                numberA.setBackground(Color.RED);
                numberA.setEnabled(false);
                numberB.setBackground(Color.RED);
                numberB.setEnabled(false);
                numberC.setBackground(Color.RED);
                numberC.setEnabled(false);
                numberD.setBackground(Color.RED);
                numberD.setEnabled(false);
                numberE.setBackground(Color.RED);
                numberE.setEnabled(false);
                numberF.setBackground(Color.RED);
                numberF.setEnabled(false);
                window.setText("");
            }
        });
        JLabel Dec = new JLabel("DEC");
        c.gridx = 0;
        c.gridy = 3;
        LeftPanel.add(DEC,c);
        c.gridx+=1;
        LeftPanel.add(Dec,c);
        //Oct Settings
        JRadioButton OCT = new JRadioButton();
        OCT.addActionListener(e -> {
            if(((JRadioButton) e.getSource()).isSelected())
            {
                isDec = false;
                isBin = false;
                isHex = false;
                isOct = true;
                number0.setBackground(Color.GREEN);
                number1.setBackground(Color.GREEN);
                number2.setBackground(Color.GREEN);
                number2.setEnabled(true);
                number3.setBackground(Color.GREEN);
                number3.setEnabled(true);
                number4.setBackground(Color.GREEN);
                number4.setEnabled(true);
                number5.setBackground(Color.GREEN);
                number5.setEnabled(true);
                number6.setBackground(Color.GREEN);
                number6.setEnabled(true);
                number7.setBackground(Color.GREEN);
                number7.setEnabled(true);
                number8.setBackground(Color.RED);
                number8.setEnabled(false);
                number9.setBackground(Color.RED);
                number9.setEnabled(false);
                numberA.setBackground(Color.RED);
                numberA.setEnabled(false);
                numberB.setBackground(Color.RED);
                numberB.setEnabled(false);
                numberC.setBackground(Color.RED);
                numberC.setEnabled(false);
                numberD.setBackground(Color.RED);
                numberD.setEnabled(false);
                numberE.setBackground(Color.RED);
                numberE.setEnabled(false);
                numberF.setBackground(Color.RED);
                numberF.setEnabled(false);
                window.setText("");
            }
        });
        JLabel Oct = new JLabel("OCT");
        c.gridx = 0;
        c.gridy = 4;
        LeftPanel.add(OCT,c);
        c.gridx+=1;
        LeftPanel.add(Oct,c);
        //Bin Settings
        JLabel Bin = new JLabel("BIN");
        JRadioButton BIN = new JRadioButton();
        BIN.addActionListener(e -> {
            if(((JRadioButton) e.getSource()).isSelected())
            {
                isDec = false;
                isBin = true;
                isHex = false;
                isOct = false;
                number0.setBackground(Color.GREEN);
                number1.setBackground(Color.GREEN);
                number2.setBackground(Color.RED);
                number2.setEnabled(false);
                number3.setBackground(Color.RED);
                number3.setEnabled(false);
                number4.setBackground(Color.RED);
                number4.setEnabled(false);
                number5.setBackground(Color.RED);
                number5.setEnabled(false);
                number6.setBackground(Color.RED);
                number6.setEnabled(false);
                number7.setBackground(Color.RED);
                number7.setEnabled(false);
                number8.setBackground(Color.RED);
                number8.setEnabled(false);
                number9.setBackground(Color.RED);
                number9.setEnabled(false);
                numberA.setBackground(Color.RED);
                numberA.setEnabled(false);
                numberB.setBackground(Color.RED);
                numberB.setEnabled(false);
                numberC.setBackground(Color.RED);
                numberC.setEnabled(false);
                numberD.setBackground(Color.RED);
                numberD.setEnabled(false);
                numberE.setBackground(Color.RED);
                numberE.setEnabled(false);
                numberF.setBackground(Color.RED);
                numberF.setEnabled(false);
                window.setText("");
            }
        });
        c.gridx = 0;
        c.gridy = 5;
        LeftPanel.add(BIN,c);
        c.gridx+=1;
        LeftPanel.add(Bin,c);

        group.add(BIN);
        group.add(OCT);
        group.add(DEC);
        group.add(HEX);
        // for Hex
        numberA = new JButton("A");
        numberA.addActionListener(this);
        c.gridx = 3;
        c.gridy = 5;
        LeftPanel.add(numberA,c);
        numberB = new JButton("B");
        numberB.addActionListener(this);
        c.gridy++;
        LeftPanel.add(numberB,c);
        numberC = new JButton("C");
        numberC.addActionListener(this);
        c.gridy++;
        LeftPanel.add(numberC,c);
        numberD = new JButton("D");
        numberD.addActionListener(this);
        c.gridy++;
        LeftPanel.add(numberD,c);
        numberE = new JButton("E");
        numberE.addActionListener(this);
        c.gridy++;
        LeftPanel.add(numberE,c);
        numberF = new JButton("F");
        numberF.addActionListener(this);
        c.gridy++;
        LeftPanel.add(numberF,c);


        //Keyboard
        //First Row
        JButton mark1 = new JButton("(");
        mark1.setSize(new Dimension(15,15));
        mark1.addActionListener( this);
        c.gridx = 0;
        c.gridy = 6;
        LeftPanel.add(mark1,c);

        JButton mark2 = new JButton(")");
        mark2.setSize(new Dimension(15,15));
        mark2.addActionListener( this);
        c.gridx++;
        LeftPanel.add(mark2,c);

        JButton mark3 = new JButton("%");
        mark3.setSize(new Dimension(15,15));
        mark3.addActionListener( this);
        c.gridx++;
        LeftPanel.add(mark3,c);

        JButton del = new JButton("DEL");
        del.setSize(new Dimension(15,15));
        del.addActionListener( this);
        del.addMouseListener(this);
        c.gridx+=2;
        LeftPanel.add(del,c);

        //Second Row
        c.gridy++;
        number7 = new JButton("7");
        number7.addActionListener( this);
        c.gridx=0;
        LeftPanel.add(number7,c);
        number8 = new JButton("8");
        number8.addActionListener( this);
        c.gridx++;
        LeftPanel.add(number8,c);
        number9 = new JButton("9");
        number9.addActionListener( this);
        c.gridx++;
        LeftPanel.add(number9,c);
        JButton divide = new JButton("/");
        divide.addActionListener( this);
        c.gridx+=2;
        LeftPanel.add(divide,c);

        //Third Row
        c.gridy++;
        number4 = new JButton("4");
        number4.addActionListener( this);
        c.gridx=0;
        LeftPanel.add(number4,c);
        number5 = new JButton("5");
        number5.addActionListener( this);
        c.gridx++;
        LeftPanel.add(number5,c);
        number6 = new JButton("6");
        number6.addActionListener( this);
        c.gridx++;
        LeftPanel.add(number6,c);
        JButton multiply = new JButton("x");
        multiply.addActionListener( this);
        c.gridx+=2;
        LeftPanel.add(multiply,c);

        //Fourth Row
        c.gridy++;
        number1 = new JButton("1");
        number1.addActionListener( this);
        c.gridx=0;
        LeftPanel.add(number1,c);
        number2 = new JButton("2");
        number2.addActionListener( this);
        c.gridx++;
        LeftPanel.add(number2,c);
        number3 = new JButton("3");
        number3.addActionListener( this);
        c.gridx++;
        LeftPanel.add(number3,c);
        JButton minus = new JButton("-");
        minus.addActionListener( this);
        c.gridx+=2;
        LeftPanel.add(minus,c);

        //Fifth Row
        c.gridy++;
        JButton dot = new JButton(".");
        dot.addActionListener( this);
        c.gridx=0;
        LeftPanel.add(dot,c);
        number0 = new JButton("0");
        number0.addActionListener( this);
        c.gridx++;
        LeftPanel.add(number0,c);
        JButton equals = new JButton("=");
        equals.addActionListener( this);
        c.gridx++;
        LeftPanel.add(equals,c);
        JButton plus = new JButton("+");
        plus.addActionListener( this);
        c.gridx+=2;
        LeftPanel.add(plus,c);


        //DEFAULT SETTINGS
        number0.setBackground(Color.GREEN);
        number1.setBackground(Color.GREEN);
        number2.setBackground(Color.GREEN);
        number2.setEnabled(true);
        number3.setBackground(Color.GREEN);
        number3.setEnabled(true);
        number4.setBackground(Color.GREEN);
        number4.setEnabled(true);
        number5.setBackground(Color.GREEN);
        number5.setEnabled(true);
        number6.setBackground(Color.GREEN);
        number6.setEnabled(true);
        number7.setBackground(Color.GREEN);
        number7.setEnabled(true);
        number8.setBackground(Color.GREEN);
        number8.setEnabled(true);
        number9.setBackground(Color.GREEN);
        number9.setEnabled(true);
        numberA.setBackground(Color.RED);
        numberA.setEnabled(false);
        numberB.setBackground(Color.RED);
        numberB.setEnabled(false);
        numberC.setBackground(Color.RED);
        numberC.setEnabled(false);
        numberD.setBackground(Color.RED);
        numberD.setEnabled(false);
        numberE.setBackground(Color.RED);
        numberE.setEnabled(false);
        numberF.setBackground(Color.RED);
        numberF.setEnabled(false);










        add(LeftPanel);

    }
    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        switch(str){
            //FIRST LINE
            case "(": window.setText(window.getText()+"("); break;
            case ")": window.setText(window.getText()+")"); break;
            case "%": window.setText(window.getText()+"%"); break;
            case "DEL":

                String temp = window.getText();
                if(temp.equals("Wrong equation") || temp.equals("Give equation") || temp.equals(answer) || temp.equals("Wrong expression"))
                {
                    window.setText(""); break;
                } else {
                    int length = temp.length();
                    if (length > 0)
                        temp = temp.substring(0, length - 1);
                    window.setText(temp);
                }

                break;
            //SECOND LINE
            case "7": window.setText(window.getText()+ "7"); break;
            case "8": window.setText(window.getText()+ "8"); break;
            case "9": window.setText(window.getText()+ "9"); break;
            case "/": window.setText(window.getText()+ "/"); break;
            // THIRD LINE
            case "4": window.setText(window.getText()+ "4"); break;
            case "5": window.setText(window.getText()+ "5"); break;
            case "6": window.setText(window.getText()+ "6"); break;
            case "x": window.setText(window.getText()+ "*"); break;
            // FOURTH LINE
            case "1": window.setText(window.getText()+ "1"); break;
            case "2": window.setText(window.getText()+ "2"); break;
            case "3": window.setText(window.getText()+ "3"); break;
            case "-": window.setText(window.getText()+ "-"); break;
            // FIFTH LINE
            case ".": window.setText(window.getText()+ "."); break;
            case "0": window.setText(window.getText()+ "0"); break;
            case "=":
                if(isDec) {
                    try {
                        if (window.getText().length() > 0) {
                            CalculationsDecimal calculate = new CalculationsDecimal(window.getText());
                            double result = calculate.getResult();
                            this.answer = Double.toString(result);
                            window.setText(answer);
                        } else if (window.getText().length() == 0)
                            window.setText("Give equation");
                    } catch (EmptyStackException e) {
                        window.setText("Wrong equation");
                    } catch (NumberFormatException e) {
                        window.setText("Wrong expression");
                    }
                }else if(isOct)
                {
                    try {
                        if (window.getText().length() > 0) {
                            CalculationsOctal calculate = new CalculationsOctal(window.getText());
                            int result = calculate.getResult();
                            this.answer = Integer.toString(result);
                            window.setText(answer);
                        } else if (window.getText().length() == 0)
                            window.setText("Give equation");
                    } catch (EmptyStackException e) {
                        window.setText("Wrong equation");
                    } catch (NumberFormatException e) {
                        window.setText("Wrong expression");
                    }
                }else if(isHex)
                {
                    try {
                        if (window.getText().length() > 0) {
                            CalculationsHexa calculate = new CalculationsHexa(window.getText());
                            String result = calculate.getResult();
                            this.answer = result;
                            window.setText(result);
                        } else if (window.getText().length() == 0)
                            window.setText("Give equation");
                    } catch (EmptyStackException e) {
                        window.setText("Wrong equation");
                    } catch (NumberFormatException e) {
                        window.setText("Wrong expression");
                    }
                }else if(isBin)
                { try {
                    if (window.getText().length() > 0) {
                        CalculationsBinary calculate = new CalculationsBinary(window.getText());
                        int result = calculate.getResult();
                        this.answer = Integer.toString(result);
                        window.setText(answer);
                    } else if (window.getText().length() == 0)
                        window.setText("Give equation");
                } catch (EmptyStackException e) {
                    window.setText("Wrong equation");
                } catch (NumberFormatException e) {
                    window.setText("Wrong expression");
                }
                }



            break;
            case "+": window.setText(window.getText()+ "+"); break;
            case "A": window.setText(window.getText()+ "A"); break;
            case "B": window.setText(window.getText()+ "B"); break;
            case "C": window.setText(window.getText()+ "C"); break;
            case "D": window.setText(window.getText()+ "D"); break;
            case "E": window.setText(window.getText()+ "E"); break;
            case "F": window.setText(window.getText()+ "F"); break;
        };




    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
