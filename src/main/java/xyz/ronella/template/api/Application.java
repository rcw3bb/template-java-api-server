package xyz.ronella.template.api;

import org.slf4j.LoggerFactory;
import xyz.ronella.logging.LoggerPlus;
import xyz.ronella.template.api.config.AppConfig;
import xyz.ronella.template.api.util.AppInfo;
import xyz.ronella.template.api.util.FileMgr;
import xyz.ronella.template.api.wrapper.SimpleHttpServer;
import xyz.ronella.trivial.handy.PathFinder;

import java.io.IOException;

/**
 * The entry point of this application.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
public final class Application {

    static {
        final var confDir = FileMgr.getConfDir();
        confDir.ifPresent(___confDir -> {
            final var logPath = PathFinder.getBuilder("logback.xml")
                    .addPaths(".", ___confDir.getAbsolutePath())
                    .build();
            final var optLogFile = logPath.getFile();
            if (optLogFile.isPresent()) {
                final var logFile = optLogFile.get();
                if (logFile.exists()) {
                    System.setProperty("logback.configurationFile", logFile.getAbsolutePath());
                }
            }
        });
    }

    private Application() {}

    private static final LoggerPlus LOGGER_PLUS = new LoggerPlus(LoggerFactory.getLogger(Application.class));

    /**
     * The application entry point.
     * @param args The command line arguments.
     * @throws IOException The exception to handle.
     */
    public static void main(String ... args) throws IOException {
        try(var mLOG = LOGGER_PLUS.groupLog("void main(String[])")) {
            final var appInfo = AppInfo.INSTANCE;
            mLOG.info("%s v%s (%s)", appInfo.getAppName(), appInfo.getAppVersion(), appInfo.getBuildDate());

            try(final var server = SimpleHttpServer.createServer()) {
                server.start();
                final var port = AppConfig.INSTANCE.getServerPort();

                mLOG.info("%nThe app started on port %s%nPress enter to stop...%n", port);
                System.in.read();
            }
        }
    }
}
