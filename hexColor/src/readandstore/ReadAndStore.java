/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package readandstore;


import java.io.*;
import java.util.List;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import showgui.*;
import showgui.ShowGUI;


/**
 *
 * @author Ty Long
 * Dec 18, 2011
 */
public class ReadAndStore {
    public ReadAndStore(){
        try{
            Scanner scanner = new Scanner(new FileReader("ColorHex.txt"));
            Map<String, String> colorMap = new HashMap<String, String>();
            //TreeMap<String, String> tMap = new TreeMap<String, String>();
            while (scanner.hasNextLine()) {
            String[] textInput = scanner.nextLine().split("->");
            colorMap.put(textInput[0], textInput[1]);
            
        }  
            System.out.println("*********************************\n"
                             + "*         Final Project         *\n"
                             + "*                               *\n"
                             + "*  By: Ty Long		            *\n"
                             + "*  17 Dec 2011                  *\n"
                             + "*********************************");
            
            System.out.println("\nSorted by hexadecimal color values: ");
            //At first I was trying to use a TreeMap to sort by the values
            //but the keys for some reason were not playing nice in the print
            //statements. 
            for (Iterator i = sortByValue(colorMap).iterator(); i.hasNext(); ) {
            String key = (String) i.next();
            System.out.printf("%s->%s\n", key, colorMap.get(key));
            
            }
            
            System.out.println();
            
        }catch(Exception e){
            System.err.println(e);
        }
        try{
            List<String> colorText = new ArrayList<String>();
            BufferedReader reader = new BufferedReader(new FileReader("ColorHex.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
            colorText.add(line );
        }
        reader.close();
        Set colorSort = new TreeSet(colorText); 
        //TreeSet sort seemed like the easiest way to sort the names
        //I tried a few other collections with mixed results.
            System.out.println("The names sorted lexiconically by name: ");
            int cs2 = colorSort.size();
            for(Object n : colorSort){
                if(--cs2 == 0){ //last element in Array an additional 2 sec to runtime
                    System.out.print(n); //just prints the element without the ","                 
                }else{
                    System.out.print(n + ", \n");
                }
            } 
            System.out.println();
        
        }catch(Exception ae){
            System.err.println(ae);
        }
        
    }
    
    public static void main(String[] args){
        ReadAndStore ras = new ReadAndStore();
        
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
        
            
}
