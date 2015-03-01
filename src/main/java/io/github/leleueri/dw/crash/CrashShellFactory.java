package io.github.leleueri.dw.crash;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.setup.Environment;
import io.dropwizard.util.Duration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by eric on 05/02/15.
 */
public class CrashShellFactory {

    @JsonProperty("conf-mount-point")
    private String configMountPoint = null;

    @JsonProperty("cmd-mount-point")
    private String commandMountPoint = null;

    public CrashEmbeddedShell build(Environment environment) {
        CrashEmbeddedShell shell = new CrashEmbeddedShell(configMountPoint, commandMountPoint);
        environment.lifecycle().manage(shell);
        return shell;
    }

}

