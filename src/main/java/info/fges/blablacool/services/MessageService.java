package info.fges.blablacool.services;

import info.fges.blablacool.dao.MessageDao;
import info.fges.blablacool.helpers.MailHelper;
import info.fges.blablacool.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Service
public class MessageService extends ServiceInterface<Message,Integer>
{
    @Autowired
    private MessageDao messageDao;

    @Override
    public Message findById(Integer integer) {
        return messageDao.findById(integer);
    }

    @Override
    public List<Message> findAll() {
        return messageDao.findAll();
    }

    @Override
    public void create(Message message)
    {
        messageDao.create(message);

        // Sending the notification...
        HashMap<String, String> mailPlaceholders = new HashMap<String, String>();
        mailPlaceholders.put("passengerNickname", message.getSender().getNickname());
        mailPlaceholders.put("driverNickname", message.getTrip().getDriver().getNickname());
        mailPlaceholders.put("tripSummary", message.getTrip().getDepartureStep().getPlace().getCity() + " > " + message.getTrip().getArrivalStep().getPlace().getCity());
        mailPlaceholders.put("messagesTripUrl", "https://blablacool.fges.info/trips/" + message.getTrip().getIdTrip() + "#messagesList");

        MailHelper mailHelper = new MailHelper(message.getTrip().getDriver().getNickname(),
                message.getTrip().getDriver().getEmail(),
                "messages/new",
                mailPlaceholders,
                "Une nouvelle question vous attend...",
                "Un passager vient de poser une question sur un de vos voyages à venir !");
        mailHelper.send();
    }

    @Override
    public void update(Message message) {
        messageDao.update(message);
    }

    @Override
    public void delete(Message message) {
        messageDao.delete(message);
    }

    @Override
    public void deleteById(Integer integer) {
        messageDao.deleteById(integer);
    }
}
