package io.github.leleueri.dw.crash;


import io.dropwizard.lifecycle.Managed;
import org.crsh.plugin.Embedded;
import org.crsh.plugin.PluginDiscovery;
import org.crsh.plugin.ServiceLoaderDiscovery;
import org.crsh.util.Utils;
import org.crsh.vfs.spi.FSMountFactory;
import org.crsh.vfs.spi.file.FileMountFactory;
import org.crsh.vfs.spi.url.ClassPathMountFactory;

import java.util.*;
import java.util.logging.Level;

/**
 * Created by eric on 05/02/15.
 */
public class CrashEmbeddedShell extends Embedded implements Managed {

    protected final HashMap<String, FSMountFactory<?>> drivers = new HashMap<String, FSMountFactory<?>>();

    private String cmdMountPointConfig;

    private String confMountPointConfig;

    private final Map<String, Object> attributes = new HashMap<String, Object>();

    public CrashEmbeddedShell(String confMountPointConfig, String cmdMountPointConfig) {
        this.cmdMountPointConfig = cmdMountPointConfig;
        this.confMountPointConfig = confMountPointConfig;
    }

    @Override
    public void start() {
        final ClassLoader classLoader = this.getClass().getClassLoader();
        try {
            drivers.put("classpath", new ClassPathMountFactory(classLoader));
            drivers.put("file", new FileMountFactory(Utils.getCurrentDirectory()));
        } catch (Exception e) {
            log.log(Level.SEVERE, "Coult not initialize classpath driver", e);
            return;
        }

        PluginDiscovery discovery = new ServiceLoaderDiscovery(classLoader);
        start(Collections.unmodifiableMap(attributes), discovery, classLoader);
    }

    @Override
    protected Map<String, FSMountFactory<?>> getMountFactories() {
        return drivers;
    }

    @Override
    protected String resolveConfMountPointConfig() {
        return confMountPointConfig != null ? confMountPointConfig : getDefaultConfMountPointConfig();
    }

    @Override
    protected String resolveCmdMountPointConfig() {
        return cmdMountPointConfig != null ? cmdMountPointConfig : getDefaultCmdMountPointConfig();
    }

    protected String getDefaultCmdMountPointConfig() {
        return "classpath:/crash/commands/";
    }

    protected String getDefaultConfMountPointConfig() {
        return "classpath:/crash/";
    }
}
