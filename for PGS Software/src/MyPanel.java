/**
 * Created by Przemek on 2016-04-21.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Przemek on 2016-04-20.
 */
public class MyPanel extends JPanel {

    private JPanel buttonPanel;
    private JPanel[] pagePanels=new JPanel[6];
    private JButton backButton, nextButton;
    private int counter=0;
    private JTextArea textArea1,textArea2;



    public MyPanel() {

        setLayout(new BorderLayout());


        /**
         * Here we constructs pages for getting Name, Surname etc.
         */
        pagePanels[0] = new Page(new String[]{"Name:  "});
        pagePanels[1] = new Page(new String[]{"Surname:  "});
        pagePanels[2] = new Page(new String[]{"Country:  ", "City:  ", "Postal Code:  ", "Street:  ", });
        pagePanels[3] = new Page(new String[]{"Phone Number:"});
        /**
         *Page 4 asks if we want to display the data
         *Page 5 displays the data.
         */
        pagePanels[4] = new JPanel();
        pagePanels[5] = new JPanel();

        textArea1 = new JTextArea(1,15);
        textArea1.setEditable(false);
        textArea1.setBackground(this.getBackground());
        textArea1.setText("To display the data click next."+"\n"+
                "Warning: If you click next, you " +"\n"+
                "will not be able to change the data.");
        pagePanels[4].add(textArea1);

        textArea2=new JTextArea(15,20);
        textArea2.setEditable(false);
        textArea2.setBackground(this.getBackground());
        pagePanels[5].add(textArea2);

        /**
         * Adding buttons and Listeners to them
         */

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        backButton = new JButton("Back");
        backButton.setEnabled(false);
        nextButton = new JButton("Next");
        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);


        add(pagePanels[0], BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(pagePanels[counter--]);
                if(counter<=0)
                {
                    backButton.setEnabled(false);
                }
                choseTheProperPage();
                revalidate();
                repaint();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backButton.setEnabled(true);
                remove(pagePanels[counter++]);
                choseTheProperPage();
                revalidate();
                repaint();
                if(counter>=5)
                {
                    nextButton.setEnabled(false);
                    backButton.setEnabled(false);
                }
            }
        });
    }

    /**
     * This method is responsible for choosing the proper Page.
     * When the counter reaches 5 this method loads text from each Page
     * using getText method from Page Class and appends text to textArea2
     * which displays Name, Surname etc.
     */
    private void choseTheProperPage()
    {
        if(counter==0)
        {
            add(pagePanels[0],BorderLayout.NORTH);

        }
        else if(counter==1)
        {
            add(pagePanels[1],BorderLayout.NORTH);
        }
        else if(counter==2)
        {
            add(pagePanels[2],BorderLayout.NORTH);

        }
        else if(counter==3)
        {
            add(pagePanels[3],BorderLayout.NORTH);

        }
        else if(counter==4)
        {
            /**
             *On this page users decides if he/she wants
             * to display the data.
             */
            add(pagePanels[4],BorderLayout.NORTH);

        }
        else if(counter==5)
        {
            /**
             * If the user decides to display the data
             * this part of code appends text from each Page
             * to textArea2.
             */
            add(pagePanels[5],BorderLayout.NORTH);
            for(int i=0;i < pagePanels.length-2;i++)
            {
                /**
                 * The type of pagePanels is JPanel.
                 * Page class extends JPanel.
                 * We cast pagePanels[i] to Page so
                 * that we can use getText method.
                 */
                Page a= (Page)pagePanels[i];
                String[] table = a.getText();

                for(int j=0; j<table.length;j++)
                {
                    textArea2.append("\n"+table[j]);
                }
            }
        }
    }


}
