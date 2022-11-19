import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridBagLayout;

public class Excel extends JFrame implements ActionListener{

    //creation of one panel
    JPanel pnl = new JPanel();

    //item that we need
    JLabel txt = new JLabel("Enter your numbers separated by spaces");

    JTextField input = new JTextField(10);
    
    JRadioButton auto_sum = new JRadioButton("AutoSum");
    JRadioButton average = new JRadioButton("Average");
    JRadioButton max = new JRadioButton("Max");
    JRadioButton min = new JRadioButton("Min");

    JButton calculate = new JButton("Calculate");

    JTextArea result = new JTextArea("Result");

    public Excel(){
        super("Excel form");
        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(pnl);
        pnl.setLayout(new GridBagLayout());
        GridBagLayout gbl = new GridBagLayout();

        //grid
        GridBagConstraints gbc = new GridBagConstraints();  
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbl.getLayoutDimensions();
        gbc.ipadx=0;
        gbc.ipady=0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx=0;
        gbc.gridy=0;
        

        // adding items to the panel with contraints
        pnl.add(txt,gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        pnl.add(input,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        pnl.add(auto_sum,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        pnl.add(average,gbc);
        gbc.gridx=0;
        gbc.gridy=3;
        pnl.add(max,gbc);
        gbc.gridx=0;
        gbc.gridy=4;
        pnl.add(min,gbc);
        gbc.gridx=0;
        gbc.gridy=5;
        pnl.add(calculate,gbc);
        gbc.gridx=0;
        gbc.gridy=6;
        pnl.add(result,gbc);

        // adding group button
        // Group the radio button : 
        ButtonGroup grp = new ButtonGroup();
        grp.add(auto_sum);
        grp.add(average);
        grp.add(max); 
        grp.add(min); 

        //automatic check 
        auto_sum.setSelected(true);

        calculate.addActionListener(this);  
        
        //changing color of button
        calculate.setBackground(Color.LIGHT_GRAY);
        auto_sum.setForeground(Color.BLUE);
        average.setForeground(Color.BLUE);
        min.setForeground(Color.BLUE);
        max.setForeground(Color.BLUE);
        result.setSize(6,6);
        result.setForeground(Color.BLACK);
        //result.setBackground(Color.LIGHT_GRAY);

        //add option
        input.setBackground(Color.PINK);


    }
    public static void main(String[] args) {
        new Excel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource()==calculate){
            String txt_input = input.getText();

            System.out.println(txt_input);
            txt_input = txt_input.trim();

            //Our array
            String[]test = txt_input.split("\\s+");
            //System.out.println(Arrays.toString(test));
            //System.out.println("Number" +test.length);

            if(test.length<2){
                result.setText("Impossible");
            }
            else{
                int count=0;
                int res =0;
                if(auto_sum.isSelected()){
                    while(count<test.length){
                        res+=Integer.parseInt(test[count]);
                        count++;
                    }
                }else if(average.isSelected()){
                    while(count<test.length){
                        res+=Integer.parseInt(test[count]);
                        count++;
                    }
                    res = res/test.length;
                } else if(max.isSelected()){
                    int max = Integer.parseInt(test[0]);
                    for(count=1; count<test.length; count++){
                        if(Integer.parseInt(test[count])>max){
                            max = Integer.parseInt(test[count]);
                        }
                    }
                    res = max;
                }else if(min.isSelected()){
                    int min = Integer.parseInt(test[0]);
                    for(count=1; count<test.length; count++){
                        if(Integer.parseInt(test[count])<min){
                            min = Integer.parseInt(test[count]);
                        }
                    }
                    res = min;
                }
                result.setText("Result :" +res);
            }
        }
        
    }

}
