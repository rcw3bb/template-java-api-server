package xyz.ronella.template.api.controller.impl;

import org.slf4j.LoggerFactory;
import xyz.ronella.logging.LoggerPlus;

import xyz.ronella.template.api.config.PersonDependencies;
import xyz.ronella.template.api.controller.IResource;
import xyz.ronella.template.api.controller.IResources;
import xyz.ronella.template.api.wrapper.SimpleHttpExchange;

import java.util.Optional;
import java.util.Set;

/**
 * The implementation for IResources for returning a particular implementation of IResource.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
public class PersonResources implements IResources {

    private static final LoggerPlus LOGGER_PLUS = new LoggerPlus(LoggerFactory.getLogger(PersonResources.class));

    /**
     * The resource name for Person.
     */
    public static final String RESOURCE_NAME = "Person";

    final private Set<IResource> resources;

    /**
     * Creates an instance of PersonResources.
     * @param resources An set of unique implementation of IResource.
     */
    public PersonResources(final Set<IResource> resources) {
        this.resources = resources;
    }

    /**
     * A set of unique implementation if IResource.
     * @return A set of IResource.
     */
    @Override
    public Set<IResource> getResources() {
        return resources;
    }

    /**
     * Creates a particular implementation IResource.
     * @param exchange An instance of SimpleHttpExchange.
     * @return An implementation of IResource.
     */
    public static Optional<IResource> createResource(SimpleHttpExchange exchange) {
        try(var mLOG = LOGGER_PLUS.groupLog("Optional<IResource> getInstance(SimpleHttpExchange)")) {
            final var personResource = PersonDependencies.getPersonResources();
            final var resources = personResource.getResources();
            final var resource = resources.stream().filter(___resource -> ___resource.canProcess(exchange)).findFirst();
            mLOG.debug(()-> "Resource instance: " + resource.get());
            return resource;
        }
    }

}
