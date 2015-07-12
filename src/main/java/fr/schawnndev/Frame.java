/*
 * ******************************************************
 *  * Copyright (C) 2015 SchawnnDev <contact@schawnndev.fr>
 *  *
 *  * This file (fr.schawnndev.Frame) is part of HGStatus.
 *  *
 *  * Created by SchawnnDev on 12/07/15 12:18.
 *  *
 *  * HGStatus can not be copied and/or distributed without the express
 *  * permission of SchawnnDev.
 *  ******************************************************
 */

package fr.schawnndev;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private final String[] titles = {"Serveur", "Ip", "Type", "Statut", "Places"};
    private boolean firstStart = true;

    public Frame(){
        init();
    }

    private void init(){
        setTitle("HGStatus by SchawnnDev");
        setSize(1000, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void updateTableau(Object[][] datas){

        JTable tableau = new JTable(datas, titles);

        tableau.setDragEnabled(false);

        if(!firstStart)
            getContentPane().removeAll();
        else
            firstStart = false;

        getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
        getContentPane().add(tableau, BorderLayout.CENTER);


        pack();
    }

}
