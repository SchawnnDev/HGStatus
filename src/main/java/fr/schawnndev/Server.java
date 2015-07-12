/*
 * ******************************************************
 *  * Copyright (C) 2015 SchawnnDev <contact@schawnndev.fr>
 *  *
 *  * This file (fr.schawnndev.Server) is part of HGStatus.
 *  *
 *  * Created by SchawnnDev on 12/07/15 12:20.
 *  *
 *  * HGStatus can not be copied and/or distributed without the express
 *  * permission of SchawnnDev.
 *  ******************************************************
 */

package fr.schawnndev;

import lombok.Getter;

public class Server {

    @Getter
    private int id;

    @Getter
    private String ip;

    public Server(int id, String ip){
        this.id = id;
        this.ip = ip;
    }

}
