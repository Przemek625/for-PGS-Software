import javax.swing.*;
import java.awt.*;

/**
 * Created by Przemek on 2016-04-20.
 */
public class Page extends JPanel{


    private String[] jlabelNames;
    private JLabel[] jLabels;
    private JTextField[] jTextFields;

    /**
     * @param jlabelNames
     * This is constructor of Page class
     * This constructor allows to make Page
     * with any number(Size of frame is the limit)
     * of pair Label and JtextField.
     * I wanted to give it such flexibility and functionality.
     */

    public Page(String[] jlabelNames)
    {

        final int LENGTH= jlabelNames.length;
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setPreferredSize(new Dimension(266,300));

        this.jlabelNames = new String[jlabelNames.length];
        jLabels     = new JLabel[LENGTH];
        jTextFields = new JTextField[LENGTH];

        /**
         * Adding Rows with JLabels and JTextFields
         */

        for(int i=0; i<LENGTH; i++)
        {
            jLabels[i]=new JLabel(jlabelNames[i]);
            add(jLabels[i]);
            jTextFields[i]=new JTextField(15);
            add(jTextFields[i]);

        }
    }

    /**
     * @return String[]
     *This method is responsible for giving access
     *to each textField in Page object.
     *This method returns the values from each JtextField
     *of Page Object as a String table.
     */

    public String[] getText()
    {
        String [] temporary=new String[this.jTextFields.length];

        for(int i=0; i< this.jTextFields.length; i++)
        {
            temporary[i]=jTextFields[i].getText();
        }

        return temporary;
    }

}

