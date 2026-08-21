def call(String imageName, String tag = 'latest') {

    withCredentials([
        usernamePassword(
            credentialsId: 'DockerHubCred',
            usernameVariable: 'dockerHubUser',
            passwordVariable: 'dockerHubPassword'
        )
    ]) {
        sh """
            echo "\$dockerHubPassword" | docker login -u "\$dockerHubUser" --password-stdin

            docker image tag ${imageName}:${tag} "\$dockerHubUser/${imageName}:${tag}"

            docker push "\$dockerHubUser/${imageName}:${tag}"
        """
    }

    echo "Docker image pushed successfully"
}
