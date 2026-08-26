def call(String repoUrl, String branch = 'main') {
    echo 'This is cloning the code'

    sh 'git --version'

    git url: repoUrl,
        branch: branch

    echo 'Clone is successful'
}
