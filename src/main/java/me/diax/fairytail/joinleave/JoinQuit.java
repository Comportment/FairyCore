/*
 * Copyright 2017 Comportment | comportment@diax.me
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.diax.fairytail.joinleave;

import me.diax.fairytail.Main;
import me.diax.fairytail.util.Util;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.regex.Pattern;

/**
 * Created by Comportment at 00:55 on 23/05/17
 * https://github.com/Comportment | comportment@diax.me
 *
 * @author Comportment
 */
public class JoinQuit implements Listener {

    private JoinQuitProperties properties;
    private String joinMessage;
    private String quitMessage;

    public JoinQuit(Main plugin) {
        properties = Util.loadConfig("joinquit.properties", JoinQuitProperties.class, this.getClass().getClassLoader());
        joinMessage = properties.getJoinMessage();
        quitMessage = properties.getQuitMessage();
        plugin.registerEvents(this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (joinMessage != null)
            event.setJoinMessage(joinMessage.replaceAll(Pattern.quote("<player>"), event.getPlayer().getName()));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (quitMessage != null)
            event.setQuitMessage(quitMessage.replaceAll(Pattern.quote("<player>"), event.getPlayer().getName()));
    }
}