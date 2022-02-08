FROM wenliang/wenliang-pipelines-jenkins:22.02

COPY ./scripts/ ${JENKINS_HOME}/init.groovy.d/
COPY requirements.txt ${JENKINS_HOME}
WORKDIR ${JENKINS_HOME}
USER root
# if the requirments.txt changed, run "docker-compose build --no-cache" to rebuild the image
RUN pip install -r requirements.txt
USER jenkins