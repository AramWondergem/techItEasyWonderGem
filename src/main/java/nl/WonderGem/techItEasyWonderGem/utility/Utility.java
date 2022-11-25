package nl.WonderGem.techItEasyWonderGem.utility;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class Utility {

    public static String badRequestMessageGenerator(BindingResult br) {
        StringBuilder sb = new StringBuilder();

        for (FieldError fe :
                br.getFieldErrors()) {
            sb.append(fe.getField() + ": ");
            sb.append(fe.getDefaultMessage());
            sb.append("\n");
        }

        return sb.toString();
    }

    public static URI uriGenerator(String path, Long createdID) {
        URI uri = URI.create(
                ServletUriComponentsBuilder.
                        fromCurrentContextPath().
                        path(path + createdID).toUriString());

        return uri;
    }
}
