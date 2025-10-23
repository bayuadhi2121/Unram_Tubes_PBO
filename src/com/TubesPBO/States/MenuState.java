package com.TubesPBO.States;

import com.TubesPBO.Game.Game;
import com.TubesPBO.Game.Handler;
import com.TubesPBO.Grapichs.Assets;
import com.TubesPBO.Ui.Click;
import com.TubesPBO.Ui.UiButton;
import com.TubesPBO.Ui.UiManager;

import javax.swing.*;
import java.awt.*;


public class MenuState extends State {
    private UiManager uiManager;

    public MenuState(Handler handler){
        super(handler);
        uiManager= new UiManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UiButton(370, 170, 190, 100, Assets.start, new Click() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                handler.getGame().gameState.switched();
                State.setState(handler.getGame().gameState);
            }
        }));
        uiManager.addObject(new UiButton(370, 240, 190, 100, Assets.exit, new Click() {
            @Override
            public void onClick() {
                System.exit(0);
            }
        }));
    }

    @Override
    public void update() {
        uiManager.update();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.menu,0,0,640,480,null);
        g.drawImage(Assets.title,0,160,350,200,null);
        uiManager.render(g);
    }

    @Override
    public void switched() {
        handler.getMouseManager().setUiManager(uiManager);
    }



}
