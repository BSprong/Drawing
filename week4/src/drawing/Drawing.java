/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author Bart
 */
public class Drawing {
    private String name;
    private Integer width;
    private Integer height;
    private  ArrayList<DrawingItem>items = new ArrayList<>();//final

        public String getName() {
            return name;
        }

        public void setName(String Name) {
            this.name = Name;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public List <DrawingItem> getItems()
        {
            return (List<DrawingItem>) Collections.unmodifiableList(items);
            //return items;
        }
    //constructor

        public Drawing(String Name, Integer width, Integer height) {
            this.name = Name;
            this.width = width;
            this.height = height;
            items = new ArrayList<>();
        }

        /*public void removeitem(DrawingItem delete)
        {
            if (items.contains(delete)) {
                items.remove(delete);

                deleted = delete;
            }
        }*/

        @Override
        public String toString() {
            return "Drawing{" + "Name=" + name + ", width=" + width + ", height=" + height + ", items=" + items + '}';
        }
        
        /**
         * @param args the command line arguments
         */


        
        
        public void paint(IPaintable paintable)
        {
            for(DrawingItem item: getItems()){
                item.paint(paintable);
            }
        }

    public void addItem(DrawingItem item) {
        items.add(item);
       
    }
    }
    
    

