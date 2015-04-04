package info.fges.blablacool.helpers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Valentin on 04/04/15.
 */
public class ReadFileHelper
{
    public static String readFile(String path, Charset encoding, Boolean convertLineBreaksToBr) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));

        String result = new String(encoded, encoding);
        if (convertLineBreaksToBr)
        {
            result = result.replaceAll("(\r\n|\n)", "<br />");
        }

        return result;
    }
}
