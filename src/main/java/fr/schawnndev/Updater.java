/*
 * ******************************************************
 *  * Copyright (C) 2015 SchawnnDev <contact@schawnndev.fr>
 *  *
 *  * This file (fr.schawnndev.Updater) is part of HGStatus.
 *  *
 *  * Created by SchawnnDev on 12/07/15 12:14.
 *  *
 *  * HGStatus can not be copied and/or distributed without the express
 *  * permission of SchawnnDev.
 *  ******************************************************
 */

package fr.schawnndev;

public class Updater extends Thread {

    @Override
    public void run() {

        while (true){

                Object[][] datas = new Object[Main.getServers().size()][5];

                int s = 0;

                for(Server server : Main.getServers()){

                    ServerInfo serverInfo = Main.getServerInfo(server);
                    ServerStatusEnum serverStatusEnum = serverInfo.getServerStatus();
                    String type = server.getId() == 8 ? "Soupe" : server.getId() == 2 ? "Mort Subite" : server.getId() == 1 ? "Event Team" : "Normal";
                    String statut = serverStatusEnum == ServerStatusEnum.LOBBY ? ("Commence dans " + serverInfo.getData() + " seconde" + (serverInfo.getData() > 1 ? "s" : "")) : serverStatusEnum == ServerStatusEnum.GAME ? "En jeu" : serverStatusEnum == ServerStatusEnum.RESTARTING ? "Redémarrage" : "Génération " + serverInfo.getData() + "%";

                    datas[s][0] = "HG " + server.getId();
                    datas[s][1] = server.getIp();
                    datas[s][2] = type;
                    datas[s][3] = statut;
                    datas[s][4] = serverInfo.getAvaiableSlots();

                    s++;
                }

                    Main.getFrame().updateTableau(datas);

                try {
                    sleep(1000L);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

            }

    }

}
