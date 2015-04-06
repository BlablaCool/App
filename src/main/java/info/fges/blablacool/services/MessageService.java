package info.fges.blablacool.services;

import info.fges.blablacool.dao.MessageDao;
import info.fges.blablacool.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void create(Message message) {
        messageDao.create(message);
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
