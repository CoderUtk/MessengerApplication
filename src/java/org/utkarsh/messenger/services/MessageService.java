package org.utkarsh.messenger.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.utkarsh.messenger.database.Database;
import org.utkarsh.messenger.model.Message;

public class MessageService {

    private final Map<Long, Message> messages = Database.getMessages();

    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }

    public Message getMessage(Long id) {
        return messages.get(id);
    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {
        if (message.getId() <= 0) {
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public void removeMessage(Long id) {
        messages.remove(id);
    }

    public List<Message> getMessagesForYear(int year) {
        List<Message> filteredMessages = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for (Message message : messages.values()) {
            cal.setTime(message.getDateCreated());
            if (cal.get(Calendar.YEAR) == year) {
                filteredMessages.add(message);
            }
        }
        return filteredMessages;
    }

    public List<Message> getAllMessagesPaginated(int start, int size) {
        List<Message> messageList = new ArrayList<>(messages.values());
        if (start + size > messageList.size()) {
            return new ArrayList<>();
        }
        return messageList.subList(start, start + size);
    }
}
