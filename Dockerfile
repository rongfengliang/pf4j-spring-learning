FROM openjdk:8-jre-slim
COPY jprofiler_linux_13_0.deb /opt/jprofiler_linux_13_0.deb
RUN dpkg -i /opt/jprofiler_linux_13_0.deb
COPY bootstrap/target/bootstrap-1.0-SNAPSHOT.jar /opt/app.jar
COPY app.sh /opt/app.sh
RUN chmod +x /opt/app.sh
ENTRYPOINT ["sh","/opt/app.sh"]
