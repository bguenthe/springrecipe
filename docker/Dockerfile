FROM centos

RUN yum install -y java

VOLUME /tmp
ADD /springrecipe-0.0.1-SNAPSHOT.jar myapp.jar

RUN sh -c 'touch /myapp.jar'
ENTRYPOINT ["java", "-jar", "/myapp.jar"]