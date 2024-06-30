FROM maven as BUILDER
ARG VERSION=0.0.1-SNAPSHOT
WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src/
COPY .git /build/.git

#RUN mvn clean package
RUN mvn clean compile generate-sources package -Dmaven.test.skip=true
RUN cp target/resume-service-${VERSION}.jar target/application.jar

FROM openjdk
WORKDIR /app/

COPY --from=BUILDER /build/target/application.jar /app/
CMD java -jar /app/application.jar 