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
        ServerStatus serverStatus = ServerStatus.RESTARTING;

        final String _motd = motd;

        if(_motd.contains("Hunger Games en cours") || _motd.contains("§7Hunger Games en cours"))
            return ServerStatus.GAME;

        else if(_motd.contains("Génération en cours") || _motd.equals("§7Génération en cours"))
            return ServerStatus.GENERATING;

        else if(_motd.contains("Génération en cours") || _motd.equals("§7Génération en cours"))
            return ServerStatus.GENERATING;



        return serverStatus;
    }
}
