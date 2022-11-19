import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;




public class Main extends JFrame implements ItemListener, ActionListener{
    JPanel pnl = new JPanel();

    JLabel fname = new JLabel("first name:");
    JLabel lname = new JLabel("last name:");
    JLabel email_ = new JLabel("email:");
    JLabel address_ = new JLabel("address:");
    JLabel city_ = new JLabel("city:");
    JLabel province_ = new JLabel("province:");
    JLabel member = new JLabel("Membership: ");

    JTextField f_name = new  JTextField(10);
    JTextField l_name = new JTextField(10);
    JTextField email = new JTextField(10);
    JTextField address = new JTextField(10);
    JTextField city = new JTextField(10);
    JTextField province = new JTextField(10);

    // Button
    JButton send = new JButton("Suscribe");
    JButton reset = new JButton("Cancel");

    JRadioButton prem = new JRadioButton("Premium");
    JRadioButton stan = new JRadioButton("Standart");
    JRadioButton bas = new JRadioButton("Basic");

    JTextArea txt = new JTextArea();
    


    public Main(){
        super("Register form");
        setVisible(true);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(pnl);

        // adding grid
        GridBagLayout gbl = new GridBagLayout();
        pnl.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();  
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx=0;
        gbc.ipady=0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx=0;
        gbc.gridy=0;

        //adding button
        pnl.add(fname,gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        pnl.add(f_name,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        pnl.add(lname,gbc);
        gbc.gridx=1;
        gbc.gridy=1;
        pnl.add(l_name,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        pnl.add(email_,gbc);
        gbc.gridx=1;
        gbc.gridy=2;
        pnl.add(email,gbc);
        gbc.gridx=0;
        gbc.gridy=3;
        pnl.add(address_,gbc);
        gbc.gridx=1;
        gbc.gridy=3;
        pnl.add(address,gbc);
        gbc.gridx=0;
        gbc.gridy=4;
        pnl.add(city_,gbc);
        gbc.gridx=1;
        gbc.gridy=4;
        pnl.add(city,gbc);
        gbc.gridx=0;
        gbc.gridy=5;
        pnl.add(province_,gbc);
        gbc.gridx=1;
        gbc.gridy=5;
        pnl.add(province,gbc);
        gbc.gridx=0;
        gbc.gridy=6;
        pnl.add(member,gbc);
        
        gbc.gridx=0;
        gbc.gridy=7;
        pnl.add(prem,gbc);
        gbc.gridx=0;
        gbc.gridy=8;
        pnl.add(stan,gbc);
        gbc.gridx=0;
        gbc.gridy=9;
        pnl.add(bas,gbc);
        
        gbc.gridx=0;
        gbc.gridy=10;
        pnl.add(send,gbc);
        gbc.gridx=1;
        gbc.gridy=10;
        pnl.add(reset,gbc);

        // Group the radio button : 
        ButtonGroup grp = new ButtonGroup();
        grp.add(prem);
        grp.add(stan);
        grp.add(bas);      

        send.addActionListener(this);
        reset.addActionListener(this);
        prem.addActionListener(this);
        stan.addActionListener(this);
        bas.addActionListener(this);

        //prem
        prem.setSelected(true);

        // adding color
        f_name.setBackground(Color.PINK);
        l_name.setBackground(Color.PINK);
        address.setBackground(Color.PINK);
        email.setBackground(Color.PINK);
        city.setBackground(Color.PINK);
        province.setBackground(Color.PINK);
        member.setForeground(Color.BLUE);
        send.setBackground(Color.CYAN);
        reset.setBackground(Color.LIGHT_GRAY);

    }
    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        GridBagConstraints gbc_ = new GridBagConstraints();  
        gbc_.gridx=0;
        gbc_.gridy=11;
        //gbc_.gridwidth=5;
        gbc_.ipady = 30;

        // reset the text 
        txt.setText(null);
        pnl.add(txt,gbc_);
        
        if(e.getSource() == send){
            String fn = f_name.getText();
            String ln = l_name.getText();
            String mail = email.getText();
            String dress = address.getText();
            String ci = city.getText();
            String pro = province.getText();
            
            String member = "";
            // TODO Auto-generated method stub
            if(prem.isSelected()){
                member ="Premium";
            }else if( stan.isSelected()){
                member = "Standart";
            }else if(bas.isSelected()){
                 member = "Basic";
            }
            txt.append("Name: " + fn + " " + ln + "\nemail: " + mail + "\naddress: " + dress + "\ncity: " + ci +"\nprovince: "+pro +"\nMembership "+member);
        }
        else if(e.getSource() == reset){
            f_name.setText("");
            l_name.setText("");
            email.setText("");
            address.setText("");
            city.setText("");
            province.setText("");

        }
    }
}