package com.grzesiek.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.grzesiek.game.Dragon;
import com.grzesiek.game.screens.PlayScreen;
import com.grzesiek.game.player.Player;

/**
 * Created by Grzesiek on 2017-09-16.
 */

public class Wood extends StockObject
{
    private static TiledMapTileSet tileSet;

    public Wood(PlayScreen screen, MapObject object)
    {
        super(screen, object);
        tileSet = map.getTileSets().getTileSet("level_1");
        fixture.setUserData(this);
        setCategoryFilter(Dragon.WOOD_BIT);
        stockAmount = 5;
    }

    @Override
    public void onActivation(Player player)
    {
        player.adjustWood(stockAmount);
        Gdx.app.log("Stock", "picked up " +String.valueOf(stockAmount) +" wood");
        setCategoryFilter(Dragon.REMOVED_STOCK_BIT);
        getCell().setTile(tileSet.getTile(530));
    }
}
