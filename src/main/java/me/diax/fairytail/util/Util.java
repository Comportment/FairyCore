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

package me.diax.fairytail.util;

import com.knockturnmc.api.util.ConfigurationUtils;
import com.knockturnmc.api.util.NamedProperties;
import org.bukkit.ChatColor;

import java.io.File;

/**
 * Created by Comportment at 22:44 on 22/05/17
 * https://github.com/Comportment | comportment@diax.me
 *
 * @author Comportment
 */
public class Util {

    private static char colorChar = '&';

    private static File getDirectory() {
        return new File(System.getProperty("user.dir"));
    }

    public static String addColor(String message) {
        return ChatColor.translateAlternateColorCodes(colorChar, message);
    }

    public static <T extends NamedProperties> T loadConfig(Class<? extends T> clazz, ClassLoader loader) {
        return ConfigurationUtils.loadConfiguration(loader, getDirectory().getPath(), clazz);
    }

    public static <T extends NamedProperties> T loadConfig(String name, Class<? extends T> clazz, ClassLoader loader) {
        return ConfigurationUtils.loadConfiguration(loader, name, getDirectory(), clazz);
    }
}