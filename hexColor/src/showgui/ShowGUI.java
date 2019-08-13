/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package showgui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Ty Long
 * Dec 18 2011
 */

public class ShowGUI extends JPanel implements ActionListener{
    private JRadioButton redButton;
    private JRadioButton orangeButton;
    private JRadioButton yellowButton;
    private JRadioButton whiteButton;
    private JRadioButton greenButton;
    private JRadioButton cyanButton;
    private JRadioButton blueButton;
    private JRadioButton purpleButton;
    private JRadioButton grayButton;
    private JRadioButton blackButton;
    public  Map<String, String> colorMap = new HashMap<String, String>();
    
    public ShowGUI(){
        try{
            Scanner scanner = new Scanner(new FileReader("ColorHex.txt"));
            //TreeMap<String, String> tMap = new TreeMap<String, String>();
            while (scanner.hasNextLine()) {
            String[] textInput = scanner.nextLine().split("->");
            colorMap.put(textInput[0], textInput[1]);
            }
            
        }catch(Exception e){
            System.err.println(e);
            System.exit(ERROR);
        }
        
    grayButton = new JRadioButton("Gray");
    grayButton.setMnemonic(KeyEvent.VK_H);
    grayButton.setSelected(true);
    
    redButton = new JRadioButton("Red");
    redButton.setMnemonic(KeyEvent.VK_R);

    orangeButton = new JRadioButton("Orange");
    orangeButton.setMnemonic(KeyEvent.VK_O);

    yellowButton = new JRadioButton("Yellow");
    yellowButton.setMnemonic(KeyEvent.VK_Y);
    
    whiteButton = new JRadioButton("White");
    whiteButton.setMnemonic(KeyEvent.VK_M);

    greenButton = new JRadioButton("Green");
    greenButton.setMnemonic(KeyEvent.VK_G);

    cyanButton = new JRadioButton("Cyan");
    cyanButton.setMnemonic(KeyEvent.VK_N);
    
    blueButton = new JRadioButton("Blue");
    blueButton.setMnemonic(KeyEvent.VK_B);
    
    purpleButton = new JRadioButton("Purple");
    purpleButton.setMnemonic(KeyEvent.VK_P);   
    
    blackButton = new JRadioButton("Black");
    blackButton.setMnemonic(KeyEvent.VK_A);   

    //Group the radio buttons.
    ButtonGroup colorGroup = new ButtonGroup();
    colorGroup.add(redButton);
    colorGroup.add(orangeButton);
    colorGroup.add(yellowButton);
    colorGroup.add(greenButton);
    colorGroup.add(whiteButton);
    colorGroup.add(cyanButton);
    colorGroup.add(blueButton);
    colorGroup.add(purpleButton);
    colorGroup.add(grayButton);
    colorGroup.add(blackButton);

    //Register a listener for the radio buttons.
    redButton.addActionListener(this);
    orangeButton.addActionListener(this);
    yellowButton.addActionListener(this);
    greenButton.addActionListener(this);
    whiteButton.addActionListener(this);
    cyanButton.addActionListener(this);
    blueButton.addActionListener(this);
    purpleButton.addActionListener(this);
    grayButton.addActionListener(this);
    blackButton.addActionListener(this);
    
    
    JPanel colorPanel = new JPanel(new GridLayout(0, 2));
    for(String n : colorMap.keySet()){
        //Automagically create the jRadioButtons from the keySet values
            JRadioButton jrb = new JRadioButton(n);
            colorGroup.add(jrb);
            colorPanel.add(jrb);
            jrb.addActionListener(this);
        }  

        add(colorPanel, BorderLayout.LINE_START);
        setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       //Use the vales from the HashMap and then set the background from the
       //String hex values that are passed in.
       String action = colorMap.get(ae.getActionCommand());
       setBackground(Color.decode(action));  
    }
    @SuppressWarnings("unchecked")
        public static List sortByValue(final Map colorMap) {
        List colorKeys = new ArrayList();
        colorKeys.addAll(colorMap.keySet());
        Collections.sort(colorKeys, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Object v1 = colorMap.get(o1);
                Object v2 = colorMap.get(o2);
                if (v1 == null) {
                    return (v2 == null) ? 0 : 1;
                }
                else if (v1 instanceof Comparable) {
                    return ((Comparable) v1).compareTo(v2);
                }
                else {
                    return 0;
                }
            }
        });
        
        return colorKeys;
        }
    public static void main(String[] args) {
        //Used Main in ReadAndStore.java so this code moved there
        //so the GUI is started from that Main() there.
   
        JFrame frame = new JFrame("Select a color: ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new ShowGUI();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true); 
    }
        

}
