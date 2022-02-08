#!groovy
import jenkins.model.Jenkins;

pm = Jenkins.instance.pluginManager
uc = Jenkins.instance.updateCenter

pm.doCheckUpdatesServer()

["git", "workflow-aggregator",'blueocean', "docker-plugin","docker-workflow",'docker-java-api','docker-commons','job-dsl'].each {
    if (! pm.getPlugin(it)) {
    deployment = uc.getPlugin(it).deploy(true)
    deployment.get()
    }
}
