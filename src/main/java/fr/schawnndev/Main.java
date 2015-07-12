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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
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

    /**
     *
     *  Code from https://bukkit.org/threads/get-player-count-and-motd-of-another-server.123219/
     *
     */

    public static ServerInfo getServerInfo(Server server){
        String[] data = null;
        String motd = null;
        int playersCount = 0;
        int maxPlayers = 0;

        try {

            Socket sock = new Socket(server.getIp(), 25565);

            DataOutputStream out = new DataOutputStream(sock.getOutputStream());
            DataInputStream in = new DataInputStream(sock.getInputStream());

            out.write(0xFE);

            int b;
            StringBuffer str = new StringBuffer();
            while ((b = in.read()) != -1) {
                if (b != 0 && b > 16 && b != 255 && b != 23 && b != 24) {
                    str.append((char) b);
                }
            }

            data = str.toString().split("§");
            motd = data[0];
            playersCount = Integer.parseInt(data[1]);
            maxPlayers = Integer.parseInt(data[2]);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ServerInfo(motd, playersCount, maxPlayers);
    }

}
