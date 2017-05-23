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

import com.knockturnmc.api.util.NamedProperties;
import com.knockturnmc.api.util.Property;
import me.diax.fairytail.util.Util;

/**
 * Created by Comportment at 00:57 on 23/05/17
 * https://github.com/Comportment | comportment@diax.me
 *
 * @author Comportment
 */
public class JoinQuitProperties extends NamedProperties {

    @Property(value = "joinMessage", defaultvalue = "&7[&a+&7] <player> has joined!")
    private String joinMessage;

    @Property(value = "quitMessage", defaultvalue = "&7[&c+&7] <player> has left!")
    private String quitMessage;

    public String getJoinMessage() {
        return Util.addColor(joinMessage);
    }

    public String getQuitMessage() {
        return Util.addColor(quitMessage);
    }
}