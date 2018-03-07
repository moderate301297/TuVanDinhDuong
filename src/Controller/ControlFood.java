/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.QueryFood;
import Views.ListMenuView;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author quangns
 */
public class ControlFood {
    private InterfaceListMenu showfood;
    

    public ControlFood(ListMenuView aThis) {
        this.showfood = (InterfaceListMenu) aThis;
    }

    
    public void ShowFood() throws SQLException {
        ArrayList<String> food = new QueryFood().ShowAll();
        for (int i = 0; i < food.size(); i = i + 6) {
            String id = food.get(i);
            String tenmon = food.get(i+1);
            String soluong = food.get(i+2);
            String protein = food.get(i+3);
            String tinhbot = food.get(i+4);
            String lipit = food.get(i+5);
            showfood.ShowList(id, tenmon, soluong, protein, tinhbot, lipit);
        }
    }
}
