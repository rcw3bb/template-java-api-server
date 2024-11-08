/**
 * The module definition.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
open module xyz.ronella.template.api {

    requires static lombok;
    requires static java.net.http;

    requires com.fasterxml.jackson.databind;
    requires jdk.httpserver;

    requires xyz.ronella.casual.trivial;
    requires xyz.ronella.logging.logger.plus;

    requires com.google.guice;

    requires org.slf4j;
    requires ch.qos.logback.classic;
    requires java.naming;

}