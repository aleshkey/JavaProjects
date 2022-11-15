package Music;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("classicalMusic")
public class ClassicalMusic implements Music{
    @Override
    public String getSong() {
        return "rhapsody";
    }
}
