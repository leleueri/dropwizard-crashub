import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.github.leleueri.dw.crash.CrashShellConfiguration;
import io.github.leleueri.dw.crash.CrashShellFactory;

/**
 * Created by eric on 01/03/15.
 */
public class CrashConfiguration extends Configuration implements CrashShellConfiguration {

    @JsonProperty("crash")
    public CrashShellFactory crashShellFactory;

    @Override
    public CrashShellFactory getCrashShellFactory(Configuration configuration) {
        return crashShellFactory;
    }
}
