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

    @Getter
    private static Frame frame;

    @Getter
    private static Updater updater;

    public static void main(String[] args){

        for(int s = 1; s <= 8; s++){
            Server server = new Server(s, s + ".hungergames-mc.fr");
            servers.add(server);
        }

        frame = new Frame();
        frame.setVisible(true);

        updater = new Updater();
        updater.start();

    }


    public static ServerInfo getServerInfo(Server server){
        ServerStatus serverStatus = new ServerStatus(server.getIp());
        return new ServerInfo((String) serverStatus.getServerStatus(StatusType.MOTD), (Long) serverStatus.getServerStatus(StatusType.PLAYERS), (Long) serverStatus.getServerStatus(StatusType.MAX_PLAYERS));
    }

}
