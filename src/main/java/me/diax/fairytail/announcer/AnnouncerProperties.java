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

import com.knockturnmc.api.util.NamedProperties;
import com.knockturnmc.api.util.Property;
import me.diax.fairytail.util.Util;

import java.util.regex.Pattern;

/**
 * Created by Comportment at 22:35 on 22/05/17
 * https://github.com/Comportment | comportment@diax.me
 *
 * @author Comportment
 */
public class AnnouncerProperties extends NamedProperties {

    @Property(value = "messages", defaultvalue = "&7Testing &2message! <message>Another message!\nMultiple lines!!!")
    private String messages;

    @Property(value = "spacer", defaultvalue = "-=-=-=-=-=-=-=-=-=-=-=-")
    private String spacer;

    @Property(value = "interval", defaultvalue = "60")
    private String interval;

    public String[] getMessages() {
        return Util.addColor(messages).split(Pattern.quote("<message>"));
    }

    public String getSpacer() {
        return Util.addColor(spacer);
    }

    public long getInterval() {
        return Long.valueOf(interval);
    }
}