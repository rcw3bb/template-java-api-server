package xyz.ronella.template.api.config;

import xyz.ronella.template.api.controller.IResource;
import xyz.ronella.template.api.controller.IResources;
import xyz.ronella.template.api.controller.impl.*;
import xyz.ronella.template.api.repository.IPersonRepository;
import xyz.ronella.template.api.repository.impl.PersonListRepository;
import xyz.ronella.template.api.service.IPersonService;
import xyz.ronella.template.api.service.impl.PersonServiceImpl;

import java.util.Set;

/**
 * The class that holds the dependency registry.
 * This class is responsible for creating the instances of the classes that are needed by the application.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
final public class PersonDependencies {

    private PersonDependencies() {}

    /**
     * Returns the set of IResource for Person.
     * @return A set of IResource.
     */
    public static Set<IResource> getPersonResourceSet() {
        return Set.of(
                new PersonCreate(),
                new PersonDeleteById(),
                new PersonRetrieveAll(),
                new PersonRetrieveById(),
                new PersonUpdateById()
        );
    }

    /**
     * Returns an implementation of IPersonRepository.
     * @return An implementation of IPersonRepository.
     */
    public static IPersonRepository getPersonRepository() {
        return new PersonListRepository();
    }

    /**
     * Returns an implementation of IPersonService.
     * @return An implementation of IPersonService.
     */
    public static IPersonService getPersonService() {
        return new PersonServiceImpl(getPersonRepository());
    }

    /**
     * Returns an implementation of IResources for Person.
     * @return An implementation of IResources.
     */
    public static IResources getPersonResources() {
        return new PersonResources(getPersonResourceSet());
    }

}
