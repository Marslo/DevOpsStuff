import java.lang.reflect.*;
import jenkins.model.Jenkins;
import jenkins.model.*;
import org.jenkinsci.plugins.scriptsecurity.scripts.*;
import org.jenkinsci.plugins.scriptsecurity.sandbox.whitelists.*;
import static groovy.json.JsonOutput.*

scriptApproval = ScriptApproval.get()
alreadyApproved = new HashSet<>(Arrays.asList(scriptApproval.getApprovedSignatures()))
println prettyPrint( toJson(alreadyApproved) )

// List scriptList = ['method hudson.model.Job getLastSuccessfulBuild', 'method hudson.model.Node getNodeName', 'method hudson.util.PersistedList get java.lang.Class', 'method hudson.model.Item getName', 'method hudson.model.ParametersAction createUpdated java.util.Collection', 'method hudson.tasks.test.TestResult isPassed', 'staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods getMetaClass java.lang.Object', 'method hudson.model.Job getBuildByNumber int', 'method hudson.model.Node getSelfLabel', 'staticMethod hudson.model.User get java.lang.String', 'staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods execute java.util.List', 'method org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition getScriptPath', 'staticMethod org.codehaus.groovy.runtime.ProcessGroovyMethods getText java.lang.Process', 'method hudson.model.Node setLabelString java.lang.String', 'new java.io.File java.lang.String', 'staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods takeRight java.lang.Object[] int', 'staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods toInteger java.lang.Number', 'method hudson.model.Actionable addAction hudson.model.Action', 'method java.lang.Throwable printStackTrace java.io.PrintWriter', 'new com.cwctravel.hudson.plugins.extended_choice_parameter.ExtendedChoiceParameterDefinition java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String java.lang.String boolean boolean int java.lang.String java.lang.String', 'method hudson.slaves.EnvironmentVariablesNodeProperty getEnvVars', 'method hudson.model.Run getLog', 'staticMethod hudson.util.Secret toString hudson.util.Secret', 'method hudson.model.Node getLabelString', 'method jenkins.model.Jenkins getGlobalNodeProperties', 'new com.emenda.klocwork.config.KlocworkReportConfig boolean', 'staticMethod java.lang.String valueOf int', 'staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods putAt java.lang.Object java.lang.String java.lang.Object', 'new hudson.model.StringParameterValue java.lang.String java.lang.String', 'staticMethod org.apache.commons.io.FilenameUtils getBaseName java.lang.String', 'method hudson.model.Node getAssignedLabels', 'staticMethod org.boon.Boon fromJson java.lang.String', 'staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods head java.lang.Object[]', 'method hudson.model.ItemGroup getAllItems java.lang.Class', 'method jenkins.model.Jenkins getNode java.lang.String', 'staticMethod groovy.json.JsonOutput toJson java.lang.Object', 'method hudson.model.Cause$UserIdCause getUserId', 'method hudson.model.Saveable save', 'method org.jenkinsci.plugins.workflow.job.WorkflowJob getDefinition', 'method hudson.model.ItemGroup getItem java.lang.String', 'method hudson.model.Computer getNode', 'method hudson.model.User getAuthorities', 'method hudson.model.Cause getShortDescription', 'new hudson.model.ParametersAction java.util.List', 'staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods findAll java.lang.String java.lang.String', 'method groovy.lang.MetaObjectProtocol getMethods', 'method hudson.model.Label getName', 'staticField java.lang.System out', 'staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods dropRight java.lang.Object[] int', 'method hudson.EnvVars addLine java.lang.String', 'staticMethod java.lang.String valueOf char[]', 'method org.jfrog.hudson.pipeline.common.types.ArtifactoryServer getPassword', 'method hudson.model.Run getCause java.lang.Class', 'staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods take java.util.Map int', 'staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods dump java.lang.Object', 'method hudson.model.ParametersAction merge hudson.model.ParametersAction', 'method hudson.model.AbstractCIBase getNodes', 'method hudson.model.Cause$UpstreamCause getUpstreamUrl', 'method org.jvnet.hudson.plugins.groovypostbuild.GroovyPostbuildRecorder$BadgeManager createSummary java.lang.String', 'method hudson.model.Run getCauses', 'staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods getAt java.lang.Object[] groovy.lang.IntRange', 'method hudson.model.Run getLogReader', 'method hudson.model.Cause$UserIdCause getUserName', 'method hudson.model.Run getEnvironment', 'method jenkins.model.Jenkins getComputers', 'method hudson.model.Actionable getActions java.lang.Class', 'staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods drop java.lang.Object[] int', 'method hudson.tasks.test.AbstractTestResultAction getResult', 'method hudson.model.Actionable getAllActions', 'method hudson.model.ParametersAction getParameters', 'staticMethod java.lang.Thread currentThread', 'method hudson.model.Run getParent', 'staticField com.cwctravel.hudson.plugins.extended_choice_parameter.ExtendedChoiceParameterDefinition PARAMETER_TYPE_JSON', 'new java.io.PrintWriter java.io.Writer', 'staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods getCount java.util.regex.Matcher', 'new java.lang.String byte[]', 'staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods getAt java.util.List java.util.Collection', 'staticMethod org.codehaus.groovy.runtime.EncodingGroovyMethods decodeBase64 java.lang.String', 'new hudson.model.ParametersAction hudson.model.ParameterValue[]', 'method hudson.model.Run getEnvVars', 'method hudson.model.Actionable removeAction hudson.model.Action', 'method hudson.model.Cause$UpstreamCause getUpstreamProject', 'method groovy.lang.GroovyObject invokeMethod java.lang.String java.lang.Object', 'method java.io.PrintStream println java.lang.Object', 'staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods getAt java.lang.Object java.lang.String', 'staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods println groovy.lang.Closure java.lang.Object', 'staticMethod jenkins.model.Jenkins getInstance', 'method org.jenkinsci.plugins.workflow.support.actions.EnvironmentAction getEnvironment', 'method org.jenkinsci.plugins.workflow.support.steps.build.RunWrapper getRawBuild', 'method hudson.model.Cause$UpstreamCause getUpstreamBuild']
List scriptList = ['']
scriptList.each {
  approveSignature(it)
}
scriptApproval.save()

void approveSignature(String signature) {
  if (!alreadyApproved.contains(signature)) {
    scriptApproval.approveSignature(signature)
  }
}

// Utility methods
String printArgumentTypes(Object[] args) {
  StringBuilder b = new StringBuilder();
  for (Object arg : args) {
    b.append(' ');
    b.append(EnumeratingWhitelist.getName(arg));
  }
  return b.toString();
}
