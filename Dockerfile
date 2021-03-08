ARG MAVEN_VERSION=3.6.0-jdk-11-slim

FROM maven:${MAVEN_VERSION} AS build

COPY [ "./target", "/home/app/target" ]

FROM openjdk:11-jdk-slim

COPY --from=build [ "/home/app/target/**.jar", "/usr/local/lib/client-manager.jar" ]

EXPOSE 8092

ENTRYPOINT [ "java","-jar", "/usr/local/lib/client-manager.jar" ]
