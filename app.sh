#!/bin/sh
java -Dpf4j.pluginsDir=/opt/plugins  -agentpath:/opt/jprofiler13/bin/linux-x64/libjprofilerti.so=port=8849,nowait -jar /opt/app.jar