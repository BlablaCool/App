package info.fges.blablacool.dao;

import info.fges.blablacool.models.Message;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Repository
public class MessageDao extends DaoInterface<Message, Integer>
{
    @Override
    public Message findById(Integer integer)
    {
        openCurrentSession();
        Message message = (Message) currentSession.get(Message.class, integer);
        closeCurrentSession();

        return message;
    }

    @Override
    public List<Message> findAll()
    {
        openCurrentSession();
        Query query = currentSession.createQuery("from Message");
        List<Message> list = query.list();
        closeCurrentSession();

        return list;
    }

    @Override
    public void deleteById(Integer integer)
    {
        openCurrentSessionWithTransaction();
        Message messageToDelete = (Message) currentSession.get(Message.class, integer);
        currentSession.delete(messageToDelete);
        closeCurrentSessionWithTransaction();
    }
}
