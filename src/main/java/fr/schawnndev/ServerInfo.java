/*
 * ******************************************************
 *  * Copyright (C) 2015 SchawnnDev <contact@schawnndev.fr>
 *  *
 *  * This file (fr.schawnndev.ServerInfo) is part of HGStatus.
 *  *
 *  * Created by SchawnnDev on 12/07/15 12:38.
 *  *
 *  * HGStatus can not be copied and/or distributed without the express
 *  * permission of SchawnnDev.
 *  ******************************************************
 */

package fr.schawnndev;

import lombok.Getter;

public class ServerInfo {

    @Getter
    private String motd;

    @Getter
    private int playersCount;

    @Getter
    private int maxPlayers;

    public ServerInfo(String motd, int playersCount, int maxPlayers){
        this.motd = motd;
        this.playersCount = playersCount;
        this.maxPlayers = maxPlayers;
    }

    public ServerStatus getServerStatus(){

        if(motd.contains("Hunger Games en cours") || motd.contains("§7Hunger Games en cours"))
            return ServerStatus.GAME;
        else if(motd.contains("Génération en cours") || motd.equals("§7Génération en cours"))
            return ServerStatus.GENERATING;
        else if(motd.contains("Hunger Games debute") || motd.equals("§2Hunger Games debute"))
            return ServerStatus.LOBBY;
        else
            return ServerStatus.RESTARTING;

    }

    public int getData(){
        ServerStatus serverStatus = getServerStatus();
        final String _motd = motd;

        if(serverStatus == ServerStatus.GENERATING) {
            String motd = _motd.replaceAll("Génération", "").replaceAll("en", "").replaceAll("cours", "").replace('(', ' ').replace(')', ' ').replaceAll("%", "").replaceAll(" ", "");

            try {
                return Integer.parseInt(motd);
            } catch (NumberFormatException e){
                e.printStackTrace();
                return 0;
            }



        } else if (serverStatus == ServerStatus.LOBBY) {

        }

        return 0;
    }

}
