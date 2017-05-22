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

package me.diax.fairytail.announcer;

import me.diax.fairytail.util.Util;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

/**
 * Created by Comportment at 22:51 on 22/05/17
 * https://github.com/Comportment | comportment@diax.me
 *
 * @author Comportment
 */
public class Announcer implements Runnable {

    private AnnouncerProperties properties;
    private Server server;
    private String[] messages;
    private int index;

    public Announcer(Plugin plugin) {
        properties = Util.loadConfig("announcer.properties", AnnouncerProperties.class, this.getClass().getClassLoader());
        this.server = plugin.getServer();
        this.messages = properties.getMessages();
        index = 0;
        server.getScheduler().runTaskTimerAsynchronously(plugin, this, 0, properties.getInterval());
    }

    private void announce(String message) {
        String spacer = properties.getSpacer();
        server.getOnlinePlayers().forEach(p -> p.sendMessage(String.format(Util.addColor("&r%s\n&r%s\n&r%s"), spacer, message, spacer)));
    }

    @Override
    public void run() {
        if (index + 1 >= messages.length) {
            index = 0;
        } else {
            index += 1;
        }
        announce(messages[index]);
    }
}