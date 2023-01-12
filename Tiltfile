SOURCE_IMAGE = os.getenv("SOURCE_IMAGE", default='docker.io/olgamaciaszek/tanzu-java-web-app-openfeign-source')
LOCAL_PATH = os.getenv("LOCAL_PATH", default='.')
NAMESPACE = os.getenv("NAMESPACE", default='my-apps')
OUTPUT_TO_NULL_COMMAND = os.getenv("OUTPUT_TO_NULL_COMMAND", default=' > /dev/null ')

include('/home/olga/Downloads/tanzu-java-web-app/Tiltfile')

k8s_custom_deploy(
    'tanzu-java-web-app-openfeign',
    apply_cmd="tanzu apps workload apply -f config/workload.yaml --update-strategy replace --debug --live-update" +
               " --local-path " + LOCAL_PATH +
               " --source-image " + SOURCE_IMAGE +
               " --namespace " + NAMESPACE +
               " --yes " +
               OUTPUT_TO_NULL_COMMAND +
               " && kubectl get workload tanzu-java-web-app-openfeign --namespace " + NAMESPACE + " -o yaml",
    delete_cmd="tanzu apps workload delete -f config/workload.yaml --namespace " + NAMESPACE + " --yes",
    deps=['pom.xml', './target/classes'],
    container_selector='workload',
    live_update=[
      sync('./target/classes', '/workspace/BOOT-INF/classes')
    ]
)

k8s_resource('tanzu-java-web-app-openfeign', port_forwards=["8080:8080"],
            extra_pod_selectors=[{'carto.run/workload-name': 'tanzu-java-web-app-openfeign', 'app.kubernetes.io/component': 'run'}])
allow_k8s_contexts('tap-aks-omaciaszeksh')