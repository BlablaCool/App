package info.fges.blablacool.helpers;

import com.microtripit.mandrillapp.lutung.MandrillApi;
import com.microtripit.mandrillapp.lutung.model.MandrillApiError;
import com.microtripit.mandrillapp.lutung.view.MandrillMessage;
import com.microtripit.mandrillapp.lutung.view.MandrillMessageStatus;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by Valentin on 28/03/15.
 */
public class MailHelper
{
    private Properties properties;

    public MailHelper()
    {
        this.properties = this.readProperties();

        sendTestMail();
    }

    public void sendTestMail()
    {
        MandrillApi mandrillApi = new MandrillApi(properties.get("key").toString());

        MandrillMessage message = new MandrillMessage();
        message.setSubject("Hello World!");
        message.setHtml("<h1>Hi pal!</h1><br />Really, I'm just saying hi!");
        message.setAutoText(true);
        message.setFromEmail("kitty@yourdomain.com");
        message.setFromName("Kitty Katz");

        ArrayList<MandrillMessage.Recipient> recipients = new ArrayList<MandrillMessage.Recipient>();
        MandrillMessage.Recipient recipient = new MandrillMessage.Recipient();
        recipient.setEmail("claireannette@someotherdomain.com");
        recipient.setName("Claire Annette");
        recipients.add(recipient);

        message.setTo(recipients);
        message.setPreserveRecipients(true);
        ArrayList<String> tags = new ArrayList<String>();
        tags.add("test");
        tags.add("helloworld");
        message.setTags(tags);

        try {
            MandrillMessageStatus[] messageStatusReports = mandrillApi.messages().send(message, true);

            for (MandrillMessageStatus mandrillMessageStatus : messageStatusReports)
            {
                System.out.println(mandrillMessageStatus.getStatus());
            }

        } catch (MandrillApiError mandrillApiError) {
            mandrillApiError.printStackTrace();
        } catch (IOException e) {
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
