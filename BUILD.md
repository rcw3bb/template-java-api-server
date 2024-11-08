# Build

## Prerequisites

* Java 21

## Testing

Run the following command to test the application:

```
gradlew clean check
```

> The preceding command must be run from the location where you've cloned the repository.

## Building

Run the following command to build the application:

```
gradlew jlink
```

> The preceding command must be run from the location where you've cloned the repository.

The output of this task will be in the following directory format:

```
build\java-api-server-<VERSION>
```

From the preceding directory you can test the build by running the following batch file:

```
java-api-server.bat
```

Once started you can try to open the following address in your browser:

http://localhost:8080/person

Expect the following response:

```json
[{"id":1,"firstName":"Ronaldo","lastName":"Webb"},{"id":2,"firstName":"Juan","lastName":"Dela Cruz"}]
```

## Packaging

Run the following command to package the application:

```
gradlew packWin
```

> The preceding command must be run from the location where you've cloned the repository.

The output of this task will be in the following directory:

```
build\pack
```

The package will contain the a distributable zip file and doesn't require java to be installed on the target windows machine.

## Locking Dependencies

Lock the dependencies to make the build reproducible using the following command:

```
gradlew dependencies --write-locks
```

The preceding command will create the lock files *(e.g. gradle.lockfile and settings-gradle.lockfile)* that must be part of the source control. If the lock files already exist, they will be overwritten.

> There are no lock files in this repository since it is a template. Always start the development as much as possible with the latest stable versions.
