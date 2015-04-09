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
    /**
     * Finds message by id
     * @param integer
     * @return
     */
    @Override
    public Message findById(Integer integer)
    {
        openCurrentSession();
        Message message = (Message) currentSession.get(Message.class, integer);
        closeCurrentSession();

        return message;
    }

    /**
     * Finds all messages
     * @return
     */
    @Override
    public List<Message> findAll()
    {
        openCurrentSession();
        Query query = currentSession.createQuery("from Message");
        List<Message> list = query.list();
        closeCurrentSession();

        return list;
    }

    /**
     * Deletes message by id
     * @param integer
     */
    @Override
    public void deleteById(Integer integer)
    {
        openCurrentSessionWithTransaction();
        Message messageToDelete = (Message) currentSession.get(Message.class, integer);
        currentSession.delete(messageToDelete);
        closeCurrentSessionWithTransaction();
    }
}
