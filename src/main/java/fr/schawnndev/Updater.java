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

    public Updater(){

        while (true){

            for(Server server : Main.getServers()){

            }

            try {
                sleep(1000L);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }


    }

}
