/*
 * ******************************************************
 *  * Copyright (C) 2015 SchawnnDev <contact@schawnndev.fr>
 *  *
 *  * This file (fr.schawnndev.Main) is part of HGStatus.
 *  *
 *  * Created by SchawnnDev on 12/07/15 12:08.
 *  *
 *  * HGStatus can not be copied and/or distributed without the express
 *  * permission of SchawnnDev.
 *  ******************************************************
 */

package fr.schawnndev;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    @Getter
    private static List<Server> servers = new ArrayList<>();

    public static void main(String[] args){

        for(int s = 1; s <= 8; s++){
            Server server = new Server(s + ".hungergames-mc.fr");
            servers.add(server);
        }

        Frame frame = new Frame();
        frame.setVisible(true);
    }

    public static 

}
