def call(String credentialsId, String localImage, String dockerHubImage) {

    echo 'This is pushing to DockerHub'

    withCredentials([
        usernamePassword(
            credentialsId: credentialsId,
            usernameVariable: 'dockerHubUser',
            passwordVariable: 'dockerHubPass'
        )
    ]) {

        sh '''
            echo "$dockerHubPass" | docker login \
                -u "$dockerHubUser" \
                --password-stdin
        '''

        sh "docker tag ${localImage}:latest ${dockerHubImage}:latest"

        sh "docker push ${dockerHubImage}:latest"
    }
}
