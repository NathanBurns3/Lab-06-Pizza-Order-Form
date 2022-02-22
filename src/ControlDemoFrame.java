import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlDemoFrame extends JFrame
{
    JPanel mainPnl;
    JPanel radioPnl;
    JPanel checkPnl;
    JPanel comboPnl;
    JPanel controlPnl;

    JComboBox homeCB;

    JCheckBox gopherCB;
    JCheckBox monsterToeCB;
    JCheckBox shadeCB;
    JCheckBox bloodCB;
    JCheckBox heartCB;
    JCheckBox brainsCB;
    JCheckBox fangsCB;
    JCheckBox tearsCB;

    JRadioButton smallRB;
    JRadioButton mediumRB;
    JRadioButton largeRB;
    JRadioButton superRB;


    JButton quitBtn;
    JButton displayChoicesBtn;

    public ControlDemoFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new GridLayout(4,1));

        createRadioPanel();
        mainPnl.add(radioPnl);

        createCheckPanel();
        mainPnl.add(checkPnl);

        createComboPanel();
        mainPnl.add(comboPnl);

        createControlPanel();
        mainPnl.add(controlPnl);

        add(mainPnl);
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createComboPanel()
    {
       comboPnl = new JPanel();
       comboPnl.setBorder(new TitledBorder(new EtchedBorder(),"Home"));

        homeCB = new JComboBox();
        homeCB.addItem("Narnia");
        homeCB.addItem("Barsoom");
        homeCB.addItem("Asgard");
        homeCB.addItem("Midgard");
        homeCB.addItem("Jotunheim");
        comboPnl.add(homeCB);


    }

    private void createRadioPanel()
    {
        radioPnl = new JPanel();
        radioPnl.setLayout(new GridLayout(1, 4));
        radioPnl.setBorder(new TitledBorder(new EtchedBorder(),"Radio Buttons"));


        smallRB  = new JRadioButton("Small");
        mediumRB = new JRadioButton("Medium");
        largeRB  = new JRadioButton("Large");
        superRB  = new JRadioButton("Super");

        radioPnl.add(smallRB);
        radioPnl.add(mediumRB);
        radioPnl.add(largeRB);
        radioPnl.add(superRB);

        mediumRB.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(smallRB);
        group.add(mediumRB);
        group.add(largeRB);
        group.add(superRB);


    }

    private void createCheckPanel()
    {
        checkPnl = new JPanel();
        checkPnl.setLayout(new GridLayout(2,4));
        checkPnl.setBorder(new TitledBorder(new EtchedBorder(),"Checkboxes"));

        gopherCB = new JCheckBox("Gopher Guts");
        monsterToeCB = new JCheckBox("Monster Toes");
        shadeCB = new JCheckBox("Ghost Shade");
        bloodCB = new JCheckBox("Bitter Blood");
        heartCB = new JCheckBox("Tell Tale Heart");
        fangsCB = new JCheckBox("Vampire Fangs");
        brainsCB = new JCheckBox("Zombie Brains");
        tearsCB = new JCheckBox("Clown Tears");

        checkPnl.add(gopherCB);
        checkPnl.add(monsterToeCB);
        checkPnl.add(shadeCB);
        checkPnl.add(bloodCB);
        checkPnl.add(heartCB);
        checkPnl.add(fangsCB);
        checkPnl.add(brainsCB);
        checkPnl.add(tearsCB);

    }


    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setBorder(new TitledBorder(new EtchedBorder(),"Controls"));

        displayChoicesBtn = new JButton("Display Choices");
        displayChoicesBtn.addActionListener(
                (ActionEvent ae) ->
                {
                    // Generate a result string and then display it with a Message Diaplog
                    String res ="Form Details\n";
                    // get the size choice
                    res += "Crust size: ";
                    if(smallRB.isSelected())
                        res += "Small\n";
                    else if(mediumRB.isSelected())
                        res += "Medium\n";
                    else if(largeRB.isSelected())
                        res += "Large\n";
                    else if(superRB.isSelected())
                        res += "Super\n";
                    // get the items
                    res += "With these gourmet toppings:\n";

                    if (gopherCB.isSelected())
                        res += "\tGopher Guts\n";

                    if (monsterToeCB.isSelected())
                        res += "\tMonster Toes\n";

                    if (shadeCB.isSelected())
                        res += "\tGhost Shade\n";

                    if (bloodCB.isSelected())
                        res += "\tBitter Blood\n";

                    if (fangsCB.isSelected())
                        res += "\tVampire Fangs\n";

                    if (brainsCB.isSelected())
                        res += "\tZombie Brains\n";

                    if (tearsCB.isSelected())
                        res += "\tClown Tears\n";

                    res += "To be delivered to: ";

                    res += (String) homeCB.getSelectedItem();

                    res += "\n";
                    // get the home
                    JOptionPane.showMessageDialog(mainPnl,res);
                }
        );

        quitBtn = new JButton("Quit!");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPnl.add(displayChoicesBtn);
        controlPnl.add(quitBtn);

    }
}
