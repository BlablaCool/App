package info.fges.blablacool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Valentin on 29/03/15.
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class AccessForbiddenException extends RuntimeException
{
}
