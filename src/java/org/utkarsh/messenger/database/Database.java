/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utkarsh.messenger.database;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.persistence.tools.profiler.Profile;
import org.utkarsh.messenger.model.Message;

/**
 *
 * @author Utkarsh
 */
public class Database {

    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<Long, Profile> profiles = new HashMap<>();

    public static Map getMessages() {
        return messages;
    }

    public static Map getProfiles() {
        return profiles;
    }
}
