package info.fges.blablacool.helpers;

import com.microtripit.mandrillapp.lutung.MandrillApi;
import com.microtripit.mandrillapp.lutung.model.MandrillApiError;
import com.microtripit.mandrillapp.lutung.view.MandrillMessage;
import com.microtripit.mandrillapp.lutung.view.MandrillMessageStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Valentin on 28/03/15.
 */
public class MailHelper
{
    private Properties properties;
    private HashMap<String, String> recipients;
    private String title;
    private String content;
    private String summary;

    public MailHelper(HashMap<String, String> recipients,
                      String title,
                      String content,
                      String summary)
    {
        properties = readProperties();

        this.recipients = recipients;
        this.title = title;
        this.content = content;
        this.summary = summary;
    }

    private void send()
    {
        MandrillApi mandrillApi = new MandrillApi(properties.get("key").toString());

        MandrillMessage message = new MandrillMessage();
        message.setSubject(summary);
        message.setFromEmail("no-reply@blablacool.com");
        message.setFromName("BlablaCool");

        ArrayList<MandrillMessage.Recipient> allRecipients = new ArrayList<MandrillMessage.Recipient>();
        for (Map.Entry<String, String> recipient : this.recipients.entrySet())
        {
            MandrillMessage.Recipient recipientToAdd = new MandrillMessage.Recipient();
            recipientToAdd.setEmail(properties.get("email").toString());
            recipientToAdd.setName("Valentin Polo");
            allRecipients.add(recipientToAdd);
        }

        message.setTo(allRecipients);
        message.setPreserveRecipients(true);

        try
        {
            HashMap<String, String> parameters = new HashMap<String, String>();
            parameters.put("title", this.title);
            parameters.put("content", this.content);
            parameters.put("summary", this.summary);

            MandrillMessageStatus[] messageStatusReports = mandrillApi.messages().sendTemplate("blablacool", parameters, message, true);

            for (MandrillMessageStatus mandrillMessageStatus : messageStatusReports)
            {
                System.out.println(mandrillMessageStatus.getStatus());
            }
        }
        catch (MandrillApiError mandrillApiError)
        {
            mandrillApiError.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private Properties readProperties()
    {
        Properties properties = new Properties();

        try {
            properties.load(MailHelper.class.getResourceAsStream("/mandrill.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return properties;
    }
}
